/**
 * @ProjectName: Array
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/10/31 14:41
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Array {

    private int[] data;
    private int size;

    //构造函数, 传入数组的容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    //提供默认的构造函数. 设置初识值
    public Array(){
        this(10);
    }

    //获取数组中元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(int e){
        /*if(size == data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        data[size] = e;
        size ++;*/
        add(size, e);
    }

    //向所有元素前添加一个新元素
    public void addFirst(int e){
        add(0, e);
    }

    //第index个位置插入一个新元素e
    public void add(int index, int e){
        if(size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    //不直接修改数组, 而是通过get方法的好处是在函数数对索引进行判断.
    int get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    //修改index索引位置的元素e
    void set(int index, int e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否含有元素e
    public boolean contains(int e){
        for(int i = 0 ; i < size ; i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引, 如果不存在元素e, 则返回-1
    public int find(int e){
        for(int i = 0 ; i < size ; i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素, 返回删掉的元素.
    public int remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        int ret = data[index];
        for(int i = index + 1 ; i < size ; i++){
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    //从数组中删除第一个元素, 返回删除的元素
    public int removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素, 返回删除的元素
    public int removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e, 如果数组中有e就删除 ,没有就不用干什么. 也可以拓展其他场景.返回布尔值等.
    public void removeElement(int e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }



    //覆盖父类Object类的方法. 写注解的好处是如果有误可以有提示信息.
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

}
