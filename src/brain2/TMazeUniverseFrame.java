/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brain2;

/**
 *
 * @author Jacob-MTech
 */

    
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Jacob-MTech
 */
public class TMazeUniverseFrame extends JFrame {

    MainPanel mP;
    
    public TMazeUniverseFrame() throws InterruptedException {
        super("TMazeUniverse");
        setSize(1000, 500);
        mP = new MainPanel();
        add(mP);
        
        //new JButton("restart")
        //add()
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);

        for(int i=0;i<500 ;i++) {
            System.out.println(i);
            Thread.sleep(30);
            mP.next();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        TMazeUniverseFrame s = new TMazeUniverseFrame();

        // TODO code application logic here
    }
}




/**
 *
 * @author Jacob-MTech
 */
class MainPanel extends JPanel {
    Universe u;
    GestaltPanel gP;
    UniversePanel uP;

    public MainPanel() {
        //setBackground(Color.green);
        //this.setPreferredSize(new Dimension(500, 500));
        u = new Universe();
        //
        uP = new UniversePanel(u);
        //add(uP);
        ////            jp.add(new JButton("aoeu"));
        //
        ////            add(jp)
        //
        gP = new GestaltPanel(u);
        //add(gP);
        //
        setLayout(new BorderLayout());
        //
        add(uP, BorderLayout.CENTER);
        add(gP, BorderLayout.EAST);
    }

    //        public void paint(Graphics g) {
    //            g.drawLine(100, 111, 200, 222);
    //        }
    public void next() throws InterruptedException {

        gP.next();
        uP.next();
    }
    
}





/**
 *
 * @author Jacob-MTech
 */
class GestaltPanel extends JPanel {
    Universe u;
    JTextArea ta;
    StringBuffer t=new StringBuffer();

    public GestaltPanel(Universe u) {
        super();
        this.u = u;
        this.setPreferredSize(new Dimension(400, 300));
            this.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK)); 

        setLayout(new BorderLayout());
        ta = new JTextArea("");
        ta.setBackground(Color.WHITE);

        //setPreferredSize(new Dimension(100,100));
        ta.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(ta);
        //            scrollPane.setPreferredSize(new Dimension(120,100));
        ta.setEditable(false);
        DefaultCaret caret = (DefaultCaret)ta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void next() {
//        ta.setText(u.toString());
        t.append(u.toString());
        t.append("------------------------------------\n");

        ta.setText(t.toString());
    }
    
}
