package lab12mafne;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestGraph {
	public static void main(String[] argv) throws IOException {
		Graph temp=new Graph(50);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		while (true){
			tokens.nextToken();
			String x=tokens.sval;
			if(x.equals("Addv")) {
				tokens.nextToken();
				Vertex w=new Vertex(tokens.sval);
				temp.insertVertex(w);
				
			}
			else if(x.equals("Adde")) {
				tokens.nextToken();
				String w=tokens.sval;
				tokens.nextToken();
				String f=tokens.sval;
				tokens.nextToken();
				int j=(int)tokens.nval;
				temp.insertEdge(w,f, j);
				
			}
			else if(x.equals("W")) {
				tokens.nextToken();
				String x1=tokens.sval;
				tokens.nextToken();
				String x2=tokens.sval;
				System.out.println(temp.edgeWeight(x1, x2));
			}
			else if(x.equals("R")) {
				tokens.nextToken();
				Vertex x1=temp.retrieveVertex(tokens.sval);
				System.out.println(x1.getLabel());
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
