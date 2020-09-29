class node
{
  int data;
  node leftchild;
  node rightchild;
  int height;
  //helper functions
  void setdata(int data)
  {
    this.data=data;
  }
  int getData()
  {
    return data;
  }
  void setHeight(int height)
  {
    this.height=height;
  }
  int getHeight()
  {
    return height;
  }
  void setLeftChild(node leftchild)
  {
    this.leftchild=leftchild;
  }
  void setRightChild(node rightchild)
  {
    this.rightchild=rightchild;
  }
  node getLeftChild()
  {
    return leftchild;
  }
  node getRightChild()
  {
    return rightchild;
  }
}
