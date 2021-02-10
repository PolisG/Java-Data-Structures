package sequential_files_streams;

import java.io.*;

/**
 *
 * @author Polis
 */
public class Ask9_1a {
    
    public static void main(String[] args) {
        int[] data1 = {0, 4, 7, 11, 15, 28, 34, 52, 66, 71, 77, 99, 100, 111, 127, 200, 224, 255};
        int[] data2 = {1, 3, 10, 16, 24, 31, 41, 72, 76, 91, 97, 101, 110, 115, 128, 199, 232, 254};
        
        try {
            FileOutputStream file1 = new FileOutputStream("pic1.gif");
            FileOutputStream file2 = new FileOutputStream("pic2.gif");
            for(int i=0; i<data1.length; i++) {
                file1.write(data1[i]);
            }
            for(int i=0; i<data2.length; i++) {
                file2.write(data2[i]);
            }
            file1.close();
            file2.close();
        }catch(IOException e) {
            System.out.println("Error - "+e.toString());            
        }
    }
}