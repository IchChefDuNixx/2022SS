import java.util.function.Consumer;

public class Operations<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
        System.out.println(t);

    }

}
