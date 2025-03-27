/**
 * List Class
 * Custom singly-linked list for player objects
 * @author Cody Bandrowski
 */
public class List {
    private Node head;

    /**
     * Default Constructor
     * Initalizes an empty list
     */
    public List() {
        this.head = null;
    }

    /**
     * copy constructor
     * @param other list to copy
     */
    public List(List other) {
        if(other.head == null) {
            this.head = null;
        }
        this.head = new Node(other.head.getPlayer().createClone());
        Node current = this.head;
        Node otherCurrent = other.head.getNext();
    }

    /**
     * createClone
     * creates and returns a deep copy of the list
     * @return a new cloned list
     */
    public List createClone() {
        return new List(this);
    }
    /**
     * add
     * adds a new player to the front of the list
     * @param player to add
     */
    public void add(Player player){
        Player clonedPlayer = player.createClone();
        Node newNode = new Node(clonedPlayer,head);
        head = newNode;

    }

    /**
     * find
     * finds a player by name
     * @param name to search for
     */
    public Player find(String name){
        Node current = head;
        while(current != null){
            if(current.getPlayer().getName().equals(name)){
                return current.getPlayer();
            }
            current = current.getNext();
        }
        return null;
    }
}
