public class NodeList {
    private Node head;
    private Node tail;

    public NodeList() {
        head = null;
        tail = null;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }
    public void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value + " <-> ");
            temp=temp.next;
        }
    }

    public void reverse(){
        Node temp = null;
        Node current = head;
         while (current != null)
        {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
         if (temp != null)
        {
            head = temp.prev;
        }
    }

}
