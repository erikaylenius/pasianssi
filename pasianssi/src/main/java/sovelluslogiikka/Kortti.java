package sovelluslogiikka;


/**
 *
 * @author eylenius
 */
public class Kortti {

    private String maa;
    private String vari;
    private int arvo;
    private boolean oikeinPain;

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
    
    public boolean onkoOikeinPain() {
        return this.oikeinPain;
    }
    
    public void kaanna() {
        if (this.oikeinPain) {
            this.oikeinPain = false;
        } else {
            this.oikeinPain = true;
        }
    }
}
