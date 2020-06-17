package memoryallocationproject;

import java.util.ArrayList;
import java.util.Scanner;


public class Hole 
{
    private int holeID;
    private Double holeSize;
    private Double startingAddress;
    private Double endingAddress;
    Process X;

       public static ArrayList<Process> Arrayofprocesses = new ArrayList();
    
    public Process getX() {
        return X;
    }

    public void setX(Process X) {
        this.X = X;
    }

    public Hole(int holeID, Double holeSize, Double startingAddress, Double endingAddress) 
    {
        this.holeID = holeID;
        this.holeSize = holeSize;
        this.startingAddress = startingAddress;
        this.endingAddress = holeSize + startingAddress;
    }
    
    public Hole(int holeID, Double holeSize, Double startingAddress) 
    {
        this.holeID = holeID;
        this.holeSize = holeSize;
        this.startingAddress = startingAddress;

    }
    
    
    public Hole() 
    {
        this.holeID = 0;
        this.holeSize = 0.0;
        this.startingAddress = 0.0;
        this.endingAddress = 0.0;
    }

    public int getHoleID() 
    {
        return holeID;
    }

    public void setHoleID(int holeID) 
    {
        this.holeID = holeID;
    }

    public Double getHoleSize() 
    {
        return holeSize;
    }

    public void setHoleSize(Double holeSize) 
    {
        this.holeSize = holeSize;
        endingAddress = holeSize + startingAddress;
    }

    public Double getStartingAddress() 
    {
        return startingAddress;
    }

    public void setStartingAddress(Double startingAddress) 
    {
        this.startingAddress = startingAddress;
        holeSize = endingAddress - startingAddress;
        
    }

    public Double getEndingAddress() 
    {
        return endingAddress;
    }

    public void setEndingAddress(Double endingAddress) 
    {
        this.endingAddress = endingAddress;
        holeSize = endingAddress - startingAddress;
    }
    
     public void addHole(ArrayList <Hole> holes, int n)
    {
        for(int i = 0; i < n; i++)
        {
        Scanner in = new Scanner(System.in);
          
        System.out.println("Enter ID of hole number: " + i);
        holeID = in.nextInt();
        
        System.out.println("Enter size of hole number: " + i);
        holeSize = in.nextDouble();
        
        System.out.println("Enter startingAddress of hole number: " + i);
        startingAddress = in.nextDouble();
        
        holes.add(new Hole(holeID, holeSize, startingAddress, endingAddress));
        }
    }
     
    public String toString() 
    {
        return ("Hole ID: " + this.holeID + " ,Hole size: " + this.holeSize + "\n  ,starting address: " + this.startingAddress
                 +",ending address: " + this.endingAddress + "\n \n");
    }
}