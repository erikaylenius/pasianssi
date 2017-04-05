package sovelluslogiikka;


/**
 * Luokka määrittelee vapaasti järjestyksessä selattavan korttipakan ominaisuudet.
 */

import java.util.*;

public class Pakka {
    private ArrayList<Kortti> pakka;
    
    public Pakka() {
        this.pakka = new ArrayList<Kortti>();
    }
    
    public void lisaaKortti(Kortti kortti) {
        this.pakka.add(kortti);
    }
    
    public int pakanKoko() {
        return this.pakka.size();
    }
}
