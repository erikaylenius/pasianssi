package sovelluslogiikka;


/**
 * Luokka määrittelee neljän eri peruspinon ominaisuudet. Pinot ovat aluksi
 * tyhjiä, mutta niihin on tavoitteena koota 13 saman maan korttia 
 * arvojärjestyksessä, arvoltaan suurin kortti päällimmäisenä. 
 */

import java.util.ArrayList;

public class Peruspino {
    private ArrayList<Kortti> perusPino;
    
    /**
     * Konstruktori.
     */
    
    public Peruspino() {
        this.perusPino = new ArrayList<Kortti>();
    }
    
    /**
     * Metodi palauttaa pinon koon kokonaislukuna.
     * @return pinon koko
     */
    
    public int pinonKoko() {
        return this.perusPino.size();
    }
    
    /**
     * Metodi lisää pinoon uuden kortin päällimmäiseksi, mikäli kortin saa
     * sääntöjen mukaan lisätä.
     * @param kortti pinoon lisättävä kortti
     */
    
    public void lisaaPinoon(Kortti kortti) {
        if (voikoLisataPinoon(kortti)) {
            this.perusPino.add(kortti);
        }
    }
    
    /**
     * Metodi poistaa pinon päällimmäisen kortin silloin, kun kyseinen kortti 
     * siirretään muualle.
     * @param kortti poistettava kortti
     */
    
    public void poistaPinosta(Kortti kortti) {
        this.perusPino.remove(kortti);
    }
    
    /**
     * Metodi palauttaa pinossa indeksistä i löytyvän kortin.
     * @param i haettava indeksi
     * @return indeksistä i löytyvä kortti
     */
    
    public Kortti getKortti(int i) {
        return this.perusPino.get(i);
    }
    
    /**
     * Metodi kertoo, voiko korttia lisätä sääntöjen mukaan pinon päällimmäiseksi.
     * @param kortti kortti, jota yritetään siirtää pinon päälle
     * @return saako kortin siirtää pinoon
     */
    
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
    
    /**
     * Metodi kertoo, onko pinossa 13 korttia, ja onko yksittäisessä pinossa 
     * täten kaikki pelin läpäisemiseksi tarvitut kortit.
     * @return onko pinossa kaikki kortit
     */
    
    public boolean pinoValmis() {
        if (this.perusPino.get(12) != null) {
            return true;
        }
        
        return false;
    }
    
}
