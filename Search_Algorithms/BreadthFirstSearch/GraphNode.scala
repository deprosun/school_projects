class GraphNode(value: Int ,neighbors: Array[GraphNode], nameOfNode: String){
  var valueNumber: Int = value;
  var nextNode: GraphNode = null;
  var neighborNodes: Array[GraphNode] = neighbors;
  var nodeName: String = nameOfNode;
  var visited: Boolean = false;

  def printElements(): Unit = {
    println(this.valueNumber);
    for(j <- neighborNodes){
      println(j.valueNumber);
    }
  }

  def getValue():Int ={
    return valueNumber;
  }

  def getNextNode():GraphNode = {
    return nextNode;
  }

  def getNeighborNodes():Array[GraphNode] = {
    return neighborNodes;
  }

  def getNodeName():String={
    return nodeName;
  }
}
// vim: set ts=2 sw=2 et:
