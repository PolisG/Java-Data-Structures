package Lab10_3;

import java.io.*;

/**
 *
 * @author Polis
 */
public class Lab10_3 {
    
    public static void main(String[] args) {
        RAMStudent students = new RAMStudent();

        try {
            RandomAccessFile file = new RandomAccessFile("lab10_3.dat", "rw");
            boolean flag = true;

            new RAMStudent(12001, "Test1", "Test1", 1, 6.5).write(file);
            new RAMStudent(12002, "Test2", "Test2", 3, 4.0).write(file);
            new RAMStudent(12003, "Test3", "Test3", 0, 10.0).write(file);
            new RAMStudent(12004, "Test4", "Test4", 2, 8.2).write(file);
            new RAMStudent(12005, "Test5", "Test5", 4, 2.4).write(file);

            do {
                System.out.println("[1] Εγγραφή ενός φοιτητή στο αρχείο\n[2] Διαγραφή ενός φοιτητή από το αρχείο\n[3] Παρουσίαση των στοιχείων του φοιτητή στην οθόνη\n[4] Ενημέρωση των απουσιών ενός φοιτητή\n[5] Καταχώρηση της βαθμολογίας ενός φοιτητή\n[6] Βαθμολογίες φοιτητών\n[7] Φοιτητές που πέρασαν το μάθημα\n[8] Φοιτητές με κατοχύρωση\n[9] Διαγραφή φοιτητών με 2 απουσίες\n[10] Έξοδος");
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
                        System.out.println("-----\nΒαθμολογίες\n");

                        try {
                            int counter = 0;

                            while(true) {
                                file.seek(counter);
                                RAMStudent tmp = students.read(file);

                                if(tmp.getAM() != 0)
                                    System.out.println("AM: " + tmp.getAM() + " Vathmos: " + tmp.getVathmos());
                                
                                counter += 76;
                            }
                        }
                        catch(EOFException e) {
                            System.out.println("-----");
                        }
                        break;
                    case 7:
                        System.out.println("-----\nΦοιτητές που πέρασαν\n");

                        try {
                            int counter = 0;

                            while(true) {
                                file.seek(counter);
                                RAMStudent tmp = students.read(file);

                                if(tmp.getVathmos() >= 5 && tmp.getAM() != 0)
                                    System.out.println("AM: " + tmp.getAM());
                                
                                counter += 76;
                            }
                        }
                        catch(EOFException e) {
                            System.out.println("-----");
                        }
                        break;
                    case 8:
                        System.out.println("-----\nΦοιτητές που κατοχύρωσαν\n");

                        try {
                            int counter = 0;

                            while(true) {
                                file.seek(counter);
                                RAMStudent tmp = students.read(file);

                                if(tmp.getVathmos() < 5 && tmp.getAM() != 0)
                                    System.out.println("AM: " + tmp.getAM());
                                
                                counter += 76;
                            }
                        }
                        catch(EOFException e) {
                            System.out.println("-----");
                        }
                        break;
                    case 9:
                        System.out.println("-----\nΦοιτητές που θα διαγραφούν με 2 απουσίες\n");

                        try {
                            int counter = 0;

                            while(true) {
                                file.seek(counter);
                                RAMStudent tmp = students.read(file);

                                if(tmp.getAr_apousiwn() >= 2 && tmp.getAM() != 0) {
                                    System.out.println("AM: " + tmp.getAM());

                                    file.seek(counter);
                                    new RAMStudent(0, "", "", 0, 0.0).write(file);
                                }
                                counter += 76;
                            }
                        }
                        catch(EOFException e) {
                            System.out.println("-----");
                        }
                        break;
                    case 10:
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
