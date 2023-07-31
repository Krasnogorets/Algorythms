public class hh_3_1 {

    public static void main(String[] args) {
        NodeList list1 = new NodeList();
        list1.addFirst(7);
        list1.addFirst(2);
        list1.addFirst(1);
        list1.addFirst(5);
        list1.addFirst(10);
        list1.addFirst(8);
        list1.printList();
        list1.reverse();
        System.out.println();
        System.out.println("---------------------------");
        list1.printList();

    }



}
