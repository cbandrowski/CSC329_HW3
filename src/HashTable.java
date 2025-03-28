/**
 * HashTable class
 * Custom hash table
 * @author Cody Bandrowski
 */
public class HashTable {
    private int size;
    private List[] buckets;
    private double loadFactor = 0.75;

    /**
     * Default constructor
     * Initializes with 4 buckets
     */
    public HashTable() {
        buckets = new List[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new List();
        }
        size = 0;
    }

    /**
     * copy constructor
     * @param other hashtable
     */
    public HashTable(HashTable other) {
        this.buckets = new List[other.buckets.length];
        for(int i = 0; i < buckets.length; i++) {
            this.buckets[i] = other.buckets[i].createClone() ;
        }
        this.size = other.size;
    }
    /**
     *createClone
     * creates and returns a clone deep copy
     * @return cloned HashTable
     */
    public HashTable createclone() {
        return new HashTable(this);
    }

    /**
     * add
     * Adds a player to HashTable
     * @param p player
     */
    public void add(Player p){
        if((double)(size + 1)/ buckets.length > loadFactor){
            resize();
        }
        int index = getIndex(p);
        buckets[index].add(p);
        size++;
    }
    /**
     * find
     * search for player
     * @param name
     * @return player if found null if not found
     */
    public Player find(String name) {
        for (List bucket : buckets) {
            Player found = bucket.find(name);
            if (found != null) return found;
        }
        return null;
    }


    /**
     * resize
     * doubles the number of buckets and rehashes
     */
    private void resize() {
        List[] oldBuckets = buckets;
        buckets = new List[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new List();
        }
        size = 0;
        for (List bucket : oldBuckets) {
            Node current = getHead(bucket);
            while (current != null) {
                add(current.getPlayer().createClone());
                current = current.getNext();
            }
        }
    }

    /**
     * GetHead
     * @param bucket
     * @return
     */
        private Node getHead(List bucket){
            return bucket.getHead();
        }

    /**
     * getIndex
     * @param p
     * @return int index
     */
    public int getIndex(Player p){
            int hash = p.hashCode();ß
            return hash % buckets.length;
    }

    /**
     * showBucket
     * @param bucket
     */
    public void showBucket(List bucket){
        Node current = getHead(bucket);
        while (current != null) {
            System.out.println(current.getPlayer()+ "\n");
            current = current.getNext();
        }
        System.out.println("Null");
    }

}
