package hust.soict.ictglobal.aims.media;

import hust.soict.ictglobal.aims.Aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable {
	
	
	private String title;
	private String category;
	//private String director;
	//private int length;
	private float cost;
	@Override
	public String toString() {
		return "ID: "+getId()+" Title: "+getTitle()+" Category: "+getCategory()+" Diretor: "+getDiretor()+" Length: "+getLength()+" Cost:  "+getCost();
	}
	public void play() throws PlayerException {
		if(this.getLength()<=0) {
			System.err.println("ERROR: DVD length is 0");
			throw(new PlayerException());
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public DigitalVideoDisc() {
		
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	public DigitalVideoDisc(String title, String category, String directory) {
		super();
		this.title = title;
		this.category = category;
		this.director = directory;
	}
	
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost ) {
		super();
		this.title = title;
		this.category = category;
		this.director = directory;
		this.length = length;
		this.cost = cost;
	}  
	
	
	
	public String getDiretor() {
		return director;
	}
	public void setDiretor(String directory) {
		this.director = directory;
	}
	/*public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}*/
	public boolean search (String title) {
		String a = title.toLowerCase();
		String [] word1 =a.split("\\s");
		String b = getTitle().toLowerCase();
		String [] word2 =b.split("\\s");
		int count =0;
		for(int i=0;i<word1.length;i++) { 
			for(int j=0;j<word2.length;j++) {
				if(word1[i].equals(word2[j])) {
					count++;
					word2[j]=null;
					break;
				}
			}
		}
		/*for(int i=0;i<word1.length;i++) {
			System.out.println(word1[i]);
		}
		for(int i=0;i<word2.length;i++) {
			System.out.println(word2[i]);
		}
		
		System.out.println(count);*/
		//System.out.println(word1.length);
		//System.out.println(word2.length);
		if (count==word1.length)
		return true;
		else
		return false;
		}
	@Override
	/*public int compareTo(Media obj) {
		// TODO Auto-generated method stub	
		return this.getTitle().compareTo(obj.getTitle());
	}*/
	
	public int compareTo(Object obj) {
		if (this.getCost()>((DigitalVideoDisc) obj).getCost())
			return 1;
		else if(this.getCost()<((DigitalVideoDisc) obj).getCost())
			return -1;
		else
			return 0;
		
	}

	/*public int compareTo(Media arg0) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}
