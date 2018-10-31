public class Main {

    public static void main(String[] args) {

        Array arr = new Array(20);
        for (int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        //1的索引位置添加100这个元素.
        arr.add(1, 100);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
