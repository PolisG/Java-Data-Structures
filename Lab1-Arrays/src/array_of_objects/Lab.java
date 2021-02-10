package array_of_objects;

/**
 *
 * @author Polis
 */
public class Lab {
    
    /* H counter xrisimopoieitai gia tin apothikeusi tou akrives arithmou
     * kataxwerimenwn foititwn se ena ergastirio - mporei na einai mikroteri apo tin xwritikotita tou ergastiriou
     */
    private int counter = 0;
    private int capacity;
    public Student[] st;
    
    Lab() {
        capacity = 0;
        st = new Student[capacity];
    }
    
    Lab(int capacity) {
        this.capacity = capacity;
        st = new Student[capacity];
        
        for(int i=0; i<capacity; i++) {
            st[i] = new Student();
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
        String s="\nArithmos foititwn sto tmima: "+counter+
                 "\nXwritikothta tmimatos: "+capacity;
        return s;
    }
    
    public void eisagwgiFoititi() {
        if(counter >= capacity) {
            System.out.println("Den yparxei diathesimos xwros!");
        }else {
            int AM;
            do {
                System.out.print("Dwse Arithmo Mitroou(>0): ");
                AM = UserInput.getInteger();
            
                for(int i=0; i<counter; i++) {
                    if(st[i].getAM()==AM) {
                        AM = 0;
                        System.out.println("Kathe foititis exei ksexwristo A.M.");
                    }
                }
            }while(AM<1);
            
            System.out.print("Dwse onoma: ");
            String name = UserInput.getString();
        
            System.out.print("Dwse epitheto: ");
            String epitheto = UserInput.getString();
            
            System.out.print("Dwse ilikia: ");
            double age = UserInput.getDouble();
            while(age<18) {
                System.out.print("Dwse ilikia(>18): ");
                age = UserInput.getDouble();
            }
        
            System.out.print("Dwse fylo: ");
            char sex = UserInput.getCharacter();
            while(sex != 'm' && sex != 'f') {
                System.out.print("Dwse fylo(m/f): ");
                sex = UserInput.getCharacter();
            }
        
            System.out.print("Dwse arithmo apousiwn: ");
            int ar_apousiwn = UserInput.getInteger();
            while(ar_apousiwn<0) {
                System.out.print("Dwse arithmo apousiwn(>=0): ");
                ar_apousiwn = UserInput.getInteger();
            }
        
            System.out.print("Dwse vathmo: ");
            double vathmos = UserInput.getDouble();
            while(vathmos<0 || vathmos>10) {
                System.out.print("Dwse vathmo(>=0 <10): ");
                vathmos = UserInput.getDouble();
            }
            
            boolean bool=true;
            
            for(int j=0; j<counter; j++) {
                // An A.M=0 simainei oti stin thesh auti upirkse DIAGRAFH;
                if(st[j].getAM()==0) {
                    st[j] = new Student(AM,name,epitheto,age,sex,ar_apousiwn,vathmos);
                    bool = false;
                }
            }
        
            if(bool==true) {
                st[counter] = new Student(AM,name,epitheto,age,sex,ar_apousiwn,vathmos);
                counter++;
            }
        }
    }
    
    public void diagrafiFoititi() {
        System.out.print("Dwse Arithmo Mitroou diagrafomenou: ");
        int AM = UserInput.getInteger();
        while(AM<0) {
            System.out.print("Dwse Arithmo Mitroou diagrafomenou(>=0): ");
            AM = UserInput.getInteger();
        }
        
        // H anazitisiFoititi ginetai mexri ton arithmo twn foititwn kai oxi mexri tin xwritikotita tou ergastiriou
        for(int i=0; i<counter; i++) {
            if(st[i].getAM()==AM) {
                st[i] = new Student();
                counter--;
            }
        }
    }
    
    public void anazitisiFoititi() {
        System.out.print("Dwse Arithmo Mitroou anazitisis: ");
        int AM = UserInput.getInteger();
        while(AM<0){
            System.out.print("Dwse Arithmo Mitroou anazitisis(>=0): ");
            AM = UserInput.getInteger();
        }
        
        for(int i=0; i<counter; i++) {
            if(st[i].getAM()==AM) {
                System.out.println(st[i].toString());
            }
        }
    }
    
    public void ektypwsi(){
        for(int i=0;i<counter; i++) {
            System.out.println(st[i].toString());
        }
    }
}