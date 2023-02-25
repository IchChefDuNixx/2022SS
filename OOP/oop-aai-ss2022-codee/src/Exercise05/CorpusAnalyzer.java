
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

class CorpusAnalyzer {
	private List<String> theses;
	private List<String> splitTheses;

	CorpusAnalyzer(Iterator<String> thesesIterator) throws IOException {
		Iterator<String> corpusIterator = CorpusReader.thesisTitleIterator();
		String tempInput = "";
		theses = new LinkedList<>();
		splitTheses = new LinkedList<>();
		while (corpusIterator.hasNext() == true) {
			tempInput = corpusIterator.next();
			theses.add(tempInput);
			for (String w : tempInput.split(" ")) {
				splitTheses.add(w);
			}
		}
	}

	/**
	 * Gibt die Anzahl der angefertigten Theses zurück
	 */
	int countTheses() {
		return theses.size();
	}

	/**
	 * Gibt die durchschnittliche Länge von Titeln in Worten zurück
	 */
	int averageThesisTitleLength() {
		double length = 0;
		for (String w : splitTheses) {
			length++;
		}
		return (int) Math.round(length / theses.size());
	}

	/**
	 * Gibt eine alphabetisch absteigend sortierte und duplikatfreie
	 * Liste der ersten Wörter der Titel zurück.
	 */
	List<String> uniqueFirstWords() {
		List<String> output = new LinkedList<>();
		String s = "";
		for (String w : theses) {
			s = w.substring(0, w.indexOf(" "));
			if (output.contains(s) == false) {
				output.add(s);
			}
		}
		Collections.sort(output, Collections.reverseOrder());
		return output;
	}

	/**
	 * Gibt einen Iterator auf Titel zurück; dabei werden alle Woerter, welche
	 * in `blackList` vorkommen durch Sternchen ersetzt (so viele * wie Buchstaben).
	 */
	Iterator<String> censoredIterator(Set<String> blackList) throws IOException {
		return CorpusReader.censoredTitleIterator(blackList);
	}

	/**
	 * Gibt eine Liste von allen Titeln zurueck, wobei Woerter so ersetzt werden,
	 * wie sie in der Map abgebildet werden, und die Liste nach Stringlaenge
	 * absteigend sortiert ist.
	 */
	List<String> normalizedTheses(Map<String, String> replaceMap) throws IOException {
		Iterator<String> normalizedIterator = CorpusReader.thesisTitleIterator();
		List<String> outputList = new LinkedList<>();
		String normalString = "";

		System.out.println("size: " + replaceMap.size() + "\n" +
				"k: " + replaceMap.keySet() + "\n" +
				"v: " + replaceMap.values());

		while (normalizedIterator.hasNext() == true) {
			normalString = normalizedIterator.next();
			System.out.println("normalString: " + normalString);
			for (String k : replaceMap.keySet()) {
				normalString = normalString.replaceAll(k, replaceMap.get(k));
			}
			outputList.add(normalString);
		}
		Collections.sort(outputList, Collections.reverseOrder());
		return outputList;
	}
}
