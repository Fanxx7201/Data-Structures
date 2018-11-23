/**
 * @ProjectName: BST
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description: 基于二分搜索树的Set集合
 * @Author: fanxx
 * @CreateDate: 2018/11/23 10:09
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst; //集合基于二分搜索树实现

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e); //对于BST本身就在添加元素的时候, 不理会重复的元素
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
