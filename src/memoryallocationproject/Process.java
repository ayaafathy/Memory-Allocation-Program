package memoryallocationproject;

import java.util.ArrayList;
import java.util.Scanner;


public class Process 
{
    private int processID;
    private Double processSize;

    
    public Process(int processID, Double processSize) 
    {
        this.processID = processID;
        this.processSize = processSize;
    }
    
    public Process() 
    {    
        this.processID = 0;
        this.processSize = 0.0;
    }


    public int getProcessID() 
    {
        return processID;
    }

    public void setProcessID(int processID) 
    {
        this.processID = processID;
    }

    public Double getProcessSize() 
    {
        return processSize;
    }

    public void setProcessSize(Double processSize) 
    {
        this.processSize = processSize;
    }

    
    
    public void addProcess(ArrayList<Process> processes, int n)
    {
        for(int i = 0; i < n; i++)
        {
        Scanner in = new Scanner(System.in);
          
        System.out.println("Enter ID of process number: " + i);
        processID = in.nextInt();
        
        System.out.println("Enter size of process number: " + i);
        processSize = in.nextDouble();
        
        processes.add(new Process(processID, processSize));

        }
    }
    
    public String toString() 
    {
        return ("Process ID: " + this.processID + " ,Process size: " + this.processSize + "\n");
    }
     

}