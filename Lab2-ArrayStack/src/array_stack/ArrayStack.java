package array_stack;

/**
 *
 * @author Polis
 */
public class ArrayStack implements iStack {
    //main meta tin class ArrayStack
    public static final int capacity = 100;
    private Object arr_s[];
    private int itop = -1;

    public ArrayStack() {
        this(capacity);
    }

    public ArrayStack(int capacity) {
        arr_s = new Object[capacity];
    }
    
    @Override
    public int size() {
        return (itop+1);
    }

    @Override
    public boolean isEmpty() {
        return (itop<0);
    }

    @Override
    public boolean isFull() {
        return (itop == arr_s.length);
    }

    @Override
    public Object top() throws StackEmptyExc {
        if(size() == arr_s.length)
            throw new StackEmptyExc("Stack is empty");
        return arr_s[itop];
    }

    @Override
    public void push(Object item) throws StackFullExc {
        if(size() == arr_s.length)
            throw new StackFullExc("Stack overflow");
        arr_s[++itop] = item;
    }

    @Override
    public Object pop() throws StackEmptyExc {
        Object obj;
        if(isEmpty())
            throw new StackEmptyExc("Stack is empty");
        obj = arr_s[itop];
        arr_s[itop--] = null;
        return obj;
    }
    
    public static void main(String args[]) {
        int AM, apousies;
        String name, surname;
        double age, vathmos;
        char sex;
        
        System.out.println("Poses theseis na exei h stoiva ;");
        ArrayStack obj1 = new ArrayStack(UserInput.getInteger());
        
        int choice = 1;
        
        while(choice>0 || choice<7) {
            System.out.println("---MENU---");
            System.out.println(" 1.PUSH");
            System.out.println(" 2.TOP");
            System.out.println(" 3.POP");
            System.out.println(" 4.SIZE");
            System.out.println(" 5.EMPTY");
            System.out.println(" 6.FULL");
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
                        obj1.push(new Student(AM,name,surname,age,sex,apousies,vathmos));
                    }
                    catch(StackFullExc e) {
                        System.out.println("Stack full can't push!");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("--------------");
                        System.out.println("--Top object-- :"+obj1.top());
                        System.out.println("--------------");
                    }
                    catch(StackEmptyExc e) {
                        System.out.println("--------------");
                        System.out.println("Stack is empty");
                        System.out.println("--------------");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("--------------");
                        System.out.println("Pop done\n OBJECT :"+ obj1.pop()); 
                        System.out.println("--------------");
                    }
                    catch(StackEmptyExc e) {
                        System.out.println("--------------");
                        System.out.println("Stack is empty");
                        System.out.println("--------------");
                    }
                    break;
                case 4:
                    System.out.println("--------------");
                    System.out.println("Size = "+obj1.size());
                    System.out.println("--------------");
                    break;
                case 5:
                        System.out.println("--------------");
                        System.out.println("Empty? "+obj1.isEmpty());
                        System.out.println("--------------");
                        break;
                case 6:
                    System.out.println("--------------");
                    System.out.println("Full?  "+obj1.isFull());
                    System.out.println("--------------");
                    break;
            }
        }
    }
}