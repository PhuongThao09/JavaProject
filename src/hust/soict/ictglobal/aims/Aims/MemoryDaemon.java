package hust.soict.ictglobal.aims.Aims;

public class MemoryDaemon implements Runnable {
	
	long memoryUsed ;
	
	
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		while(true) {
			used = rt.totalMemory() - rt.freeMemory();
			if ( used != memoryUsed) {
				System.out.println("\t Memory used =  " +used );
				memoryUsed = used;
			}
		}
		
	}
	public MemoryDaemon() {
		// TODO Auto-generated constructor stub
	}

}
