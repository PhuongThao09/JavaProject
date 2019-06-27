package hust.soict.ictglobal.aims.Aims;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.ictglobal.aims.order.Order.Order;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		int a=5;
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
			System.out.println("nhập sai xin m�?i nhập lại");
			//a =(Integer) input.nextInt();
			
		}
		
		
		input.close();
		JOptionPane.showMessageDialog(null, "Tesst 1");	
		
		
		//System.out.println(a);
		/*switch (a) {
		case 0:
			System.out.println("Good bye !");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Tesst 1");
			break;
		case 2:
			System.out.println(a);
			JOptionPane.showMessageDialog(null, "Tesst 2");
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;
		}*/
	
	}
}
