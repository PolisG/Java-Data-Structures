package simple_linked_list;

/**
 *
 * @author Polis
 */
public class SLListManagement {
    
    public static void main(String[] args) {
        
        SimpleLinkedList myList = new SimpleLinkedList();
        String str;
        int choice = 0;
        
        while(choice>=0 || choice<=8) {
            System.out.println("\n**********LINKED LIST MANAGMENT**********");
            System.out.println("1.INSERT ELEMENT AT THE BEGINNING OF THE LIST");
            System.out.println("2.INSERT ELEMENT AT THE END OF THE LIST");
            System.out.println("3.DELETE ELEMENT FROM THE BEGINNING OF THE LIST");
            System.out.println("4.DELETE ELEMENT FROM THE END OF THE LIST");
            System.out.println("5.LIST LENGTH");
            System.out.println("6.IS THE LIST EMPTY");
            System.out.println("7.PRINT LIST");
            System.out.println("8.EXIT");
            
            do {
                System.out.println("\nINPUT YOUR CHOICE:");
                choice = UserInput.getInteger();
            }while(choice<1 ||choice>8);
            
            switch(choice) {
                case 1:
                    System.out.println("Enter an element");
                    str = UserInput.getString();
                    myList.insertFirst((Object)str);
                    break;
                case 2:
                    System.out.println("Enter an element");
                    str = UserInput.getString();
                    myList.insertLast((Object)str);
                    break;
                case 3:
                    try {
                        System.out.println("Deleted from the beginning : "+myList.removeFirst()+"\nSuccess!");
                    }
                    catch(ListEmptyException e) {
                        System.out.println("Empy list! Can not delete.");
                    }
                    break;
                case 4:
                    try {                      
                        System.out.println("Deleted from the end : "+myList.removeLast()+"\nSuccess!");
                    }
                    catch(ListEmptyException e) {
                        System.out.println("Empy list! Can not delete.");
                    }
                    break;
                case 5:
                    System.out.println("List length : "+myList.size());
                    break;
                case 6:
                    System.out.println("Is the list empty ? "+myList.isEmpty());
                    break;
                case 7:
                    //case7: try {myList.printList();}catch(ListEmptyException e) { System.out.println(e);} break;
                    //case7: SLListNode current = myList.getFirst(); while(current != null) {System.out.println(current.getNodeData); current = current.getNextNode();} break;
                    System.out.println("List is : \n");
                    try {
                        myList.printList();
                    }
                    catch(ListEmptyException e) {
                        System.out.println(e);
                    }
                    break;
                case 8:
                    return;
            }
        }
    }
}
