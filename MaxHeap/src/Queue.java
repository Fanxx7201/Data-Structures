public interface Queue<E> { //基于堆实现的优先队列, 可以复用队列的接口

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
