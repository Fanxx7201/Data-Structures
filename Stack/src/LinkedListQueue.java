

/**
 * @description:
 * @author: fanxinxin
 * @create: 2018-11-18
 */
public class LinkedListQueue<E> implements Queue<E>{

    //定义链表的节点 .
    private class Node{
        public E e;
        public Node next;

        //用户传过来的数据,赋值给节点
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //头节点和尾节点
    private Node head, tail;
    //int类, 链表中存储多少元素.
    private int size;

    //默认构造函数
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        //入队操作是从链表的尾进行.
        if(tail == null){ //tail为空, head也为空.
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("can not dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;

    }

    @Override
    public E getFront() {
        return null;
    }


}
