
/**
 * Creates own linked list
 *
 * @author Vance Field
 * @version 27-Apr-2016
 */
public class AddressList {
    
    private ListNode head,currentNode;
    
    /**
     * This nested, private class represents a node of a singly linked list.
     */
    private class ListNode {

        private String name;
        private String tel; // Telephone number
        private String email;
        private String addr; // Address
        private String dob; // Date of birth
        private ListNode next; // Pointer to the next node

        private ListNode(String name, String tel, String email, String addr, String dob) {
            this.name = name;
            this.tel = tel;
            this.email = email;
            this.addr = addr;
            this.dob = dob;
        } // end of the constructor

        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public String getEmail() {
            return email;
        }

        public String getAddr() {
            return addr;
        }

        public String getDob() {
            return dob;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode link) {
            next = link;
        }
    } // end of class ListNode
    
    /**
     * Returns whether the list is empty
     * @return head
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Adds a ListNode to the front of the list
     *
     * @param name name
     * @param tel phone number
     * @param email email
     * @param address address
     * @param dob date of birth
     */
    public void addToFront(String name, String tel, String email, String address, String dob) {
        // creates new node 
        ListNode currentNode = new ListNode(name, tel, email, address, dob);
        // adds new node to the front of the list
        currentNode.setNext(head);
        // sets the head node to the current node
        head = currentNode; 
    }
    
    /**
     * Adds a ListNode to the back of the list
     *
     * @param name name
     * @param tel phone number
     * @param email email
     * @param address address
     * @param dob date of birth
     */
    public void addToBack(String name, String tel, String email, String address, String dob) {
        // creates new node
        ListNode node = new ListNode(name, tel, email, address, dob);
        // helper method
        add(node, head);
    } 
    
    /**
     * Helper method that adds node to the end of the list
     * @param newNode
     * @param current 
     */
    private void add(ListNode newNode, ListNode current) {
        if (current == null) {
            head = newNode;
            head.setNext(null);
        } else if (current.getNext() != null) {
            add(newNode, current.getNext());
        } else {
            currentNode = current;
            currentNode.setNext(newNode);
        }
    }
  
    /**
     * toString
     *
     * @return information from the ListNodes
     */
    public String toString() {
        // helper method
        return toStringHelper(head, "");
    }
    
    /**
     * Helper method that gets each node's toString
     * @param node
     * @param str
     * @return
     */
    private String toStringHelper(ListNode node, String str) {
        if (node == null) 
            return str;        

        str = str + node.name + " " + node.tel + " " + node.email + " " + node.addr + " " + node.dob + "\n";

        if (node.next == null) 
            return str;        

        return toStringHelper(node.next, str);
    }
    
    /**
     * reverse of toString
     *
     * @return String; the reversed toString
     */
    public String reverseToString() {
        // helper method
        return reverseToStringHelper(head, "");
    } 
    
    /**
     * Helper method for reverseToString()
     * @param node
     * @param str
     * @return 
     */
    private String reverseToStringHelper(ListNode node, String str) {
        if (node == null) 
            return str;        

        str += reverseToStringHelper(node.next, str);
        str += node.name + " " + node.tel + " " + node.email + " " + node.addr 
                + " " + node.dob + "\n";

        return str;
    }
    
    /**
     * Reverses the current list
     *
     * @return a reverse copy of the current list
     */
    public AddressList reverse() {
        // helper method
        return reverseHelper(head, new AddressList());
    }
    
    /**
     * Helper method for reverse() that adds each node to a new list
     * @param node
     * @param newList
     * @return 
     */
    private AddressList reverseHelper(ListNode node, AddressList newList) {
        if (node == null) 
            return newList;        

        newList.addToFront(node.getName(), node.getTel(), node.getEmail(), 
                node.getAddr(), node.getDob());
        newList = reverseHelper(node.getNext(), newList);

        return newList;
    } 
    
    /**
     * Size of current list
     *
     * @return size of current list
     */
    public int sizeOf() {
        return count(head, 0);
    } 
    
    /**
     * Helper method for sizeOf()
     * @param node
     * @param i
     * @return 
     */
    private int count(ListNode node, int i) {
        if (node == null) 
            return i;
        
        if (node.next == null) {
            i = i + 1;
            return i;
        }

        i += 1;
        return count(node.next,i);
    }
    
    /**
     * Finds phone number by given name
     *
     * @param name name entered
     * @return String; phone number desired
     */
    public String phoneNumberByName(String name) {
        return phoneNumberByNameHelper(name, head);
    }
    
    /**
     * Helper method for phoneNumberByName()
     * @param name
     * @param node
     * @return 
     */
    private String phoneNumberByNameHelper(String name, ListNode node) {
        if (node == null) 
            return "No matching data";        
        
        if (node.getName().equals(name)) 
            return node.getTel();
        else 
            return phoneNumberByNameHelper(name, node.getNext());        
    }
    
    /**
     * Finds email by given name
     *
     * @param name name entered
     * @return String; email desired
     */
    public String emailByName(String name) {
        return emailByNameHelper(name, head);
    }
    
    /**
     * Helper method for emailByName()
     * @param name
     * @param node
     * @return 
     */
    private String emailByNameHelper(String name, ListNode node) {
        if (node == null) 
            return "No matching data";
        
        if (node.getName().equals(name)) 
            return node.getEmail();
        else 
            return emailByNameHelper(name, node.getNext());        
    }
    
    /**
     * Finds name by given phone number
     *
     * @param tel phone number entered
     * @return String; name desired
     */
    public String nameByPhoneNumber(String tel) {
        return nameByPhoneNumberHelper(tel, head);
    }
    
    /**
     * Helper method for nameByPhoneNumber()
     * @param tel
     * @param node
     * @return 
     */
    private String nameByPhoneNumberHelper(String tel, ListNode node) {
        if (node == null) {
            return "No matching data";
        }

        if (node.getTel().equals(tel)) {
            return node.getName();
        } else {
            return nameByPhoneNumberHelper(tel, node.getNext());
        }
    }
    
    /**
     * Finds date of birth by given name
     *
     * @param name name entered
     * @return String; date of birth desired
     */
    public String dobByName(String name) {
        return dobByNameHelper(name, head);
    }
    
    /**
     * Helper method for dobByName()
     * @param name
     * @param node
     * @return 
     */
    private String dobByNameHelper(String name, ListNode node) {
        if (node == null) {
            return "No matching data";
        }

        if (node.getName().equals(name)) {
            return node.getDob();
        } else {
            return dobByNameHelper(name, node.getNext());
        }
    }
}
