class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        remove(node);
        addToFront(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.val = value;

            remove(node);
            addToFront(node);
            return;
        }

        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        addToFront(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}