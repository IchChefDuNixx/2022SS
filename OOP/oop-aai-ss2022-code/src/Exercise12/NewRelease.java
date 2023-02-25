public class NewRelease extends Movie {

    private NewRelease(String title) {
        super(title, 1);
    }

    static NewRelease create(String title) {
        NewRelease nr = new NewRelease(title);
        return nr;
    }

}
