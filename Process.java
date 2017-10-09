/**
 * Created by Cam1221 on 10/9/2017.
 */
public class Process implements Comparable{
    int pid;
    int Priority;
    ProcessImage p;
    public Process(String process) {
        this.pid = this.p.getPCB().getPid();
        this.Priority = this.p.getPCB().getPriority();

    }

    public int compareTo(Object obj) {
            if (this.Priority < ((Process) obj).Priority)
                return -1;
            else if (this.Priority > ((Process) obj).Priority)
                return 1;
            else
                return 0;
    }
}
