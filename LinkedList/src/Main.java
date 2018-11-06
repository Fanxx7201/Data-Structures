public class Main {

    public static void main(String[] args) {

        LinkedListDummyHead<Integer> linkedListDummyHead = new LinkedListDummyHead<>();
        for (int i = 0; i < 5; i++){
            linkedListDummyHead.addFirst(i);
            System.out.println(linkedListDummyHead);
        }
        linkedListDummyHead.add(2, 666);
        System.out.println(linkedListDummyHead);

        linkedListDummyHead.remove(2);
        System.out.println(linkedListDummyHead);

        linkedListDummyHead.removeFirst();
        System.out.println(linkedListDummyHead);

        linkedListDummyHead.removeLast();
        System.out.println(linkedListDummyHead);
    }
}
