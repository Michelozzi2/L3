package cdpoo.TD5.exo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class LectureFichier3 {
    public static void main(String[] args)throws IOException {
        FileInputStream fis = new FileInputStream(new File("cdpoo/TD5/exo3/text.txt"));
        FileChannel fc = fis.getChannel();
        int size = (int) fc.size();

        ByteBuffer buf = ByteBuffer.allocate(size);

        long startTime = System.currentTimeMillis();

        fc.read(buf);
        buf.flip();

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Time taken: " + timeTaken + "ms");
        fis.close();
    }
}
