package sections6;

public class LinkedList {

  static class Node {

    int value;
    Node next;

    // Constructor
    Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  // 建立兩個指標的節點 head 和 tail
  private Node head;
  private Node tail;

  public LinkedList() {
  }

  ;

  // 新增節點
  public void add(int value) {
    // 如果 head 為空，則建立新節點並指定給 head，並將 tail 指向 head
    if (head == null) {
      head = new Node(value);
      tail = head;
    } else {
      // 如果 head 不為空，則建立新節點並指定給 tail.next，並將 tail 指向 tail.next
      tail.next = new Node(value);
      tail = tail.next;
    }
  }

  // 搜尋節點
  public Integer search(int value) {
    // 判空，如果 head 為空，則回傳 null
    if (head == null)
      return null;

    // 建立一個指標節點 node，指向 head
    Node node = head;
    // 當 node 不為空時，進行迴圈
    while (true) {
      // 如果 node 為空，則回傳 null
      if (node == null)
        return null;
      // 如果 node 的值等於 value，則回傳 node 的值
      if (node.value == value)
        return node.value;
      // 將 node 指向 node.next
      node = node.next;
    }
  }

  public void remove(int value){
    Node node = head;
    Node nodeTarget = null;
    Node nodePrev = null;

    while(true){
      if(node == null) break;

      if(node.value == value){
        nodeTarget = node;
        break;
      }

      nodePrev = node;
      node = node.next;
    }
   if (nodeTarget == null) return;
   if (nodeTarget == head) {
     head = head.next;
   }else{
      nodePrev.next = nodeTarget.next;
   }
  }

  public static void main(String[] args) {
    // 建立 LinkedList 物件
    LinkedList linkedList = new LinkedList();

    // add O(1) - 第一個新增的節點
    linkedList.add(9);

    // add O(1) - 從後面開始新增的
    linkedList.add(11);
    linkedList.add(34);
    linkedList.add(68);
    linkedList.add(26);
    linkedList.add(99);

    // search O(n) - 搜尋節點
    int value = linkedList.search(34);

    // remove O(n) - 移除節點
    linkedList.remove(34);


  }
}


