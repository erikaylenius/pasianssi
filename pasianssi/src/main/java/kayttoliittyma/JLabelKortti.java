package kayttoliittyma;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import sovelluslogiikka.Kortti;

public class JLabelKortti extends JLabel {
    
    private Kortti kortti;
    public ImageIcon kuva;
    
    public JLabelKortti(ImageIcon kuva, Kortti kortti) {
        super(kuva);
        this.setKortti(kortti);
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
    
}
