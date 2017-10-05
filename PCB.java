/**
 * Created by Cam1221 on 10/2/2017.
 */
public class PCB {
    public int pid; //process ID
    public int AO; //arrivalOrder
    public long AT = System.currentTimeMillis(); //arrival time
    public int Priority; 
    public String state = ""; 
    public static int nextpid = 0; //location of next process to execute

    public PCB(int pid, int AO, int AT, int Priority, String state)
    {
        this.state = state;
        this.pid = ++PCB.nextpid;
        this.AT = AT;
        this.AO = AO;
        this.Priority = Priority;

    }

    public String showPCB()
    {
        return "P_ID: " + this.getPid() + "\nState: " + this.getState() + "\nArrival Time: " + 
            this.getAT() + "\nArrival Order: " + this.getAO() + "\nPriority: " + this.getPriority() +"\n";

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
