
package memoryallocationproject;

import java.util.ArrayList;
import java.util.Scanner;



public class MemoryAllocationProject 
{
    private int hNum, pNum;
    private ArrayList<Hole> holes = new ArrayList<Hole>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private ArrayList<Hole> allocatedHoles = new ArrayList<Hole>();


       Hole x = new Hole();
    Process y = new Process();
    
    public int getHNum() 
    {
        return hNum;
    }

    public void setHNum(int hNum) 
    {
        this.hNum = hNum;
    }

    public int getPNum() 
    {
        return pNum;
    }

    public void setPNum(int pNum) 
    {
        this.pNum = pNum;
    }

    public ArrayList<Hole> getHoles() 
    {
        return holes;
    }

    public void setHoles(ArrayList<Hole> holes) 
    {
        this.holes = holes;
    }

    public ArrayList<Process> getProcesses() 
    {
        return processes;
    }

    public void setProcesses(ArrayList<Process> processes) 
    {
        this.processes = processes;
    }

    public ArrayList<Hole> getAllocatedHoles() {
        return allocatedHoles;
    }

    public void setAllocatedHoles(ArrayList<Hole> allocatedHoles) {
        this.allocatedHoles = allocatedHoles;
    }

    
    public void print( ArrayList<Process> enteredProcesses, Integer procNum)
    {
        System.out.println("\n Process No.\t Process Size\t Block no."); 
        for (int i = 0; i < procNum; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + enteredProcesses.get(i).getProcessSize() + "\t\t"); 
            
            if (allocatedHoles.get(i).getHoleID() != -1) 
            {
                System.out.print(allocatedHoles.get(i).getHoleID() + 1); 
            }
            else
            {
                System.out.print("Not Allocated"); 
            }
            System.out.println(); 
        } 
    }
    
    public void allocateHole(Integer pIndex, Integer hIndex, ArrayList<Process> entProcesses, ArrayList<Hole> allocHoles)       
    {
       Double allocatedHoleEndingAddress = 0.0;
       Double updatedEndingAddress = 0.0;
       Double updatedholeSize = 0.0;
       
       allocatedHoleEndingAddress = entProcesses.get(pIndex).getProcessSize() + allocHoles.get(hIndex).getStartingAddress();  
       allocatedHoles.add(pIndex, new Hole(hIndex ,entProcesses.get(pIndex).getProcessSize( ), allocHoles.get(hIndex).getStartingAddress() ,allocatedHoleEndingAddress));
                
       updatedholeSize = allocHoles.get(hIndex).getHoleSize() - entProcesses.get(pIndex).getProcessSize() ;
       updatedEndingAddress = updatedholeSize + allocHoles.get(hIndex).getStartingAddress();
                   
       allocHoles.get(hIndex).setHoleSize(updatedholeSize);
       allocHoles.get(hIndex).setEndingAddress(updatedEndingAddress);
    }
    
    
    
   public void FirstFit(Integer holesNum,Integer procNum, ArrayList<Hole> memoryHoles, ArrayList<Process> enteredProcesses)
   {
       
       for(int i = 0; i < processes.size(); i++)
       {
           y=processes.get(i);
           allocatedHoles.add(i, new Hole(-1, 0.0, 0.0, 0.0));
           for(int j=0; j<allocatedHoles.size();j++){
               x= allocatedHoles.get(j);
               if(y.getProcessSize()<=x.getHoleSize())
               {
                   x.setX(y);
                   processes.remove(i);
               }
           }
       }
       
    try {
        
       for(int i = 0; i < procNum; i++)
       {
           for(int j = 0; j < holesNum; j++)
           {
               
               if(memoryHoles.get(j).getHoleSize() >= enteredProcesses.get(i).getProcessSize())
               {
                   allocateHole(i, j, enteredProcesses, memoryHoles);
                   break;
               }
           }
       }
       } 
    catch(ArrayIndexOutOfBoundsException e)
        { 
        System.out.println("That index doesn't exist"); 
        }
        
//    print(enteredProcesses, procNum);
     System.out.println("\n Process No.\t Process Size\t Block no."); 
        for (int i = 0; i < enteredProcesses.size(); i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + enteredProcesses.get(i).getProcessSize() + "\t\t"); 
            
            if (allocatedHoles.get(i).getHoleID() != -1) 
            {
                System.out.print(allocatedHoles.get(i).getHoleID() + 1); 
            }
            else
            {
                System.out.print("Not Allocated"); 
            }
            System.out.println(); 
    }
   }
   
   
   public void BestFit(Integer holesNum,Integer procNum, ArrayList<Hole> memoryHoles, ArrayList<Process> enteredProcesses)
   {

        for(int i = 0; i < processes.size(); i++)
       {
           y=processes.get(i);
           allocatedHoles.add(i, new Hole(-1, 0.0, 0.0, 0.0));
           for(int j=0; j<allocatedHoles.size();j++)
           {
               x = allocatedHoles.get(j);
               if(y.getProcessSize()<=x.getHoleSize())
               {
                   x.setX(y);
                   processes.remove(i);
               }
           }
           
           
           
       }
        
    try {
        
       for(int i = 0; i < procNum; i++)
       {
           int best = -1; 
           
           for(int j = 0; j < holesNum; j++)
           {
               if(memoryHoles.get(j).getHoleSize() >= enteredProcesses.get(i).getProcessSize())
               {
                   if (best == -1) 
                   {
                       best = j;
                   } 
                   else if (memoryHoles.get(best).getHoleSize() > memoryHoles.get(j).getHoleSize())
                   {
                       best = j;
                   }                   
               }
            }
               
            if (best != -1) 
            { 
                allocateHole(i, best, enteredProcesses, memoryHoles);
            } 
       }
    } 
    catch(ArrayIndexOutOfBoundsException e)
        { 
        System.out.println("That index doesn't exist"); 
        }
    
    print(enteredProcesses, procNum);
   }
   
   public void WorstFit(Integer holesNum,Integer procNum, ArrayList<Hole> memoryHoles, ArrayList<Process> enteredProcesses)
   {
       
       Double allocatedHoleEndingAddress = 0.0;
       Double updatedEndingAddress = 0.0;
       Double updatedholeSize = 0.0;
       
        for(int i = 0; i < processes.size(); i++)
       {
           y=processes.get(i);
           allocatedHoles.add(i, new Hole(-1, 0.0, 0.0, 0.0));
           for(int j=0; j<allocatedHoles.size();j++)
           {
               x = allocatedHoles.get(j);
               if(y.getProcessSize()<=x.getHoleSize())
               {
                   x.setX(y);
                   processes.remove(i);
               }
           }
       }
        
    try {
        
       for(int i = 0; i < procNum; i++)
       {
           int worst = -1; 
           
           for(int j = 0; j < holesNum; j++)
           {
               if(memoryHoles.get(j).getHoleSize() >= enteredProcesses.get(i).getProcessSize())
               {
                   if (worst == -1) 
                   {
                       worst = j;
                   } 
                   else if (memoryHoles.get(worst).getHoleSize() < memoryHoles.get(j).getHoleSize())
                   {
                       worst = j;
                   }                   
               }
            }
           
           if(worst != -1)
           {
                allocatedHoleEndingAddress = enteredProcesses.get(i).getProcessSize() + memoryHoles.get(worst).getStartingAddress();  
                allocatedHoles.add(i, new Hole(worst,enteredProcesses.get(i).getProcessSize( ), memoryHoles.get(worst).getStartingAddress() ,allocatedHoleEndingAddress));
                
                updatedholeSize = memoryHoles.get(worst).getHoleSize() - enteredProcesses.get(i).getProcessSize() ;
                updatedEndingAddress = updatedholeSize + memoryHoles.get(worst).getStartingAddress();
                   
                memoryHoles.get(worst).setHoleSize(updatedholeSize);
                memoryHoles.get(worst).setEndingAddress(updatedEndingAddress);
           }
       }
    }
    catch(ArrayIndexOutOfBoundsException e)
        { 
        System.out.println("That index doesn't exist"); 
        }
    
//       print(enteredProcesses, procNum);
    
         System.out.println("\n Process No.\t Process Size\t Block no."); 
        for (int i = 0; i < procNum; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + enteredProcesses.get(i).getProcessSize() + "\t\t"); 
            
            if (allocatedHoles.get(i).getHoleID() != -1) 
            {
                System.out.print(allocatedHoles.get(i).getHoleID() + 1); 
            }
            else
            {
                System.out.print("Not Allocated"); 
            }
            System.out.println(); 
        } 
       
   }
   
    public static void main(String[] args) 
    {  
        MemoryAllocationProject  m = new MemoryAllocationProject ();
        Scanner in = new Scanner(System.in); 
        Process p = new Process();
        Hole h = new Hole();
        
////        m.hNum = 5;
////        m.holes.add(0, new Hole(0, 100.0, 0.0    ,99.0));
////        m.holes.add(1, new Hole(1, 500.0, 150.0  ,649.0));
////        m.holes.add(2, new Hole(2, 200.0, 700.0  ,899.0));
////        m.holes.add(3, new Hole(3, 300.0, 900.0  ,1199.0));
////        m.holes.add(4, new Hole(4, 600.0, 1400.0 ,1999.0));
////        
////        m.pNum = 4;
////        m.processes.add(0, new Process(0, 212.0));
////        m.processes.add(1, new Process(1, 417.0));
////        m.processes.add(2, new Process(2, 112.0));
////        m.processes.add(3, new Process(3, 426.0));
        
        
        
        System.out.println("Enter number of holes: ");
        m.setHNum(in.nextInt());
        h.addHole(m.holes,m.getHNum());
//        System.out.println(m.holes);
   
        
        System.out.println("Enter number of processes: ");
        m.setPNum(in.nextInt()); 
        p.addProcess(m.processes,m.getPNum());
//        System.out.println(m.processes);
       
        
//        m.FirstFit(m.getHNum(), m.getPNum(), m.getHoles(), m.getProcesses());
//        m.BestFit(m.getHNum(), m.getPNum(), m.getHoles(), m.getProcesses());
//        m.WorstFit(m.getHNum(), m.getPNum(), m.getHoles(), m.getProcesses());
        
        
        
        System.out.println("for First Fit type 1");
        System.out.println("for Best Fit type 2");
        System.out.println("for Worst Fit type 3");
        
        Scanner Sc = new Scanner(System.in);
        int NN;
        NN = Sc.nextInt();
        
        if(NN ==1)
        {
         m.FirstFit(m.holes.size(), m.processes.size(), m.holes, m.processes);
        }
        if(NN ==2)
        {
         m.BestFit(m.holes.size(),m.processes.size(), m.holes, m.processes);
        }
        if (NN ==3)
        {
         m.WorstFit(m.holes.size(),m.processes.size(), m.holes, m.processes);
        }
    
   
   
   
//   new GUILayer().setVisible(true);
        
   
        }
    }   


