import java.*;
import java.io.File;
import java.io.FileNotFoundException;

public class RunHuffman 
{
	public static void main(String[] args) throws Exception
	{
		HuffmanEncoder huff = new HuffmanEncoder();
		
		File filename = new File("sample");
		
		System.out.println(huff.getFrequencies(filename));
		HuffTree node = huff.buildTree(filename);
		
		System.out.println(huff.encodeFile(filename, node));
		
		System.out.println(huff.traverseHuffmanTree(node));
		
		System.out.println(huff.decodeFile(huff.encodeFile(filename, node), node));
		
		String s1 = "=a=az=a=aaaaaaaQaa==wQa_aaaaQaaaaaaaa=a=aQaQ=aaa==aQ=a=QaGaQ1=a=aa1zaza=1Qzaz=a=Q=a=Qa=aaa=aQa=aa=zwaa=aaaazaa=Qa11Qaaaa=aa==aaa=Qa=aQaaaaa=a====11=a1Qa=1aQQ==aQ=1aaaaazQ1waaa==a=a==1aa=awQQ=1Qa=a=QaQa=aa=aaaaaQ=a1aaaQ=a=aaaaaaa=Ga=aa=aaQ1aQ====Q1==aaQaaa";
		String s2 = "=a=az=a=aaaaaaaQaa==wQa_aaaaQaaaaaaaa=a=aQaQ=aaa==aQ=a=QaGaQ1=a=aa1zaza=1Qzaz=a=Q=a=Qa=aaa=aQa=aa=zwaa=aaaazaa=Qa11Qaaaa=aa==aaa=Qa=aQaaaaa=a====11=a1Qa=1aQQ==aQ=1aaaaazQ1waaa==a=a==1aa=awQQ=1Qa=a=QaQa=aa=aaaaaQ=a1aaaQ=a=aaaaaaa=Ga=aa=aaQ1aQ====Q1==aaQaaa";
		System.out.println(s1.equals(s2));
		
		String s3 = "011011000010110111111110011101010000010011000000011110011111111101101100110010111101011001011010011000000110010001011011100010000110000110100010010000110000101101001011010011011110110011011101000010000011101111100001110100110001000100111110111010111101001101100111111011010101010001000101100010011010001100100101011001010001111110000100100010000011110101101101010001110110000010010010100010011011010011001101110111111001011000111100101101111111101000000110111011100100011001010101010010001010111001111";
		String s4 = "011011000010110111111110011101010000010011000000011110011111111101101100110010111101011001011010011000000110010001011011100010000110000110100010010000110000101101001011010011011110110011011101000010000011101111100001110100110001000100111110111010111101001101100111111011010101010001000101100010011010001100100101011001010001111110000100100010000011110101101101010001110110000010010010100010011011010011001101110111111001011000111100101101111111101000000110111011100100011001010101010010001010111001111";
		System.out.println(s3.equals(s4));
			
		
		HuffmanEncoder huff2 = new HuffmanEncoder();
		File filename2 = new File("pa3.txt");
		System.out.println(huff2.getFrequencies(filename2));
		HuffTree node2 = huff2.buildTree(filename2);
		
		System.out.println(huff2.encodeFile(filename2, node2));
		
		System.out.println(huff2.traverseHuffmanTree(node2));
		
		System.out.println(huff2.decodeFile(huff.encodeFile(filename2, node2), node2));
    }
	
	
	
}

