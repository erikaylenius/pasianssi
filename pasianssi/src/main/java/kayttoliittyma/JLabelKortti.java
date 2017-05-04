package kayttoliittyma;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import sovelluslogiikka.Kortti;

public class JLabelKortti extends JLabel {
    
    private Kortti kortti;
    private JLayeredPane aiempiPaikka;
    private Rectangle aiempiSijainti;
    public ImageIcon kuva;
    
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
