package TextFileDecoder;

public  class CharacterFrequency {
    public char character;
    public Double frequency;

    public CharacterFrequency(char character, Double frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public void printCharacterFrequency() {
        System.out.println("Character: " + this.character + " has frequency: " + this.frequency);
    }
}