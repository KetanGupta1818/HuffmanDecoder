package TextFileDecoder;

import java.io.IOException;
import java.util.*;
public class Main {
    static List<CharacterByteCode> characterByteCodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String line = TextFileParser.getText();
        System.out.println(line);
        PriorityQueue<HuffmanTreeNode> minHeap = HuffmanTreeNode.getMinHeap(line);
        HuffmanTreeNode root = HuffmanTreeNode.huffmanTreeCreator(minHeap);
        HuffmanTreeNode.byteCodeSetter(root,"");
        characterByteCodes.forEach(CharacterByteCode::printCharactersByteCode);
        WriterToTextFile w = new WriterToTextFile();
        w.writeToFile(characterByteCodes,TextFileParser.getText());
        w.writeInformationToFile(line, characterByteCodes);
    }
}
