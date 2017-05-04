package sovelluslogiikka;


/**
 * Luokka määrittelee vapaasti järjestyksessä selattavan korttipakan ominaisuudet.
 */

import java.util.*;

public class Pakka {
    private ArrayList<Kortti> pakka;
    private Kortti paallimmainen;
    
    /**
     * Konstruktori.
     */
    
    public Pakka() {
        this.pakka = new ArrayList<Kortti>();
        this.paallimmainen = null;
    }
    
    /**
     * Metodi lisää uuden kortin pakkaan. Metodia käytetään vain pelin alkaessa.
     * @param kortti pakkaan lisättävä kortti
     */
    
    public void lisaaKortti(Kortti kortti) {
        this.pakka.add(kortti);
        this.paallimmainen = kortti;
    }
    
    /**
     * Metodi poistaa kortin pakasta.
     * @param kortti pakasta poistettava kortti
     */
    
    public void poistaPakasta(Kortti kortti) {
        this.pakka.remove(kortti);
    }
    
    /**
     * Metodi siirtää pakassa seuraavana olevan kortin päällimmäiseksi.
     * @return seuraavana oleva kortti
     */
    
    public Kortti naytaSeuraava() {
        if (this.pakka.indexOf(this.paallimmainen) == this.pakka.size() - 1) {
            this.paallimmainen = this.pakka.get(0);
        } else {
            this.paallimmainen = this.pakka.get(pakka.indexOf(this.paallimmainen) + 1);
        }
        
        return this.paallimmainen;
    }
    
    /**
     * Metodi palauttaa pakan koon kokonaislukuna.
     * @return pakan koko
     */
    
    public int pakanKoko() {
        return this.pakka.size();
    }
    
    public Kortti getPaallimmainen() {
        return this.paallimmainen;
    }
    
    public ArrayList<Kortti> getPakka() {
        return this.pakka;
    }
}
