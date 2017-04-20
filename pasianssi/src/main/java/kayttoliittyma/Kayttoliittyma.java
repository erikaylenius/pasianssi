
package kayttoliittyma;

/**
 *
 * @author eylenius
 */
import sovelluslogiikka.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor; 
/* */
import java.awt.Dimension;
import java.awt.EventQueue;
/* */
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
/* */
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
/* */

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Pasianssi");
        frame.setPreferredSize(new Dimension(1000, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Color tausta = new Color(155, 120, 85);
        container.setLayout(null);
        container.setBackground(tausta);
        
        Insets insets = container.getInsets();
        
        JButton pakka = new JButton("pakka");
        container.add(pakka);

        pakka.setBounds(25 + insets.left, 5 + insets.top, 100, 200);
        
        
        pakka.addActionListener(new PakkaKuuntelija());
        
        
        JLabel testi = new JLabel("testi");
        container.add(testi);
        testi.setBackground(Color.blue);
        testi.setBounds(700 + insets.left, 5 + insets.top, 100, 200);
        


        
        JLabelKortti labelKortti = 
                new JLabelKortti(new Kortti("hertta", "punainen", 3));
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
