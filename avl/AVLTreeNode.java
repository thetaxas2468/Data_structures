package lab8mafne;

public class AVLTreeNode {
	private int key;
	private int height ; // Height of the sub-tree
	private AVLTreeNode left, right;
	public AVLTreeNode (int elem, int height, AVLTreeNode leftPtr, AVLTreeNode rightPtr){ 
		this.key=elem;
		this.height=0;
		this.left=leftPtr;
		this.right=rightPtr;
	}
	public void setRight(AVLTreeNode ptr) {
		this.right=ptr;
	}
	public void setLeft(AVLTreeNode ptr) {
		this.left=ptr;
	}
	public AVLTreeNode getRight() {
		return right;
	}
	public AVLTreeNode getLeft() {
		return left;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
