package lab8mafne;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestAVLTree {
	public static void main(String[] args) throws IOException {
//		AVLTree tree = new AVLTree();
		//LL
//		tree.insert(5);
//		tree.insert(2);
//		tree.insert(1);
//		tree.insert(0);
//		tree.insert(-1);
		//RR
//		tree.insert(1);
//		tree.insert(2);
//		tree.insert(5);
//		tree.insert(7);
//		tree.insert(8);
		//LR
//		tree.insert(100);
//		tree.insert(50);
//		tree.insert(150);
//		tree.insert(10);
//		tree.insert(60);
//		System.out.println(tree);
//		tree.insert(55);
//		System.out.println(tree);
		//RL
//		tree.insert(100);
//		tree.insert(50);
//		tree.insert(150);
//		tree.insert(140);
//		tree.insert(160);
//		System.out.println(tree);
//		tree.insert(145);
//		System.out.println(tree);
		//Another example LF TO AVOID NULLPOINTERS CHECK
//		tree.insert(50);
//		tree.insert(40);
//		System.out.println(tree);
//		tree.insert(45);
//		System.out.println(tree);
		//Another example RL TO AVOID NULLPOINTERS CHECK
//		tree.insert(50);
//		tree.insert(60);
//		System.out.println(tree);
//		tree.insert(55);
//		System.out.println(tree);
		AVLTree tree=new AVLTree();
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		while (true){
			tokens.nextToken();
			String x=tokens.sval;
			if(x.equals("ADD")) {
				tokens.nextToken();
				Integer y=(int)tokens.nval;
				tree.insert(y);
			}
			else if(x.equals("FIND")) {
				tokens.nextToken();
				Integer y=(int)tokens.nval;
				AVLTreeNode temp=tree.retrieve(y);
				if(temp==null) {
					System.out.println("Element is not in tree");
				}
				else {
					System.out.println(temp.getKey());
				}
			}
			else if(x.equals("K")) {
				System.out.println(tree);
			}
			else if(x.equals("E")) {
				System.out.println(tree.isEmpty());
			}
			else if(x.equals("F")) {
				System.out.println(tree.isFull());
			}
			else if(x.equals("C")) {
				tree.clear();
			}
			else if(x.equals("Q")) {
				break;
			}
			
		}
	}
}
