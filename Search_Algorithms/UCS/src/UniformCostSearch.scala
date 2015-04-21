import scala.collection.mutable.ArrayBuffer

object UniformCostSearch {
  def main(args: Array[String]): Unit = {
    var hashmap: Map[String, Int] = Map();
    var explored: Map[String, String] = Map();
    var places = new ArrayBuffer[GraphNode]();

    val A = new GraphNode("A", null);
    val B = new GraphNode("B", null);
    val C = new GraphNode("C", null);
    val D = new GraphNode("D", null);
    val E = new GraphNode("E", null);
    val F = new GraphNode("F", null);
    val G = new GraphNode("G", null);

    A.neighborPlaces = Array(B, D);
    B.neighborPlaces = Array(C);
    C.neighborPlaces = Array(E, G);
    D.neighborPlaces = Array(F, E);
    E.neighborPlaces = Array(B);
    F.neighborPlaces = Array(G);
    G.neighborPlaces = Array(E);

    hashmap += (A.name + B.name -> 5);
    hashmap += (A.name + D.name -> 3);
    hashmap += (B.name + C.name -> 1);
    hashmap += (C.name + E.name -> 6);
    hashmap += (C.name + G.name -> 8);
    hashmap += (D.name + F.name -> 2);
    hashmap += (D.name + E.name -> 2);
    hashmap += (E.name + B.name -> 4);
    hashmap += (F.name + G.name -> 3);
    hashmap += (G.name + E.name -> 4);

    Search(A, G);

    def Search(s: GraphNode, g: GraphNode) {
      val frontier = new MinHeap();
      val start = new GraphNode(s.name, s.neighborPlaces);
      start.cost = s.cost;
      frontier.insert(places, start);

      var found = false;
      while ((!frontier.isEmpty(places)) && (found == false)) {

        if (!frontier.isEmpty(places)) {
          var node = frontier.ExtractMin(places); //popping minimum cost node
          println("poping: " + node.name + " with cost from A as " + node.cost);
          explored += (node.name -> node.name); //marking the node explored

          if (node.name.equalsIgnoreCase(g.name)) {
            found = true;
            println("Found! :)");
            println(node.cost);

          } else {
            for (a <- node.neighborPlaces) {
              //              val n = new GraphNode(a.name, a.neighborPlaces);
              if (!explored.contains(a.name)) {
                a.cost = a.cost + node.cost;
              }
              if (!explored.contains(a.name)) {
                explored += (a.name -> a.name);
                a.cost = a.cost + hashmap(node.name + a.name);
                //                println("Adding cost of "+ a.name + " with cost "+ a.cost);
                println("inserting: " + a.name + " with cost " + a.cost);
                frontier.insert(places, a);
              } else {
                println("already added".toUpperCase() + " " + a.name);
              }
            }
          }
        } else {
          println("Not Found :(");
        }
      }

    }

  }
}