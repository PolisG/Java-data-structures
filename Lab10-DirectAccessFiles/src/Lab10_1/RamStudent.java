package Lab10_1;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Polis
 */
public class RamStudent extends Student {
    
    public RamStudent() {
        this(0, "", "");
    }

    public RamStudent(int am, String onoma, String epitheto) {
        super(am, onoma, epitheto);
    }

    public RamStudent read(RandomAccessFile file) throws IOException {
        setAM(file.readInt());
        setName(cutName(file));
        setSurname(cutName(file));
        return this;
    }

    private String cutName(RandomAccessFile file) throws IOException {
        char[] name = new char[15];

        for(int i = 0; i < name.length; i++)
        {
            name[i] = file.readChar();
        }

        return new String(name).replace('\0', ' ');
    }

    public void write(RandomAccessFile file) throws IOException {
        file.writeInt(getAM());
        putName(file, getName());
        putName(file, getSurname());
    }

    private void putName(RandomAccessFile file, String name) throws IOException {
        StringBuffer buf = null;

        if(name != null)
        {
            buf = new StringBuffer(name);
        }
        else
        {
            buf = new StringBuffer(15);
        }

        buf.setLength(15);

        file.writeChars(buf.toString());
    }

    public static int size() {
        return 34;
    }
}