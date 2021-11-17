package TextFileDecoder;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanTreeNode {
	char data;
	HuffmanTreeNode left;
	HuffmanTreeNode right;
	Double frequency;
	static List<CharacterByteCode> characterByteCodes = new ArrayList<>();
	public HuffmanTreeNode()  {
		this.data = '<';
		this.left = null;
		this.right = null;
		this.frequency = 0.0;
	}
	

	
	public HuffmanTreeNode(char data, Double frequency) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.frequency = frequency;
	}

	public static void printHuffmanTreeNode(HuffmanTreeNode root){
		System.out.println("Character: "+ root.data);
		System.out.println("Frequency: " + root.frequency);
		System.out.println();
	}


	public static PriorityQueue<HuffmanTreeNode> getMinHeap(String line){
		List<CharacterFrequency> charactersWithTheirFrequency = FrequencyCalculator.getFrequencyOfCharacters(line);
		charactersWithTheirFrequency
				.forEach(cf->System.out.println(cf.character + "    " + cf.frequency));
		List<HuffmanTreeNode> huffmanTreeNodes = charactersWithTheirFrequency.stream()
				.map(cf->new HuffmanTreeNode(cf.character, cf.frequency))
				.collect(Collectors.toList());

		PriorityQueue<HuffmanTreeNode> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.frequency));
		minHeap.addAll(huffmanTreeNodes);
		return minHeap;

	}

	public static HuffmanTreeNode huffmanTreeCreator(PriorityQueue<HuffmanTreeNode> minHeap){
		while(minHeap.size()!=1){
			HuffmanTreeNode temp = new HuffmanTreeNode();
			temp.right = minHeap.poll();
			assert temp.right != null;
			temp.left = minHeap.poll();
			assert temp.left != null;
			temp.frequency = temp.left.frequency + temp.right.frequency;
			minHeap.add(temp);
		}

		return minHeap.poll();
	}

	public static void main(String[] args){
		HuffmanTreeNode root = huffmanTreeCreator(getMinHeap("aaaabbbccd"));
		System.out.println("\n\nByteCodes are:     ");
		byteCodeSetter(root, "");
		characterByteCodes.forEach(CharacterByteCode::printCharactersByteCode);
	}
	public static void byteCodeSetter(HuffmanTreeNode root, String currentString){
		if(root == null) return;
		if(root.left == null && root.right == null)
			Main.characterByteCodes.add(new CharacterByteCode(root.data, currentString));
		byteCodeSetter(root.left, currentString+"0");
		byteCodeSetter(root.right, currentString+"1");
	}


}


