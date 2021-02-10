package sequential_files_streams;

import java.io.*;

/**
 *
 * @author Polis
 */
public class Ask9_2 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String fileIn = "vote.txt";
        String fileYes = "voteYes.txt";
        String fileNo = "voteNo.txt";
        
        BufferedReader in = null;
        FileWriter outYes = null;
        FileWriter outNo = null;
        
        int count1 = 0, count2 = 0;
        
        try {
            in = new BufferedReader(new FileReader(fileIn));
            outYes = new FileWriter(fileYes);
            outNo = new FileWriter(fileNo);
            
            String line1,line2;
            while((line1 = in.readLine())!=null && (line2 = in.readLine())!=null) {
                if(line2.equals("YES")) {
                    count1++;
                    outYes.write(count1+" "+line1+"\n");
                }else if(line2.equals("NO")) {
                    count2++;
                    outNo.write(count2+" "+line1+"\n");
                }
            }
        }
        finally {
            if(in != null)
                in.close();
            if(outYes != null)
                outYes.close();
            if(outNo != null)
                outNo.close();
        }
    }
}
