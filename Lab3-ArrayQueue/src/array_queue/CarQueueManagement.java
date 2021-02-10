package array_queue;

/**
 *
 * @author Polis
 */
public class CarQueueManagement {
    public static void main(String[] args) {
        
        System.out.println("Poses theseis na exei h oura ;");
        ArrayQueue obj = new ArrayQueue(UserInput.getInteger());
        
        int choice = 1;
       
        while(choice>0 || choice<5) {
            System.out.println("\n---MENU---");
            System.out.println(" 1.Afiksi kai stoixeia autokinitou");
            System.out.println(" 2.Apoxwrisi autokinitou");
            System.out.println(" 3.Arithmos autokinitwn stin oura");
            System.out.println(" 4.EXIT");
            
            do {
                System.out.println("Dwse epilogh 1-4:");
                choice = UserInput.getInteger();
            }while(choice<0 ||choice>5);
            
            switch(choice) {
                case 1:
                    try {
                        obj.add(Car.readCar());
                    }
                    catch(QueueFullException e) {
                        System.out.println("Queue full can't add another car!");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("First car in queue is "+obj.remove());
                        System.out.println("Successfully removed from the Queue!");
                    }
                    catch(QueueEmptyException e) {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 3:
                    System.out.println("Is car queue empty? -"+obj.isEmpty());
                    System.out.println("Is car queue full? -"+obj.isFull());
                    System.out.println("The number of cars in the queue is "+obj.size());
                    System.out.println(obj);
                break;
            case 4:
                return;
               
        }
    }
    }
}
