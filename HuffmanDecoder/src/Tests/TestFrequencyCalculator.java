package Tests;
import TextFileDecoder.FrequencyCalculator;
import junit.framework.*;

public class TestFrequencyCalculator extends TestCase {
    public TestFrequencyCalculator(String name){
        super(name);
    }

    public void testGetFrequencyOfCharacters() {
        assertEquals(0.3333, FrequencyCalculator.getFrequencyOfCharacters("abc").get(0).frequency,0.001);
        assertEquals(0.3333, FrequencyCalculator.getFrequencyOfCharacters("abc").get(1).frequency,0.001);
        assertEquals(0.5, FrequencyCalculator.getFrequencyOfCharacters("aabc").get(0).frequency,0.001);
        assertEquals(0.25, FrequencyCalculator.getFrequencyOfCharacters("aabc").get(1).frequency,0.001);
        assertEquals(0.25, FrequencyCalculator.getFrequencyOfCharacters("aabc").get(2).frequency,0.001);
    }

    public void testGetFrequencyOfCharactersEdgeCases()  {
        assertEquals(1.0, FrequencyCalculator.getFrequencyOfCharacters("aaaaa").get(0).frequency,0.001);
        assertEquals(1.0, FrequencyCalculator.getFrequencyOfCharacters("                     ").get(0).frequency,0.001);
    }



}
