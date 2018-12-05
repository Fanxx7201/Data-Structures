import java.util.HashSet;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        Student student = new Student(2, 2, "bobo", "liu");
        System.out.println(student.hashCode());

        //这样, 我们就可以使用java给我们提供的Hash表
        //以下就是java提供的hash表的基本使用方法.
        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);


        //如果我们不覆盖hashCode的话, java是根据每一个Object类的地址, 转成的hashCode.
        Student student2 = new Student(2, 2, "bobo", "liu");
        System.out.println(student2.hashCode());
    }
}
