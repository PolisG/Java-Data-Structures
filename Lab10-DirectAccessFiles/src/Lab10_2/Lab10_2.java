package Lab10_2;

import java.io.*;

/**
 *
 * @author Polis
 */
public class Lab10_2 {
    
    public static void main(String[] args) {
        RAMStudent students = new RAMStudent();

        try {
            RandomAccessFile file = new RandomAccessFile("lab10_2.dat", "rw");
            boolean flag = true;

            do {
                System.out.println("[1] Εγγραφή ενός φοιτητή στο αρχείο\n[2] Διαγραφή ενός φοιτητή από το αρχείο\n[3] Παρουσίαση των στοιχείων του φοιτητή στην οθόνη\n[4] Ενημέρωση των απουσιών ενός φοιτητή\n[5] Καταχώρηση της βαθμολογίας ενός φοιτητή\n[6] Έξοδος");
                System.out.print("Δώσε Επιλογή:");

                int n = UserInput.getInteger();

                switch(n) {
                    case 1:
                        System.out.print("Δώσε αριθμό μητρώου για εισαγωγή: ");
                        int add = UserInput.getInteger();

                        new RAMStudent(add, "", "", 0, 0.0).write(file);
                        break;
                    case 2:
                        System.out.print("Δώσε αριθμό μητρώου για διαγραφή: ");
                        int delete = UserInput.getInteger();

                        file.seek(hash(delete));
                        new RAMStudent(0, "", "", 0, 0.0).write(file);
                        break;
                    case 3:
                        System.out.print("Δώσε αριθμό μητρώου για εμφάνιση: ");
                        int show = UserInput.getInteger();

                        file.seek(hash(show));
                        RAMStudent student = students.read(file);
                        System.out.println(student.toString());
                        break;
                    case 4:
                        System.out.print("Δώσε αριθμό μητρώου για ενημέρωση απουσιών: ");
                        int update = UserInput.getInteger();

                        System.out.print("Δώσε αριθμό απουσιών: ");
                        int apousies = UserInput.getInteger();

                        file.seek(hash(update));
                        RAMStudent updated = students.read(file);

                        updated.setAr_apousiwn(apousies);

                        file.seek(hash(update));
                        updated.write(file);
                        break;
                    case 5:
                        System.out.print("Δώσε αριθμό μητρώου για καταχώριση βαθμού: ");
                        int insert = UserInput.getInteger();

                        System.out.print("Δώσε βαθμό: ");
                        double vathmos = UserInput.getDouble();

                        file.seek(hash(insert));
                        RAMStudent inserted = students.read(file);

                        inserted.setVathmos(vathmos);

                        file.seek(hash(insert));
                        inserted.write(file);
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Λάθος Επιλογή.\n");
                }
            }while(flag);
        }
        catch(IOException e) {
            System.out.println(e.toString());
        }
    }

    public static int hash(int x) {
        return 76 * (x - 12001);
    }
}