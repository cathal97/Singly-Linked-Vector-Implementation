/**
 * Created by cathal on 13/02/17.
 */
public class VectorTest {
    public static void main(String[] args){     //class to test the vector implementation
        Vector<Object> myVector = new SinglyLinkedVector();
        System.out.println(myVector.isEmpty());
        System.out.println(myVector.toString());

        myVector.insertAtRank(0,"L");
        System.out.println(myVector.toString());
        myVector.insertAtRank(1,"L");
        System.out.println(myVector.toString());
        myVector.insertAtRank(0,"A");
        //System.out.println(myVector.toString());
        myVector.insertAtRank(3,"O");
        System.out.println(myVector.toString());
        myVector.insertAtRank(0,"E");
        System.out.println(myVector.toString());
        myVector.insertAtRank(0,"H");
        System.out.println(myVector.toString());
        myVector.removeAtRank(2);
        System.out.println(myVector.toString());

    }
}
