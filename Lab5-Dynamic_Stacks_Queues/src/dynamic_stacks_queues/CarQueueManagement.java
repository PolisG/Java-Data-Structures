package dynamic_stacks_queues;

/**
 *
 * @author Polis
 */
public class CarQueueManagement {
    public static void main(String[] args) {
        
        LinkedQueue lq = new LinkedQueue();
        int choice = 1;
       
        while(choice>0 || choice<5) {
            System.out.println("--------MENU--------");
            System.out.println("1. Afiksi kai stoixeia autokinitou");
            System.out.println("2. Apoxwrisi autokinitou");
            System.out.println("3. Arithmos autokinitwn stin oura");
            System.out.println("4. EXIT");
            
            do {
                System.out.println("Dwse epilogh 1-4");
                choice = UserInput.getInteger();
            }while(choice<0 ||choice>5);
            
            switch(choice) {
                case 1:
                    lq.add(Car.readCar());
                    break;
                case 2:
                    try {
                        System.out.println("First car in queue is "+lq.remove());
                        System.out.println("Successfully removed from the Queue!");
                    }
                    catch(QueueEmptyException e) {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 3:
                    System.out.println("Is car queue empty? -"+lq.isEmpty());
                    System.out.println("The number of cars in the queue is "+lq.size());

                    for(int i=0; i<lq.size(); i++) {
                        Car temp = (Car)lq.remove();
                        System.out.println("License plate: " + temp.getLicense_plate());
                        lq.add(temp);
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
