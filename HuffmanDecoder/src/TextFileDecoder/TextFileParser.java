package TextFileDecoder;

import com.sun.deploy.net.MessageHeader;

import java.io.*;

public class TextFileParser {
    static File file = new File("C:\\Users\\Admin\\Documents\\Huffman Project\\Sample1.txt");
    public static String getText() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = new String();
        String allLines = new String();
        while((line = br.readLine())!=null) {
            allLines = allLines+line;
        }
        br.close();
        return allLines;
    }
}
