package test3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestHash {

	public static void main(String[] args) throws IOException {
		HashTable temp=new HashTable(20);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		while (true){
			tokens.nextToken();
			String x=tokens.sval;
			if(x.equals("Add")) {//ID    NAME   FAMILYNAME   YO   AVERAGE
				tokens.nextToken();
				int id=(int)tokens.nval;
				tokens.nextToken();
				String name=tokens.sval;
				tokens.nextToken();
				String familyname=tokens.sval;
				tokens.nextToken();
				int yo=(int)tokens.nval;
				tokens.nextToken();
				int average= (int)tokens.nval;
				System.out.println(id+" "+name+" "+familyname+" "+yo+" "+average);
				temp.insert(new HashTableData(id,name,familyname,yo,average));
			}
			else if(x.equals("Del")) {
				tokens.nextToken();
				int id=(int)tokens.nval;
				tokens.nextToken();
				String name=tokens.sval;
				tokens.nextToken();
				String familyname=tokens.sval;
				tokens.nextToken();
				int yo=(int)tokens.nval;
				tokens.nextToken();
				int average= (int)tokens.nval;
				System.out.println(id+" "+name+" "+familyname+" "+yo+" "+average);
				HashTableData o=new HashTableData(id,name,familyname,yo,average);
				System.out.println(temp.remove(o));
			}
			else if(x.equals("Get")) {
				tokens.nextToken();
				int id=(int)tokens.nval;
				tokens.nextToken();
				String name=tokens.sval;
				tokens.nextToken();
				String familyname=tokens.sval;
				tokens.nextToken();
				int yo=(int)tokens.nval;
				tokens.nextToken();
				int average= (int)tokens.nval;
				HashTableData search=new HashTableData(id,name,familyname,yo,average);
				temp.retrieve(search);
			}
			else if(x.equals("E")) {
				System.out.println(temp.isEmpty());
			}
			else if(x.equals("F")) {
				System.out.println(temp.isFull());
			}
			else if(x.equals("C")) {
				temp.clear();
			}
			else if(x.equals("Print")) {
				System.out.println(temp.toString().toString());
			}
			else if(x.equals("Quit")) {
				break;
			}
			
	}

	}

}
