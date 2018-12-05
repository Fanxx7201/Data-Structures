public class Main2 {

    public static void main(String[] args) {
        //java的基本类型不是一个对象.
        //
        int a = 42;
        System.out.println(((Integer)a).hashCode()); //结果: 42

        int b = -42;
        System.out.println(((Integer)b).hashCode()); //结果: -42 int有符号, 所以hashCode返回值就可能为正, 可能为负

        double c= 3.1415926;
        System.out.println(((Double)c).hashCode()); //219937201

        String d = "imooc";
        System.out.println(d.hashCode()); //100327135

        Student stu = new Student(3, 2, "bobo", "liu");
        System.out.println(stu.hashCode()); //94107933


    }
}
