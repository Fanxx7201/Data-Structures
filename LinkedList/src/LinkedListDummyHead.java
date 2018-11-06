/**
 * @ProjectName: LinkedList
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description: 使用链表的虚拟头节点.
 * @Author: fanxx
 * @CreateDate: 2018/11/2 17:12
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LinkedListDummyHead<E> {
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
    private Node dummyHead;
    //链表的长度
    private int size;

    //对于初始化链表来说, 是存在一个结点的, 也就是dummyHead, 初始值为空
    public LinkedListDummyHead(){
        dummyHead = new Node(null,null);
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
        add(0, e);
    }

    //在链表的index(0 - based) 位置添加新的元素e
    //在链表中不是一个常用的操作.
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
            Node prev = dummyHead;
            //可以尝试遍历3个左右,
            for (int i = 0; i < index; i++){
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }


    //在链表的末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    //获得链表的第index(0 - based)个位置的元素
    //在链表中不是一个常用的操作.
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        //index位置的元素. 就应该从dummyHead的下一个开始找
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
            return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
                cur = cur.next;
        }
        return false;
    }

    //从链表中删除index位置的元素. 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        //cur为空, 列表遍历结束
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


}
