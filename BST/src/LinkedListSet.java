

/**
 * @ProjectName: BST
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/23 10:57
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E> list;

    /**
     * @Description  添加操作, 之前我们实现LinkedList的时候, 没有做唯一性的校验. 可以允许重复的.
     * @Date  2018/11/23
     * @Param [e]
     * @return void
     **/

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
