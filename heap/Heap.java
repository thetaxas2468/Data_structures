package lab11mafne;

public class Heap {
	private static final int DEF_MAX_HEAP_SIZE = 10; // Default maximum heap size
	private int currentplace=0;
	private int size=0; // Actual number of elements in the heap
	private HeapData [ ] elements; // Array containing the heap elements

	public Heap () {
		this(DEF_MAX_HEAP_SIZE);
	}
	public Heap ( int maxNumber ) {
		this.size=maxNumber;
		elements=new HeapData[maxNumber];
		elements[currentplace]=new HeapData(-32768);
	}
//	private void swap(int elements2,int elements3) {
//		int temp=elements2;
//		elements2=elements3;
//		elements3=temp;
//	}
	private void Heapify(int place,HeapData element) {
		while(place/2!=0) {
			if(elements[place/2].getPriority()>element.getPriority()) { 
			//swap(elements[place/2].getPriority(),elements[place].getPriority());
				elements[place]=new HeapData(elements[place/2].getPriority());
				place=place/2;
			}
			else {
				elements[place].setPriority(element.getPriority());
				return;
			}
		}
		elements[place].setPriority(element.getPriority());
	}
	// Heap manipulation methods
	public void insert (HeapData newElement )  {
		if(this.isFull()) {
			throw new RuntimeException("Heap is empty");
		}
		else {
			currentplace++;
			if(currentplace/2==0) {
				elements[currentplace]=newElement;
				return;
			}
			if(elements[currentplace/2].getPriority()>newElement.getPriority()) {
				this.Heapify(currentplace,newElement);
			}
			else {
				elements[currentplace]=newElement;
				return;
			}
		}
		
	}
	 // To implement, you can write and use Heapify)( help
	 // method. Be sure you make only one swap between
	 // the elements!
	public HeapData removeMin() {
		if(this.isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		int i=1;
		HeapData head=elements[i];
		HeapData tail=elements[currentplace];
		elements[currentplace]=null;
		currentplace--;
		while(true) {
			if(i*2>currentplace) {//leaf node
				elements[i]=tail;
				break;
			}
			else if((i*2)+1>currentplace&&i*2==currentplace) {//has left node
				if(elements[2*i].getPriority()<elements[i].getPriority()) {
					elements[i].setPriority(elements[2*i].getPriority());
					i=i*2;
				}
				else {
					elements[i].setPriority(tail.getPriority());
					break;
				}
			}
			else {//has 2 nodes
				int min=Math.min(elements[2*i].getPriority(), elements[(2*i)+1].getPriority());
				min=Math.min(tail.getPriority(), min);
				if(min==tail.getPriority()) {
					elements[i].setPriority(tail.getPriority());
					break;
				}
				else if(min==elements[2*i].getPriority()) {
					elements[i].setPriority(elements[2*i].getPriority());
					i=2*i;
				}
				else if(min==elements[(2*i)+1].getPriority()){
					elements[i].setPriority(elements[(2*i)+1].getPriority());
					i=(2*i)+1;
				}
			}
		}
		return head;
	}
	
	
	
	
	
//	public HeapData removeMin () throws Exception {
//		if(this.isEmpty()) {
//			throw new Exception("Heap is empty");
//		}
//		int i=1;
//		HeapData node=elements[i];
//		swap(elements[i].getPriority(),elements[currentplace].getPriority());
//		currentplace--;
//		if((i*2)+1>currentplace&&i*2==currentplace) {
//			
//		}
//		int min=Math.min(elements[(i*2)].getPriority(), elements[(i*2)+1].getPriority());
//		while(elements[i].getPriority()>min) {
//			int temp;
//			if(elements[i*2].getPriority()==min) {
//				temp=i*2;
//			}
//			else {
//				temp=(i*2)+1;
//			}
//			swap(elements[i].getPriority(),elements[temp].getPriority());
//			i=temp;
//			if(i*2>currentplace) {
//				return node;
//			}
//			if((i*2)+1>currentplace) {
//				
//			}
//			min=Math.min(elements[(i*2)].getPriority(), elements[(i*2)+1].getPriority());
//		}
//		return node;
//	}
	
	
	
	
	
	
	
	public void clear () {		// Clear heap: Make it efficient!!
		currentplace=0;
	}
	// Heap status methods
	public boolean isEmpty () {
		if(currentplace==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull () {
		if(currentplace==size) {
			return true;
		}
		else {
			return false;
		}
	}
	// Output the heap structure
	public String toString () {
		String str="";
		for(int i=1;i<=currentplace;i++) {
			str+=(elements[i].getPriority());
			str+=('(');
			str+=(i);
			str+=(')');
			str+=('\t');
		}
		return str;
	}
	} // class Heap