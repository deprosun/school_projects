import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList
import scala.collection.mutable.HashMap
object AStarSearch {

  def main(args: Array[String]): Unit = {
    var hashmap: Map[String, Int] = Map();
    var places = new ArrayBuffer[GraphNode]();

    val arad = new GraphNode("arad", 366);
    val sibui = new GraphNode("sibui", 253);
    val timisora = new GraphNode("timisora", 329);
    val zerind = new GraphNode("zerind", 374);
    val oradea = new GraphNode("oradea", 380);
    val fagaras = new GraphNode("fagaras", 176);
    val bucharest = new GraphNode("bucharest", 0);
    val pitesti = new GraphNode("pitesti", 100);
    val rimnicuVilcea = new GraphNode("rimnicuVilcea", 193);
    val craiova = new GraphNode("craiova", 160);
    val giurgiu = new GraphNode("giurgiu", 77);
    val drobeta = new GraphNode("drobeta", 242);
    val mehadia = new GraphNode("mehadia", 241);
    val lugoj = new GraphNode("lugoj", 244);
    val neamt = new GraphNode("neamt", 234);
    val iasi = new GraphNode("iasi", 226);
    val vaslui = new GraphNode("vaslui", 199);
    val urziceni = new GraphNode("urziceni", 80);
    val hirsova = new GraphNode("hirsova", 151);
    val eforie = new GraphNode("eforie", 161);

    arad.setNeighbors(sibui, timisora, zerind);
    sibui.setNeighbors(arad, oradea, fagaras, rimnicuVilcea);
    timisora.setNeighbors(arad, lugoj);
    zerind.setNeighbors(arad, oradea);
    oradea.setNeighbors(zerind, sibui);
    fagaras.setNeighbors(sibui, bucharest);
    bucharest.setNeighbors(pitesti, urziceni, fagaras, giurgiu);
    pitesti.setNeighbors(rimnicuVilcea, bucharest, craiova);
    rimnicuVilcea.setNeighbors(pitesti, craiova, sibui);
    craiova.setNeighbors(rimnicuVilcea, pitesti, drobeta);
    giurgiu.setNeighbors(bucharest);
    drobeta.setNeighbors(mehadia, craiova);
    mehadia.setNeighbors(lugoj, drobeta);
    lugoj.setNeighbors(timisora, mehadia);
    neamt.setNeighbors(iasi);
    iasi.setNeighbors(neamt, vaslui);
    vaslui.setNeighbors(iasi, urziceni);
    urziceni.setNeighbors(bucharest, vaslui, hirsova);
    hirsova.setNeighbors(urziceni, eforie);
    eforie.setNeighbors(hirsova);

    //arad
    hashmap += (arad.getPlace() + sibui.getPlace() -> 140);
    hashmap += (arad.getPlace() + timisora.getPlace() -> 118);
    hashmap += (arad.getPlace() + zerind.getPlace() -> 75);

    //sibui
    hashmap += (sibui.getPlace() + oradea.getPlace() -> 151);
    hashmap += (sibui.getPlace() + fagaras.getPlace() -> 99);
    hashmap += (sibui.getPlace() + rimnicuVilcea.getPlace() -> 80);

    //timisora
    hashmap += (timisora.getPlace() + lugoj.getPlace() -> 111);

    //zerind
    hashmap += (zerind.getPlace() + oradea.getPlace() -> 71);

    //fagaras
    hashmap += (fagaras.getPlace() + bucharest.getPlace() -> 211);

    //bucharest
    hashmap += (bucharest.getPlace() + urziceni.getPlace() -> 85);
    hashmap += (bucharest.getPlace() + pitesti.getPlace() -> 101);
    hashmap += (bucharest.getPlace() + giurgiu.getPlace() -> 90);

    //pitesti
    hashmap += (pitesti.getPlace() + rimnicuVilcea.getPlace() -> 97);
    hashmap += (pitesti.getPlace() + craiova.getPlace() -> 138);

    //rimnicuVilcea
    hashmap += (rimnicuVilcea.getPlace() + craiova.getPlace() -> 146);

    //craiova
    hashmap += (craiova.getPlace() + drobeta.getPlace() -> 120);

    //drobeta
    hashmap += (drobeta.getPlace() + mehadia.getPlace() -> 75);

    //mehadia
    hashmap += (mehadia.getPlace() + lugoj.getPlace() -> 70);

    //neamt
    hashmap += (neamt.getPlace() + iasi.getPlace() -> 87);

    //iasi
    hashmap += (iasi.getPlace() + vaslui.getPlace() -> 92);

    //vaslui
    hashmap += (vaslui.getPlace() + urziceni.getPlace() -> 142);

    //urziceni
    hashmap += (urziceni.getPlace() + hirsova.getPlace() -> 98);

    //hirasova
    hashmap += (hirsova.getPlace() + eforie.getPlace() -> 86);
    AStarSearchFind(arad, bucharest);

    def AStarSearchFind(s: GraphNode, g: GraphNode) {
      val frontier = new MinHeap;
      val k = new GraphNode(s.getPlace(), s.getHeuristic);
      k.neighborPlaces = s.neighborPlaces;
      println(k.getPlace().toUpperCase() + " is the start node");
      frontier.insert(places, k);
      var found = false;
      while ((found == false) && !(frontier.isEmpty(places))) {
        val p = frontier.ExtractMin(places);
        System.err.println("Dequeued " + p.getPlace().toUpperCase() + " with estimation " + p.getFunction());
        if (p.getPlace().equalsIgnoreCase(g.getPlace())) {
          println("found..");
          found = true;
        } else {
          for (c <- p.getNeighbors) {
            val k = new GraphNode(c.getPlace(), c.getHeuristic);
            k.neighborPlaces = c.neighborPlaces;
            if (hashmap.contains(p.getPlace() + k.getPlace())) {
              k.setFunction(math.abs(p.getFunction() - p.getHeuristic) + hashmap(p.getPlace() + k.getPlace()));
            } else {
              k.setFunction(math.abs(p.getFunction() - p.getHeuristic) + hashmap(k.getPlace() + p.getPlace()));
            }
            frontier.insert(places, k);
            println("Enqueued " + k.getPlace().toUpperCase() + " with estimation " + k.getFunction());
          }
        }
      }
    }
  }

}