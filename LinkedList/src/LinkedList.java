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
    }

}
