public class DoubleLinkedList<T> {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.printAll();

        System.out.println("#");
        MyLinkedList.addfront(0, 1);
        System.out.println("##");
        MyLinkedList.printAll();
        MyLinkedList.addfront(0, 3);
        System.out.println("###");
        MyLinkedList.printAll();
        MyLinkedList.addfront(0, 5);
        System.out.println("####");
        MyLinkedList.printAll();
        MyLinkedList.addfront(0, 9);
        System.out.println("#####");
        MyLinkedList.printAll();

    }

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public void addfront(T data, T targetdata) {
        Node<T> node = this.head;
        System.out.println("현재 헤드 데이터는" + node.data);
        while (node.data != targetdata) {
            node = node.next;
        }

        System.out.println("현재 노드 데이터는" + node.data);
        if (node == this.head) {
            node.prev = new Node<T>(data);
            node.prev.next = node;
            this.head = node.prev;
        } else {
            Node<T> prenode = node.prev;
            node.prev = new Node<T>(data);
            node.prev.prev = prenode;
            node.prev.next = node;
            prenode.next = node.prev;
        }


    }
}