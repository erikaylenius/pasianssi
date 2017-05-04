
package kayttoliittyma;
import sovelluslogiikka.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Luokka luo käyttöliittymän näkyvät visuaaliset komponentit.
 */

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    
    /**
     * Konstruktori.
     */
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
         
        JMenuBar valikko = new JMenuBar();
        JMenu pelimenu = new JMenu("Peli");
        JMenuItem lopeta = new JMenuItem("Lopeta");
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pelimenu.add(lopeta);
        valikko.add(pelimenu);
        frame.setJMenuBar(valikko);      
    }

    private void luoKomponentit(Container container) {
        Color tausta = new Color(193, 186, 188);
        container.setLayout(null);
        container.setBackground(tausta);
        Insets insets = container.getInsets();    
    // Pakka
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/pakka.png");
            ImageIcon nurin = new ImageIcon(ImageIO.read(is));
            JButton pakka = new JButton(nurin);
            container.add(pakka);
            pakka.setBounds(25 + insets.left, 20 + insets.top, nurin.getIconWidth(), nurin.getIconHeight());
            JLayeredPane nakyvaPakka = luoPakka();
            container.add(nakyvaPakka);
            nakyvaPakka.setBounds(150, 20, 120, 200); 
            pakka.addActionListener(new PakkaKuuntelija(container, nakyvaPakka));
        } catch (Exception e) {   
        }
    // Luodaan seitseman poytapinoa    
        JLayeredPane poytaPino1 = luoPoytaPino(0, peli.getPoytaPinot().get(0));
        container.add(poytaPino1);
        poytaPino1.setBounds(25, 200, 120, 1000);
        JLayeredPane poytaPino2 = luoPoytaPino(1, peli.getPoytaPinot().get(1));
        container.add(poytaPino2);
        poytaPino2.setBounds(150, 200, 120, 1000);
        JLayeredPane poytaPino3 = luoPoytaPino(2, peli.getPoytaPinot().get(2));
        container.add(poytaPino3);
        poytaPino3.setBounds(275, 200, 120, 1000);
        JLayeredPane poytaPino4 = luoPoytaPino(3, peli.getPoytaPinot().get(3));
        container.add(poytaPino4);
        poytaPino4.setBounds(400, 200, 120, 1000);
        JLayeredPane poytaPino5 = luoPoytaPino(4, peli.getPoytaPinot().get(4));
        container.add(poytaPino5);
        poytaPino5.setBounds(525, 200, 120, 1000);
        JLayeredPane poytaPino6 = luoPoytaPino(5, peli.getPoytaPinot().get(5));
        container.add(poytaPino6);
        poytaPino6.setBounds(650, 200, 120, 1000);      
        JLayeredPane poytaPino7 = luoPoytaPino(6, peli.getPoytaPinot().get(6));
        container.add(poytaPino7);
        poytaPino7.setBounds(775, 200, 120, 1000);
    // Luodaan nelja peruspinoa          
        JLayeredPane perusPino1 = luoPerusPino(peli.getPerusPinot().get(0));
        perusPino1.setBounds(400, 20, 120, 163);
        container.add(perusPino1);
        JLayeredPane perusPino2 = luoPerusPino(peli.getPerusPinot().get(1));
        perusPino2.setBounds(525, 20, 120, 163);
        container.add(perusPino2);
        JLayeredPane perusPino3 = luoPerusPino(peli.getPerusPinot().get(2));
        perusPino3.setBounds(650, 20, 120, 163);
        container.add(perusPino3);
        JLayeredPane perusPino4 = luoPerusPino(peli.getPerusPinot().get(3));
        perusPino4.setBounds(775, 20, 120, 163);
        container.add(perusPino4);
    // Lisätään kuuntelija    
        Kortinsiirto hiiri = new Kortinsiirto(container);
        container.addMouseListener(hiiri);
        container.addMouseMotionListener(hiiri);    
    }

    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Metodi luo oikean kokoisen pinon pöydälle, jossa päällimmäinen kortti on oikein päin, muut kuvapuoli alaspäin.
     * @param nro luotavan pinon korttien lukumäärä - 1
     * @param poytapino sovelluslogiikan pino, johon pöytäpino liittyy
     * @return uusi pöytäpino
     */      
    public JLayeredPane luoPoytaPino(int nro, Poytapino poytapino) {
        JLayeredPanePoytaPino pinonKortit = new JLayeredPanePoytaPino(poytapino);
        int sijainti = 0;
        for (int i = 0; i < peli.getPoytaPinot().get(nro).getPoytaPino().size(); i++) {
            try {
                Kortti viiteKorttiin = peli.getPoytaPinot().get(nro).getPoytaPino().get(i);
                String tiedostonimi = getTiedostoNimi(viiteKorttiin);
                InputStream is = getClass().getClassLoader().getResourceAsStream(tiedostonimi);
                ImageIcon kuvaKortista = new ImageIcon(ImageIO.read(is));            
                if (viiteKorttiin.onkoOikeinPain() == false) {
                    InputStream is2 = getClass().getClassLoader().getResourceAsStream("kortit/pakka.png");
                    kuvaKortista = new ImageIcon(ImageIO.read(is2));
                }        
                JLabelKortti pakanKortti = new JLabelKortti(kuvaKortista, viiteKorttiin);
                pakanKortti.setBounds(0, sijainti, kuvaKortista.getIconWidth(), kuvaKortista.getIconHeight());            
                pinonKortit.add(pakanKortti, i, -1);          
                sijainti = sijainti + 40;
            } catch (Exception e) {         
            }
        }       
        return pinonKortit;
    }  
    
    /**
     * Metodi luo pelin pakan.
     * @return uusi pakka
     */ 
    public JLayeredPane luoPakka() {       
        JLayeredPane pakanKortit = new JLayeredPane();
        for (int i = 0; i < peli.getPakka().getPakka().size(); i++) {
            try {
                Kortti viiteKorttiin = peli.getPakka().getPakka().get(i);
                String tiedostonimi = getTiedostoNimi(viiteKorttiin);
                InputStream is = getClass().getClassLoader().getResourceAsStream(tiedostonimi);
                ImageIcon kuvaKortista = new ImageIcon(ImageIO.read(is));
                JLabelKortti pakanKortti = new JLabelKortti(kuvaKortista, viiteKorttiin);
                pakanKortti.setBounds(0, 0, kuvaKortista.getIconWidth(), kuvaKortista.getIconHeight());
                pakanKortit.add(pakanKortti, i, -1);
            } catch (Exception e) {              
            }
        }       
        return pakanKortit;
    }
    
    /**
     * Metodi luo tyhjän peruspinon, johon kortteja voidaan pinota sääntöjen mukaisesti.
     * @param peruspino sovelluslogiikan luokassa Peli oleva peruspino, jota 
     * visualisoidaan JLayeredPanella
     * @return uusi peruspino
     */   
    public JLayeredPane luoPerusPino(Peruspino peruspino) {
        JLayeredPanePerusPino perusPino = new JLayeredPanePerusPino(peruspino);
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/tyhjapino.png");
            ImageIcon kuva = new ImageIcon(ImageIO.read(is));      
            JLabel tyhjaPino = new JLabel(kuva);
            tyhjaPino.setBounds(0, 0, kuva.getIconWidth(), kuva.getIconHeight());
            perusPino.add(tyhjaPino, -1);
        } catch (Exception e) {    
        }
        return perusPino;
    }
    
    /**
     * Metodi muodostaa tiettyä korttia vastaavan kuvan tiedostonimen.
     * @param kortti kortti, jota vastaava kuva halutaan löytää
     * @return korttia vastaavan kuvan tiedostonimi
     */ 
    public String getTiedostoNimi(Kortti kortti) {
        String tiedostonimi = "kortit/" + kortti.getMaa() + kortti.getArvo() + ".png";
        return tiedostonimi;
    }       
}