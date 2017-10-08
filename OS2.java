package singleProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OS {
    public CPU cpu;
    public IOdevice io;
    public boolean isCPUAvailable;
    ArrayList<ProcessImage> N_Q = new ArrayList<ProcessImage>(); // these should be PCB(she said they were pcb in class)
    ArrayList<ProcessImage> R_Q = new ArrayList<ProcessImage>();
    ArrayList<ProcessImage> W_Q = new ArrayList<ProcessImage>();
    ArrayList<ProcessImage> T_Q = new ArrayList<ProcessImage>();

    public void main(String[] args) throws IOException {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("input.txt"));
            String read = null;
            while ((read = in.readLine()) != null) {
                ProcessImage p = new ProcessImage(read);
                N_Q.add(p);
                R_Q = N_Q;

                break;

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
                
                
                //add FCFS algorithm
            } else if (a == 2) {
                //add RR algorithm
            } else if (a == 3) {
                //add SP algorithm
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
*  Didn't wanna overwrite the OS file we have now if you didnt agree with the changes I made.
*/
