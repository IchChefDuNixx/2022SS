public class ChildrensMovie extends Movie {

    private ChildrensMovie(String title) {
        super(title, 2);
    }

    static ChildrensMovie create(String title) {
        ChildrensMovie cm = new ChildrensMovie(title);
        return cm;
    }

}
