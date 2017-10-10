
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Add changed variables to fit pcb object
import java.util.Collections;
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
	static ArrayList<Integer> Priority = new ArrayList<Integer>();

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
			if (a == 4) {
				System.out.println("Terminating Simulator...");
				System.exit(4);
			}
			int processCount = 0;
			read(); // read all and put into N_Q(N_Q HAS ALL PROCESSES)
			if (a == 3) { // PRIORITY

				for (int i = 0; i < N_Q.size(); i++) {
					ProcessImage moveImage = N_Q.get(i);
					int m = moveImage.getPriority();
					Priority.add(m);

				}

				System.out.println(Priority.toString());

				while (processCount < N_Q.size()) {

					int minIndex = Priority.indexOf(Collections.min(Priority));
					System.out.println(Priority.toString());

					System.out.println("Min" + minIndex);

					R_Q.add(N_Q.get(minIndex)); // Start with Ready Queue Add

					ProcessImage pImage = N_Q.get(minIndex); // start with RQ
					Priority.set(minIndex, 10000);

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

			}

			if (a == 1) {
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
			}
			if (a == 2)
			{
				ArrayList<Integer> timeSlices = new ArrayList<Integer>();
				int quantum = 2;
				
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
					
					timeSlices = codeList;
					int sizechecker = codeList.size();
					
					
					while(sizechecker > 0) {
					for (int i = 0; i < codeList.size();) {
						
						
						
						
						int currentBurst = codeList.get(i);
						int remainingBurst = currentBurst - quantum;
					
						CPU s = new CPU();
						IODevice k = new IODevice();

						if (s.cpuIsBusy() == false) {
			//				System.out.println(currentBurst + " " +  quantum + "CPU remainder" + remainingBurst);
							
							if (remainingBurst <= 0)
							{
								s.setBurstNumber(quantum);
								s.run();
							}
							
							
							if (remainingBurst > 0)
							 {
						timeSlices.set(i, remainingBurst);
						
					}
					else {
						timeSlices.set(i, 0);
						sizechecker = sizechecker - 1;
					}
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
						int remainingBurst2 = currentBurst - quantum;
						System.out.println("IO remainder" + remainingBurst2);
						if (s.cpuIsBusy() == false && k.IOIsBusy() == false) {
							B.setState(PCB.State.Wait);
							// W_Q.add(N_Q.get(processCount));
							if (!R_Q.isEmpty()) {
								W_Q.add(N_Q.get(processCount));
								

								R_Q.remove(0);

							}
							if (remainingBurst2 <= 0)
							{
								k.setBurstNumber(quantum);
								k.run();
							}
					

							
							if (remainingBurst2 > 0)
							 {
						timeSlices.set(i, remainingBurst2);
						
					}
					else {
						timeSlices.set(i, 0);
						sizechecker = sizechecker - 1;
						
					}
							
							
							
							System.out.println("done with burst: " + currentBurst);

							i++;

						}

					}

					// ----PROCESS END----
			

				}
					
					
					long responseTime = responseTimeEnd - responseTimeStart;
					long endTime = System.currentTimeMillis();
					long latency = endTime - processArivalTime;
					System.out.println(timeSlices.toString());
					System.out.println("Process " + pImage.getpId() + " Latency:" + latency);
					System.out.println("Process " + pImage.getpId() + " Response Time:" + responseTime);

					B.setState(PCB.State.Terminate);
					T_Q.add(pImage);
					
					processCount++;
			}
			}

			// add FCFS algorithm

			// add SP algorithm

		} catch (InputMismatchException e) {
			System.err.println("Invalid Entry!");
		}
	}
}
