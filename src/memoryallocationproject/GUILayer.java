
package memoryallocationproject;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GUILayer extends JFrame
{
    private Process p = new Process();
    private Hole h = new Hole();
    private ArrayList<Hole> holes = new ArrayList<Hole>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private MemoryAllocationProject m = new MemoryAllocationProject();


    public GUILayer()
    {
        setSize(600, 600);
        setTitle("Memory Allocation Program");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null); 

        
        
   ///* Holes panel *///     
    JPanel hpanel = new JPanel(); 
    Object[] hOptions = { "Add new hole", "Next" , "Cancel" };
    
    hpanel.add(new JLabel("ID:"));
    
    JTextField hIDField = new JTextField(7);
    hpanel.add(hIDField);
    
    hpanel.add(new JLabel("Size:"));
    
    JTextField hSizeField = new JTextField(7);
    hpanel.add(hSizeField);
    
    hpanel.add(new JLabel("Starting Address:"));
    
    JTextField hStAddField = new JTextField(7);
    hpanel.add(hStAddField);
    
    
    ///* Processes Panel *///      
    JPanel ppanel = new JPanel(); 
    Object[] poptions = { "Add new process", "Next" , "Cancel"};
    
    ppanel.add(new JLabel("ID:"));
    
    JTextField IDField = new JTextField(7);
    ppanel.add(IDField);
    
    ppanel.add(new JLabel("Size:"));
    
    JTextField sizeField = new JTextField(7);
    ppanel.add(sizeField);
        
    
    
///* Choosing allocation method panel *///
    JPanel apanel = new JPanel(); 
    Object[] OOptions = { "First Fit", "Best Fit" , "Worst Fit"};
    
    
    
///* Using Panels *///
    
    Integer holesNum = Integer.valueOf(JOptionPane.showInputDialog(cp,"Enter Number of Holes: "));
    

    int result1 = JOptionPane.showOptionDialog(null, hpanel, "Add new hole", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, hOptions, null);
    
     holes.add(new Hole(Integer.valueOf(IDField.getText()), Double.valueOf(hSizeField.getText()), Double.valueOf(hStAddField.getText())));
    
    
    while (result1 == JOptionPane.YES_OPTION)
        {
            JOptionPane.showOptionDialog(null, hpanel, "Add new hole", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, hOptions, null);
            
            holes.add(new Hole(Integer.valueOf(IDField.getText()), Double.valueOf(hSizeField.getText()), Double.valueOf(hStAddField.getText())));
        }
    
    if (result1 == JOptionPane.NO_OPTION)
        {
            Integer procNum = Integer.valueOf(JOptionPane.showInputDialog(cp,"Enter Number of processes: "));  
                
            int result2 = JOptionPane.showOptionDialog(null, ppanel, "Add new process", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, poptions, null);
            
            processes.add(new Process(Integer.valueOf(IDField.getText()), Double.valueOf(sizeField.getText())));  
    
            while (result2 == JOptionPane.YES_OPTION)
            {
                JOptionPane.showOptionDialog(null, ppanel, "Add new process", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                 null, poptions, null);
                
                processes.add(new Process(Integer.valueOf(IDField.getText()), Double.valueOf(sizeField.getText())));  
            }
            ////CHOOSE ALLOCATION METHOD
            if (result2 == JOptionPane.NO_OPTION)
            {
                int a = JOptionPane.showOptionDialog(null, "Choose allocation method", "Allocation",
                                                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, OOptions, null);
                
                if(a == 0)
                {
                    m.FirstFit(holesNum, procNum, holes, processes);
                }
                else if(a == 1)
                {
                    m.BestFit(holesNum, procNum, holes, processes);
                }
                else if(a == 2)
                {
                    m.WorstFit(holesNum, procNum, holes, processes);
                }
            }
            
            if (result2 == JOptionPane.CANCEL_OPTION)
            {
               System.exit(0);
            }
        } 
    if (result1 == JOptionPane.CANCEL_OPTION )
    {
        System.exit(0);
    }
        
    }
}