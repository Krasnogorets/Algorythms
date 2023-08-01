public class task1<K,V> {
    private final int SIZE=10;
    private int length =0;
    private double loadFactor=0.75;
    List [] list;
    public task1(int size) {
        list =(List[]) new Object[size];
    }
    public boolean addItemByHash(K key, V value){
        if (list.length > loadFactor * length){
            resizeList();
        }
        Entity newEntity = new Entity();
        newEntity.key=key;
        newEntity.value=value;
        int index = calcBacketIndex(key);
        List itemList = list[index];
        if (itemList == null){
            itemList = new List();
            list[index] = itemList;
        }
        boolean flag=  list[index].add(newEntity);
        if(flag) {length++;}
        return true;
    }
    public boolean removeItem(K key){
        int index = calcBacketIndex(key);
        boolean flag=list[index].remove(key);
        if(flag) {length--;}
        return true;
    }
    public task1() {
        list =(List[]) new Object[SIZE];
    }
    public void resizeList(){
        List[]oldList = list;
        list = (List[]) new Object[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            List itemList = oldList[i];
            List.Node node = itemList.head;
            while (node !=null){
                addItemByHash(node.data.key,node.data.value);
                node = node.next;
            }
            oldList[i]=null;
        }
    }
    public int calcBacketIndex(K key){
        return key.hashCode()% list.length;
    }
    public V findValueList(K key){
        int index = calcBacketIndex(key);
        if(list[index]!= null){
            return list[index].findValue(key);
        }
    }
    class Entity{
        private K key;
        private V value;

    }

    class List{
        private Node head;

        class Node{
            private Entity data;
            private Node next;
        }
        public V findValue(K key){
            Node node = head;
            while (node != null){
                if(node.data.key.equals(key)){
                    return node.data.value;
                }
                node=node.next;
            }
            return null;
        }
        public boolean add(Entity item){
            Node node = head;
            while (node != null){
                if (node.data.key.equals(item.key)){
                    break;
                }
                if (node.next == null) break;
                node = node.next;
            }
            Node newNode = new Node();
            newNode.data = item;
            node.next = newNode;
            return true;
        }
        public boolean remove(K key){
            Node node = head;
            Node previous = head;
            if (head !=null){
                if (head.data.key.equals(key)){
                    head = head.next;
                    return true;
                }
            }
            while (node!= null){
                if (node.data.key.equals(key)){
                    previous.next = node.next;
                    return true;
                }
                previous = node;
                node = node.next;
            }
            return false;
        }
    }
    public static void main(String[] args) {

    }
}
