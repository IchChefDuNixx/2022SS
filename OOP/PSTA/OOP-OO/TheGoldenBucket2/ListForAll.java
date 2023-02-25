package TheGoldenBucket2;

public interface ListForAll<T> extends Iterable<T> {
    public boolean add(T f);

    public boolean contains(T f);

    public boolean remove(T f);

    public int size();

    public ListForAllImpl.ListElement getFirst();
}
