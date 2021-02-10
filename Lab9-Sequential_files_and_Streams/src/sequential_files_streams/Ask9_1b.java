package sequential_files_streams;

import java.io.*;

/**
 *
 * @author Polis
 */
public class Ask9_1b {
    
    public static void main(String[] args) throws IOException {
        
        FileInputStream infile1 = new FileInputStream("pic1.gif");
        FileInputStream infile2 = new FileInputStream("pic2.gif");
        FileOutputStream outfile = new FileOutputStream("pic.gif");
        
        int input1, input2;
        
        input1 = infile1.read();
        input2 = infile2.read();
        
        while(input1 != -1 || input2 != -1) {
            if(input1 == -1) {
                outfile.write(input2);
                input2 = infile2.read();
            }
            else if(input2 == -1) {
                outfile.write(input1);
                input1 = infile1.read();
            }
            else if(input1 != -1 && input2 != -1) {
                if(input1 < input2) {
                    outfile.write(input1);
                    input1 = infile1.read();
                }
                else {
                    outfile.write(input2);
                    input2 = infile2.read();
                }
            }
        }
        infile1.close();
        infile2.close();
        outfile.close();
        
        FileInputStream infile = new FileInputStream("pic.gif");
        input1 = infile.read();
        int count = 0;
        while(input1 != -1) {
            System.out.print(input1+", ");
            input1 = infile.read();
            count++;
        }
    }
}
