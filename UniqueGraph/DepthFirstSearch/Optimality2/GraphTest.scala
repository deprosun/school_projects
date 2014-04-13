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

    arad.neighborNodes = Array(zerind, timisoara, sibiu);
    oradea.neighborNodes = Array(zerind,sibiu);
    sibiu.neighborNodes = Array(rimnicuV,fagaras);
    rimnicuV.neighborNodes = Array(sibiu, pitesti,craiova);
    pitesti.neighborNodes = Array(rimnicuV, craiova, bucharest);
    bucharest.neighborNodes = Array(urziceni, giurgiu,fagaras);
    fagaras.neighborNodes = Array(sibiu,bucharest);
    urziceni.neighborNodes = Array(vaslui,hirsova,bucharest);
    hirsova.neighborNodes = Array(urziceni, eforie);
    vaslui.neighborNodes = Array(urziceni,iasi);
    iasi.neighborNodes = Array(iasi,neamt);
    giurgiu.neighborNodes = Array(bucharest);
    craiova.neighborNodes = Array(rimnicuV,pitesti,drobeta);
    mehadia.neighborNodes = Array(lugoj,drobeta);
    lugoj.neighborNodes = Array(timisoara, mehadia);
    timisoara.neighborNodes = Array(lugoj, arad);
    eforie.neighborNodes = Array(hirsova);
    drobeta.neighborNodes = Array(mehadia,craiova);
    zerind.neighborNodes = Array(oradea,arad);
    neamt.neighborNodes = Array(iasi);

    dfs(arad, bucharest);
  }

  def dfs(root:GraphNode, x:GraphNode): Unit = {
    val stack = new Stack();
    var isFound : Boolean = false;
    if((root.getPlace()).equalsIgnoreCase(x.getPlace())){
      println("Already in "+ root.getPlace());
    }
    else{
      var tempNode: GraphNode = root;
      stack.push(tempNode);
      while((!stack.isEmpty()) && (isFound == false)){
        tempNode = stack.pop();
        println("popped.."+tempNode.getPlace());
        if((tempNode.getPlace()).equalsIgnoreCase(x.getPlace())){
          isFound = true;
        }
        else if(tempNode.visited == false){
          tempNode.visited = true;
          for(a <- tempNode.getNeighborNodes()){
            if(a.visited == false){
            stack.push(a);
          }
        }
      }
    }
  }
}
}
