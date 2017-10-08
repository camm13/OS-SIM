package singleProcessor;

public class CPU extends Thread {
	private boolean BusyOrNot;
	public int PC; // Your CPU only has one register PC
	public int timeslice;

	public CPU(int settimeslice) {
		timeslice = settimeslice;
		BusyOrNot = false;
	}

	OS ss = new OS();

	Thread thread = new Thread();

	public void run() {

		System.out.println("Thread Running");
	}
	
	
	/**looks like we need a pair and process class
	 * for this method
	public class Pair< PC, state> execute(Process P){ 
		
		
	}
	*/
	
	
	
	public void BubbleSort(){
        int a[] = new int[100000];
        int temp = 0;
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 1; j <(a.length-1); j++)
            {
                if (a[j] > a[j-1]){
                    temp = a[j];
                    a[j]= a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
	
	public boolean cpuIsBusy() {
		return BusyOrNot;
	}
}
