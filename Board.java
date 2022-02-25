
package gamex;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Board extends JFrame{
    
    private  List<Card> cards;
    static ArrayList <Player> arrayPL = new ArrayList <Player>();
    private Card selectedCard;
    private Card card1;
    private Card card2;
    private  Timer t,timee;
    private int tries =1;
    private JLabel Jtime;
    private  JLabel Jtries;
    private  int seconds;
    
    public Board(){
  
        int pairs = 8;
        List<Card> cardsList = new ArrayList<>();
        List<Integer> cardVals = new ArrayList<>();

        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
        Collections.shuffle(cardVals);

        for (int val : cardVals){
            final Card c = new Card();
            c.setId(val);
            c.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
           
        
    ActionListener taskPerformer = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
    seconds++;
    String date = new java.text.SimpleDateFormat("mm:ss").format(new
         java.util.Date(seconds * 1000L));
    Jtime.setText(date);

          }
      };
    timee =   new Timer(1000, taskPerformer);
    timee.start();

t = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);
        
        setTitle("Number Match");
        JPanel p1= new JPanel();
        
        p1.setLayout(new GridLayout((pairs/2),2));
        for (Card c : cards){
            p1.add(c);
        }
   
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(p1);
              
        Jtime = new JLabel();
        Jtime.setForeground(Color.BLACK);
        Jtime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Jtime.setPreferredSize(new Dimension(200,30));
        pane.add(Jtime,BorderLayout.NORTH);
        
        Jtries = new JLabel("0");
        Jtries.setForeground(Color.BLACK);
        Jtries.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Jtries.setAlignmentX(50);
        Jtries.setPreferredSize(new Dimension(100,30));
        pane.add(Jtries,BorderLayout.SOUTH);
                
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu game = new JMenu("game",true);
        game.setMnemonic('g');
        mb.add(game);
        final JMenuItem newG; 
        final JMenuItem exitG;
    
 
    game.add(newG = new JMenuItem("return to Menu       alt+r", 'r'));
    game.add(exitG = new JMenuItem("exit game                alt+e", 'e'));
    
    exitG.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
               if (ae.getSource()== exitG){
                   music("boo.wav");
   JOptionPane.showMessageDialog(null, "Warning! your score will not be saved",
 "Warning", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
        
               }
          }
      });
    
     newG.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
               if (ae.getSource()== newG){
                   music("boo.wav");
   JOptionPane.showMessageDialog(null, "Warning! your score will not be saved",
 "Warning", JOptionPane.INFORMATION_MESSAGE);
       dispose();
        
               }
          }
      });
    }
       
       private void setTries(int tries){
         String tri= Integer.toString(tries);
         Jtries.setText(tri+" trie(s)");
       }

    public void doTurn(){
        if (card1 == null && card2 == null){
            card1 = selectedCard;
            card1.setText(String.valueOf(card1.getId()));
            
        }

        if (card1 != null && card1 != selectedCard && card2 == null){
            card2 = selectedCard;
            card2.setText(String.valueOf(card2.getId()));
            t.start();

        }
    }

    public void checkCards(){
        if (card1.getId() == card2.getId()){
            music("ding.wav");
            card1.setEnabled(false);
            card2.setEnabled(false);
            card1.setMatched(true);
            card2.setMatched(true);
            card1.setBackground(Color.RED);
            card2.setBackground(Color.RED);
                   
     if (this.isGameWon()){
        music("tada.wav");
        JOptionPane.showMessageDialog(this, "You win! "+"you did "+(tries-1)+
            " tries to finish with the time of "+Jtime.getText());
      timee.stop();
      t.stop();
      
     String Sname,Stries,Stime; 
    
    Stries=Jtries.getText();
    Stime= Jtime.getText();
    Sname= JOptionPane.showInputDialog("enter your name");
    boolean namecheck= false;
    
    do{
    if(Sname.matches("[a-zA-Z]+") ){
   Player p = new Player(Sname,Stries,Stime); 
    arrayPL.add(p);
    namecheck=true;}  
    
    else if(Sname.isEmpty()){   
     Sname= JOptionPane.showInputDialog("enter a name and not an empty space "); 
    }
    
    else{
     Sname= JOptionPane.showInputDialog("you entered the wrong type of input"
             + " please make sure you entered an all characters name "); 
    }
    }while( namecheck==false);
    
         
    JOptionPane.showMessageDialog(null, "Your score has been saved");
    
    this.dispose();
            }
        }
        
        else{ 
            music("buzz.wav");
            card1.setText("");
            card2.setText("");
            setTries(tries++);
           
        }
        card1 = null; 
        card2 = null;
        
    }

    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return  arrayPL + "\n";
    }
    
    public static void music(String sound){
        InputStream music;      
                try{
             music = new FileInputStream(new File(sound));     
         AudioStream   mas = new AudioStream(music);
          AudioPlayer.player.start(mas);
                }
                catch(IOException error){JOptionPane.showMessageDialog(null,
                        "error");}
             
        }
    }
    




