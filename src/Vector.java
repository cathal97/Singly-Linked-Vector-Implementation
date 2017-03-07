public interface Vector<E> {
    int size();
    boolean isEmpty();
    E elemAtRank(int rank);
    E replaceAtRank(int rank, E element);
    void insertAtRank(int rank, E element);
    E removeAtRank(int rank);
}