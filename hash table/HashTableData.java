package test3;

public class HashTableData {
	private String key; 
	private int ID;
	private String Familykey;
	private int yo;
	private int average;
	public int getID() {
		return ID;
	}
	public String getFamilykey() {
		return Familykey;
	}
	public int getYo() {
		return yo;
	}
	public int getAverage() {
		return average;
	}
	public HashTableData (int id,String key,String familyname,int yo,int average){ 
		this.ID=id;
		this.key=key;
		this.Familykey=familyname;
		this.yo=yo;
		this.average=average;
	}
	public String getKey() {
		return key;
	}
}
