/**
 * @ProjectName: Queue
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/1 17:09
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    //size: 有多少个元素.
    // 不使用size也可以.可以用front 和tail进行计算. 但是这里是为了逻辑简单一点.
    private int size;

    //capacity :用户希望最多可以存放多少元素
    public LoopQueue(int capacity) {
        //需要留一个空间,防止front和tail相等队列为空的情况.
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    //入队的操作
    @Override
    public void enqueue(E e) {
        //首先判断当前队列是否是满的.
        if ((tail + 1) % data.length == front) {
            //扩容, getCapacity是浪费了一个空间
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;

    }

    private void resize(int newCapacity) {
        //1.新创建一个对象, 容量是传入的容量 + 1 ,因为数组中要浪费一个空间
        E[] newData = (E[]) new Object[newCapacity + 1];
        //2.原来data中的元素放在newData中.
        for (int i = 0; i < size; i++) {
            //data中的元素相对于newData, 索引值有front的偏移..由于我们是循环队列,索引要循环. 值有可能会产生超过data.length.
            newData[i] = data[(i + front) % data.length];
            data = newData;
            front = 0;
            tail = size;
        }
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        //缩容之后容量不为0
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        //遍历循环队列,
        for(int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) { //每插入队列3个元素, 从队列中取出一个元素.
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
