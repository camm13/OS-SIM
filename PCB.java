public class PCB {
    public int pid, AO, Priority;
    public long AT = System.currentTimeMillis();
    public String state = "";
    public static int nextpid = 0;

    public PCB(int pid, int AO, int Priority, long AT, String state)
    {
        this.state = state;
        this.pid = ++PCB.nextpid;
        this.AT = AT;
        this.AO = AO;
        this.Priority = Priority;

    }

    public String showPCB()
    {
        return "P_ID: " + this.getPid() + "\nState: " + this.getState() + "\nArrival Time: " + this.getAT() + "\nArrival Order: " + this.getAO() + "\nPriority: " + this.getPriority() +"\n";

    }

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getAO() {
		return AO;
	}

	public void setAO(int aO) {
		AO = aO;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public long getAT() {
		return AT;
	}

	public void setAT(long aT) {
		AT = aT;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static int getNextpid() {
		return nextpid;
	}

	public static void setNextpid(int nextpid) {
		PCB.nextpid = nextpid;
	}

    //To do: PCB data structure of a process
    //for example: Process_id, Arrive_time, state,
    //PositionOfNextInstructionToExecute(PC value)
    //and so on
}
