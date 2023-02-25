import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class TwitterAnalysis2 implements TweetSammlung {
    List<String> tweetList = new LinkedList<>();
    Map<String, Integer> indexMap = new TreeMap<>();
    List<String> stopWordList = new LinkedList<>();
    Map<String, Integer> hashtagIndexMap = new TreeMap<>();
    Map<String, Integer> topWordsMap = new TreeMap<>();
    List<Pair> topHashtagPairList = new LinkedList<>();
    List<String> topHashtagList = new LinkedList<>();

    List<Pair> topTweetList = new LinkedList<>();
    int buzzwordCounter = 0;
    String[] splitArray = new String[99];

    @Override
    public void setStopwords(File file) throws FileNotFoundException, IOException {
        FileReader stopwordReader = new FileReader(file);
        setStopwordsHelper(stopwordReader);

    }

    public void setStopwords(String source) throws FileNotFoundException, IOException {
        FileReader stopwordReader = new FileReader(
                new File(getClass().getClassLoader().getResource(source).getFile()));
        setStopwordsHelper(stopwordReader);

    }

    private void setStopwordsHelper(FileReader stopWordReader) throws IOException {
        int readChar = 0;
        StringBuilder builder = new StringBuilder();
        do {
            readChar = stopWordReader.read();
            if (!Character.isWhitespace((char) readChar)) {
                builder.append((char) readChar);
            } else if (builder.length() > 0) {
                stopWordList.add(builder.toString());
                builder.delete(0, builder.length());
            }
        } while (readChar != -1);
        stopWordReader.close();
    }

    @Override
    public void ingest(String tweet) {
        tweetList.add(tweet);
        List<String> tempTokens = tokenize(tweet);
        tempTokens.stream()
                .filter((String s) -> !stopWordList.contains(s))
                .forEach((String s) -> {
                    if (indexMap.containsKey(s)) {
                        indexMap.replace(s, indexMap.get(s) + 1);
                    } else {
                        indexMap.put(s, 1);
                    }
                    if (s.matches("^#.*")) {
                        if (hashtagIndexMap.containsKey(s)) {
                            hashtagIndexMap.replace(s, hashtagIndexMap.get(s) + 1);
                        } else {
                            hashtagIndexMap.put(s, 1);
                        }
                    }
                    if (Character.isAlphabetic(s.charAt(0))) {
                        if (topWordsMap.containsKey(s)) {
                            topWordsMap.replace(s, topWordsMap.get(s) + 1);
                        } else {
                            topWordsMap.put(s, 1);
                        }
                    }
                });
    }

    @Override
    public Iterator<String> vocabIterator() {
        return indexMap.keySet().iterator();
    }

    @Override
    public Iterator<String> topHashTags() {
        hashtagIndexMap.entrySet().stream().forEach((Entry<String, Integer> entry) -> {
            topHashtagPairList.add(new Pair(entry.getKey(), entry.getValue()));
        });
        Collections.sort(topHashtagPairList);
        Collections.reverse(topHashtagPairList);
        topHashtagPairList.stream().forEach((Pair pair) -> {
            topHashtagList.add(pair.getKey());
        });
        return topHashtagList.iterator();
    }

    @Override
    public Iterator<String> topWords() {
        List<Pair> alphabeticalStartPairList = new LinkedList<>();
        List<String> result = new LinkedList<>();
        indexMap.entrySet().stream()
                .filter((Entry<String, Integer> entry) -> Character.isAlphabetic(entry.getKey().charAt(0)))
                .forEach((Entry<String, Integer> entry) -> alphabeticalStartPairList
                        .add(new Pair(entry.getKey(), entry.getValue())));
        Collections.sort(alphabeticalStartPairList);
        Collections.reverse(alphabeticalStartPairList);
        alphabeticalStartPairList.stream().forEach((Pair pair) -> result.add(pair.getKey()));
        return result.iterator();

    }

    @Override
    public Iterator<Pair> topTweets() {
        tweetList.stream().forEach((String tweet) -> {
            splitArray = tweet.split("\s+");
            Arrays.stream(splitArray).filter((String split) -> split.length() > 0).forEach((String split) -> {
                if (indexMap.get(split) != null)
                    buzzwordCounter += indexMap.get(split);
            });
            topTweetList.add(new Pair(tweet, buzzwordCounter));
            Arrays.fill(splitArray, null);
            buzzwordCounter = 0;
        });
        Collections.sort(topTweetList);
        Collections.reverse(topTweetList);
        return topTweetList.iterator();
    }

    static List<String> tokenize(String tweet) {
        List<String> list = new LinkedList<>();

        Scanner scanner = new Scanner(tweet);
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }

    static TwitterAnalysis2 create() {
        return new TwitterAnalysis2();
    }

    static <T> void forEach(Collection<T> coll, Consumer<T> cons) {
        for (T t : coll) {
            cons.accept(t);
        }
    }
}
