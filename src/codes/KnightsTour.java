package codes;

public class KnightsTour {
	
	public static int colSize = 5; // Board column size
	public static int rowSize = 5; // Board row size
	public static LinkedGrid board;
	public static Node root;
	public static int solutions = 0;

	public static void main(String[] args) {
		
		// Set up the board using a Linked Grid
		board = new LinkedGrid(colSize, rowSize);
		root = board.getRoot();
		//board.display();
		
		System.out.println("Board Size: " + colSize + " x " + rowSize);
		System.out.println("Starting Knights Tour...\n");
		
		// Start exploring every house in the board
		exploreBoard();
		
		System.out.println("\n\nNumber of solutions found for this board: " + solutions);

	}
	
	// A method that iterates through every Node in the LinkedGrid and calls the explore() method on that Node
	public static void exploreBoard(){
		Node rowPointer = root;
		
		int counter = 1;
		
		while(rowPointer != null){
			Node colPointer = rowPointer;
			
			while(colPointer != null){
				
				int solutionsFound = solutions;
				
				// Find all of the solutions for the Node
				explore(colPointer, 1);
				
				// Number of solutions for the current Node
				solutionsFound = solutions - solutionsFound;
				
				System.out.println("Solutions for house " + counter + " : " + solutionsFound );
				
				counter++;
				colPointer = colPointer.getRight();
			}
			
			rowPointer = rowPointer.getDown();
		}
		
	}
	
	// The recursive method for finding all of the possible knight tours solutions starting from a given Node and the provided step 
	public static void explore(Node knight, int step){
		
		// If the chosen house is null  OR  it's already visited
		if(knight == null || knight.getData() != 0){
			return;
		}
		
		// Check to see if the board is solved
		if(step == colSize*rowSize){
			// If the tour is done, increase the number of solutions by 1
			solutions++;
			//board.display(); // for debugging purposes
			return;
		}
		
		// Set the Node value to the step passed from the previous function called
		knight.setData(step);
		
		// Call this method recursively for all 8 possible knight moves around this Node
		explore(knight.topRight(), step+1);
		explore(knight.topLeft(), step+1);
		
		explore(knight.bottomRight(), step+1);
		explore(knight.bottomLeft(), step+1);
		
		explore(knight.rightTop(), step+1);
		explore(knight.rightBottom(), step+1);
		
		explore(knight.leftTop(), step+1);
		explore(knight.leftBottom(), step+1);
		
		knight.setData(0); // Set the Node back to 0 so we can try other paths
		
	}

}
