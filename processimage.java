package osProject;

public class processimage {
	private PCB pcb_data;
	private String code;
	private int id,ao,priority;
	
	public processimage(String process) {
		
		String[] data = process.split("\\s+");
		id = Integer.parseInt(data[0]);
		ao = Integer.parseInt(data[1]);
		priority = Integer.parseInt(data[2]);
		
		//need code to take in burst code
		
		
	
		
	
		
	}

}
