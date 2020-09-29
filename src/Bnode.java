public class Bnode {
    int data;
    int height;
    Bnode leftChild;
    Bnode rightchild;
    Bnode getLeftChild()
    {
        return leftChild;
    }
    public void setHeight(int value)
    {
      this.height=value;
    }
    Bnode getRightchild()
    {
        return rightchild;
    }
    int getData()
    {
        return data;
    }
    int getHeight()
    {
      return height;
    }
}
