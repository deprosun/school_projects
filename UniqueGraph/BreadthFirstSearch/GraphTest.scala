object GraphTest{
  def main(args: Array[String]){
    val arad = new GraphNode("arad", null);
    val zerind = new GraphNode("zerind", null);
    val oradea = new GraphNode("oradea", null);
    val timisoara = new GraphNode("timisoara", null);
    val lugoj = new GraphNode("logoj", null);
    val mehadia = new GraphNode("mehadia", null);
    val drobeta = new GraphNode("drobeta", null);
    val craiova = new GraphNode("craiova", null);
    val rimnicuV = new GraphNode("rimnicuV", null);
    val sibiu = new GraphNode("sibiu", null);
    val fagaras = new GraphNode("fagaras", null);
    val pitesti = new GraphNode("pitesti", null);
    val giurgiu = new GraphNode("giurgiu", null);
    val bucharest = new GraphNode("bucharest", null);
    val urziceni = new GraphNode("urziceni", null);
    val eforie = new GraphNode("eforie", null);
    val hirsova = new GraphNode("hirsova", null);
    val vaslui = new GraphNode("vaslui", null);
    val iasi = new GraphNode("iasi", null);
    val neamt = new GraphNode("neamt", null);
    
    //make a graph

    arad.neighborNodes = Array(sibiu,timisoara,zerind);
    oradea.neighborNodes = Array(sibiu,zerind);
    sibiu.neighborNodes = Array(fagaras,rimnicuV);
    rimnicuV.neighborNodes = Array(craiova,pitesti,sibiu);
    pitesti.neighborNodes = Array(bucharest,craiova,rimnicuV);
    bucharest.neighborNodes = Array(fagaras,giurgiu,urziceni);
    fagaras.neighborNodes = Array(bucharest,sibiu);
    urziceni.neighborNodes = Array(bucharest,hirsova,vaslui);
    hirsova.neighborNodes = Array(eforie,urziceni);
    vaslui.neighborNodes = Array(iasi,urziceni);
    iasi.neighborNodes = Array(neamt,iasi);
    giurgiu.neighborNodes = Array(bucharest);
    craiova.neighborNodes = Array(drobeta,pitesti,rimnicuV);
    mehadia.neighborNodes = Array(drobeta,lugoj);
    lugoj.neighborNodes = Array(mehadia,timisoara);
    timisoara.neighborNodes = Array(arad,lugoj);
    eforie.neighborNodes = Array(hirsova);
    drobeta.neighborNodes = Array(craiova,mehadia);
    zerind.neighborNodes = Array(arad,oradea);
    neamt.neighborNodes = Array(iasi);

    bfs(arad, bucharest);
  }

  def bfs(root: GraphNode, x: GraphNode): Unit = {
    val queue = new Queue();
    var isFound = false;
    if((root.getPlace()).equalsIgnoreCase(x.getPlace())){
      println("find in root..");
    }
    else {
    root.visited = true;
    queue.enqueue(root);
    
    while((queue.first != null)&&(isFound==false)){
      val t : GraphNode = queue.dequeue();
      println(t.getPlace()); 
      if((t.getPlace()).equalsIgnoreCase(x.getPlace())){
            println("found "+ t.getPlace());
            isFound=true;
      }
      else {
       for(a <- t.neighborNodes){
        if(a.visited == false){
          a.visited = true;
          queue.enqueue(a);
        }
      }
     }
   }
    if(queue.first == null){
      println(x.getPlace()+" does not exist.");
    }
  }

  }
}
