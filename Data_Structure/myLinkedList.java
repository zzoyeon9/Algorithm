public class myLinkedList<T> {

    public Node<T> head = null;

    public void add(T data)
    {
        if(head==null)
            head = new Node<T>(data);
        else
        {
            Node<T> newNode = this.head;

            while(newNode.next!=null)
                newNode = newNode.next;

            newNode.next = new Node<T>(data);
        }



    }

    public void printall()
    {
        if(head!=null)
        {
            Node<T> node = this.head;
            System.out.println(node.data);

            while(node.next!=null)
            {
                node=node.next;
                System.out.println(node.data);

            }

        }

    }

    public static void main(String args[])
    {
         myLinkedList<Integer> mylist = new myLinkedList<Integer>();
         mylist.add(1);
         mylist.add(3);
         mylist.add(4);
         mylist.betweenAdd(5, 3);
        mylist.betweenAdd(9, 3);
        mylist.betweenAdd(8, 1);
        mylist.betweenAdd(0, 7);
        mylist.printall();
    }

    public void betweenAdd(T data, T targetData)
    {
        Node<T> searchedNode = search(targetData);
        if(searchedNode==null)
            add(data);
        else
        {
            Node<T> newNode = new Node<>(data);
            newNode.next = search(targetData).next;
            search(targetData).next = newNode;


        }

    }

    public Node<T> search(T targetData)
    {
        Node<T> node = head;

            while(node != null)
            {
                if(node.data == targetData)
                    return node;
                else
                    node = node.next;
            }

            return null;


    }

}
