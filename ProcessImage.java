package singleProcessor;
public class ProcessImage {
	private PCB pcb_data;
	private int[] code;
	private int id,ao,priority;
	public ProcessImage(String process) {
		
		String[] data = process.split("\\s+"); //"\\s+" is what jared had so i think it checks by spaces.
		long at = System.currentTimeMillis(); 
		id = Integer.parseInt(data[0]);
		ao = Integer.parseInt(data[1]);
		priority = Integer.parseInt(data[2]);
		
		//Cpu/io burst sequence
		char[] bs = data[3].toCharArray();
		code = new int[bs.length];
		for(int i = 0; i< code.length; i++) {
			code[i] = Character.getNumericValue(bs[i]);
		}
		this.pcb_data = new PCB(id,ao,priority);
        
        //I thought i saw you added state in PCB so thats why  i did not add here.
		
		
			
	}
	public PCB getPcb_data() {
		return pcb_data;
	}
	public int getPriority() {
		return priority;
	}

}
