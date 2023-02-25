public class DuplikateTest {
	public static void main(String[] args) {
		String t1 = "In Ulm! und um Ulm! und um Ulm herum!";
		/*
		String test1 = "";
		String test2 = "a";
		String test3 = "ab ba";
		String test4 = "a b c";
		*/

		StringSet s1 = Duplikate.findeDuplikate(t1);
		System.out.println(s1);
		/*
		StringSet set1 = Duplikate.findeDuplikate(test1);
		StringSet set2 = Duplikate.findeDuplikate(test2);
		StringSet set3 = Duplikate.findeDuplikate(test3);
		StringSet set4 = Duplikate.findeDuplikate(test4);
		*/

		System.out.println(s1.size() + "\n" +  // Ulm und um
		s1.contains("Ulm") + "\n" +
		s1.contains("und") + "\n" +
		s1.contains("um") + "\n" +
		s1.contains("In") + "\n" +
		s1.contains("herum") + "\n" +
		s1.contains("Ulm!"));  // keine Satzzeichen!

		String t2 = "Ein armer Affe";
		StringSet s2 = Duplikate.findeDuplikate(t2);

		System.out.println(s2.size());

		String t3 = "Wenn Fliegen hinter Fliegen fliegen?";
		StringSet s3 = Duplikate.findeDuplikate(t3);

		System.out.println(s3.size() + "\n" +
		s3.contains("Fliegen") + "\n" +
		s3.contains("fliegen"));
	}
}
