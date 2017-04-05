package sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eylenius
 */
import java.util.ArrayList;

public class Peruspino {
    private ArrayList<Kortti> perusPino;
    
    public Peruspino() {
        this.perusPino = new ArrayList<Kortti>();
    }
    
    public int pinonKoko() {
        return this.perusPino.size();
    }
    
    public void lisaaPinoon(Kortti kortti) {
        if (voikoLisataPinoon(kortti)) {
            this.perusPino.add(kortti);
        }
    }
    
    public void poistaPinosta(Kortti kortti) {
        this.perusPino.remove(kortti);
    }
    
    public Kortti getKortti(int i) {
        return this.perusPino.get(i);
    }
    
    public boolean voikoLisataPinoon(Kortti kortti) {
        if (this.perusPino.isEmpty() && kortti.getArvo() == 1) {
            return true;
        }
        
        if (!this.perusPino.isEmpty()) {
        
            if ((this.perusPino.get(this.perusPino.size() - 1)).getMaa().equals(kortti.getMaa())
                && this.perusPino.get(this.perusPino.size() - 1).getArvo() == kortti.getArvo() - 1) {

                return true;
            }
        }
        return false;
    }
    
    public boolean pinoValmis() {
        if (this.perusPino.get(12) != null) {
            return true;
        }
        
        return false;
    }
}
