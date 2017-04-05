/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 *
 * @author eylenius
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;

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
        container.setLayout(null);
        
        JButton pakka = new JButton("pakka");
        container.add(pakka);
        
        Insets insets = container.getInsets();

        pakka.setBounds(25 + insets.left, 5 + insets.top, 100, 200);
        
        pakka.addActionListener(new PakkaKuuntelija());
    }

    public JFrame getFrame() {
        return frame;
    }
}
