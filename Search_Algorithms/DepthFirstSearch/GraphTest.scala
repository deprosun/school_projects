object GraphTest{
  def main(args: Array[String]){
    val n1 = new GraphNode(2, null, "n1");
    val n2 = new GraphNode(5, null, "n2");
    val n3 = new GraphNode(6, null, "n3");
    val n4 = new GraphNode(3, null, "n4");
    val n5 = new GraphNode(7, null, "n5");
    
    //make a graph
    n1.neighborNodes = Array(n2,n3,n5);
    n2.neighborNodes = Array(n1,n4);
    n3.neighborNodes = Array(n1,n4,n5);
    n4.neighborNodes = Array(n2,n3,n5);
    n5.neighborNodes = Array(n1,n3,n4);

    dfs(n1,5);
  }

  def dfs(root:GraphNode, x:Int): Unit = {
    val stack = new Stack();
    var isFound : Boolean = false;
    if((root.getValue()) == x){
      println("Found in root"+ root.getNodeName());
    }
    else{
      var tempNode: GraphNode = root;
      stack.push(tempNode);
      while((!stack.isEmpty()) && (isFound == false)){
        tempNode = stack.pop();
        if(tempNode.visited == false){
          tempNode.visited = true;
          for(a <- tempNode.getNeighborNodes()){
            if(a.getValue()==x){
              println("Found in "+a.getNodeName());
              isFound = true;
            }
            if(isFound == false){
            stack.push(a);
            }
          }
        }
      }
    }
  }
}
