package simple_linked_list;

/**
 *
 * @author Polis
 */
public class StudentListManagement extends SimpleLinkedList {
    
    public static Student megalyterosVathmos(SimpleLinkedList obj) {
        SLListNode temp;
        
        Student bestStudent; //Krataw ton foithth me ton kalytero vathmo
        if(obj.isEmpty())
            throw new ListEmptyException("List is empty!");
        else
            temp = obj.getFirstNode();
        bestStudent = (Student)(obj.getFirstNode().getNodeData());
        
        while(temp!=null) {
            if(((Student)temp.getNodeData()).getVathmos()>bestStudent.getVathmos())
                bestStudent= (Student)temp.getNodeData();
            temp = temp.getNextNode();
        }
        return bestStudent;
    }
    
    public static Student mikroterosVathmos(SimpleLinkedList obj) {
        SLListNode temp;
        
        Student worstStudent; //Krataw ton foithth me ton xeirotero vathmo
        if(obj.isEmpty())
            throw new ListEmptyException("List is empty!");
        else
            temp = obj.getFirstNode();
        worstStudent = (Student)(obj.getFirstNode().getNodeData());
        
        while(temp!=null) {
            if(((Student)temp.getNodeData()).getVathmos()<worstStudent.getVathmos())
                worstStudent= (Student)temp.getNodeData();
            temp = temp.getNextNode(); 
        }
        return worstStudent;
    }
    
    public static void main(String args[]) {
        int AM, age, apousies;
        String name, surname;
        char sex;
        double vathmos;
        
        SimpleLinkedList myStdList = new SimpleLinkedList();
        int choice = 0;
        
        while(choice>=0 || choice<=5) {
            System.out.println("1-EISAGWGH FOITHTH STH LISTA");
            System.out.println("2-EMFANISH LISTAS");
            System.out.println("3-FOITHTHS ME TON MEGALYTERO VATHMO");
            System.out.println("4-FOITHTHS ME TON MIKROTERO VATHMO");
            System.out.println("5-EXIT");
            
            do {
                System.out.println("INPUT YOUR CHOICE:");
                choice = UserInput.getInteger();
            }while(choice<1 ||choice>5);
            
            switch(choice) {
                case 1:
                    System.out.println("Dwse to AM: ");
                    AM = UserInput.getInteger();
                    while(AM < 1) {
                        System.out.print("Dwse to AM(>0): ");
                        AM = UserInput.getInteger();
                    }
                    
                    System.out.println("Dwse to onoma: ");
                    name = UserInput.getString();
                    
                    System.out.println("Dwse to epitheto: ");
                    surname = UserInput.getString();
                    
                    System.out.println("Dwse thn hlikia: ");
                    age = UserInput.getInteger();
                    while(age < 18) {
                        System.out.print("Dwse swsti hlikia(>18): ");
                        age = UserInput.getInteger();
                    }
                    
                    System.out.println("Dwse to fylo (m for male or f for female): ");
                    sex = UserInput.getCharacter();
                    while(sex != 'm' && sex != 'f') {
                        System.out.print("Dwse to fylo(m/f): ");
                        sex = UserInput.getCharacter();
                    }
                    
                    System.out.println("Dwse tis apousies: ");
                    apousies = UserInput.getInteger();
                    while(apousies < 0) {
                        System.out.print("Dwse tis apousies(den mporei na einai <0): ");
                        apousies = UserInput.getInteger();
                    }
                    
                    System.out.println("Dwse ton vathmo: ");
                    vathmos = UserInput.getDouble();
                    while(vathmos<0 || vathmos>10) {
                        System.out.print("Dwse to vathmo(>=0 <=10): ");
                        vathmos = UserInput.getDouble();
                    }
                    
                    myStdList.insertLast(new Student(AM,name,surname,age,sex,apousies,vathmos));
                    break;
                case 2:
                    System.out.println("Lista foithtwn: \n");
                    System.out.println(myStdList.toString());
                    break;
                case 3:
                    try {
                        System.out.println("O foithths me ton kalytero vathmo einai : ");
                        System.out.println(megalyterosVathmos(myStdList));
                    }
                    catch(ListEmptyException e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.println("O foithths me ton xeirotero vathmo einai : ");
                        System.out.println(mikroterosVathmos(myStdList));  
                    }
                    catch(ListEmptyException e) {
                        System.out.println(e);  
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
