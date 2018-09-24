package codes;

public class Node {
	
	private int data;
	private Node up;
	private Node down;
	private Node right;
	private Node left;
	
	// Initialize the Node variables
	public Node(){
		this.data = 0;
		up = down = right = left = null;
	}
	
	// Overload the constructor
	public Node(int data){
		this.data = data;
	}
	
	// Getter and Setters for the Node value
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	// Getters for the adjacent Nodes
	public Node getUp(){
		return this.up;
	}
	
	public Node getDown(){
		return this.down;
	}
	
	public Node getRight(){
		return this.right;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	// Setters for the adjacent Nodes
	public void setUp(Node up){
		this.up = up;
	}
	
	public void setDown(Node down){
		this.down = down;
	}
	
	public void setRight(Node right){
		this.right = right;
	}

	public void setLeft(Node left){
		this.left = left;
	}
	
	// Getters for the knight-move(L shape) Nodes in all 8 directions
	
	public Node topRight(){
		if(this.getUp() != null){
			if(this.getUp().getUp() != null){
				if(this.getUp().getUp().getRight() != null){
					return this.getUp().getUp().getRight();
				}
			}
		}
		return null;
	}
	
	public Node topLeft(){
		if(this.getUp() != null){
			if(this.getUp().getUp() != null){
				if(this.getUp().getUp().getLeft() != null){
					return this.getUp().getUp().getLeft();
				}
			}
		}
		return null;
	}
	
	public Node bottomRight(){
		if(this.getDown() != null){
			if(this.getDown().getDown() != null){
				if(this.getDown().getDown().getRight() != null){
					return this.getDown().getDown().getRight();
				}
			}
		}
		return null;
	}
	
	public Node bottomLeft(){
		if(this.getDown() != null){
			if(this.getDown().getDown() != null){
				if(this.getDown().getDown().getLeft() != null){
					return this.getDown().getDown().getLeft();
				}
			}
		}
		return null;
	}
	
	public Node rightTop(){
		if(this.getRight() != null){
			if(this.getRight().getRight() != null){
				if(this.getRight().getRight().getUp() != null){
					return this.getRight().getRight().getUp();
				}
			}
		}
		return null;
	}
	
	public Node rightBottom(){
		if(this.getRight() != null){
			if(this.getRight().getRight() != null){
				if(this.getRight().getRight().getDown() != null){
					return this.getRight().getRight().getDown();
				}
			}
		}
		return null;
	}
	
	public Node leftTop(){
		if(this.getLeft() != null){
			if(this.getLeft().getLeft() != null){
				if(this.getLeft().getLeft().getUp() != null){
					return this.getLeft().getLeft().getUp();
				}
			}
		}
		return null;
	}

	public Node leftBottom(){
		if(this.getLeft() != null){
			if(this.getLeft().getLeft() != null){
				if(this.getLeft().getLeft().getDown() != null){
					return this.getLeft().getLeft().getDown();
				}
			}
		}
		return null;
	}
	
}
