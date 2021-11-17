package TextFileDecoder;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FrequencyCalculator {
	public static List<CharacterFrequency> getFrequencyOfCharacters (String line){
		//line = line.toLowerCase();
		final int len = line.length();
		HashSet<Character> setOfCharacters = new HashSet<>();
		HashMap<Character, Integer> mapOfCharactersWithTheirFrequency = new HashMap<>();
		for(int i=0;i<line.length();i++) {
			char currentCharacter = line.charAt(i);
			if(mapOfCharactersWithTheirFrequency.containsKey(currentCharacter))
				mapOfCharactersWithTheirFrequency.put(currentCharacter,mapOfCharactersWithTheirFrequency.get(currentCharacter)+1);
			else
				mapOfCharactersWithTheirFrequency.put(currentCharacter,1);
			setOfCharacters.add(currentCharacter);
		}
		;
		
		
		
		
		return setOfCharacters.stream()
				//.forEach(cc->System.out.println(mapOfCharactersWithTheirFrequency.get(cc)));
				.map(cc->new CharacterFrequency(cc, mapOfCharactersWithTheirFrequency.get(cc)/(len*1.0)))
				.collect(Collectors.toList());
	}
	public static void main(String[] args) {
	}
}
