public class PCB {
    public int pid;
    public int AO;
    public long AT = System.currentTimeMillis();
    public int Priority;
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
    public int getAO() {
        return AO;
    }
    public int getPriority(){
        return Priority;
    }
    public long getAT(){
        return AT;
    }

    public String getState() {
        return state;
    }
    //To do: PCB data structure of a process
    //for example: Process_id, Arrive_time, state,
    //PositionOfNextInstructionToExecute(PC value)
    //and so on
}
