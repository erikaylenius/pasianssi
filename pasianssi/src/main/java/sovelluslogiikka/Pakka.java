package sovelluslogiikka;


/**
 * Luokka määrittelee vapaasti järjestyksessä selattavan korttipakan ominaisuudet.
 */

import java.util.*;

public class Pakka {
    private ArrayList<Kortti> pakka;
    private Kortti nakyva;
    
    public Pakka() {
        this.pakka = new ArrayList<Kortti>();
    }
    
    /**
     * Metodi lisää uuden kortin pakkaan. Metodia käytetään vain pelin alkaessa.
     * @param kortti pakkaan lisättävä kortti
     */
    
    public void lisaaKortti(Kortti kortti) {
        this.pakka.add(kortti);
    }
    
    
    public int pakanKoko() {
        return this.pakka.size();
    }
}
