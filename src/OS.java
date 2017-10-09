
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Add changed variables to fit pcb object

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OS {
	public CPU cpu;
	public IODevice io;
	public boolean isCPUAvailable;
	static ArrayList<ProcessImage> N_Q = new ArrayList<ProcessImage>();
	static ArrayList<ProcessImage> R_Q = new ArrayList<ProcessImage>();
	static ArrayList<ProcessImage> W_Q = new ArrayList<ProcessImage>();
	static ArrayList<ProcessImage> T_Q = new ArrayList<ProcessImage>();

	public static void read() throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String read = null;
			while ((read = in.readLine()) != null) {
				ProcessImage p = new ProcessImage(read);
				N_Q.add(p);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = null;

		System.out.println("Welcome to our OS-Simulator");
		System.out.print("Select a scheduling algorithm or exit the simulator");
		Scanner scan = new Scanner(System.in);
		System.out.println("1: FCFS (First Come First Serve) ");
		System.out.println("2: RR (Round Robin) ");
		System.out.println("3: SP (Static Priority) ");
		System.out.println("4: Exit");

		try {
			int a = scan.nextInt();
			if (a == 1) {
				int processCount = 0;
				read(); // read all and put into N_Q(N_Q HAS ALL PROCESSES)

				// --------
				// Priority algorithm - here you can collection.sort by priority
				// -------

				while (processCount < N_Q.size()) {

					// W_Q = N_Q; // not sure if this is how wait queue is supposed to be used?

					R_Q.add(N_Q.get(processCount)); // Start with Ready Queue Add

					ProcessImage pImage = N_Q.get(processCount); // start with RQ
					PCB B = pImage.getPcb_data(); // PCB obj for getting states,(not sure how to do this)
					B.setState(PCB.State.Run);
					if (!W_Q.isEmpty()) {
						W_Q.remove(0);
					}
					B.setState(PCB.State.Ready);
					R_Q.add(pImage);

					long processArivalTime = System.currentTimeMillis();
					long responseTimeStart = System.currentTimeMillis();
					long responseTimeEnd = 0;

					ArrayList<Integer> codeList = pImage.returnCode();

					for (int i = 0; i < codeList.size();) {
						int currentBurst = codeList.get(i);

						CPU s = new CPU();
						IODevice k = new IODevice();

						if (s.cpuIsBusy() == false) {

							s.setBurstNumber(currentBurst);
							s.run();
							if (i == 0) {
								responseTimeEnd = System.currentTimeMillis();

							}

							System.out.println("done with burst: " + currentBurst);
							i++;

						}
						if (i >= codeList.size()) {
							break;
						}

						currentBurst = codeList.get(i);
						if (s.cpuIsBusy() == false && k.IOIsBusy() == false) {
							B.setState(PCB.State.Wait);
							// W_Q.add(N_Q.get(processCount));
							if (!R_Q.isEmpty()) {
								W_Q.add(N_Q.get(processCount));

								R_Q.remove(0);

							}

							k.setBurstNumber(currentBurst);
							k.run();

							System.out.println("done with burst: " + currentBurst);

							i++;

						}

					}

					// ----PROCESS END----
					long responseTime = responseTimeEnd - responseTimeStart;
					long endTime = System.currentTimeMillis();
					long latency = endTime - processArivalTime;
					System.out.println("Process " + pImage.getpId() + " Latency:" + latency);
					System.out.println("Process " + pImage.getpId() + " Response Time:" + responseTime);

					B.setState(PCB.State.Terminate);
					T_Q.add(pImage);
					processCount++;

				}

				// add FCFS algorithm
			} else if (a == 2) {
				// add RR algorithm
			} else if (a == 3) {
				// add SP algorithm
			} else if (a == 4) {
				System.out.println("Terminating Simulator...");
				System.exit(4);
			}
		} catch (InputMismatchException e) {
			System.err.println("Invalid Entry!");
		}
	}
}
/**
 * Didn't wanna overwrite the OS file we have now if you didnt agree with the
 * changes I made.
 */
