package gamex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


public class Gamex extends JFrame {

   
    public static void main(String[] args) {
    MessagePanel messagePanel = new MessagePanel();
    messagePanel.setFont(new Font("timesRoman", Font.BOLD, 30));
    messagePanel.setBackground(Color.BLACK);
    messagePanel.setForeground(Color.red);
    messagePanel.setToolTipText("main menu");
    messagePanel.setCentered(true);

    final JFrame frame = new JFrame("memory game");
    frame.getContentPane().add(messagePanel);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    JMenuBar mb = new JMenuBar();
    frame.setJMenuBar(mb);
    JMenu play = new JMenu("play",true);
    JMenu about = new JMenu("about",true);
    JMenu scores = new JMenu("scores",true);
  
    mb.add(play);
    mb.add(about);
    mb.add(scores);
    
    final JMenuItem jmiPlay; 
    final JMenuItem jmiClose;
    final JMenuItem aboutUs;
    final JMenuItem jmiScores;
    
    play.add(jmiPlay = new JMenuItem("New Game   alt+n",'n'));
    play.add(jmiClose = new JMenuItem("Close             alt+c",'c'));
    about.add(aboutUs= new JMenuItem("about us    alt+a",'a'));
    scores.add(jmiScores= new JMenuItem("scores    alt+s",'s'));
   
    play.setMnemonic('p');
    about.setMnemonic('a');
    scores.setMnemonic('s');

    
    jmiPlay.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==jmiPlay){   
      
        Board b= new Board();
        b.setPreferredSize(new Dimension(500,500));
        b.setLocation(500, 200);
        b.pack();
        b.setVisible(true);
       
            }
          }
          
          
      });
    
    jmiClose.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
               if (ae.getSource()== jmiClose){
        System.exit(0);
               }
          }
      });

    
  
    aboutUs.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==aboutUs){
        AboutFrame abf= new AboutFrame();

               
        }
//           
        }
    });
    
    
    jmiScores.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==jmiScores){
 final JFrame frame = new JFrame("scores");
frame.setVisible(true);  
frame.setLocation(700, 100);
frame.setVisible(true);
frame.setLayout(new BorderLayout());
frame.setSize(500, 500);

final JButton closeScore = new JButton("closeScore");

 closeScore.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
               if (ae.getSource()== closeScore ){
        frame.dispose();
               }
          }
      });

 frame.add(closeScore, BorderLayout.SOUTH);

 JTable tbl = new JTable(Board.arrayPL.size(),3);
 tbl.getColumnModel().getColumn(0).setHeaderValue("name");
 tbl.getColumnModel().getColumn(1).setHeaderValue("tries");
 tbl.getColumnModel().getColumn(2).setHeaderValue("time");
 tbl.setBackground(Color.BLACK);
 tbl.setForeground(Color.RED);
 tbl.getTableHeader().setBackground(Color.BLACK);
 tbl.getTableHeader().setForeground(Color.RED);
 tbl.setFont(new Font("timesRoman", Font.BOLD, 16));
 tbl.getTableHeader().setFont(new Font("timesRoman", Font.BOLD, 16));
 
 
 JScrollPane jspMap = new JScrollPane(tbl);

jspMap.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 
 for(int i =0 ; i< Board.arrayPL.size();i++){
     Player ply=Board.arrayPL.get(i);
     tbl.setValueAt(ply.getName(), i, 0);
     tbl.setValueAt(ply.getTries(), i, 1);
     tbl.setValueAt(ply.getTime(), i, 2);
 }
 frame.add(tbl.getTableHeader(),BorderLayout.NORTH);
 frame.add(tbl);
 frame.add(jspMap,BorderLayout.EAST);
               
        }         
        }
    });
       
}
    
   
}
