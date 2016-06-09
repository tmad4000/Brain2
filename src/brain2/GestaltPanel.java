package brain2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultCaret;

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
