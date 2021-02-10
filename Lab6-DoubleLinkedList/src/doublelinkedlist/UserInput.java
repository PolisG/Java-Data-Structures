package doublelinkedlist;

import java.io.*;

/**
 *
 * @author Polis
 */
class UserInput {
    public static int getInteger() {
        String line;
        InputStreamReader eisodos = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(eisodos);
        try {
            line = br.readLine();
            int i = Integer.parseInt(line);
            return i;
        }
        catch(Exception e) {
            return -1;
        }
    }
    
    
    public static float getFloat() {
        String line;
        InputStreamReader eisodos = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(eisodos);
        try {
            line = br.readLine();
            float i = Float.parseFloat(line);
            return i;
        }
        catch(Exception e) {
            return -1;
        }
    }


    public static double getDouble() {
      String line;
      InputStreamReader eisodos = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(eisodos);
      try {
        line = br.readLine();
        double i = Double.parseDouble(line);
        return i;
      }
      catch(Exception e) {
        return -1;
      }
    }


    public static short getShort() {
      String line;
      InputStreamReader eisodos = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(eisodos);
      try {
        line = br.readLine();
        short i = Short.parseShort(line);
        return i;
      }
      catch(Exception e) {
        return -1;
      }
    }


    public static long getLong() {
      String line;
      InputStreamReader eisodos = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(eisodos);
      try {
        line = br.readLine();
        long i = Long.parseLong(line);
        return i;
      }
      catch(Exception e) {
        return -1;
      }
    }


    public static byte getByte() {
      String line;
      InputStreamReader eisodos = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(eisodos);
      try {
        line = br.readLine();
        byte i = Byte.parseByte(line);
        return i;
      }
      catch(Exception e) {
        return -1;
      }
    }


    public static char getCharacter() {
      char c;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
        c = (char)br.read();
        return c;
      }
      catch(Exception e) {
        return 'e';
      }
    }

    public static String getString() {
      String str;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
        str = br.readLine();
        return str;
      }
      catch(Exception e) {
        return "error";
      }
    }
}