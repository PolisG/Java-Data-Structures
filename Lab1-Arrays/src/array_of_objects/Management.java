package array_of_objects;

/**
 *
 * @author Polis
 */
public class Management {
    public static void main(String args[]) {
        System.out.print("Dwse ton arithmo ergastiriwn: ");
        int ar_erg = UserInput.getInteger();
        while(ar_erg<0) {
            System.out.print("O arithmos twn ergastiriwn prepei na einai > 0 : ");
            ar_erg = UserInput.getInteger();
        }
        
        LaboratoryCourse Lc=new LaboratoryCourse(ar_erg); //Dimiourgia enos sunolou ergastiriwn
        
        boolean bool = true; //Metavliti gia tin periptwsi exodou(Epilogh 5)
        
        // Menu
        while(bool==true) {
            System.out.println("\nEpiloges :");
            System.out.println("1.Xeirismos Ergastiriwn");
            System.out.println("2.Ektypwsi Tmimatwn");
            System.out.println("3.Ektypwsi Apotelesmatwn Tmimatwn");
            System.out.println("4.Ektypwsi Mesou Orou Tmimatwn");
            System.out.println("5.Ektypwsi Posostwn Tmimatwn");
            System.out.println("6.Exodos");
            System.out.print("Apantisi: ");
            int answer = UserInput.getInteger();
            
            while(answer<1 || answer>6) {
                System.out.println("\nEpiloges :");
                System.out.println("1.Xeirismos Ergastiriwn");
                System.out.println("2.Ektypwsi Tmimatwn");
                System.out.println("3.Ektypwsi Apotelesmatwn Tmimatwn");
                System.out.println("4.Ektypwsi Mesou Orou Tmimatwn");
                System.out.println("5.Ektypwsi Posostwn Tmimatwn");
                System.out.println("6.Exodos");
                System.out.print("Apantisi: ");
                answer = UserInput.getInteger();
            }
            
            if(answer != 6 ) {
                switch(answer) {
                    case 1:Lc = new LaboratoryCourse(ar_erg);
                           break;
                    case 2:Lc.ektypwsiTmimatwn();
                           break;
                    case 3:Lc.ektypwsiApotelesmatwn();
                           break;
                    case 4:Lc.ektypwsiLabAvg();
                           break;
                    case 5:Lc.ektypwsiPosostwnTmimatwn();
                           break; 
                }
                bool = true;
            }else {
                bool = false;
            }
        }
    }
}
