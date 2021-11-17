package TextFileDecoder;

public class CharacterByteCode {
    char character;
    String byteCode;

    public CharacterByteCode(char character, String byteCode){
        this.character = character;
        this.byteCode = byteCode;
    }

    public void printCharactersByteCode(){
        System.out.println("Character: " + this.character + "   ByteCode: " + this.byteCode);
    }
}
