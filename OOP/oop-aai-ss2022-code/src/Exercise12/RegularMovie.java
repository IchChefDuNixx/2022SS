public class RegularMovie extends Movie {

    private RegularMovie(String title) {
        super(title, 0);
    }

    static RegularMovie create(String title) {
        RegularMovie rm = new RegularMovie(title);
        return rm;
    }

}
