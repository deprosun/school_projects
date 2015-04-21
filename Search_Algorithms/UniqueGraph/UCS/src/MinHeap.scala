import scala.collection.mutable.ArrayBuffer

class MinHeap {

  def BuildMinHeap(A: ArrayBuffer[GraphNode]) {
    val length = A.length;
    var i = length / 2;
    while (i >= 0) {
      MinHeapify(A, i);
      i = i - 1;
    }
  }

  def MinHeapify(A: ArrayBuffer[GraphNode], i: Int) {
    val left = (2 * i) + 1;
    val right = (2 * i) + 2;
    var min = i;

    if ((left <= A.length - 1) && (A(left).cost < A(min).cost)) {
      min = left;
    }

    if ((right <= A.length - 1) && (A(right).cost < A(min).cost)) {
      min = right;
    }

    if (min != i) {
      val temp = A(min);
      A(min) = A(i);
      A(i) = temp;
      MinHeapify(A, min);
    }
  }

  def insert(A: ArrayBuffer[GraphNode], v: GraphNode) {
    A.append(v);
    siftup(A, A.length - 1);
  }

  def siftup(A: ArrayBuffer[GraphNode], nodeIndex: Int) {
    if (nodeIndex != 0) {
      val parentNode: Int = nodeIndex / 2;
      if (A(nodeIndex).cost < A(parentNode).cost) {
        val temp = A(nodeIndex);
        A(nodeIndex) = A(parentNode);
        A(parentNode) = temp;
        siftup(A, parentNode);

      }
    }
  }

  def ExtractMin(A: ArrayBuffer[GraphNode]): GraphNode = {
    if (!isEmpty(A)) {
      val temp = A(0);
      A(0) = A(A.length - 1);
      A.remove(A.length - 1);
      MinHeapify(A, 0);
      return temp;
    } else {
      println("Empty!");
      return null;
    }
  }
  
  def isEmpty(A: ArrayBuffer[GraphNode]):Boolean={
    return A.isEmpty;
  }

}