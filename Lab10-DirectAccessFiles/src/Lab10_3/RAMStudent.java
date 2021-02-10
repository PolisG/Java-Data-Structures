package Lab10_3;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Polis
 */
public class RAMStudent extends Student {
    
    public RAMStudent() {
        this(0, "", "", 0, 0.0);
    }

    public RAMStudent(int am, String onoma, String epitheto, int apousies, double vathmos) {
        super(am, onoma, epitheto, apousies, vathmos);
    }

    public RAMStudent read(RandomAccessFile file) throws IOException {
        setAM(file.readInt());
        setName(cutName(file));
        setSurname(cutName(file));
        setAr_apousiwn(file.readInt());
        setVathmos(file.readDouble());
        return this;
    }

    private String cutName(RandomAccessFile file) throws IOException {
        char[] name = new char[15];

        for(int i = 0; i < name.length; i++) {
            name[i] = file.readChar();
        }

        return new String(name).replace('\0', ' ');
    }

    public void write(RandomAccessFile file) throws IOException {
        file.writeInt(getAM());
        putName(file, getName());
        putName(file, getSurname());
        file.writeInt(getAr_apousiwn());
        file.writeDouble(getVathmos());
    }

    private void putName(RandomAccessFile file, String name) throws IOException {
        StringBuffer buf = null;

        if(name != null) {
            buf = new StringBuffer(name);
        } else {
            buf = new StringBuffer(15);
        }

        buf.setLength(15);

        file.writeChars(buf.toString());
    }

    public static int size() {
        return 76;
    }
}
