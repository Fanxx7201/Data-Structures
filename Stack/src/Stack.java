/**
 * @ProjectName: Stack
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/1 11:20
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
