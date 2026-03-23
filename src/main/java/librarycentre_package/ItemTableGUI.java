/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author b.villarini
 */
public class ItemTableGUI extends JFrame {
    
    JTable myTable;
    ItemTableModel tableModel;
    ArrayList<Item> itemList;
    JButton button1;
    
    // contructor
    public ItemTableGUI(ArrayList<Item> itemList){
        
        //set the title
        this.setTitle("Items in Westminster Library");
        
        // initialise and instantiate the instance variable 
        this.itemList = itemList;
        tableModel = new ItemTableModel(itemList);
        myTable =  new JTable(tableModel);
        
        // set the size of the frame 
        setBounds(20,20,800,600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        // sorting
        myTable.setAutoCreateRowSorter(true);
      
        // add the table to the panle
        JScrollPane scrollPane = new JScrollPane(myTable); 
        scrollPane.setPreferredSize(new Dimension(380,280)); 

        // add a button on the bottom
        button1 = new JButton("Info");

        MyButtonListener listener = new MyButtonListener();
        button1.addActionListener(listener);

        
        // add the panel to the frame
        add(scrollPane,BorderLayout.CENTER); 
        add(button1, BorderLayout.SOUTH);
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            button1.setText("Button clicked!");
        }
    }
  
        
    
}
