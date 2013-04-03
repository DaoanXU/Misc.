package xor_encoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EasyEncoder {

    public static void main(String[] args) throws IOException {

        final String USAGE = "<file>  <password>";
        final int BufferSize = 128 * 1024 * 1024;
        byte[] inBuffer = new byte[BufferSize];
        byte[] outBuffer = new byte[BufferSize];

        if (args.length != 2) {
            System.out.print("Error, No Input Value, Usage: ");
            System.out.println(USAGE);
            System.exit(1);
        }

        String filename = args[0];
        String outputFileName = "__" + filename;

        byte[] coder = args[1].getBytes();

        FileInputStream inStream = new FileInputStream(filename);
        FileOutputStream outStream = new FileOutputStream(outputFileName);

        int coderIndex = 0;
        int coderMaxIndex = coder.length - 1;
        int current = inStream.read(inBuffer);
        while (current != -1) {
            for (int i = 0; i < current; i++) {
                outBuffer[i] = (byte) (inBuffer[i] ^ coder[coderIndex]);
                coderIndex = (coderIndex + 1) % coderMaxIndex;
            }
            outStream.write(outBuffer, 0, current);
            current = inStream.read(inBuffer);
        }

        inStream.close();
        outStream.close();
    }
}
