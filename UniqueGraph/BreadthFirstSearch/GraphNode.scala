class GraphNode(value: String ,neighbors: Array[GraphNode]){
  var place: String = value;
  var nextNode: GraphNode = null;
  var neighborNodes: Array[GraphNode] = neighbors;
  var visited: Boolean = false;

  def getPlace():String ={
    return place;
  }

  def getNextNode():GraphNode = {
    return nextNode;
  }

  def getNeighborNodes():Array[GraphNode] = {
    return neighborNodes;
  }

}
// vim: set ts=2 sw=2 et:
