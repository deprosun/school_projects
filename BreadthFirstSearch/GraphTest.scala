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

    bfs(n1, 24);
  }

  def bfs(root: GraphNode, x: Int): Unit = {
    val queue = new Queue();
    var isFound = false;
    if(root.valueNumber == x){
      println("find in root..");
    }
    else {
    root.visited = true;
    queue.enqueue(root);
    
    while((queue.first != null)&&(isFound==false)){
      val t : GraphNode = queue.dequeue();

      for(a <- t.neighborNodes){
        if(a.visited == false){
          a.visited = true;
          println(a.nodeName);
          if(a.valueNumber == x){
            println("found in "+ a.nodeName);
            isFound=true;
          }
          queue.enqueue(a);
        }
      }
    }
    if(queue.first == null){
      println(x+" does not exist in the graph");
    }
  }

  }
}
