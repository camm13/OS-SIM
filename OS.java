import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OS {
	private String processid;
	private String arrivaltime;
	private String priority;
	private String code;

	// public CPU cpu;
	// public IOdevice io;
	// public boolean isCPUAvailable;
	// public ProcessTable process_Table;
	ArrayList<Process> New_Q = new ArrayList<Process>();
	ArrayList<Process> R_Q = new ArrayList<Process>();
	ArrayList<Process> W_Q = new ArrayList<Process>();
	ArrayList<Process> T_Q = new ArrayList<Process>();
	
	// public ArrayList<Process> New_Queue;
	// public ArrayList<Process> Ready_Queue;
	// public ArrayList<Process> Wait_Queue;
	// public ArrayList<Process> Terminated_Queue;
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

	public void setProcessID(String processid) {
		this.processid = processid;

	}

	public String getProcessID() {
		return processid;
	}

	public void setArrivalTime(String arrivaltime) {
		this.arrivaltime = arrivaltime;

	}

	public String getArrivalTime() {
		return arrivaltime;
	}

	public void setPriority(String priority) {
		this.priority = priority;

	}

	public String getPriority() {
		return priority;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
