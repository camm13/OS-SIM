package singleProcessor;

//Going to be very similar to CPU
public class IODevice extends Thread {
    private boolean BusyOrNot = false;
    public int PC; // Your CPU only has one register PC
    public int timeslice;
    private int burstnumber;

    public IODevice() {
        BusyOrNot = false;
        //timeslice = settimeslice; only needed for RR
        //BusyOrNot = false;
    }



    Thread thread = new Thread();

    public void run() {

        System.out.println("IO Thread Running");
        int burst = getBurstNumber();
        BusyOrNot = true;
        for(int i = 0; i < burst; i++)
        {
            BubbleSort();
        }

        BusyOrNot = false;

    }





    public void BubbleSort(){
        int a[] = new int[100]; //add a few 0's for a more realistic time result
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




    public boolean IOIsBusy() {
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

}
