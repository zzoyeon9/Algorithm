import java.sql.SQLOutput;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;


        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        //CASE1 : Node가 하나도 없을 때
        if (this.head == null)
            this.head = new Node(data);
        else {//CASE2 : Node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                //CASE2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (findNode.value > data)
                    if (findNode.left != null)
                        findNode = findNode.left;
                    else {
                        findNode.left = new Node(data);
                        break;
                    }
                else{
                    if(findNode.right != null)
                        findNode = findNode.right;
                    else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
                //CASE2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
            }
        }
        return true;
    }

    public Node search(int data){
        //CASE 1 : 노드가 하나도 없을 때
        if(this.head == null)
            return null;
        else{//CASE 2 : 노드가 하나 이상 있을 때
            Node findnode = head;
            while(findnode != null){
                if(findnode.value == data)
                    return findnode;
                else if(data < findnode.value)
                    findnode = findnode.left;
                else
                    findnode = findnode.right;
            }
            return null;
        }

    }

    public boolean delnode(int data){
        boolean searched = false;

        Node curParentnode = this.head;
        Node curNode = this.head;
            //노드가 아예 없을 때
        if(this.head==null)
            return false;
        else { //노드가 일단 존재
            if(this.head.value == data && this.head.left == null && this.head.right == null){//노드가 단지 하나만 존재할 때
                this.head = null;
                return true;
            }
            while (curNode != null) {//여기서부터는 최소 노드가 2개 이상인 트리라는 것.
                if(data == curNode.value){
                    searched = true;
                    break;
                } else if (data < curNode.value){
                    curParentnode = curNode;
                    curNode = curNode.left;
                }else {
                    curParentnode = curNode;
                    curNode = curNode.right;
                }
            }//while을 뚫었다면 1. 결국 타겟 노드를 찾았거나 2. 찾는 노드가 없는 경우.
            if(searched == false)//찾는 노드가 없을 때
                return false;
            else{                //타겟 노드를 찾았을 때
                if(curNode.left == null && curNode.right == null){//타겟 노드가 말단 노드일 때
                    if(curNode.value < curParentnode.value)
                        curParentnode.left = null;
                    else
                        curParentnode.right = null;
                }else if(curNode.left != null && curNode.right == null){//타겟 노드의 자식 노드가 왼쪽에만 있을 경우
                    if(curNode.value < curParentnode.value)//타겟 노드가 부모 노드의 왼쪽 자식일 경우
                        curParentnode.left = curNode.left;
                    else                                   //타겟 노드가 부모 노드의 오른쪽 자식일 경우
                        curParentnode.right = curNode.left;

                }else if(curNode.right != null && curNode.left == null){//타겟 노드의 자식 노드가 오른쪽에만 있을 경우
                    if(curNode.value < curParentnode.value)//타겟 노드가 부모 노드의 왼쪽 자식일 경우
                        curParentnode.left = curNode.right;
                    else                                   //타겟 노드가 부모 노드의 오른쪽 자식일 경우
                        curParentnode.right = curNode.right;
                }else{//삭제할 노드가 자식 노드를 두 개 가지고 있을 때 중,
                    //삭제할 노드가 부모 노드의 왼쪽에 있을 때
                    if(data < curParentnode.value){

                        Node changeNode = curNode.right;
                        Node changeParentNode = curNode.right;

                        while(changeNode.left != null){
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        //여기까지 실행되면 changeNode에는 삭제할 노드의 오른쪽 자식 노드 중 가장 작은 값을 가진 노드가 들어있음

                        //Case 3-1-1: changeNode의 오른쪽 자식 노드가 있을 때
                        if(changeNode.right != null){
                            changeParentNode.left = changeNode.right;
                        }

                        //Case 3-1-2: changeNode의 자식 노드가 없을 때
                        else{
                            changeParentNode.left = null;
                        }
                        //curParentNode의 왼쪽 자식 노드에 삭제할 노드의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연
                        curParentnode.left = changeNode;
                        //parentNode의 왼쪽 자식 노드가 현재, changeNode이고, changeNode의 왼쪽 / 오른쪽 자식 노드를,모두 삭제할 curNode의 기존 왼쪽 / 오른쪽의 노드로 변경
                        changeNode.right = curNode.right;
                        changeNode.left = curNode.left;

                        curNode = null;
                    }
                    else//삭제할 노드가 부모 노드의 오쪽에 있을 때
                        if(data > curParentnode.value){

                            Node changeNode = curNode.right;
                            Node changeParentNode = curNode.right;

                            while(changeNode.left != null){
                                changeParentNode = changeNode;
                                changeNode = changeNode.left;
                            }

                            if(changeNode.right != null){ //Case 3-1-1: changeNode의 오른쪽 자식 노드가 있을 때
                                changeParentNode.left = changeNode.right;
                            }

                            //Case 3-1-2: changeNode의 자식 노드가 없을 때
                            else{
                                changeParentNode.left = null;
                            }
                            //curParentNode의 오른 자식 노드에 삭제할 노드의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연결
                            curParentnode.right = changeNode;
                            //parentNode의 왼쪽 자식 노드가 현재, changeNode이고, changeNode의 왼쪽 / 오른쪽 자식 노드를,모두 삭제할 curNode의 기존 왼쪽 / 오른쪽의 노드로 변
                            changeNode.right = curNode.right;
                            changeNode.left = curNode.left;

                            curNode = null;
                    }
                }
                return true;

            }

        }
    }

    public static void main(String [] args){
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        myTree.delnode(15);
        System.out.println("Head : " + myTree.head.value);
        System.out.println("Head Left : " + myTree.head.left.value);
        System.out.println("Head Left Left: " + myTree.head.left.left.value);
        System.out.println("Head Left Right : " + myTree.head.left.right.value);
        System.out.println("Head Right: " + myTree.head.right.value);
        System.out.println("Head Right Left: " + myTree.head.right.left.value);
        System.out.println("Head Right Right: " + myTree.head.right.right.value);
        System.out.println("Head Right Right Left: " + myTree.head.right.right.left.value);
        System.out.println("Head Right Right Right: " + myTree.head.right.right.right.value);

    }
}
