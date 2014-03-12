class Queue(){
  var first: GraphNode = null;
  var last: GraphNode = null;

  def enqueue(node: GraphNode): Unit = {
    if(first == null){
      first = node;
      last = first;
    }
    else{
      last.nextNode = node;
      last = node;
    }
  }

  def dequeue():GraphNode = {
    if (first == null){
      return null;
    }

    else{
      val temp = new GraphNode(first.valueNumber, first.neighborNodes, first.nodeName);
      first = first.nextNode;
      return temp;
    }
  }
}

// vim: set ts=2 sw=2 et:
