import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Add changed variables to fit pcb object

public class OS {
	
	private int processId;
	private Long arrivalTime;
	public int arrivalOrder;
	private int priority;
	private String code;

	// public CPU cpu;
	// public IOdevice io;
	// public boolean isCPUAvailable;
	// public ProcessTable process_Table;
	ArrayList<Process> New_Q = new ArrayList<Process>();
	ArrayList<Process> R_Q = new ArrayList<Process>(); //ready queue
	ArrayList<Process> W_Q = new ArrayList<Process>(); //waiting queue
	ArrayList<Process> T_Q = new ArrayList<Process>(); //terminated queue
	
	PCB test = null;
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
				processId = Integer.parseInt(test1);
	
				String test2 = splited[1];
				arrivalOrder = Integer.parseInt(test2);
				
				String test3 = splited[2];
				priority = Integer.parseInt(test3);

				String test4 = splited[3];
				code = test4;
				arrivalTime = System.currentTimeMillis();
				PCB test = new PCB(processId, arrivalOrder, arrivalTime, priority, "");
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
