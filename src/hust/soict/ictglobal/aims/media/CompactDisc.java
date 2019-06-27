package hust.soict.ictglobal.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.ictglobal.aims.Aims.PlayerException;
/*Trừ khi một lớp triển khai interface là lớp trừu tượng abstract, 
 * còn lại tất cả các phương thức của interface cần được định nghĩa trong class.  */
public class CompactDisc extends Disc implements Playable, Comparable{
	
	private String artist;
	private int length;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public void play() throws PlayerException 
	{
		if(this.getLength()<=0) {
			System.err.println("ERROR: DVD length is 0");
			throw(new PlayerException());
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
		java.util.Iterator iter = tracks.iterator();
		Track nextTrack;
		
		while(iter.hasNext()) {
			nextTrack = (Track) iter.next();
			try {
				nextTrack.play();
				
			}catch(PlayerException e) {
				e.printStackTrace();
			}
		}
	}
		/*
		System.out.println(" Play CD!  ");
		System.out.println("Độ dài CD :" + this.getLength());
		System.out.println("Tác giả :"+this.getArtist());
		for (int i = 0; i < this.tracks.size(); i++) {
			System.out.println("Track "+(i+1));
			tracks.get(i).play();
			
		}*/
		
	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void addTrack(Track trackIn ) {
		if(this.tracks.contains(trackIn))
			System.out.println("The track " + trackIn.getTitle() + " is existed. ");
		else 
		{
			this.tracks.add(trackIn);
			System.out.println("The track " + trackIn.getTitle() + " has been added. ");
		}
			
		
	}
	
	public void removeTrack(Track trackOut) {
		if(this.tracks.contains(trackOut)) 
		{
			this.tracks.remove(trackOut);
			System.out.println("The track "+ trackOut.getTitle() + " has been removed. " );
		}
			
		else
			System.out.println("The track "+ trackOut.getTitle() + " is not existed. " );
	}
	
	
	public int getLength() {
		int lengthOfCD=0;
		for (int i = 0; i < this.tracks.size(); i++) 
		{
			lengthOfCD += tracks.get(i).getLength();
			
		}
		return lengthOfCD;
		
		
	}


	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Object obj) {
		if (this.tracks.size()>((CompactDisc) obj).tracks.size())
			return 1;
		else if(this.tracks.size()<((CompactDisc) obj).tracks.size())
			return -1;
		else 
		{
			if (this.getLength() > ((CompactDisc) obj).getLength())
				return 1;
			else if(this.getLength() < ((CompactDisc) obj).getLength())
				return -1;
			else
				return 0;
			
		}
			
		
	}
}
