import java.io.*;
import java.util.*;
public class Bst {
    Bnode root;
    PrintStream o = System.out;
    public Bnode getRoot()//used to return root
    {
        return root;
    }
    public int getRootvalue()//used to return the value of the root
    {
        return root.data;
    }
    Bst()
    {
        root = null;
    }
    void insert(int data)
    {
        root = insert(root, data);
    }
    Bnode insert(Bnode currentnode, int data)
    {
        if (currentnode == null) {
            Bnode newnode = new Bnode();
            newnode.data = data;
            currentnode = newnode;
            return currentnode;
        } else if (data < currentnode.data)
        {
            currentnode.leftChild = insert(currentnode.leftChild, data);
            return currentnode;
        } else
            {
            currentnode.rightchild = insert(currentnode.rightchild, data);
            return currentnode;
        }
    }
    void inorder(Bnode strtnode) {
        if (strtnode == null)
            return;
        else {
            inorder(strtnode.leftChild);
            System.out.println(strtnode.data);
            inorder(strtnode.rightchild);
        }
    }
    void preorder(Bnode root) {
        if (root == null)
            return;
        else {
            preorder(root.leftChild);
            preorder(root.rightchild);
            System.out.println(root.data);
        }
    }
    void postorder(Bnode root) {
        if (root == null)
            return;
        else {
            System.out.println(root.data);
            postorder(root.leftChild);
            postorder(root.rightchild);

        }
    }
    void search(Bnode root, int searchdata) {
        if (root == null) {
            o.println("Value not found");
            return;
        } else if (root.data == searchdata)
            o.println("Value found");
        else if (searchdata <= root.data)
            search(root.leftChild, searchdata);//element present in left subtree
        else {
            search(root.rightchild, searchdata);//element present in right subtree
        }
    }
    Bnode deletenode(Bnode root, int data) {
        if (root == null) {
            o.println("Value not present in Binary Tree");//if root is empty element does not exist
            return null;
        }
        if (data < root.data)
            root.leftChild = deletenode(root.leftChild, data);//element present in left subtree and it has to be deleted
        else if (data > root.data)
            root.rightchild = deletenode(root.rightchild, data);//element present in right subtree and it has to be deleted
        //done with base conditions
        //if the root node has two children
        else {
            if(root.leftChild!=null && root.rightchild!=null)//both the childs are non-empty
            {
                Bnode temp=root;//assign temporary node to root
                Bnode minimumnode=getmininum(temp.getRightchild());//get the minimum node from the right subtree
                root.data=minimumnode.getData();//replace the root.data with minimum value from right sub tree
                root.rightchild=deletenode(root.rightchild,minimumnode.getData());//then delete the minimum node from right sub tree to avoid duplication
            }
            //if the node has only left child
            else if(root.rightchild==null)
                root=root.leftChild;
            //if the node has only the right child
            else if(root.leftChild==null)
                root=root.rightchild;
            //if the node does not contain any children the root is replaced by null,it will be deleted
            else
                root=null;
        }
        return root;//return the root at the last for the changes to be applied
    }
    void deleteBST()//delete entire tree
    {
        root = null;//just assign null to root then other nodes will be automatically deleted
    }
    private Bnode getmininum(Bnode root)
            //used to get the minimum value from the right subtree
    {
        if(root.leftChild==null)
            return root;
        else
            return getmininum(root.getLeftChild());
    }
    void levelordertraversal()
    {
        Queue<Bnode> q = new LinkedList<Bnode>();
        q.add(root);
        while(!q.isEmpty())
        {
            Bnode presentnode = q.remove();
            o.print(presentnode.data+" ");
            if(presentnode.leftChild!=null)
                q.add(presentnode.getLeftChild());
            if(presentnode.rightchild!=null)
                q.add(presentnode.getRightchild());
        }
    }
}
