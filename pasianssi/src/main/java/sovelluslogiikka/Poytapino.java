package sovelluslogiikka;

/**
 * Luokka määrittelee seitsemän eri pelin alussa jaetun pinon ominaisuudet. 
 * Pinot sisältävät aluksi 1, 2, 3, 4, 5, 6 ja 7 arvottua korttia. Alkuasetelmassa 
 * kunkin pinon ylin kortti on oikein päin, loput nurinpäin. 
 */

import java.util.ArrayList;

public class Poytapino {

    private ArrayList<Kortti> poytaPino;
    
    /**
     * Konstruktori.
     */
    
    public Poytapino() {
        
        this.poytaPino = new ArrayList<Kortti>();
        
    } 
    
    /**
     * Metodi lisää kortin pöytäpinoon uuden pelin alkaessa.
     * @param kortti pinoon lisättävä kortti
     */
    
    public void lisaaKortti(Kortti kortti) {
        this.poytaPino.add(kortti);
    }
    
    /**
     * Metodi huolehtii siitä, että sääntöjen mukaiset kortit ovat pelin alkaessa
     * ylösalaisin.
     */
    
    public void alusta() {
        for (int i = 0; i < (poytaPino.size() - 1); i++) {
            poytaPino.get(i).kaanna();
        }
    }
    
    /**
     * Metodi palauttaa pinon koon kokonaislukuna.
     * @return pinon koko
     */
    
    public int pinonKoko() {
        return this.poytaPino.size();
    }
    
    /**
     * Metodi palauttaa pinossa indeksistä i löytyvän kortin.
     * @param i haettava indeksi
     * @return indeksistä i löytyvä kortti
     */
    
    public Kortti getKortti(int i) {
        return this.poytaPino.get(i);
    }
    

    
    public ArrayList<Kortti> getPoytaPino() {
        return this.poytaPino;
    }
    
    /**
     * Metodi lisää pelin aikana pinon päälle halutun kortin, mikäli säännöt 
     * sallivat kortin lisäämisen.
     * @param kortti kortti, joka halutaan lisätä
     */
    
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
    
    public boolean voikoLisataPinoon(Kortti kortti) {
         if (poytaPino.isEmpty()) {
            if (kortti.getArvo() == 13) {
                return true;
            }
            return false;
        } else {
            if (poytaPino.get(poytaPino.size() - 1).onkoOikeinPain()) {
                if (!poytaPino.get(poytaPino.size() - 1).getVari().equals(kortti.getVari())) {
                    if ((poytaPino.get(poytaPino.size() - 1).getArvo()) == (kortti.getArvo() + 1)) {
                        poytaPino.get(poytaPino.size() - 1).kaanna();
                        return true;
                    }
                } 
            }
            return false;
        }    
    }
    
    /**
     * Metodi poistaa pinon päällimmäisen kortin pinosta silloin, kun kyseinen
     * kortti voidaan sääntöjen mukaan siirtää muualle.
     * @param kortti kortti, joka siirretään muualle
     */

    public void poistaKorttiPinosta(Kortti kortti) {
        this.poytaPino.remove(kortti);
    }
}
