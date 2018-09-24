package codes;

public class LinkedGrid {
	
	private Node root;
	
	public LinkedGrid(int cols, int rows) {
		
		root = new Node();
		Node rowPointer = root;
		
		for(int y=0; y<cols; y++){
			
			if(y != 0){
				// Add new Node to the bottom of the column
				Node temp = new Node();
				rowPointer.setDown(temp);
				temp.setUp(rowPointer);
				rowPointer = temp;
			}
			
			Node colPointer = rowPointer; // Pointing to the first Node in the row
			
			// Add all of the Nodes for that row
			for(int x=1; x<rows; x++){
				Node colTemp = new Node();
				colPointer.setRight(colTemp);
				colTemp.setLeft(colPointer);
				if(y != 0){
					// Set up and down pointers
					colTemp.setUp(colTemp.getLeft().getUp().getRight());
					colTemp.getLeft().getUp().getRight().setDown(colTemp);
				}
				colPointer = colTemp;
			}
		}
		
	}
	
	// Method for printing the Linked Grid
	public void display(){
		Node rowPointer = root;
		
		while(rowPointer != null){
			Node colPointer = rowPointer;
			
			while(colPointer != null){
				System.out.print(colPointer.getData() + "\t");
				colPointer = colPointer.getRight();
			}
			
			System.out.println();
			rowPointer = rowPointer.getDown();
		}
		
		System.out.println("\n");
		
	}
	
	// Getter for the root Node
	public Node getRoot(){
		return root;
	}
	
}
