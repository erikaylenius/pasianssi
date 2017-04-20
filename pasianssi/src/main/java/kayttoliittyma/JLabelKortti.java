package kayttoliittyma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eylenius
 */

import javax.swing.JLabel;
import sovelluslogiikka.Kortti;

public class JLabelKortti extends JLabel {
    
    private Kortti kortti;
    
    public JLabelKortti(Kortti kortti) {
        this.setKortti(kortti);
    }
    
    public void setKortti(Kortti kortti) {
        this.kortti = kortti;
    }
    
    public Kortti getKortti() {
        return kortti;
    }
    
}
