package test3;

public class HashTable {
	private static final int DEF_MAX_HASH_SIZE = 10; 
	private SLinkedList < HashTableData> hashArray[]; 
	private int Elements=0;
	public HashTable ( ) {
		this(DEF_MAX_HASH_SIZE);
	}
	@SuppressWarnings("unchecked")
	public HashTable ( int maxNumber ) 
	{
		if(maxNumber<=0) {
			System.out.println("Illegal argument");
			return;
		}
		hashArray = new SLinkedList[maxNumber];
		for(int i=0;i<hashArray.length;i++) {
			hashArray[i]=new SLinkedList<HashTableData>();
		}
	
	}
	private boolean compare(HashTableData temp1,HashTableData temp2) {
		if(temp1.getAverage()!=temp2.getAverage()) {
			return false;
		}
		else if(temp1.getFamilykey().compareTo(temp2.getFamilykey())!=0) {
			return false;
		}
		else if(temp1.getID()!=temp2.getID()) {
			return false;
		}
		else if(temp1.getKey().compareTo(temp2.getKey())!=0) {
			return false;
		}
		else if(temp1.getYo()!=temp2.getYo()) {
			return false;
		}
		else {
			return true;
		}
	}
	// HashFunctions
	int HashFunction ( int key ) {
		return key%hashArray.length;
	}
	int HashFunction ( String key ) {
		char temp[]=key.toCharArray();
		int sum=0;
		for(int i=0;i<key.length();i++) {
			sum+=(int)temp[i];
		}
		return sum%hashArray.length;
	}
	// Hash manipulation methods
	public boolean retrieve ( HashTableData searchElem) {
		if(this.isEmpty()) {
			return false;
		}
		int temp=this.HashFunction(searchElem.getKey());
		if(hashArray[temp].isEmpty()) {
			return false;
		}
		hashArray[temp].gotoBeginning();
		if(compare(searchElem,hashArray[temp].getCursor())) {
			return true;
		}
		while(hashArray[temp].gotoNext()==true) {
			if(compare(searchElem,hashArray[temp].getCursor())) {
				return true;
			}
		}
		return false;		
	}
	public boolean insert ( HashTableData newElem) {
		if(this.isFull()) {
			return false;
		}
		else {
			int temp=this.HashFunction(newElem.getKey());
			hashArray[temp].gotoBeginning();
			hashArray[temp].insert(newElem);
			Elements++;
			return true;
		}
	}
	public boolean remove ( HashTableData remElem) {
		if(this.isEmpty()) {
			return false;
		}
		else {
			int temp=this.HashFunction(remElem.getKey());
			if(hashArray[temp].isEmpty()) {
				return false;
			}
			hashArray[temp].gotoBeginning();
			if(compare(remElem,hashArray[temp].getCursor())) {
				Elements--;
				hashArray[temp].remove();
				return true;
			}
			else {
				while(hashArray[temp].gotoNext()==true) {
					if(compare(remElem,hashArray[temp].getCursor())) {
						Elements--;
						hashArray[temp].remove();
						return true;
					}
				}
				return false;
			}	
		}
	}
	public void clear ( ) {
		for(int i=0;i<hashArray.length;i++) {
			hashArray[i].clear();
		}
		
	}
	// Hash status methods
	public boolean isEmpty ( ) {
		if(Elements==0) {
			return true;
		}
		return false;
	}
	public boolean isFull ( ) {
		return false;
	}
	// Output the hash structure
	public String toString ( ) {
		String x="";
		for(int i=0;i<hashArray.length;i++) {
			if(hashArray[i].isEmpty()) {
				x+="Empty Slot\n";
			}
			x+=hashArray[i].toString();
		}
		return x;
	}
}
