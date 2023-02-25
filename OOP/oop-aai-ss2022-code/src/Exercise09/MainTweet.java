import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.Consumer;

public class MainTweet {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TwitterAnalysis2 analysis2 = TwitterAnalysis2.create();
        analysis2.ingest("hans dampf will surfen #tale");
        analysis2.ingest("peter pan will fliegen #fairy");
        analysis2.ingest("little red riding hood #fairy");

        Consumer<String> cPrinter = new Consumer<String>() {
            public void accept(String s) {
                // System.out.println(s);
            }
        };

        TwitterAnalysis2.forEach(analysis2.tweetList, cPrinter);
        // System.out.println(analysis2.indexMap);
        analysis2.setStopwords("stopwords.txt");
        System.out.println(analysis2.hashtagIndexMap);
    }
}
