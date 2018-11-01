/**
 * @ProjectName: Stack
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description: 栈, 实际使用中不需要看到其他位置的元素(除了栈顶)
 * @Author: fanxx
 * @CreateDate: 2018/11/1 11:42
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    //传入容积构造函数
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //stact接口和栈的具体实现无关
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    //动态数组已经可以利用上resize的方法. 所以这里不用考虑空间问题.
    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
            res.append("] top");
            return res.toString();
    }
}
