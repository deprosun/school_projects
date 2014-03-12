class GraphNode (placeName: String, neighbors: Array[GraphNode], h_sld: Int){
  var place: String = placeName;
  var neighborPlaces: Array[GraphNode] = neighbors;
  
  def getPlace(): String = {
    return place;
  }

  def getNeighbors: Array[GraphNode] = {
    return neighborPlaces;
  }

  def getHeuristic: Int = {
    return h_sld;
  }
}
