
package gamex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AboutFrame extends JFrame {
    
    public AboutFrame(){
 Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
 int screenWidth = screenSize.width;
 int screenHeight = screenSize.height;

 int x = (screenWidth - this.getWidth()) / 2;
 int y = (screenHeight - this.getHeight()) / 2;

this.setVisible(true);  
this.setLocation(x, y);
this.setVisible(true);
this.setLayout(new BorderLayout());
this.setSize(500, 500);

JLabel lblTitle = new JLabel("Welcome to Match The Numbers");
lblTitle.setBackground(Color.BLACK);
lblTitle.setForeground(Color.RED);
getContentPane().setBackground(Color.BLACK);
getContentPane().setForeground(Color.RED);

JTextArea jta= new JTextArea("this game tests the player’s memory of numbers "
+"and their location"+"\n"+"when you start the game multiple buttons will,"
        + " appear when you presses one of them a number"
+" will pop up, the user will then search for this identical number between"
      + " the others"+"\n"+"when 2 numbers match, their color will change and "
        + "you cannot " 
+"press them anymore. As soon as you presses your first choice of button a"
 + " timer will start"+"\n"+"and each time you choose a wrong number a counter "
        + "of tries will be"
+" increased by 1. The timer will stop when you find all the pairs of numbers"+
        "\n"+"When you finish the round, your time and number of"
+" tries will be saved \n \n \n for more info contact:\n Nabih Bassil :creator"
        + "\n nabih.bassil@std.balamand.edu.lb");

jta.setBackground(Color.BLACK);
jta.setForeground(Color.RED);
jta.setEditable(false);
jta.setFont(new Font("timesRoman", Font.BOLD, 14));

JPanel p1 = new JPanel();
p1.add(jta);
p1.setBackground(Color.BLACK);
p1.setForeground(Color.RED);

JScrollPane jspMap = new JScrollPane(jta);

jspMap.setHorizontalScrollBarPolicy(
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

getContentPane().add(lblTitle,BorderLayout.NORTH);
getContentPane().add(p1,BorderLayout.CENTER);
getContentPane().add(jspMap);

}
}


