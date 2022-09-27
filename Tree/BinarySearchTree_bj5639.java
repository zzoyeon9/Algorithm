package Tree;

import java.io.*;

public class BinarySearchTree_bj5639 {

    private static Node root;
    private static StringBuilder sb;

    public static void post(Node node) {

        if (node == null)
            return;

        post(node.left);
        post(node.right);
        sb.append(node.data+"\n");

    }

    public static void func() {
        sb = new StringBuilder();
        post(root);
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();

            if (input == null || input.equals(""))
                break;

            root.insert(Integer.parseInt(input));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }


}

class Node {
    int data;
    Node left;
    Node right;

    Node(int num) {
        this.data = num;
    }

    void insert(int n) {
        if (n < this.data) {
            if (this.left == null)
                this.left = new Node(n);
            else
                this.left.insert(n);
        } else {
            if (this.right == null)
                this.right = new Node(n);
            else
                this.right.insert(n);
        }
    }
}