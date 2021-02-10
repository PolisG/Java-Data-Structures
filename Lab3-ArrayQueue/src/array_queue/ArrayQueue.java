package array_queue;

/**
 *
 * @author Polis
 */
public class ArrayQueue implements iQueue {
    //main meta thn class ArrayQueue
    private int capacity;
    private Object arr_q[];
    private int first = 0; //left
    private int last = 0;  //right

    public ArrayQueue() {
        this(100);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr_q = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    
    @Override
    public int size() {
        return (last-first);
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean isFull() {
        return size()==arr_q.length;
    }

    @Override
    public Object front() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException("Queue is empty");
        return arr_q[first];
    }

    @Override
    public void add(Object item) throws QueueFullException {
        if(isFull())
            throw new QueueFullException("Queue full!");
        if(last==arr_q.length) {
            olisthisi();
            add(item);
        }else {
            arr_q[last] = item;
            last++;
        }
    }
    
    @Override
    public Object remove() throws QueueEmptyException {
        Object item;
        if(isEmpty())
            throw new QueueEmptyException("Queue is empty");
        else {
            item = arr_q[first];
            arr_q[first] = null;
            first++;
            return item;
        }
    }
    
    private void olisthisi() {
        for(int i=first; i<last; i++) {
            arr_q[i-first] = arr_q[i];
        }
        last = last-first;
        first = 0;
    }
    
    public static void main(String args[]) {
        int AM, apousies;
        String name, surname;
        double age, vathmos;
        char sex;
        
        System.out.println("Poses theseis na exei h oura ;");
        ArrayQueue obj = new ArrayQueue(UserInput.getInteger());
        
        int choice = 1;
        
        while(choice>0 || choice<7) {
            System.out.println("---MENU---");
            System.out.println(" 1.ENQUEUE");
            System.out.println(" 2.FRONT");
            System.out.println(" 3.DEQUEUE");
            System.out.println(" 4.SIZE");
            System.out.println(" 5.QUEUE EMPTY?");
            System.out.println(" 6.QUEUE FULL?");
            System.out.println(" 0.END PROGRAM");
            
            do {
                System.out.println("Dwse epilogh 0-6");
                choice = UserInput.getInteger();
            }while(choice<0 ||choice>6);
            
            switch(choice) {
                case 0: //Program ends
                    return ;
                case 1:
                    System.out.println("Dwse to AM :");
                    AM = UserInput.getInteger();
                    while(AM < 1) {
                        System.out.print("Dwse to AM(>0): ");
                        AM = UserInput.getInteger();
                    }
                    
                    System.out.println("Dwse ena onoma :");
                    name = UserInput.getString();
                    
                    System.out.println("Dwse to epitheto :");
                    surname = UserInput.getString();
                    
                    System.out.println("Dwse thn hlikia :");
                    age = UserInput.getDouble();
                    while(age < 18) {
                        System.out.print("Dwse swsti hlikia(>18): ");
                        age = UserInput.getDouble();
                    }
                    
                    System.out.println("Dwse to fylo (m for male or f for female) :");
                    sex = UserInput.getCharacter();
                    while(sex != 'm' && sex != 'f') {
                        System.out.print("Dwse to fylo(m/f): ");
                        sex = UserInput.getCharacter();
                    }
                    
                    System.out.println("Dwse tis apousies");
                    apousies = UserInput.getInteger();
                    while(apousies < 0) {
                        System.out.print("Dwse tis apousies, den mporei na einai <0 : ");
                        apousies = UserInput.getInteger();
                    }
                    
                    System.out.println("Dwse ton vathmo");
                    vathmos = UserInput.getDouble();
                    while(vathmos<0 || vathmos>10) {
                        System.out.print("Dwse to vathmo(>=0 <=10): ");
                        vathmos = UserInput.getDouble();
                    }
                    
                    try {
                        obj.add(new Student(AM,name,surname,age,sex,apousies,vathmos));
                    }
                    catch(QueueFullException e) {
                        System.out.println("Queue full can't add another student!");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("----------------");
                        System.out.println("--Front object-- :"+obj.front());
                        System.out.println("----------------");
                    }
                    catch(QueueEmptyException e) {
                        System.out.println("--------------");
                        System.out.println("Queue is empty");
                        System.out.println("--------------");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("----------------");
                        System.out.println("Remove done\n OBJECT :"+ obj.remove()); 
                        System.out.println("----------------");
                    }
                    catch(QueueEmptyException e) {
                        System.out.println("--------------");
                        System.out.println("Queue is empty");
                        System.out.println("--------------");
                    }
                    break;
                case 4:
                    System.out.println("--------------");
                    System.out.println("Size = "+obj.size());
                    System.out.println("--------------");
                    break;
                case 5:
                        System.out.println("--------------");
                        System.out.println("Empty? "+obj.isEmpty());
                        System.out.println("--------------");
                        break;
                case 6:
                    System.out.println("--------------");
                    System.out.println("Full?  "+obj.isFull());
                    System.out.println("--------------");
                    break;
            }
        }
    }
}