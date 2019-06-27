package hust.soict.ictglobal.aims.media;

import hust.soict.ictglobal.aims.Aims.PlayerException;

public class Track implements Playable, Comparable<Media>{
	private String title;
	private int length;
	
	public void play() throws PlayerException{
		if(this.getLength()<=0) {
			System.err.println("ERROR: DVD length is 0");
			throw(new PlayerException());
		}
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public Track() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Media disc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
