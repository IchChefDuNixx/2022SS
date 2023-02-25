
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

class CorpusReader {
	static Logger logger = Logger.getLogger(CorpusReader.class.getName());

	static String filePath = "C:\\Users\\Felix\\Desktop\\auf-zu-win-11\\th\\2022SS\\OOP\\oop-aai-ss2022-code\\src\\Exercise05\\theses.txt";

	static Iterator<String> thesisTitleIterator() throws IOException {
		ClassLoader classLoader = CorpusReader.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("theses.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// BufferedReader br = Files.newBufferedReader(Paths.get(filePath));

		return new Iterator<String>() {
			// keep first line ready
			String next = br.readLine();

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public String next() {
				String h = next;
				try {
					next = br.readLine();

					// close reader to release file
					if (next == null)
						br.close();
				} catch (IOException e) {
					next = null;
				}

				return h;
			}
		};
	}

	static Iterator<String> censoredTitleIterator(Set<String> blackList) throws IOException {
		// ClassLoader classLoader = CorpusReader.class.getClassLoader();
		// InputStream is = classLoader.getResourceAsStream("theses.txt");
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedReader br = Files.newBufferedReader(Paths.get(filePath));

		return new Iterator<String>() {
			// keep first line ready
			String next = br.readLine();

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public String next() {
				String h = next;
				try {
					next = br.readLine();

					// close reader to release file
					if (next == null)
						br.close();
				} catch (IOException e) {
					next = null;
				}

				String[] blacklistCheck = h.split(" "); // noch leeren?
				System.out.println(Arrays.toString(blacklistCheck));
				String output = "";
				for (String e : blacklistCheck) {
					if (blackList.contains(e)) {
						output += blackOut(e) + " ";
					} else {
						output += e + " ";
					}
				}
				return output.trim();
			}
		};
	}

	private static String blackOut(String input) {
		for (int i = 0; i < input.length(); i++) {
			input = input.replace(input.charAt(i), '*');
		}
		return input;
	}
}
