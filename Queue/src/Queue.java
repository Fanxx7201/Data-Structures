/**
 * @ProjectName: Queue
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/1 15:26
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
