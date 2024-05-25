package Homeworks._1_self_lists;

public class Main {
    public static void printList(List list) {
        System.out.print(list.size() + " ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        ArrayList myArrayList = new ArrayList();

        myLinkedList.add(10);
        myArrayList.add(10);

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.add(8);
        myArrayList.add(8);

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.add(1, 4);
        myArrayList.add(1, 4);

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.remove(2);
        myArrayList.remove(2);

        printList(myLinkedList);
        printList(myArrayList);
    }
}