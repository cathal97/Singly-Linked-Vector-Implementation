/**
 * Created by cathal on 13/02/17.
 */
public class SinglyLinkedVector implements Vector {     //singly linked vector implementation

    private int size;
    private Node front;

    public SinglyLinkedVector(){
        size = 0;
        front = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Object elemAtRank(int rank) {
        if(front == null) throw new VectorEmptyException();     //if vector is empty
        if(rank > size - 1) throw new VectorOutOfBoundsException();     //if attempting to access index out of bounds
        Node temp = front;
        for(int i = 0; i < rank; i++){      //iterate through the list to find the value stored at rank
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public Object replaceAtRank(int rank, Object element) {     //replaces the value at rank with the new value and returns the old value
        if(front == null) throw new VectorEmptyException();
        if(rank > size - 1) throw new VectorOutOfBoundsException();

        Node previous, next;        //stores the nodes before and after the node to be replaced
        Object value;               //temporarialy holds the value to be replaced
        previous = front;
        if(size == 1){      //if size is equal one, only front need be replaced
            value = front.getValue();
            front = new Node(element,null);
        }
        else {
            for (int i = 0; i < rank - 1; i++) {
                previous = previous.getNext();
            }
            value = previous.getNext().getValue();
            next = previous.getNext().getNext();
            previous.setNext(new Node(element, next));
        }
        return value;

    }

    @Override
    public void insertAtRank(int rank, Object element) {        //inserts given value at given rank
        if(rank < 0 || rank > size) throw new VectorOutOfBoundsException();
        if(rank == 0){
            Node temp = front;
            front = new Node(element,temp);
        }
        else{
            Node prev,curr;
            prev = front;
            for(int i = 0; i < rank - 1; i++){
                prev = prev.getNext();
            }
            curr = prev.getNext();
            prev.setNext(new Node(element,curr));
        }
        size++;
    }


    @Override
    public Object removeAtRank(int rank) {      //removes and returns value at given rank
        if(front == null) throw new VectorEmptyException();
        if(rank > size - 1) throw new VectorOutOfBoundsException();

        Node previous, temp;
        previous = front;
        if(rank == 0){
            temp = front.getNext();
            front = temp;
        }
        else {
            for (int i = 0; i < rank - 1; i++) {
                previous = previous.getNext();
            }
            temp = previous.getNext();
            previous.setNext(temp.getNext());
        }
        size--;
        return temp.getValue();
    }

    public String toString(){       //iterates through the vector and returns all elements in string format
        String output = new String("<"+size+"> : ");
        Node temp = front;
        if(size == 0){
            output += "Empty";
        }
        else {
            while(temp != null){
                output += temp.getValue() + " ";       //concatenates each value to the string
                temp = temp.getNext();      //goto next node
            }
        }
        output += "\n";
        return output;
    }


}
