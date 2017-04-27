
package kayttoliittyma;
import sovelluslogiikka.*;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
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
        InputStream is = new BufferedInputStream(new FileInputStream("kortit/pakka.png"));
        ImageIcon nurin = new ImageIcon(ImageIO.read(is));
        JButton pakka = new JButton(nurin);
        container.add(pakka);
        pakka.setBounds(25 + insets.left, 20 + insets.top, nurin.getIconWidth(), nurin.getIconHeight());
        
        JLayeredPane nakyvaPakka = luoPakka();
        container.add(nakyvaPakka);
        nakyvaPakka.setBounds(150, 20, 120, 200); 
        
        pakka.addActionListener(new PakkaKuuntelija(container, nakyvaPakka, peli));
        } catch (Exception e) {
            
        }
    
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
        JLayeredPane perusPino1 = luoPerusPino();
        perusPino1.setBounds(400, 20, 120, 163);
        container.add(perusPino1);
        JLayeredPane perusPino2 = luoPerusPino();
        perusPino2.setBounds(525, 20, 120, 163);
        container.add(perusPino2);
        JLayeredPane perusPino3 = luoPerusPino();
        perusPino3.setBounds(650, 20, 120, 163);
        container.add(perusPino3);
        JLayeredPane perusPino4 = luoPerusPino();
        perusPino4.setBounds(775, 20, 120, 163);
        container.add(perusPino4);
        
        Kortinsiirto hiiri = new Kortinsiirto(poytaPino2, perusPino1);
        poytaPino2.addMouseListener(hiiri);
        poytaPino2.addMouseMotionListener(hiiri);    
    }

    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Metodi luo oikean kokoisen pinon pöydälle, jossa päällimmäinen kortti on oikein päin, muut kuvapuoli alaspäin.
     * @param nro luotavan pinon korttien lukumäärä - 1
     * @return uusi pöytäpino
     */      
    public JLayeredPane luoPoytaPino(int nro) {
        JLayeredPane pinonKortit = new JLayeredPane();
        int sijainti = 0;
        for (int i = 0; i < peli.getPoytaPinot().get(nro).getPoytaPino().size(); i++) {
            try {
            Kortti viiteKorttiin = peli.getPoytaPinot().get(nro).getPoytaPino().get(i);
            String tiedostonimi = getTiedostoNimi(viiteKorttiin);
            InputStream is = new BufferedInputStream(new FileInputStream(tiedostonimi));
            ImageIcon kuvaKortista = new ImageIcon(ImageIO.read(is));            
            if (viiteKorttiin.onkoOikeinPain() == false) {
                kuvaKortista = new ImageIcon("kortit/pakka.png");
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
            InputStream is = new BufferedInputStream(new FileInputStream(tiedostonimi));
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
     * @return uusi peruspino
     */   
    public JLayeredPane luoPerusPino() {
        JLayeredPane perusPino = new JLayeredPane();
        try {
        InputStream is = new BufferedInputStream(new FileInputStream("kortit/tyhjapino.png"));
        ImageIcon kuva = new ImageIcon(ImageIO.read(is));      
        JLabel tyhjaPino = new JLabel(kuva);
        tyhjaPino.setBounds(0, 0, kuva.getIconWidth(), kuva.getIconHeight());
        perusPino.add(tyhjaPino);
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