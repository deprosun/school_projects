import scala.collection.mutable.ArrayBuffer

class MinHeap {

  def BuildMinHeap(A: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val length = A.length;
    var i = length / 2;
    while (i >= 0) {
      MinHeapify(A, i);
      i = i - 1;
    }
    return A;
  }

  def MinHeapify(A: ArrayBuffer[Int], i: Int) {
    val left = (2 * i) + 1;
    val right = (2 * i) + 2;

    var min = i;
    if ((left <= A.length - 1) && (A(left) < A(min))) {
      min = left;
    }

    if ((right <= A.length - 1) && (A(right) < A(min))) {
      min = right;
    }

    if (min != i) {
      val temp = A(min);
      A(min) = A(i);
      A(i) = temp;
      MinHeapify(A, min);
    }
  }

  def insert(A: ArrayBuffer[Int], v: Int) {

  }

}