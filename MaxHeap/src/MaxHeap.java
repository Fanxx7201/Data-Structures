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

    //看堆中最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("can not findMax when heap is empty");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax(){

        E ret = findMax();
        //将0位置元素和最后一个位置元素交换位置
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        //将索引为0的元素进行下浮操作.
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        //下沉结束: k这个节点没有孩子了, 下沉就结束了
        //也就是左孩子的索引, 比数据库元素的总数还要小.
        while(leftChild(k) < data.getSize()){

            //j是k节点的左孩子
            int j = leftChild(k);
            //j+1 是k节点的右孩子
            //判断右孩子是不是比左孩子的值大.
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) >= 0){
                //总之, data[j] 是leftChild 和rightChild中的最大值.
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k, j);
            //把j赋值给k, 进行新一轮的循环.
            k = j;
        }
    }

}
