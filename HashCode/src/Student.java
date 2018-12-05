public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade, int cls, String firstName, String lastName){
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //如果我们没有重写hashCode, 那么hashSet和hashMap也是一样可以用的.
    //java
    @Override
    public int hashCode(){

        int B = 31;
        int hash = 0;
        hash = hash * B + ((Integer)grade).hashCode();
        hash = hash * B + ((Integer)cls).hashCode();
        hash = hash * B + firstName.toLowerCase().hashCode(); //统一转成小写, 这样传值大小写的hashCode都是一样的
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    /**
     * @Description  判断两个对象是否相等
     * 重写equals方法的原因是: 当产生哈希冲突的时候, 如果我们重写了equals方法, 就可以判断这两个对象的HashCode是否相等.
     * 如果不重写, java会根据地址计算hashCode. 这样计算出来的hashCode就是不一致的.
     * @Date  2018/12/5
     * @Param [o]
     * @return boolean
     **/
    @Override
    public boolean equals(Object o){ //传进来一定是Object类型, 而不是我们自己的类型.

        if(this == o)
            return true;

        if(o == null)
            return false;

        if(getClass() != o.getClass())
            return false;

        Student another = (Student)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
