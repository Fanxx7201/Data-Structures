/**
 * @ProjectName: LinkedList
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/2 17:12
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LinkedList<E> {
    //私有内部类, 用户不需要知道链表的内部结构. 只需要知道链表这个数据结构就可以.
    //要对用户屏蔽底层的细节.
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

    //链表中有一个节点是head
    private Node head;
    //链表的长度
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        head = new Node(e, head);
        size++;
    }

    //在链表的index(0 - based) 位置添加新的元素e
    //在链表中不是一个常用的操作.
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for (int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            /*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    //在链表的末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

}
