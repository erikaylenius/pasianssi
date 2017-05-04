package sovelluslogiikka;

/**
 * Luokka määrittelee kaikkien 52 kortin ominaisuudet.
 */

public class Kortti {

    private String maa;
    private String vari;
    private int arvo;
    private boolean oikeinPain;

    
/**
 * Konstruktori.
 * @param maa kortin maa (hertta, ruutu, pata, risti)
 * @param vari kortin väri (musta tai punainen)
 * @param arvo kortin arvo, väliltä 1-13
 */ 
    
    public Kortti(String maa, String vari, int arvo) {
        
        this.maa = maa;
        this.vari = vari;
        this.arvo = arvo;
        this.oikeinPain = true;
        
    }


    public String getMaa() {
        return this.maa;
    }

    public String getVari() {
        return this.vari;
    }

    public int getArvo() {
        return this.arvo;
    }
    
    /**
     * Metodi kertoo, onko kortti kuvapuoli vai selkä ylöspäin.
     * @return onko kortti oikeinpäin
     */
    public boolean onkoOikeinPain() {
        return this.oikeinPain;
    }
    
    /**
     * Metodi kääntää kortin toisin päin.
     */
    
    public void kaanna() {
        if (this.oikeinPain) {
            this.oikeinPain = false;
        } else {
            this.oikeinPain = true;
        }
    }
}
