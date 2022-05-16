package lab8mafne;

public class AVLTree {
	private AVLTreeNode root;
	public AVLTree() {
		root=null;
	}
	private AVLTreeNode parent(AVLTreeNode rootie,int searchKey) {
		if(rootie==null||rootie.getKey()==searchKey) {
			return null;
		}
		else if(rootie.getLeft()!=null&&rootie.getLeft().getKey()==searchKey) {
			return rootie;
		}
		else if(rootie.getRight()!=null&&rootie.getRight().getKey()==searchKey) {
			return rootie;
		}
		else if(searchKey>rootie.getKey()) {
			return parent(rootie.getRight(),searchKey);
		}
		else {
			return parent(rootie.getLeft(),searchKey);
		}
	}
	private void leftleft(AVLTreeNode node) {
		boolean right=false;
		AVLTreeNode parent=parent(root,node.getKey());
		if(parent!=null) {
			AVLTreeNode temp1=parent.getRight();
			if(temp1==node) {
				right=true;
			}
			else {
				right=false;
			}
		}
		AVLTreeNode k2=node;
		AVLTreeNode k1=k2.getLeft();
		AVLTreeNode X=k1.getLeft();
		AVLTreeNode Y=k1.getRight();
		AVLTreeNode Z=node.getRight();
		k1.setLeft(X);
		k2.setLeft(Y);
		k2.setRight(Z);
		k1.setRight(k2);
		if(parent==null) {
			this.root=k1;
			return;
		}
		else {
			if(right==false) {
				parent.setLeft(k1);
			}
			else {
				parent.setRight(k1);
			}
		}
	}
	private void rightright(AVLTreeNode node) {
		boolean right=false;
		AVLTreeNode parent=parent(root,node.getKey());
		if(parent!=null) {
			AVLTreeNode temp1=parent.getRight();
			if(temp1==node) {
				right=true;
			}
			else {
				right=false;
			}
		}
		AVLTreeNode k2=node;
		AVLTreeNode k1=k2.getRight();
		AVLTreeNode X=k1.getRight();
		AVLTreeNode Y=k1.getLeft();
		AVLTreeNode Z=node.getLeft();
		k1.setLeft(k2);
		k2.setLeft(Z);
		k2.setRight(Y);
		k1.setRight(X);
		if(parent==null) {
			this.root=k1;
			return;
		}
		else {
			if(right==true) {
			parent.setRight(k1);
			}
			else {
				parent.setLeft(k1);
			}
		}
	}
	private void leftright(AVLTreeNode node) {
		boolean right=false;
		AVLTreeNode parent=parent(root,node.getKey());
		if(parent!=null) {
			AVLTreeNode temp1=parent.getRight();
			if(temp1==node) {
				right=true;
			}
			else {
				right=false;
			}
		}
		AVLTreeNode k3=node;
		AVLTreeNode k2=node.getLeft().getRight();
		AVLTreeNode k1=node.getLeft();
		AVLTreeNode A=k1.getLeft();
		AVLTreeNode B=k2.getLeft();
		AVLTreeNode C=k2.getRight();
		AVLTreeNode D=node.getRight();
		k3.setLeft(C);
		k3.setRight(D);
		k2.setLeft(k1);
		k2.setRight(k3);
		k1.setLeft(A);
		k1.setRight(B);
		update_height(k3);
		update_height(k1);
		update_height(k2);
		if(parent==null) {
			this.root=k2;
			return;
		}
		else {
			if(right==true) {
				parent.setRight(k2);
			}
			else {
				parent.setLeft(k2);
			}
		}
	}
	private void rightleft(AVLTreeNode node) {
		boolean right=false;
		AVLTreeNode parent=parent(root,node.getKey());
		if(parent!=null) {
			AVLTreeNode temp1=parent.getRight();
			if(temp1==node) {
				right=true;
			}
			else {
				right=false;
			}
		}
		AVLTreeNode k3=node;
		AVLTreeNode k2=node.getRight().getLeft();
		AVLTreeNode k1=node.getRight();
		AVLTreeNode A=k1.getRight();
		AVLTreeNode B=k2.getRight();
		AVLTreeNode C=k2.getLeft();
		AVLTreeNode D=node.getLeft();
		k3.setLeft(D);
		k3.setRight(C);
		k2.setLeft(k3);
		k2.setRight(k1);
		k1.setLeft(B);
		k1.setRight(A);
		update_height(k3);
		update_height(k1);
		update_height(k2);
		if(parent==null) {
			this.root=k2;
			return;
		}
		else {
			if(right==true) {
				parent.setRight(k2);
			}
			else {
				parent.setLeft(k2);
			}
		}
	}
	public void insert ( int newElement ){ 
		if(root==null) {
			root=new AVLTreeNode(newElement,0,null,null);
			return;
		}
		insert_rec(root,newElement);
	}
	private void insert_rec(AVLTreeNode node,int newElement) {
		if(node.getRight()==null&&node.getKey()<newElement) {
			node.setRight(new AVLTreeNode(newElement,0,null,null));
		}
		else if(node.getLeft()==null&&node.getKey()>newElement) {
			node.setLeft(new AVLTreeNode(newElement,0,null,null));
		}
		else {
			if(node.getKey()<newElement) {
				insert_rec(node.getRight(),newElement);
			}
			else {
				insert_rec(node.getLeft(),newElement);
			}
		}
		update_height(node);
		int balance=this.getBalance(node);
		if(balance==2) {
			if(newElement<node.getLeft().getKey()) {//LL
				this.leftleft(node);
				update_height(node);
			}
			else {//LR
				this.leftright(node);
			}
		}
		else if(balance==-2) {
			if(newElement>node.getRight().getKey()) {//RR
				this.rightright(node);
				update_height(node);
			}
			else {//RL
				this.rightleft(node);
			}
		}
	}
	private void update_height(AVLTreeNode node) {
		if(node.getRight()==null&&node.getLeft()==null) {
			node.setHeight(0);
		}
		else {
			if(node.getRight()==null) {
				node.setHeight(node.getLeft().getHeight()+1);
			}
			else if(node.getLeft()==null) {
				node.setHeight(node.getRight().getHeight()+1);
			}
			else {
				node.setHeight(Math.max(node.getRight().getHeight()+1, node.getLeft().getHeight()+1));
			}
		}
	}
	
	
	
	public AVLTreeNode retrieve ( int searchKey ){
		return retrieve_rec(root,searchKey);
	}
	private AVLTreeNode retrieve_rec(AVLTreeNode node,int searchKey) {
		if(node==null) {
			return null;
		}
		if(node.getKey()==searchKey) {
			return node;
		}
		else if(node.getKey()<searchKey) {
			return retrieve_rec(node.getRight(),searchKey);
		}
		else {
			return retrieve_rec(node.getLeft(),searchKey);
		}
	}
	public void clear () {
		root=null;
	}
	public boolean isEmpty () {
		if(root==null) {
			return true;
		}
		return false;
	}
	public boolean isFull () {return false;}
	@SuppressWarnings("unused")
	private String check_inoreder(AVLTreeNode node) {
		if(node==null) {
			return "";
		}
		return In_order(node.getLeft()) +" "+ node.getKey() + "["+node.getHeight()+"]"+ In_order(node.getRight())+" ";
	}
	private String In_order(AVLTreeNode node) {
		if(node==null) {
			return "";
		}
		return In_order(node.getLeft()) +" "+ node.getKey()+In_order(node.getRight())+" ";
	}

	private int getBalance(AVLTreeNode node) {
		if(node==null) {
			return 0;
		}
		else {
			return whatisheight(node.getLeft())-whatisheight(node.getRight());
		}
	}
	private int whatisheight(AVLTreeNode node) {
		if(node==null) {
			return -1;
		}
		return node.getHeight();
	}
	public String toString (){
		return In_order(root);
	}
}
