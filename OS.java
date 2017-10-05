import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OS {
	private String processid; //int
	private String arrivaltime; //int arrival order
	private String priority;
	private String code;

	// public CPU cpu;
	// public IOdevice io;
	// public boolean isCPUAvailable;
	// public ProcessTable process_Table;
	ArrayList<PCB> New_Q = new ArrayList<PCB>();
	ArrayList<PCB> R_Q = new ArrayList<PCB>();
	ArrayList<PCB> W_Q = new ArrayList<PCB>();
	ArrayList<PCB> T_Q = new ArrayList<PCB>();
	
	public void Read() throws IOException {
		BufferedReader in = null;
		String[] splited = null;
	
		int processCount = 0;
		
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			String read = null;
			while ((read = in.readLine()) != null) {
				splited = read.split("\\s+"); //1 -> 4 = each process
				
				String test1 = splited[0];
				setProcessID(test1);
				String test2 = splited[1];
				setArrivalTime(test2);
				String test3 = splited[2];
				setPriority(test3);
				//PCB makes processimage obj for code
				
				ProcessImage M = new ProcessImage(test1, test2, test3); //change to PCB
				
				New_Q.add(M);

				String test4 = splited[3];
				setCode(test4);
				long arrivalTime = System.currentTimeMillis();
				System.out.println(test1 + " " + test2 + " " + test3 + " " + test4);
				break;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
