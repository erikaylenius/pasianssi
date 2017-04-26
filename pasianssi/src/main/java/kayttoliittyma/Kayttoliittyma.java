
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
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
/* */ /* */ /* */ 
import java.awt.Dimension;
import java.awt.EventQueue;
/* */
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
/* */
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
/* */

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }
    
    Peli peli = new Peli();
    
    @Override
    public void run() {
        frame = new JFrame("Pasianssi");
        frame.setPreferredSize(new Dimension(1000, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Color tausta = new Color(193, 186, 188);
        container.setLayout(null);
        container.setBackground(tausta);

        
        Insets insets = container.getInsets();
      
    // Pakka
    
        ImageIcon nurin = new ImageIcon("kortit/pakka.png");
        JButton pakka = new JButton(nurin);
        container.add(pakka);
        pakka.setBounds(25 + insets.left, 20 + insets.top, nurin.getIconWidth(), nurin.getIconHeight());
        
        JLayeredPane nakyvaPakka = luoPakka();
        container.add(nakyvaPakka);
        nakyvaPakka.setBounds(150, 20, 120, 200);
        
        //Kortti paallimmainenKortti = peli.getPakka().getPaallimmainen();
        //ImageIcon paallimmaisenKuva = new ImageIcon(getTiedostoNimi(paallimmainenKortti));
        //JLabelKortti paallimmainen = new JLabelKortti(paallimmaisenKuva, paallimmainenKortti);
        //paallimmainen.setBounds(150, 20, paallimmaisenKuva.getIconWidth(), paallimmaisenKuva.getIconHeight());
        //container.add(paallimmainen);
        
        pakka.addActionListener(new PakkaKuuntelija(container, nakyvaPakka, peli));
    
    // Luodaan seitseman poytapinoa    
        
        JLayeredPane poytaPino1 = luoPoytaPino(0);
        container.add(poytaPino1);
        poytaPino1.setBounds(25, 200, 120, 400);
        
        JLayeredPane poytaPino2 = luoPoytaPino(1);
        container.add(poytaPino2);
        poytaPino2.setBounds(150, 200, 120, 400);
        
        JLayeredPane poytaPino3 = luoPoytaPino(2);
        container.add(poytaPino3);
        poytaPino3.setBounds(275, 200, 120, 400);
        
        JLayeredPane poytaPino4 = luoPoytaPino(3);
        container.add(poytaPino4);
        poytaPino4.setBounds(400, 200, 120, 400);
        
        JLayeredPane poytaPino5 = luoPoytaPino(4);
        container.add(poytaPino5);
        poytaPino5.setBounds(525, 200, 120, 400);
        
        JLayeredPane poytaPino6 = luoPoytaPino(5);
        container.add(poytaPino6);
        poytaPino6.setBounds(650, 200, 120, 400);
        
        JLayeredPane poytaPino7 = luoPoytaPino(6);
        container.add(poytaPino7);
        poytaPino7.setBounds(775, 200, 120, 1000);
        
    // Luodaan nelja peruspinoa
        
        ImageIcon kuva = new ImageIcon("kortit/tyhjapino.png");      
        JLabel perusPino1 = new JLabel(kuva);
        perusPino1.setBounds(400, 20, kuva.getIconWidth(), kuva.getIconHeight());
        container.add(perusPino1);
        
        JLabel perusPino2 = new JLabel(kuva);
        perusPino2.setBounds(525, 20, kuva.getIconWidth(), kuva.getIconHeight());
        container.add(perusPino2);
        
        JLabel perusPino3 = new JLabel(kuva);
        perusPino3.setBounds(650, 20, kuva.getIconWidth(), kuva.getIconHeight());
        container.add(perusPino3);
        
        JLabel perusPino4 = new JLabel(kuva);
        perusPino4.setBounds(775, 20, kuva.getIconWidth(), kuva.getIconHeight());
        container.add(perusPino4);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    
     public JLayeredPane luoPoytaPino(int nro) {
        JLayeredPane pinonKortit = new JLayeredPane();
        int sijainti = 0;
        for (int i = 0; i < peli.getPoytaPinot().get(nro).getPoytaPino().size(); i++) {
            Kortti viiteKorttiin = peli.getPoytaPinot().get(nro).getPoytaPino().get(i);
            String tiedostonimi = getTiedostoNimi(viiteKorttiin);
            ImageIcon kuvaKortista = new ImageIcon(tiedostonimi);
            
            if (viiteKorttiin.onkoOikeinPain() == false) {
                kuvaKortista = new ImageIcon("kortit/pakka.png");
            }
            
            JLabelKortti pakanKortti = new JLabelKortti(kuvaKortista, viiteKorttiin);
            pakanKortti.setBounds(0, sijainti, kuvaKortista.getIconWidth(), kuvaKortista.getIconHeight());
           
    
            pinonKortit.add(pakanKortti, i, -1);
           
            sijainti = sijainti + 40;
        }
        
        return pinonKortit;
    }  
    
    public String getTiedostoNimi(Kortti kortti) {
        String tiedostonimi = "kortit/" + kortti.getMaa() + kortti.getArvo() + ".png";
        return tiedostonimi;
    }
    
    public JLayeredPane luoPakka() {
    JLayeredPane pakanKortit = new JLayeredPane();
        int sijainti = 0;
        for (int i = 0; i < peli.getPakka().getPakka().size(); i++) {
            Kortti viiteKorttiin = peli.getPakka().getPakka().get(i);
            String tiedostonimi = getTiedostoNimi(viiteKorttiin);
            ImageIcon kuvaKortista = new ImageIcon(tiedostonimi);
            JLabelKortti pakanKortti = new JLabelKortti(kuvaKortista, viiteKorttiin);
            pakanKortti.setBounds(0, 0, kuvaKortista.getIconWidth(), kuvaKortista.getIconHeight());
            pakanKortit.add(pakanKortti, i, -1);
            sijainti += 40;
        }
        
        
        return pakanKortit;
    }

    public static void seuraavaPakasta(Container container) {
        JLabel label = new JLabel("oho");

        
    }
        
        
}
