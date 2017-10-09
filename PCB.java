
public class PCB {
    public int pid, AO, Priority;
    public long AT;
    public State state;
    public static int nextpid = 0;
    
    public enum State{
	New, Ready, Run, Wait, Terminate
    }
    public PCB(int pid, int AO, int Priority)
    {
        state = State.New;
        this.pid = ++PCB.nextpid;
        this.AT = System.currentTimeMillis();
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

	public State getState()
	{
		return state;
	}

	public void setState(PCB.State state) 
	{
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