class Node {
  int key, value;
  Node next, prev;
  public Node(int k, int v) {
    key = k;
    value = v;
    next = null;
    prev = null;
  }
}

public class LRUCache {
  private Node head, tail;
  private HashMap<Integer, Node> map;
  private int capacity;
  
  public LRUCache(int c) {
    capacity = c;
    head = null;
    tail = null;
    map = new HashMap<Integer, Node>();
  }
    
  public int get(int key) {
    if (map.get(key) == null) return -1;
    else {
      moveToHead(map.get(key));
      return map.get(key).value;
    }
  }
    
  public void set(int key, int value) {
    if (map.get(key) != null) {
      map.get(key).value = value;
      moveToHead(map.get(key));
    } else {
      Node hd = new Node(key, value);
      map.put(key, hd);
      
      if (tail == null) {
        head = hd;
        tail = hd;
      } else {
        hd.next = head;
        head.prev = hd;
        head = hd;
      }
      
      if (map.size() > this.capacity) {
        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
      }
    }
  }
  
  private void moveToHead(Node node) {
    if (node != head) {
      if (node == tail) {
        tail.prev.next = null;
        tail = tail.prev;
      } else {
        node.next.prev = node.prev;
        node.prev.next = node.next;
      }
      
      node.prev = null;
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
}

