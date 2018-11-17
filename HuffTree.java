
//basically a node class
public class HuffTree implements Comparable<HuffTree>
{
	protected HuffTree right; 
	protected HuffTree left;
	protected Character character;
	protected int freq;
	
	public HuffTree getRight() {
        return right;
    }
	
	public void setRight(HuffTree right) {
	       this.left = right;
    }
	 
	public HuffTree getLeft() {
        return left;
    }

    public void setLeft(HuffTree left) {
        this.left = left;
    }

    public Character getChar() {
        return character;
    }

    public void setChar(Character character) {
        this.character = character;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public HuffTree(Character character, int freq, HuffTree left, HuffTree right) {
        this.character = character;
        this.freq = freq;
        this.right = right;
        this.left = left;
    }
    
    public String printNode(HuffTree node)
    {
    	String nodeData = "";
    	nodeData += node.getChar();
    	nodeData += " ";
    	nodeData += node.getFreq();
//    	nodeData += node.getLeft();
//    	nodeData += " ";
//    	nodeData += node.getRight();
		return nodeData;
    	
    }

	@Override
	//changed o to node idk if this will change anything
	public int compareTo(HuffTree node) 
	{
		return this.freq - node.freq;
	}
	
	
	public boolean isLeaf()
	{
		if (this.left == null && this.right == null)
		{
			return true;
		}

		return false;
	}
	

    
}
