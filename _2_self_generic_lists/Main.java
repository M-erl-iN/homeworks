package Homeworks._2_self_generic_lists;

public class Main {
    public static void printList(List list) {
        System.out.print(list.size() + " ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        ArrayList<String> myArrayList = new ArrayList<String>();

        myLinkedList.add("10.1");
        myArrayList.add("10.1");

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.add("8.2");
        myArrayList.add("8.2");

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.add(1, "4.3");
        myArrayList.add(1, "4.3");

        printList(myLinkedList);
        printList(myArrayList);

        myLinkedList.remove(2);
        myArrayList.remove(2);

        printList(myLinkedList);
        printList(myArrayList);
    }
}