
/**
 * Graphical User Interface
 *
 * @author Vance Field
 * @version 26-Apr-2016
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ListGUI {
    
    // frame
    private JFrame frame;
    private final int FRAME_WIDTH = 550;
    private final int FRAME_HEIGHT = 300;
    // panels
    private JPanel mainPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    // buttons
    private JButton[] b = new JButton[12];
    // textfields
    private JTextField[] t = new JTextField[5];
    // textarea
    private JTextArea textArea;
    private JScrollPane pane;
    // AddressList obj
    private AddressList list;
    
    /**
     * Constructor initializes components
     */
    public ListGUI(){
        
        // initializing components
        list = new AddressList();
        
        for(int i = 0; i < t.length; i++)
            t[i] = new JTextField();
        
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400,100));
        textArea.setEditable(false);
        pane = new JScrollPane(textArea);
        
        // addToFront button
        b[0] = new JButton("addToFront");
        b[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                list.addToFront(t[0].getText(),t[1].getText(),t[2].getText(),
                        t[3].getText(),t[4].getText());
            }
        });
        // addToBack button
        b[1] = new JButton("addToBack");
        b[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                list.addToBack(t[0].getText(),t[1].getText(),t[2].getText(),
                        t[3].getText(),t[4].getText());
            }
        });
        // toString button
        b[2] = new JButton("toString");
        b[2].addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               textArea.setText(list.toString());
           } 
        });
        // reverseToString button
        b[3] = new JButton("reverseToString");
        b[3].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               textArea.setText(list.reverseToString());
           } 
        });
        // reverse button
        b[4] = new JButton("reverse");
        b[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                list = list.reverse();
            }
        });
        // isEmpty button
        b[5] = new JButton("isEmpty");
        b[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setText(""+list.isEmpty());
            }
        });
        // sizeOf button
        b[6] = new JButton("sizeOf");
        b[6].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setText("Size is: " + list.sizeOf());
            }
        });
        // phoneNumberByName button
        b[7] = new JButton("phoneNumberByName");
        b[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String s = JOptionPane.showInputDialog(null,
                        "Enter the name you wish to search.");
                textArea.setText(list.phoneNumberByName(s));
            }
        });
        // emailbyName button
        b[8] = new JButton("emailByName");
        b[8].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String z = JOptionPane.showInputDialog(null,
                        "Enter the name you wish to search.");
                textArea.setText(list.emailByName(z));
            }
        });
        // nameByPhoneNumber button
        b[9] = new JButton("nameByPhoneNumber");
        b[9].addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String x = JOptionPane.showInputDialog(null,
                        "Enter the phone number you wish to search.");
               textArea.setText(list.nameByPhoneNumber(x));
           } 
        });
        // dateOfBirthByName button
        b[10] = new JButton("dateOfBirthByName");    
        b[10].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String c = JOptionPane.showInputDialog(null,
                        "Enter the name you wish to search.");
                textArea.setText(list.dobByName(c));
            }
        });
        b[11] = new JButton("Clear textfields");
        b[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                t[0].setText("");
                t[1].setText("");
                t[2].setText("");
                t[3].setText("");
                t[4].setText("");
            }
        });
        
        // west panel
        westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(6,2));
        westPanel.add(new JLabel("NAME:"));
        westPanel.add(t[0]);//name
        westPanel.add(new JLabel("TELEPHONE:"));
        westPanel.add(t[1]);//telephone
        westPanel.add(new JLabel("EMAIL:"));
        westPanel.add(t[2]);//email
        westPanel.add(new JLabel("ADDRESS:"));
        westPanel.add(t[3]);//address
        westPanel.add(new JLabel("DATE OF BIRTH:"));
        westPanel.add(t[4]);//date of birth
        westPanel.add(b[0]);//add to front
        westPanel.add(b[1]);//add to back
        
        // east panel
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(5,2));
        eastPanel.add(b[2]);
        eastPanel.add(b[3]);
        eastPanel.add(b[4]);
        eastPanel.add(b[5]);
        eastPanel.add(b[6]);
        eastPanel.add(b[7]);
        eastPanel.add(b[8]);
        eastPanel.add(b[9]);
        eastPanel.add(b[11]);
        eastPanel.add(b[10]);
        
        // south panel
        southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        southPanel.add(pane);
        
        // add panels to main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
    } // constructor
    
    public void display(){
        frame = new JFrame("Vance Field");
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
