package kayttoliittyma;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import sovelluslogiikka.Kortti;

/**
 * Luokka määrittelee JLabel-luokan perivän JLabelKortin ominaisuudet. Erityisenä 
 * piirteenä kuhunkin JLabelKorttiin liittyy jokin tietty kortti.
 */

public class JLabelKortti extends JLabel {
    
    private Kortti kortti;
    private JLayeredPane aiempiPaikka;
    private Rectangle aiempiSijainti;
    public ImageIcon kuva;
    
    /**
     * Konstruktori.
     * @param kuva kortin näkyvä kuva, joko kuvapuoli tai selkä
     * @param kortti 
     */
    
    public JLabelKortti(ImageIcon kuva, Kortti kortti) {
        super(kuva);
        this.setKortti(kortti);
        this.aiempiPaikka = null;
        this.aiempiSijainti = null;
    }
    
    public void setKortti(Kortti kortti) {
        this.kortti = kortti;
    }
    
    public void setKuva(ImageIcon kuva) {
        this.kuva = kuva;
    }
    
    public Kortti getKortti() {
        return kortti;
    }
    
    public ImageIcon getKuva() {
        return this.kuva;
    }
    
    /**
     * Metodi kertoo, onko JLabelKortti oikein päin. Jos JLabelKorttiin liittyvä 
     * kortti on oikeinpäin, on myös JLabelKortti oikein päin.
     * @return totuusarvo
     */
    
    public boolean oikeinPain() {
        return kortti.onkoOikeinPain();
    }
    
    public void setAiempiPaikka(JLayeredPane paikka) {
        this.aiempiPaikka = paikka;
    }
    
    public JLayeredPane getAiempiPaikka() {
        return this.aiempiPaikka;
    }
    
    public void setAiempiSijainti(Rectangle sijainti) {
        this.aiempiSijainti = sijainti;
    }
    
    public Rectangle getAiempiSijainti() {
        return this.aiempiSijainti;
    }
    
}
