class GraphNode(placeName: String, h_sld: Int) {
  var place: String = placeName;
  var neighborPlaces: Array[GraphNode] = null;
  var explored: Boolean = false;
  var function: Int = 0;

  def getPlace(): String = {
    return place;
  }

  def getNeighbors: Array[GraphNode] = {
    return neighborPlaces;
  }

  def getHeuristic: Int = {
    return h_sld;
  }

  def getFunction(): Int = {
    if (function == 0) {
      return h_sld;
    } else {
      return function;
    }
  }

  def setNeighbors(place1: GraphNode): Unit = {
    neighborPlaces = Array(place1);
  }

  def setNeighbors(place1: GraphNode, place2: GraphNode, place3: GraphNode): Unit = {
    neighborPlaces = Array(place1, place2, place3);
  }

  def setNeighbors(place1: GraphNode, place2: GraphNode, place3: GraphNode, place4: GraphNode): Unit = {
    neighborPlaces = Array(place1, place2, place3, place4);
  }

  def setNeighbors(place1: GraphNode, place2: GraphNode): Unit = {
    neighborPlaces = Array(place1, place2);
  }

  def setFunction(g: Int) {
    function = h_sld + g;
  }
}
