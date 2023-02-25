import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class TwitterAnalysis implements TweetSammlung {
    // +private
    List<String> tweetList = new LinkedList<>();
    Map<String, Integer> indexMap = new TreeMap<>();
    Map<String, Integer> hashtagIndexMap = new TreeMap<>();
    List<Pair> topHashtagList = new LinkedList<>();
    Map<String, Integer> topWordsMap = new TreeMap<>();
    List<Pair> topWordsList = new LinkedList<>();
    List<Pair> topTweetList = new LinkedList<>();
    List<String> stopWordList = new LinkedList<>();

    @Override
    public void setStopwords(File file) throws FileNotFoundException, IOException {
        FileReader stopwordReader = new FileReader(file);
        setStopwordsHelper(stopwordReader);
    }

    public void setStopwords(String resource) throws FileNotFoundException, IOException {
        FileReader stopwordReader = new FileReader(
                new File(getClass().getClassLoader().getResource(resource).getFile()));
        setStopwordsHelper(stopwordReader);
    }

    private void setStopwordsHelper(FileReader stopwordReader) throws FileNotFoundException, IOException {
        int readChar = 0;
        String builderBase = "";
        do {
            readChar = stopwordReader.read();
            if (!Character.isWhitespace((char) readChar)) {
                builderBase += (char) readChar;
            } else {
                stopWordList.add(builderBase);
                builderBase = "";
            }
        } while (readChar != -1);
        stopwordReader.close();
    }

    @Override
    public void ingest(String tweet) {
        tweetList.add(tweet);
        List<String> tempIngestList = tokenize(tweet);
        for (String word : tempIngestList) {
            if (!stopWordList.contains(word)) {
                if (indexMap.containsKey(word)) {
                    indexMap.replace(word, indexMap.get(word) + 1);
                } else {
                    indexMap.put(word, 1);
                }
                if (word.matches("^#.*")) {
                    if (hashtagIndexMap.containsKey(word)) {
                        hashtagIndexMap.replace(word, hashtagIndexMap.get(word) + 1);
                    } else {
                        hashtagIndexMap.put(word, 1);
                    }
                }
                if (Character.isAlphabetic(word.charAt(0))) { // maybe check the code point number
                    if (topWordsMap.containsKey(word)) {
                        topWordsMap.replace(word, topWordsMap.get(word) + 1);
                    } else {
                        topWordsMap.put(word, 1);
                    }
                }
            }
        }
    }

    @Override
    public Iterator<String> vocabIterator() {
        return indexMap.keySet().iterator();
    }

    @Override
    public Iterator<String> topHashTags() {
        for (Map.Entry<String, Integer> hashtagEntry : hashtagIndexMap.entrySet()) {
            topHashtagList.add(new Pair(hashtagEntry.getKey(), hashtagEntry.getValue()));
        }
        Collections.sort(topHashtagList);
        Collections.reverse(topHashtagList);
        List<String> tempTopHashtagList = new LinkedList<>();
        for (Pair hashtagPair : topHashtagList) {
            tempTopHashtagList.add(hashtagPair.getKey());
        }
        return tempTopHashtagList.iterator();
    }

    @Override
    public Iterator<String> topWords() {
        for (Map.Entry<String, Integer> topWordsEntry : topWordsMap.entrySet()) {
            topWordsList.add(new Pair(topWordsEntry.getKey(), topWordsEntry.getValue()));
        }
        Collections.sort(topWordsList);
        Collections.reverse(topWordsList);
        List<String> tempTopWordsList = new LinkedList<>();
        for (Pair topWordsPair : topWordsList) {
            tempTopWordsList.add(topWordsPair.getKey());
        }
        return tempTopWordsList.iterator();
    }

    @Override
    public Iterator<Pair> topTweets() {
        String[] splitTweetArray = new String[99];
        int buzzwordCounter = 0;
        for (String tweet : tweetList) {
            splitTweetArray = tweet.split("\s+");
            for (String split : splitTweetArray) {
                if (indexMap.get(split) != null) {
                    buzzwordCounter += indexMap.get(split);
                }
            }
            topTweetList.add(new Pair(tweet, buzzwordCounter));
            Arrays.fill(splitTweetArray, null);
            buzzwordCounter = 0;
        }
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

    static TwitterAnalysis create() {
        return new TwitterAnalysis();
    }

    static <T> void forEach(Collection<T> coll, Consumer<T> cons) {
        for (T t : coll) {
            cons.accept(t);
        }
    }
}
