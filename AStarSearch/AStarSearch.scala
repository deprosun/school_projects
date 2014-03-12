import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList
object AStarSearch {

  def main(args: Array[String]): Unit = {
    var f = ArrayBuffer(5, 4, 2, 8, 6, 7);
    val mh = new MinHeap();
    f = mh.BuildMinHeap(f);
    
    for(j<-f){
      println(j);
    }
    
//    mh.insert(f,5);
  }

}