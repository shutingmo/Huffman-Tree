import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.Map.Entry;
import java.util.*;

public class HuffmanEncoder implements HuffmanCoding
{
    public Map<Character, Integer> map = new TreeMap<Character, Integer>();
    public Map<Character, String> viewTable = new HashMap<>();
    
	public String getFrequencies(File inputFile) throws FileNotFoundException 
	{
		String currentLine ="";
		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
		    
		    int c;
		    try 
		    {
		    	while((c = scan.read()) != -1) 
		    	{
		    		char ch = (char) c; 
					if (map.containsKey(ch)) 
					{
				        map.put(ch, map.get(ch) + 1);
					} 
					else 
					{
				         map.put(ch, 1);
					}
				 }
		    	for (Entry<Character, Integer> entry : map.entrySet())
		    	{
		    		char key = entry.getKey();
		    		int value = entry.getValue();
		    		currentLine += key + " " + value + "\n";
		    	}
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		} catch(NoSuchElementException i){
			System.out.println("Error: " + i);
		}
		
	      
		return currentLine;
	}

	@Override
	public HuffTree buildTree(File inputFile) throws FileNotFoundException, Exception 
	{
	    final PriorityQueue<HuffTree> pq = new PriorityQueue<>();

		try{
			map.clear();
			getFrequencies(inputFile);
		    Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();

			while(it.hasNext())
			   {
			    	Map.Entry<Character, Integer> entry = it.next();
			    	
			    	Character charact = entry.getKey();
			    	int frequen = entry.getValue();
			    		
			    	HuffTree node = new HuffTree(charact, frequen, null, null);
			    	
			    	pq.add(node);
			    	
			    }
			if (pq.size() == 1) 
			{
				pq.add(new HuffTree('\0', 1, null, null));
			}
			
	        while (pq.size() > 1) {
				HuffTree left = pq.poll();

				HuffTree right = pq.poll();

				HuffTree parent = new HuffTree('\0', left.freq + right.freq, left, right);
				pq.add(parent);
			}

			
		} catch(NoSuchElementException i){
			System.out.println("Error: " + i);
		}
		

		return pq.poll();

	}
	
	public Map<Character,String> buildLookupTable(HuffTree root)
	{
		try{
			buildLookupTableImple(root, "", viewTable);
		} catch (NullPointerException e){
			System.out.println("Error: " + e);
		}
		
		return viewTable;
	}
	
	public static void buildLookupTableImple(HuffTree node, String s, Map<Character, String> viewTable2) 
	{
		try {
			if(!node.isLeaf()) 
			{
				buildLookupTableImple(node.left, s + "0", viewTable2);
				buildLookupTableImple(node.right, s + "1", viewTable2);
				
			}
			else 
			{
				viewTable2.put(node.character, s);
			}
			
		} catch (NullPointerException e){
			System.out.println("Error: " + e);
		}
		
		
		
	}
	
	

	@Override
	public String encodeFile(File inputFile, HuffTree huffTree) throws FileNotFoundException 
	{
		StringBuilder builder = new StringBuilder();
		try{
			String theString ="";
			Scanner scan = new Scanner(inputFile);
			theString = scan.nextLine();
			while(scan.hasNextLine()) {
				theString = theString + "\n" + scan.nextLine();
			}
			
			this.buildLookupTable(huffTree);
			for(final char character: theString.toCharArray()) {
				builder.append(viewTable.get(character));
			}
		} catch(NoSuchElementException i){
			System.out.println("Error: " + i);
		}
		
		return builder.toString();
	}

	@Override
	public String decodeFile(String code, HuffTree huffTree) throws Exception 
	{
		StringBuilder strbuild = new StringBuilder();
		try {
			if (huffTree == null)
			{
				return null;
			}
			
			int i = 0;
			HuffTree current = huffTree;
			char[] chars = code.toCharArray();
			
			while(i < chars.length)
			{
				char c = chars[i];
				
				if (c == '0' && current.left != null)
				{
					current = current.left;
				}
				else if (c == '1' && current.right != null)
				{
					current = current.right;
				}
				
				if (current.left == null && current.right == null)
				{
					strbuild.append(current.character);
					current = huffTree;
				}
				i++;
			}
			
		} catch(NoSuchElementException i)
		{
			System.out.println("Error: " + i);

		}
		
		return strbuild.toString();

	}

	@Override
	public String traverseHuffmanTree(HuffTree huffTree) throws Exception 
	{
		String currentLine ="";
		try {
			buildLookupTable(huffTree);
			
			HuffTree node = huffTree;
			this.buildLookupTable(node);
			
			for (Entry<Character, String> entry : viewTable.entrySet()) {
				char key = entry.getKey();
				String value = entry.getValue();
				currentLine += key + " " + value + "\n";
			}
			
		} catch(NoSuchElementException i){
			System.out.println("Error: " + i);
		}
		
		
		return currentLine;
	}
}
