package test;

public class Main {

    public static void main(String[] args) {

        //数组长度固定
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = i;
        }

        int[] scores = new int[]{100, 96, 66};
        for(int i = 0 ; i < scores.length ; i++){
            System.out.println(scores[i]);
        }
    }
}
