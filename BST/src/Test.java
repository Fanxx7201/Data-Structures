import java.util.ArrayList;

/**
 * @ProjectName: BST
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/23 10:35
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList();
        FileOperation.readFile("pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size()); //Total words: 125901 有重复的单词

        BSTSet<String> set1 = new BSTSet<>();
        for (String word: words1){
            set1.add(word);
        }
        System.out.println("Total different word: " + set1.getSize()); //Total different word: 6530
    }
}
