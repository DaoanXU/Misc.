package xor_encoder;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EasyEncoder {

    public static void main(String[] args) throws IOException {

        final int BufferSize = 128 * 1024 * 1024;
        byte[] inBuffer = new byte[BufferSize];
        byte[] outBuffer = new byte[BufferSize];
        final String USAGE = "<file> ";

        if (args.length != 1) {
            System.out.print("Usage: ");
            System.out.println(USAGE);
            System.exit(1);
        }
        
        Console console = System.console();

        String filename = args[0];
        String outputFileName = "__" + filename;

        FileInputStream inStream = new FileInputStream(filename);

        String answer = console.readLine("Hide Hey? Y/N:");
        while (answer == null
                || answer.length() == 0
                || (answer.charAt(0) != 'y' && answer.charAt(0) != 'Y' && answer.charAt(0) != 'n' && answer
                        .charAt(0) != 'N')) {
            answer = console.readLine("Hide Hey? Y/N:");
        }

        String key = null;
        if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
            String k1 = String.valueOf(console.readPassword("Input Key Here       :"));
            String k2 = String.valueOf(console.readPassword("Input Key again Here :"));
            while (!k1.equals(k2)) {
                System.out.println("Not match, try again");
                k1 = String.valueOf(console.readPassword("Input Key Here       :"));
                k2 = String.valueOf(console.readPassword("Input Key again Here :"));
            }
            key = k1;
        } else {
            String k1 = console.readLine("Input Key Here       :");
            String k2 = console.readLine("Input Key again Here :");
            while (!k1.equals(k2)) {
                System.out.println("Not match, try again");
                k1 = console.readLine("Input Key Here       :");
                k2 = console.readLine("Input Key again Here :");
            }
            key = k1;
        }

        byte[] coder = key.getBytes();
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
