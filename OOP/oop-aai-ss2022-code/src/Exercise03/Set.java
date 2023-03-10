public interface Set<T> {
	/**
	 * Fügt das übergebene Element in das Set ein.
	 * @param s
	 * @return true, wenn `s` neu eingefügt wurde, false wenn es bereits enthalten war
	 */
	public boolean add(T s);

	/**
	 * Prüft, ob ein Element im Set enthalten ist.
	 */
	public boolean contains(T s);

	/**
	 * Entfernt ein Element aus dem Set; wirft eine NoSuchElementException
	 * wenn das Element nicht enthalten war.
	 *
	 * @return Das entfernte Element
	 * @throws java.util.NoSuchElementException Wenn das Element nicht vorhanden war.
	 */
	public T remove(T s);

	/**
	 * Gibt die Größe des Sets zurück
	 */
	public int size();

}
