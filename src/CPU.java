package singleProcessor;




public class CPU extends Thread {
    private boolean BusyOrNot = false;
    public int PC; // Your CPU only has one register PC
    public int timeslice = -1;
    private int burstnumber;

    public CPU() {

        //timeslice = settimeslice; only needed for RR
        //BusyOrNot = false;
    }


    OS ss = new OS();

    Thread thread = new Thread();

    public void run() {

        System.out.println("CPU Thread Running");
        int burst = getBurstNumber();
        BusyOrNot = true;
        for(int i = 0; i < burst; i++)
        {
            BubbleSort();
        }

        BusyOrNot = false;

    }


    /**looks like we need a pair and process class
     * for this method
     public class Pair< PC, state> execute(Process P){


     }
     */



    public void BubbleSort(){
        int a[] = new int[100];
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
    public  void setBurstNumber(int burstnumber) {
        this.burstnumber = burstnumber;
    }
    public int getBurstNumber() {
        return burstnumber;
    }
    public int updateBurst(int timeslice) {
    	burstnumber = timeslice;
    	return burstnumber;
    }
    public void setTimeSlice(int ts){
        this.timeslice = ts;
    }
    public int getTimeSlice(){
        return timeslice;
    }
    
}

