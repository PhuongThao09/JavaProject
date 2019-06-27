package hust.soict.ictglobal.aims.Aims;

import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.order.Order.Order;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		/*DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDiretor("Roger Allers");
		dvd1.setLength(87);
		System.out.println( dvd1.search("KING Lion"));*/
		
		
		//anOrder.addDigitalVideoDisc(dvd1);
	/*	
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tasdasd");
		dvd2.setCategory("Adasda");
		dvd2.setCost(24.95f);
		dvd2.setDiretor("Rogedasd");
		dvd2.setLength(87);
		//anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tasdasd");
		dvd3.setCategory("Adas123da");
		dvd3.setCost(18.99f);
		dvd3.setDiretor("Rogedasd");
		dvd3.setLength(87);
	//	anOrder.addDigitalVideoDisc(dvd3);
	//	anOrder.removeDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc [] dvdList1= {dvd1,dvd2,dvd3};
		DigitalVideoDisc [] dvdList2= {dvd1,dvd2};*/
		
		
	
		/*anOrder1.addDigitalVideoDisc(dvdList1);
		anOrder2.addDigitalVideoDisc(dvdList2);
		*///System.out.print("The total is :");
		//System.out.println( anOrder.totalCost() );
		
/*		anOrder1.printOrder();
		anOrder1.getALuckyItem();
		anOrder1.printOrder();
*/		//anOrder2.printOrder();
		//System.out.println(anOrder.itemsOrdered[4].getCost());
		
		/*for ( DigitalVideoDisc dvd : anOrder.itemsOrdered) {
			if(dvd != null)
			System.out.print("the dvd"+ dvd.getCategory());
			
		}*/
		
		
		Order anOrder1 = new Order("2001/11/20");
		Order anOrder2 = new Order("2001/9/20");
		
	
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDiretor("Roger Allers");
		dvd1.setLength(87);
		System.out.println( dvd1.search("KING Lion"));
		
		
		//anOrder.addDigitalVideoDisc(dvd1);
		
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tasdasd");
		dvd2.setCategory("Adasda");
		dvd2.setCost(24.95f);
		dvd2.setDiretor("Rogedasd");
		dvd2.setLength(87);
		//anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tasdasd");
		dvd3.setCategory("Adas123da");
		dvd3.setCost(18.99f);
		dvd3.setDiretor("Rogedasd");
		dvd3.setLength(87);
	//	anOrder.addDigitalVideoDisc(dvd3);
	//	anOrder.removeDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc [] dvdList1= {dvd1,dvd2,dvd3};
		DigitalVideoDisc [] dvdList2= {dvd1,dvd2};
	/*	anOrder1.addDigitalVideoDisc(dvdList1);
		anOrder2.addDigitalVideoDisc(dvdList2);

		anOrder1.printOrder();
		anOrder1.getALuckyItem();
		anOrder1.printOrder();*/
		
		
	}

}
