package hust.soict.ictglobal.aims.Aims;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import hust.soict.ictglobal.aims.media.Book;
import hust.soict.ictglobal.aims.media.CompactDisc;
import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.media.Media;
import hust.soict.ictglobal.aims.media.Track;
import hust.soict.ictglobal.aims.order.Order.Order;

public class Aims {
	
	private MemoryDaemon memory = new MemoryDaemon();
	private static Scanner input;                                              // khi dùng nextLine() lưu ý lần nhập đằng trước có là số hay ko?
	private String idItem;


	public static void showMenu() throws PlayerException {
		ArrayList<Order> listOrder = new ArrayList<Order>();
		input = new Scanner(System.in);
		int a=5;
		do {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		a = input.nextInt();
		if(a<0 || a>4 ) {
			System.out.println("nhập sai xin mời nhập lại");
			a = input.nextInt();
		}
		
		//System.out.println(a);
		switch (a) {
		case 0:
			System.out.println("Good bye !");
			break;
		case 1:
			create(listOrder);
			break;
		case 2:
			add(listOrder);
			break;
		case 3:
			del(listOrder);
			break;
		case 4:
			showOder(listOrder);
			break;
		default:
			break;
		}
		}while(a!=0);
		
	}
	public static void create(ArrayList<Order> listOrder) {
		Order ord = new Order();
		System.out.println("tạo id Order");
		String id=input.next();
		if(checkIdOrder(listOrder, id)==false) {
		ord.setId(id);
		listOrder.add(ord);
		}else
			System.out.println("id đã tồn tại");
		
		
	}
	
	public static boolean search(Order order, String id) {
		int a=0;
		for (int i = 0; i < order.getItemsOrdered().size(); i++) {
			if(order.getItemsOrdered().get(i).getId().equals(id)) {
				a++;
			}
			
		}
		if(a>0) {
			System.out.println("id đã tồn tại xin mời nhập lại ");
			return false;
		}
		else {
		System.out.println("id hợp lệ ");
		return true;
		}
		
	}
	
	public static void addDVD(Order order) throws PlayerException {
		DigitalVideoDisc dvd = new DigitalVideoDisc();
		System.out.println("Bạn đã chọn DVD");
		System.out.println("nhập vào id của DVD ");
		String id = input.next();
		while(search(order,id)==false) {
			 id= input.next();
		}
		dvd.setId(id);
		System.out.println("nhập vào title ");
		input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
		dvd.setTitle(String.valueOf(input.nextLine()));
		System.out.println("nhập vào category ");
		dvd.setCategory(input.nextLine());
		System.out.println("nhập vào cost ");
		dvd.setCost(input.nextFloat());
		System.out.println("nhập vào diretor ");
		input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
		dvd.setDiretor(input.nextLine());
		System.out.println("nhập vào length ");
		dvd.setLength(input.nextInt());
		input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
		order.addMedia(dvd);
		
		System.out.println("Đã nhập xong thông tin DVD");
		System.out.println("Bật DVD chứ ?");
		int luachon=JOptionPane.showOptionDialog(null, "Bạn có muốn bật luôn ko ?", "Bật DVD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (luachon==JOptionPane.OK_OPTION) {
			System.out.println("Đang bật DVD");
			dvd.play();
			
		}
		
		
		
		
	}
	
	
	public static void addCD(Order order){
		int numTrack=0;
		
		CompactDisc cd = new CompactDisc();
		System.out.println("Bạn đã chọn CD");
		System.out.println("nhập vào id của CD");
		String id = input.next();
		while(search(order,id)==false) {
			 id= input.next();
		}
		cd.setId(id);
		System.out.println("Nhập vào tác giả ");
		input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
		cd.setArtist(String.valueOf(input.nextLine()));
		System.out.println("Nhập vào số lượng bài hát ");
		numTrack=input.nextInt();
		for (int i = 0; i < numTrack; i++) {
			Track newTrack = new Track();
			System.out.println("Nhập vào thông tin track" +(i+1));
			System.out.println("Nhập vào Title");
			input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
			newTrack.setTitle(input.nextLine());
			System.out.println("Nhập vào độ dài");
			newTrack.setLength(input.nextInt());
			cd.addTrack(newTrack);
		}
		order.addMedia(cd);
		System.out.println("Đã nhập xong thông tin CD");
		System.out.println("Bật CD chứ ?");
		int luachon=JOptionPane.showOptionDialog(null, "Bạn có muốn bật luôn ko ?", "Bật CD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (luachon==JOptionPane.OK_OPTION) {
			System.out.println("Đang bật CD");
			try {
				cd.play();
			}catch(PlayerException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void addBook(Order order) {
		Book book=new Book();
		System.out.println("Bạn đã chọn sách");
		System.out.println("nhập vào id của sách");
		String id = input.next();
		while(search(order,id)==false) {
			 id= input.next();
		}
		book.setId(id);
		System.out.println("nhập vào title ");
		input.nextLine();                                 					// nhận kí tự Enter trước đó do khi nhập vào là số thì còn thừa kí tự Enter
		book.setTitle(input.nextLine());
		System.out.println("nhập vào category ");
		book.setCategory(input.nextLine());
		System.out.println("nhập vào cost ");
		book.setCost(input.nextFloat());
		input.nextLine();
		System.out.println("nhập vào authors cách nhau bởi dấu - ");
		String[] word = input.nextLine().split("-");
		
		List<String> authors = new ArrayList<>();
		for (int i = 0; i < word.length; i++) {
			authors.add(word[i]) ;
		}
		book.setAuthors(authors);
		order.addMedia(book);
		
		
		
	}
	
	public static void add(ArrayList<Order> listOrder) throws PlayerException {
		System.out.println("nhập vào id Order");
		String id=input.next();
		int a=0;
	
		
		for (int i = 0; i < listOrder.size(); i++) {
			if(listOrder.get(i).getId().equals(id)) {
				a++;
				System.out.println("Book or DVD or CD");
				
				
				
				//String luachon=input.next();
				int iLuachon;
				Object stringArray[] = {"Book","DVD","CD" };
				iLuachon = JOptionPane.showOptionDialog(null,
		                "Sách hoặc DVD hoặc CD", "Tùy chọn",
		                JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,stringArray,
		                null
		                );
				switch(iLuachon) {
				case 0:
					addBook(listOrder.get(i));
					break;
				case 1 :
					addDVD(listOrder.get(i));
					break;
				case 2:
					addCD(listOrder.get(i));
					break;
				}
			}
			
		}
		if(a==0)
			System.out.println("không tìm thấy id Order");
		
		
	}
	public static boolean checkIdOrder(ArrayList<Order> listOrder,String id) {
		int a=0;
		for (int i = 0; i < listOrder.size(); i++) {
			if(listOrder.get(i).getId().equals(id)) {
				a++;
				}
			
		}
		if(a==0)
			return false;		// không có Order trùng id
		else
			return true;		// có Order trùng id
	}
	public static void del(ArrayList<Order> listOrder) {
		System.out.println("nhập vào id Order");
		String id=input.next();
		int a=0;
		for (int i = 0; i < listOrder.size(); i++) {
			if(listOrder.get(i).getId().equals(id)) {
				a++;
				Order order = listOrder.get(i);
				System.out.println("nhập vào id item");
				String idItem = input.next();
				int b=0;
				for (int j = 0; j < order.getItemsOrdered().size() ; j++) {
					if	(order.getItemsOrdered().get(j).equals(idItem)) {
						order.getItemsOrdered().remove(j);
						b++;
					}
					
				}
				if(b==0)
					System.out.println("Không tìm thấy item");
				
				
				}
			
			}
		if(a==0)
			System.out.println("không tìm thấy Order");
				
		
	}
	
	public static void showOder(ArrayList<Order> listOrder) {
		System.out.println("nhập vào id Order");
		String id=input.next();
		
		for (int i = 0; i < listOrder.size(); i++) {
			if(listOrder.get(i).getId().equals(id)) {
				Order order = listOrder.get(i);
				for (int j = 0; j < order.getItemsOrdered().size(); j++) {
					System.out.println(order.getItemsOrdered().get(j).toString());
					
				}
				System.out.println("Total Cost is: "+order.totalCost());
			
				
				}
		}
			
	}


	//@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, PlayerException {
		//JOptionPane.showMessageDialog(null, "Test");
		
		
		Thread dt = new Thread(new MemoryDaemon(), "My Deamon Thread " );
		dt.setDaemon(true);
		dt.start();
		//showMenu();
		/*Thread.sleep(5000);
		System.out.println("----------Finish--------------");
		*/
		java.util.Collection<DigitalVideoDisc> collection = new java.util.ArrayList<DigitalVideoDisc>(); 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc();
		dvd1.setTitle("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc();
		dvd2.setTitle("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		collection.add(dvd2);
		collection.add(dvd1);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc();
		dvd3.setTitle("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		collection.add(dvd3);
		java.util.Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			((DigitalVideoDisc)iterator.next()).play();	
		}		
		iterator = collection.iterator();

		System.out.println("--------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		java.util.Collections.sort((java.util.List<DigitalVideoDisc>)collection);
		iterator = collection.iterator();
		System.out.println("---------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}	
	}

}
