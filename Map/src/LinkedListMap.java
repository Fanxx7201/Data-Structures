/**
 * @ProjectName: Map
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/25 16:46
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    //链表节点, 之前我们的链表只有元素e .现在map集合是包含两部分. 一部分是key, 一部分是value
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){ //用户传过来key的构造函数
            this(key, null, null);
        }

        public  Node(){ //构造函数
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    //获得节点数据的辅助函数
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        //添加操作
        //添加操作时, 刚进来, 我们要来看一下是否有这个键对应的节点.
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else { //我们做添加操作时, 要保证key的唯一性.
            //如果不唯一我们可以抛异常, 但是, 例如set集合, 元素重复的时候, 直接就覆盖了原来重复的元素
            //所以这里我们惯例覆盖, 不抛异常了
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next != null){
                if(prev.next.key.equals(key)){
                    break;
                }
                prev = prev.next;
            }
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);

        return node == null ? null : node.value;
    }

    /**
     * @Description  修改操作
     * @Date  2018/11/25
     * @Param [key, newValue]
     * @return void
     **/
    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
