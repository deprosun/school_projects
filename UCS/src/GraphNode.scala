class GraphNode(placeName: String, neighbors: Array[GraphNode]) {
	var name : String = placeName;
	var neighborPlaces : Array[GraphNode] = neighbors;
	var cost: Int = 0;
}
