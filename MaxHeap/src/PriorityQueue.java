/**
 * @ProjectName: MaxHeap
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/27 13:47
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }


    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * @Description  入队操作
     * @Date  2018/11/27
     * @Param [e]
     * @return void
     **/
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        //出队, 提取最大值
        return maxHeap.extractMax();
    }

    /**
     * @Description  最大堆, 堆顶的元素
     * @Date  2018/11/27
     * @Param []
     * @return E
     **/
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
