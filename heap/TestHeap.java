package lab11mafne;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestHeap {
	public static void main(String[] argv) throws IOException {
		Heap temp=new Heap(50);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		while (true){
			tokens.nextToken();
			String x=tokens.sval;
			if(x.equals("Add")) {
				tokens.nextToken();
				HeapData w=new HeapData((int)tokens.nval);
				temp.insert(w);
			}
			else if(x.equals("F")) {
				System.out.println(temp.isFull());
			}
			else if(x.equals("E")) {
				System.out.println(temp.isEmpty());
			}
			else if(x.equals("C")) {
				temp.clear();
			}
			else if(x.equals("Print")) {
				System.out.print(temp.toString());
			}
			else if(x.equals("Quit")) {
				break;
			}
			
	}
	}
}
