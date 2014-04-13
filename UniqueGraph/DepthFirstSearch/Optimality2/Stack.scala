class Stack(){
  var top: GraphNode = null;

  def push(node: GraphNode): Unit = {
    if(isEmpty()){
      top = node;
      top.nextNode=null;
    }
    else{
      node.nextNode = top;
      top = node;
    }
  }

  def pop(): GraphNode = {
    if(isEmpty() == false){
      val tempNode: GraphNode = top;
      top = top.nextNode;
      return tempNode;
    }
    else{
      return null;
    }
  }

  def isEmpty(): Boolean = {
    if(top == null){
      return true;
    }
    else{
      return false;
    }
  }

}

// vim: set ts=2 sw=2 et:
