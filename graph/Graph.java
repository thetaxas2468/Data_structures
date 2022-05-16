package lab12mafne;

public class Graph {
	// Default number of vertices (a constant)
	public static final int DEF_MAX_GRAPH_SIZE = 10;
	// "Weight" of a missing edge (a constant) — the max int value
	public static final int INFINITE_EDGE_WT = Integer.MIN_VALUE;
	private int size; // Actual number of vertices in the graph
	private Vertex [ ] vertexList; // Vertex list
	private int [ ][ ] adjMatrix; // Adjacency matrix (a 2D array)
	private int where;
	public Graph( ) {
		this(DEF_MAX_GRAPH_SIZE);
	}
	public Graph ( int maxNumber ) {
		if(maxNumber<=0) {
			throw new RuntimeException();
		}
		this.size=maxNumber;
		this.vertexList=new Vertex[maxNumber];
		for(int i=0;i<size;i++) {
			this.vertexList[i]=null;
		}
		this.adjMatrix=new int[maxNumber][maxNumber];
		this.where=-1;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				this.adjMatrix[i][j]=INFINITE_EDGE_WT;
			}
		}
	}
	public void insertVertex ( Vertex newVertex ) {
		if(this.isFull()) {
			throw new RuntimeException();
		}
		where++;
		this.vertexList[where]=newVertex;
	} // Insert vertex
	public void insertEdge ( String v1, String v2, int wt ){
		if(this.vertexList[this.index(v1)]==null||this.vertexList[this.index(v2)]==null||where==0) {
			throw new RuntimeException();
		}
		try {
			this.setEdge(this.index(v1), this.index(v2), wt);
			this.setEdge(this.index(v2), this.index(v1), wt);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	public Vertex retrieveVertex ( String v ) {
		if(this.isEmpty()) {
			throw new RuntimeException();
		}
		int id = 0;
		try {
			id=this.index(v);
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return this.vertexList[id];
	} // Get vertex
	public int edgeWeight ( String v1, String v2 ) {
		int id1 = 0;
		int id2 = 0;
		try {
			id1=this.index(v1);
			id2=this.index(v2);
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		if(this.vertexList[this.index(v1)]==null||this.vertexList[this.index(v2)]==null) {
			throw new RuntimeException();
		}
		return this.getEdge(id1,id2);
	} // Get edge wt
	public void removeVertex ( String v ) {
		if(this.vertexList[this.index(v)]==null||where==0) {
			throw new RuntimeException();
		}
		int ind=this.index(v);
		for(int i=0;i<size;i++) {
			this.adjMatrix[i][ind]=this.adjMatrix[i][where];
			this.adjMatrix[ind][i]=this.adjMatrix[where][i];
;
		}
		this.removeEdge(v, this.vertexList[where].getLabel());
		for(int i=0;i<size;i++) {
			this.adjMatrix[i][where]=INFINITE_EDGE_WT;
			this.adjMatrix[where][i]=INFINITE_EDGE_WT;
		}
		this.vertexList[ind]=this.vertexList[where];
		this.vertexList[where]=null;
		where--;
	} // Remove vertex
	public void removeEdge ( String v1, String v2 ) {
		if(this.vertexList[this.index(v1)]==null||this.vertexList[this.index(v2)]==null||where==0) {
			throw new RuntimeException();
		}
		this.adjMatrix[this.index(v1)][this.index(v2)]=INFINITE_EDGE_WT;
		this.adjMatrix[this.index(v2)][this.index(v1)]=INFINITE_EDGE_WT;

	} // Remove edge
	public void clear ( ) {
		where=-1;
	} // Clear graph
	public boolean isEmpty ( ) {
		return where==-1;
	} // Is graph empty?
	public boolean isFull ( ) {
		return where==size-1;
	} // Is graph full?
	public String toString( ) {
		String a="";
		for(int i=0;i<where;i++) {
			a+=this.vertexList[i].getLabel()+" ";
		}
		a+="\n";
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				a+=this.adjMatrix[i][j]+" ";
			}
			a+="\n";
		}
		return a;
	}
	private int index ( String v ) {
		int i;
		for(i=0;i<where;i++) {
			if(this.vertexList[i].getLabel().equals(v)){
				return i;
			}
		}
		if(i==size) {
			throw new RuntimeException();
		}
		return i;
	} // Converts vertex label to an adjacency matrix index
	private int getEdge ( int row, int col ) {
		return this.adjMatrix[row][col];
	} // Get edge weight using adjacency matrix indices
	private void setEdge ( int row, int col, int wt ) {
		this.adjMatrix[row][col]=wt;
	} // Set edge wt using adjacency matrix indices
	} // class Graph