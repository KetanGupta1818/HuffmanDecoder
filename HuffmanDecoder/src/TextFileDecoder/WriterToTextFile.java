package TextFileDecoder;
import java.util.*;
import java.io.*;


public class WriterToTextFile {
    File file = new File("C:\\Users\\Admin\\Documents\\Huffman Project\\Result.txt");
    File infomationFile = new File("C:\\Users\\Admin\\Documents\\Huffman Project\\Information.txt");
    static FileWriter writer;
    static FileWriter informationWriter;
    WriterToTextFile() throws IOException {
        try{
            writer = new FileWriter(file);
            informationWriter = new FileWriter(infomationFile);
        }
        catch(IOException e){
            System.out.println("Input output exception: ");
        }
    }
    public void writeToFile(List<CharacterByteCode> characterByteCodes, String line) throws IOException {
        HashMap<Character, String> mapOfByteCodesWithCharacters = new HashMap<>();
        long n = characterByteCodes.stream()
                .map(cbt->mapOfByteCodesWithCharacters.put(cbt.character, cbt.byteCode))
                .count();
        for(int i=0;i<line.length();i++){
            char currentCharacter = line.charAt(i);
            writer.write(mapOfByteCodesWithCharacters.get(currentCharacter));
        }
        writer.close();
    }
    public void writeInformationToFile(String line, List<CharacterByteCode> characterByteCodes) throws IOException {
        informationWriter.write("Characters with their frequencies: \n");
        List<CharacterFrequency> charactersWithTheirFrequency = FrequencyCalculator.getFrequencyOfCharacters(line);
        for(CharacterFrequency cf: charactersWithTheirFrequency){
            informationWriter.write((cf.character + "    " + cf.frequency+"\n"));
        }
        informationWriter.write("\n\nCharacters with their byteCodes: \n");
        for(CharacterByteCode cbc: characterByteCodes){
            informationWriter.write("Character: " + cbc.character + "   ByteCode: " + cbc.byteCode +"\n");
        }
        informationWriter.close();
    }
}
