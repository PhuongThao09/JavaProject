package hust.soict.ictglobal.aims.media;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;


public class BookTest {

		public static void main(String[] args) {
			Book book = new Book("Trên đường băng");
			book.setId("20165557");
			book.addAuthor("Thảo");
			book.setCategory("cuộc sống đời thường");
			book.setCost(9999);
			
			book.setContent("Lý tưởng sống của bạn là gì?");
			book.processContent();
			System.out.println(book.toString());
		}

	}

