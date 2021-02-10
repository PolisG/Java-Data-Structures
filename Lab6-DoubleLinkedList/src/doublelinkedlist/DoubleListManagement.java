package doublelinkedlist;

/**
 *
 * @author Polis
 */
public class DoubleListManagement {
    
    public static void main(String[] args) {
        DoubleLinkedList myList = new DoubleLinkedList();
        String str;
        int choice = 0;
        
        while(choice>=0 || choice<=9) {
            System.out.println("\n**********DOUBLE LINKED LIST MANAGMENT**********");
            System.out.println("1.INSERT ELEMENT AT THE BEGINNING OF THE LIST");
            System.out.println("2.INSERT ELEMENT AT THE END OF THE LIST");
            System.out.println("3.INSERT ELEMENT AT POSITION N OF THE LIST");
            System.out.println("4.DELETE ELEMENT FROM THE BEGINNING OF THE LIST");
            System.out.println("5.DELETE ELEMENT FROM THE END OF THE LIST");
            System.out.println("6.DELETE ELEMENT FROM POSITION N OF THE LIST");
            System.out.println("7.LIST LENGTH");
            System.out.println("8.IS THE LIST EMPTY");
            System.out.println("9.PRINT LIST");
            System.out.println("0.EXIT");
            
            do {
                System.out.println("\nINPUT YOUR CHOICE: ");
                choice = UserInput.getInteger();
            }while(choice<0 ||choice>9);
            
            try {
                switch(choice) {
                    case 0:
                        return;
                    case 1:
                        System.out.println("Enter an element: ");
                        str = UserInput.getString();
                        myList.insertFirst((Object)str);
                        break;
                    case 2:
                        System.out.println("Enter an element: ");
                        str = UserInput.getString();
                        myList.insertLast((Object)str);
                        break;
                    case 3:
                        System.out.println("Please give the position(>0) you want to enter an element and then proceed: ");
                        int position = UserInput.getInteger();
                        str = UserInput.getString();
                        myList.insert(position, (Object)str);
                        break;
                    case 4:
                        System.out.println("Removed from the beginning of the list: "+myList.removeFirst()+"\nSuccess!");
                        break;
                    case 5:
                        System.out.println("Removed from the end of the list: "+myList.removeLast()+"\nSuccess!");
                        break;
                    case 6:
                        System.out.println("Please give the position(>0) from the element you want to remove: ");
                        int pos = UserInput.getInteger();
                        myList.remove(pos);
                        break;
                    case 7:
                        System.out.println("List length: "+myList.size());
                        break;
                    case 8:
                        System.out.println("Empty list? "+myList.isEmpty());
                        break;           
                    case 9:
                        myList.printList();
                        break;
                }
            }
            catch(NoSuchListPosition e) { //catch(NoSuchListPosition | ListEmptyException e)
                System.out.println(e);
            }
            catch(ListEmptyException e) {
                System.out.println(e);
            }
        }
    }
}
