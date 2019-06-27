package hust.soict.ictglobal.aims.order.Order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Date;
import java.util.Scanner;

import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.media.Media;

public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	public String dateOrdered;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_LIMITTED_ORDERS = 5;
	private static int nOrders =0;
	private String id;
	
	
public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*	public DigitalVideoDisc getALuckyItem() {
		int k=0;
		for(int i=0;i<this.itemsOrdered.length;i++) {
			if(this.itemsOrdered[i]!= null) {
				k++;
			}
		}
		int ran = new Random().nextInt(k);
		System.out.println("The dvd has been free is : " +this.itemsOrdered[ran].getTitle() +" -" +this.itemsOrdered[ran].getCost());
		this.itemsOrdered[ran].setCost(0);
		return this.itemsOrdered[ran];
		}
*/	
	public Order(String dateOrdered) {
		if(nOrders<MAX_LIMITTED_ORDERS) {
		this.dateOrdered = dateOrdered;
		nOrders ++;
		if(nOrders == MAX_LIMITTED_ORDERS)
			System.out.println("full Order");
		}

	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public String getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	
   public float totalCost() {
    	float sum = 0;
    	for (int i = 0; i < itemsOrdered.size(); i++) {
    		sum=sum+itemsOrdered.get(i).getCost();
			
		}
    	return sum;
		}
  	

   
   
public void addMedia(Media md) {
	itemsOrdered.add(md);
	
}
public void removeMedia(Media md) {
	itemsOrdered.remove(md);
	
}

	
    }
	


