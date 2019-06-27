package hust.soict.ictglobal.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Book extends Media implements Comparable{
	
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	private String content ;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String,Integer> wordFrequency;// = new HashMap<String,Integer>();
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "ID: " +getId()+" Title: "+getTitle()+" Category: "+getCategory()+" Cost: "+getCost()+" Author: "+getAuthors();
	}


	public List<String> getAuthors() {
		return authors;
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public Book(String title) {
		super(title);
		
	}
	
	public void processContent() {
		String[] tokenArray = this.content.split("\\.|\\s");
		Iterator<String> iterator;
		for(String token:tokenArray) {
			contentTokens.add(token);
		}
		//sort
		Collections.sort(contentTokens,new Comparator<String>() {

			@Override
			public int compare(String token1, String token2) {
				// TODO Auto-generated method stub
				return token1.compareTo(token2);
			}
			
		});
		//count
		wordFrequency = new LinkedHashMap<String,Integer>();
		//System.out.println(contentTokens);
		int sumofCount =0;
		for (int i = 0; i < contentTokens.size()-1; i++) {
			String distinctToken = contentTokens.get(i);
			Integer countToken = 1;
			int j=i+1;
			while(distinctToken.equals(contentTokens.get(i+1))){
				countToken++;
				i++;
				
			}
			sumofCount+=countToken;
			wordFrequency.put(distinctToken, countToken);
			
		}
		
		if (sumofCount < contentTokens.size())
			wordFrequency.put(contentTokens.get(sumofCount), 1);
	}
	
	
	public Book(String title, String category, List<String> authors) {
		super(title, category);
		this.authors = authors;
	}


	public Book(String title, String category) {
		super(title, category);
	}


	public void addAuthor(String authorname) {
		for (int i = 0; i < authors.size(); i++) {
			if(authors.get(i)==authorname) {
				System.out.println("the author "+authorname+" has been added before");
			}
			else {
				authors.add(authorname);
				System.out.println("done!");
			}
			
		}
	}



	public void removeAuthor(String authorname) {
		for (int i = 0; i < authors.size(); i++) {
			if(authors.get(i)==authorname) {
				authors.remove(i);
				System.out.println("done!");
			}else {
				System.out.println("the author "+authorname+" is not exist");
			}
			
			
		}
	}


	public Book() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int compareTo(Media disc) {
		// TODO Auto-generated method stub
		String s1 = String.valueOf(super.getCost());
		String s2= String.valueOf(disc.getCost());
		return s1.compareTo(s2);
	}

}
