/**
 * @ProjectName: Map
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/26 16:15
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    //capacity: 容量, 用来初始化动态数组.
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }
    //返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引.
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中, 一个索引所表示的元素的左孩子节点的索引.
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中, 一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        //维护堆的性质.
        //参数是你想要上浮的节点的索引
        //data.getSize() - 1 ----> 因为是添加在数组末尾的, 所以是data.getSize() - 1
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        //整个过程就是循环
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k)); // 交换元素位置
            k = parent(k); //交换索引
        }
    }


}
