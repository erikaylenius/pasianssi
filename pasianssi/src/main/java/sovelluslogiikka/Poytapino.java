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
