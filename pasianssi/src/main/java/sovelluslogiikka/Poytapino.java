package sovelluslogiikka;

/**
 * Luokka määrittelee seitsemän eri pelin alussa jaetun pinon ominaisuudet. 
 * Pinot sisältävät aluksi 1, 2, 3, 4, 5, 6 ja 7 arvottua korttia. Alkuasetelmassa 
 * kunkin pinon ylin kortti on oikein päin, loput nurinpäin. 
 */

import java.util.ArrayList;

public class Poytapino {

    private ArrayList<Kortti> poytaPino;

    public Poytapino() {
        
        this.poytaPino = new ArrayList<Kortti>();
        
    }    
    
    public void lisaaKortti(Kortti kortti) {
        this.poytaPino.add(kortti);
    }
    
    public void alusta() {
        for (int i = 0; i < (poytaPino.size() - 2); i++) {
            poytaPino.get(i).kaanna();
        }
    }
    
    public int pinonKoko() {
        return this.poytaPino.size();
    }
    
    public Kortti getKortti(int i) {
        return this.poytaPino.get(i);
    }

    public void lisaaKorttiPaalle(Kortti kortti) {
        if (poytaPino.isEmpty()) {
            if (kortti.getArvo() == 13) {
                poytaPino.add(kortti);
            }
        } else {
            if (poytaPino.get(poytaPino.size() - 1).onkoOikeinPain()) {
                if (!poytaPino.get(poytaPino.size() - 1).getVari().equals(kortti.getVari())) {
                    if ((poytaPino.get(poytaPino.size() - 1).getArvo()) == (kortti.getArvo() + 1)) {
                        poytaPino.get(poytaPino.size() - 1).kaanna();
                        poytaPino.add(kortti);
                    }
                } 
            }
        }    
    }

    public void poistaKorttiPinosta(Kortti kortti) {
        this.poytaPino.remove(kortti);
    }
}
