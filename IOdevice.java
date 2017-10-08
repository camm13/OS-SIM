package singleProcessor;

//Going to be very similar to CPU
public class IOdevice extends Thread {
	private boolean BusyOrNot;
	
	public IOdevice() {
		BusyOrNot = false;
	}
	
	public boolean IOIsBusy() {
		return BusyOrNot;
	}

}
