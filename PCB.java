/**
 * Created by Cam1221 on 10/2/2017.
 */
public class PCB {
    public int pid;
    public int AO;
    public int Priority;
    public String state;
    public static int nextpid = 0;

    public PCB(int pid, int AO, int Priority, double BS )
    {
        this.state = "New";
        this.pid = ++PCB.nextpid;
        this.AO = AO;
        this.Priority = Priority;

    }

    public String showPCB()
    {
        return "P_ID: " + this.getPid() + "\nState: " + this.getState() + 
            "\nArrival Order: " + this.getAO() + 
            "\nPriority: " + this.getPriority() +"\n";

    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public int getAO() {
        return AO;
    }
    public void setAO(int AO){
        this.AO = AO;
    }
    public int getPriority(){
        return Priority;
    }
    public void setPriority(int Priority)
    {
        this.Priority = Priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //To do: PCB data structure of a process
    //for example: Process_id, Arrive_time, state,
    //PositionOfNextInstructionToExecute(PC value)
    //and so on
}
