
package memoryallocationproject;

import java.util.*;
import java.awt.*;
import javax.print.event.PrintJobEvent;
import javax.swing.*;

public class NewGUI extends JFrame
{
    
    private Process p = new Process();
    private Hole h = new Hole();
    private ArrayList<Hole> holes = new ArrayList<Hole>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private MemoryAllocationProject m = new MemoryAllocationProject();
    
    
    public NewGUI()
    {
        setSize(600, 600);
        setTitle("Memory Allocation Program");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null); 

        
        
   ///* Holes panel *///     
    JPanel hpanel = new JPanel(); 
    Object[] hOptions = { "Cancel" };
    
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
    Object[] poptions = {"Cancel"};
    
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
    
    Integer procNum = Integer.valueOf(JOptionPane.showInputDialog(cp,"Enter Number of Processes: "));

    JOptionPane.showOptionDialog(null, hpanel, "Add new process", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, hOptions, null);
    processes.add(new Process(Integer.valueOf(IDField.getText()), Double.valueOf(sizeField.getText())));

    while(JOptionPane.showConfirmDialog(cp, "Enter another process?","", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  
    {
        try
        {
            JOptionPane.showOptionDialog(null, hpanel, "Add new process", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, hOptions, null);
            processes.add(new Process(Integer.valueOf(IDField.getText()), Double.valueOf(sizeField.getText())));  
        }
        catch(Exception e)
        {
            JOptionPane.showInputDialog("Entered value is invalid");
        } 
    }
    
    
    
   
    
}
}
