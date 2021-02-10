package binary_search_tree;

/**
 *
 * @author Polis
 */
public class BSTreeManagement {
    
    public static void main(String args[ ]) {
        
        BSTree tree = new BSTree();
        Object sortedStud[];
        int length = 0;
        
        boolean b = true; //Metavliti gia tin periotwsi exodou
        
        while(b==true) {
            System.out.println("-------------MENOY-------------");
            System.out.println("1. Eisagwgh foititi sto dentro");
            System.out.println("2. Exit");
            System.out.print("Epilogh: ");
            int answer = UserInput.getInteger();
            
            while(answer<1 && answer>2){
                System.out.println("-------------MENOY-------------");
                System.out.println("1. Eisagwgh foititi sto dentro");
                System.out.println("2. Exit");
                System.out.print("Epilogh: ");
                answer = UserInput.getInteger();
            }
            
            if(answer != 2 ) {
                switch(answer) {
                    case 1: tree.insertElement(eisagwgh());
                            length++;
                            break;
                }
                b = true;
            }else
                b = false;
        }
        
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
        
        System.out.println("\nNumber of nodes: "+tree.numberOfNodes());
        System.out.println("\nTree height: "+tree.treeHeight());
        
        System.out.print("\nDwse data: ");
        int data = UserInput.getInteger();
        System.out.println("\nDoes the tree have "+data+"?");
        System.out.println(tree.isExist(data));
        
        if(!tree.isExist(data))
            System.out.println("This data does not exist");
        else
            System.out.println("\nTree height of data: "+tree.treeHeight(data));
        
        System.out.println("--------SORTED--------");
        sortedStud = tree.inOrderSort(length);
        for (Object sortedStud1 : sortedStud) {
            System.out.println(sortedStud1.toString());
        }
        for(int i=0; i<sortedStud.length; i++) {
            System.out.println(sortedStud[i].toString());
        }
    }
    
    public static Student eisagwgh() { // Methodos Eisagwghs
        System.out.print("\nDwse arithmo mitroou: ");
        int AM = UserInput.getInteger(); 
        while(AM<1) {
            System.out.print("\nDwse arithmo mitroou: ");
            AM=UserInput.getInteger(); 
        }
        
        System.out.print("Dwse onoma: ");
        String name = UserInput.getString();
        
        System.out.print("Dwse epitheto: ");
        String surname = UserInput.getString();
        
        System.out.print("Dwse hlikia: ");
        int age = UserInput.getInteger();
        while(age<18) {
            System.out.print("Dwse hlikia(>18): ");
            age = UserInput.getInteger();
        }
        
        System.out.print("Dwse fylo: ");
        char sex = UserInput.getCharacter();
        while(sex != 'm' && sex != 'f') {
            System.out.print("Dwse fylo(m/f): ");
            sex = UserInput.getCharacter();
        }
        
        System.out.print("Dwse arithmo apousiwn: ");
        int apousies = UserInput.getInteger();
        while(apousies<0) {
            System.out.print("Dwse arithmo apousiwn(>=0): ");
            apousies = UserInput.getInteger();
        }
        
        System.out.print("Dwse vathmo: ");
        double vathmos = UserInput.getDouble();
        while(vathmos<0 || vathmos>10) {
            System.out.print("Dwse vathmo(>=0 <10): ");
            vathmos=UserInput.getDouble();
        }
        
        return new Student(AM,name,surname,age,sex,apousies,vathmos);
    }
}
