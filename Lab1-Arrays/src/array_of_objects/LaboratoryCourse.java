package array_of_objects;

/**
 *
 * @author Polis
 */
public class LaboratoryCourse {
    int ar_tmimatwn;
    Lab lab[];
    
    LaboratoryCourse() {
        ar_tmimatwn = 0;
        lab = new Lab[ar_tmimatwn];
    }
    
    LaboratoryCourse(int ar_tmimatwn) {
        this.ar_tmimatwn = ar_tmimatwn;
        lab = new Lab[ar_tmimatwn];
        
        for(int i=0; i<ar_tmimatwn; i++) {
            createLab(lab,i);
        }
    }

    public int getAr_Tmimatwn() {
        return ar_tmimatwn;
    }

    public void setAr_Tmimatwn(int ar_tmimatwn) {
        this.ar_tmimatwn = ar_tmimatwn;
    }

    public Lab[] getLab() {
        return lab;
    }

    public void setLab(Lab[] lab) {
        this.lab = lab;
    }
    
    @Override
    public String toString() {
        String s="Arithmos tmimatwn: "+ar_tmimatwn;
        return s;
    }
    
    public void ektypwsiTmimatwn() {
        for(int i=0; i<ar_tmimatwn; i++) {
            System.out.println("\nErgasthrio "+(i+1)+"o \n-------------\n");
            lab[i].ektypwsi();
        }
    }
    
    public void ektypwsiApotelesmatwn() {
        int fail = 0;
        int pass = 0; 
        
        for(int i=0; i<ar_tmimatwn; i++) {
            int countf = 0, countp = 0;
            for(int j=0; j<lab[i].getCounter(); j++) {
                if(lab[i].st[j].getVathmos()<5) {
                        countf++; // Metavliti metrisewn apotyxias se ena ergastirio
                }else {
                        countp++; // Metavliti metrisewn epityxias se ena ergastirio
                }
            }
            System.out.println("\nErgasthrio "+(i+1)+"o \n-------------\n");
            System.out.println("Perasan: "+countp);
            System.out.println("Apetyxan: "+countf);
            
            // Metavliti metrisis epituxiwn/apotuxiwn se ola ta ergastiria
            pass+=countp;
            fail+=countf;
        }
        System.out.println("\n\nSynolika ergasthria\n-------------------\n");
        System.out.println("Perasan: "+pass);
        System.out.println("Apetyxan: "+fail);
    }
    
    public void ektypwsiLabAvg() {
        double globalSum = 0;
        double globalCount = 0;
        
        for(int i=0;i<ar_tmimatwn;i++) {
            double sum = 0,count = 0;
            for(int j=0; j<lab[i].getCounter(); j++) {
                sum+=lab[i].st[j].getVathmos();
                count++;
            }
            System.out.println("\nErgasthrio "+(i+1)+"o \n-------------\n");
            System.out.println("Avarage: "+(sum/count));
            
            // Metrites gia to geniko AVG
            globalSum+=sum;
            globalCount+=count;
        }
        
        System.out.println("\n\nSynolika ergasthria\n-------------------\n");
        System.out.println("Avarage: "+(globalSum/globalCount));
    }
    
    public void ektypwsiPosostwnTmimatwn() {
        double fail = 0;
        double pass = 0;
        double x = 0;
        
        for(int i=0; i<ar_tmimatwn; i++) {
            double countF = 0, countP = 0;
            for(int j=0; j<lab[i].getCounter(); j++) {
                if(lab[i].st[j].getVathmos()<5) {
                    countF++;
                }else {
                    countP++;
                }
            }
            System.out.println("\nErgasthrio "+(i+1)+"o \n-------------\n");
            System.out.println("Perasan: "+((countP*100)/(countP+countF))+"%");
            System.out.println("Apetyxan: "+((countF*100)/(countP+countF))+"%");
            
            // Metrites genikwn metrisewn gia pososta
            pass+=countP;
            fail+=countF;
            x+=countP+countF;
        }
        
        System.out.println("\n\nSynolika ergasthria\n-------------------\n");
        System.out.println("Perasan: "+(pass*100/x)+"%");
        System.out.println("Apetyxan: "+(fail*100/x)+"%");
    }
    
    public void createLab(Lab lab[],int i) {
        System.out.print("Dwse xwritikothta "+(i+1)+"ou ergastiriou: ");
        int x = UserInput.getInteger();
        while(x<0) {
            System.out.print("Dwse xwritikothta "+(i+1)+"ou ergastiriou(>0): ");
            x = UserInput.getInteger();
        }
        
        lab[i] = new Lab(x);
        
        //Metavliti gia tin periptwsi exodou(Epilogh 5)
        boolean bool = true;
        
        // Menu ergasiwn se kathe ergastirio  
        while(bool==true) {
            System.out.println("\nEpiloges");
            System.out.println("1.Eisagwgh");
            System.out.println("2.Diagrafh");
            System.out.println("3.Anazitisi");
            System.out.println("4.Ektypwsh");
            System.out.println("5.Exodos");
            System.out.print("Apantisi: ");
            int answer = UserInput.getInteger();
            
            while(answer<1 || answer>5) {
                System.out.println("Epiloges");
                System.out.println("1.Eisagwgh");
                System.out.println("2.Diagrafh");
                System.out.println("3.Anazitisi");
                System.out.println("4.Ektypwsh");
                System.out.println("5.Exodos");
                System.out.print("Apantisi: ");
                answer=UserInput.getInteger();
            }
            
            if(answer != 5 ) {
                switch(answer) {
                    case 1:lab[i].eisagwgiFoititi();
                           break;
                    case 2:lab[i].diagrafiFoititi();
                           break;
                    case 3:lab[i].anazitisiFoititi();
                           break;
                    case 4:lab[i].ektypwsi();
                           break;
                }
                bool=true;
            }else {
                bool=false;
            }
        }
    }
}