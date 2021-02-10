package doublelinkedlist2;

/**
 *
 * @author Polis
 */
public class NumbersList { //Epipleon eksaskisi
    
    public static void main(String[] args) {
        char choise;
        DoubleLinkedList myList = new DoubleLinkedList();
        
        do {
            System.out.print("Insert a number in the list: ");
            int num = UserInput.getInteger();
            myList.insert(num);
            System.out.println("Do you want to continue?(y/n) ");
            choise = UserInput.getCharacter();
            while(choise != 'y' && choise != 'n') {
                System.out.print("(y/n): ");
                choise = UserInput.getCharacter();
            }
        }while(choise!='n');
        
        boolean sorted = myList.isSorted();
        if(sorted == false)
            System.out.println("Mh taksinomimenoi!");
        else
            System.out.println("Taksinomimenoi.");
    }
}
