/**
 * @ProjectName: BST
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/23 10:05
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Set<E>{

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
