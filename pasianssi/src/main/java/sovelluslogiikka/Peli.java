
package sovelluslogiikka;

/**
 * Luokka luo ja hallinnoi pelissä tarvittavia korttipinoja ja -pakkoja, sekä
 * määrittää, milloin peli on läpäisty.
 */

import java.util.ArrayList;

public class Peli {

    private Arpoja korttienJako;
    private Peruspino ekaPino;
    private Peruspino tokaPino;
    private Peruspino kolmasPino;
    private Peruspino neljasPino;
    private Poytapino yksiAlussa;
    private Poytapino kaksiAlussa;
    private Poytapino kolmeAlussa;
    private Poytapino neljaAlussa;
    private Poytapino viisiAlussa;
    private Poytapino kuusiAlussa;
    private Poytapino seitsemanAlussa;
    private Pakka pakka;
    public Kortti valittuKortti;
    
    /**
     * Konstruktori, joka alustaa pelin ja luo kaikki pelin pinot käyttäen apunaan Arpoja-luokkaa.
     */
    
    public Peli() {
        
        this.korttienJako = new Arpoja();
        
        this.ekaPino = new Peruspino();
        this.tokaPino = new Peruspino();
        this.kolmasPino = new Peruspino();
        this.neljasPino = new Peruspino();
        
        korttienJako.alkuArvonta();
        
        this.yksiAlussa = korttienJako.uusiPoytaPino(1);
        this.kaksiAlussa = korttienJako.uusiPoytaPino(2);
        this.kolmeAlussa = korttienJako.uusiPoytaPino(3);
        this.neljaAlussa = korttienJako.uusiPoytaPino(4);
        this.viisiAlussa = korttienJako.uusiPoytaPino(5);
        this.kuusiAlussa = korttienJako.uusiPoytaPino(6);
        this.seitsemanAlussa = korttienJako.uusiPoytaPino(7);
        
        this.pakka = korttienJako.uusiPakka();
        
        this.valittuKortti = null;
        
    }
    
    public void setValittuKortti(Kortti kortti) {
        this.valittuKortti = kortti;
    }
    
    /**
     * Metodi siirtää kortin peruspinoon, mikäli säännöt sallivat.
     * @param kohde peruspino, johon korttia yritetään siirtää
     */
    
    public void siirraKorttiPerusPinoon(Peruspino kohde) {
        for (Poytapino poytaPino : this.getPoytaPinot()) {
            if (poytaPino.getPoytaPino().contains(valittuKortti)) {
                this.siirraPoytaPinosta(poytaPino, kohde);
            }
        }       
        if (this.pakka.getPakka().contains(valittuKortti)) {
            this.siirraPakasta(kohde);
        }
    }
    
    /**
     * Metodin siirraKorttiPerusPinoon apumetodi, jota kutsutaan, jos valittu kortti 
     * sijaitsee jossain pöytäpinossa.
     * @param poytaPino pöytapino, jossa valittu kortti sijaitsee
     * @param kohde peruspino, johon korttia yritetään siirtää
     */
    
    private void siirraPoytaPinosta(Poytapino poytaPino, Peruspino kohde) {
        kohde.lisaaPinoon(valittuKortti);
        if (kohde.voikoLisataPinoon(valittuKortti)) {
            poytaPino.poistaKorttiPinosta(valittuKortti);
        }
        
    }
    
    /**
     * Metodin siirraKorttiPerusPinoon apumetodi, jota kutsutaan, jos valittu kortti
     * sijaitsee pakassa.
     * @param kohde peruspino, johon korttia yritetään siirtää
     */
    
    private void siirraPakasta(Peruspino kohde) {
        kohde.lisaaPinoon(valittuKortti);
        if (kohde.voikoLisataPinoon(valittuKortti)) {
            this.pakka.poistaPakasta(valittuKortti);
        }      
    }
    
    public Pakka getPakka() {
        return this.pakka;
    }
    
    /**
     * Metodi palauttaa kaikki pelin arvotut pöytäpinot ArrayListina.
     * @return pöytäpinot sisältävä ArrayList
     */
    
    public ArrayList<Poytapino> getPoytaPinot() {
        ArrayList<Poytapino> palautettava = new ArrayList<>();
        palautettava.add(yksiAlussa); 
        palautettava.add(kaksiAlussa);
        palautettava.add(kolmeAlussa); 
        palautettava.add(neljaAlussa);
        palautettava.add(viisiAlussa); 
        palautettava.add(kuusiAlussa);
        palautettava.add(seitsemanAlussa);
        return palautettava;
    }
    
    /**
     * Metodi palauttaa kaikki pelin arvotut peruspinot ArrayListina.
     * @return peruspinot sisältävä ArrayList
     */
    
    public ArrayList<Peruspino> getPerusPinot() {
        ArrayList<Peruspino> palautettava = new ArrayList<>();
        palautettava.add(ekaPino); 
        palautettava.add(tokaPino);
        palautettava.add(kolmasPino); 
        palautettava.add(neljasPino);
        return palautettava;
    }
    
}
