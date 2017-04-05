package sovelluslogiikka;


/**
 * Luokka jakaa kortit satunnaisessa järjestyksessä uuden pelin alkaessa, 
 * osan seitsemään eri pinoon pöydälle ja loput pakkaan. 
 */

import java.util.ArrayList;
import java.util.Collections;

public class Arpoja {
    private ArrayList<Kortti> kaikki;
    
    
    public Arpoja() {
        this.kaikki = new ArrayList<Kortti>();
    }
    
    public void alkuArvonta() {
        lisaaKaikki(this.kaikki);
        Collections.shuffle(kaikki);        
    }
        
    public Poytapino uusiPoytaPino(int maara) {
        Poytapino palautettava = new Poytapino();
        int i = 0;
        while (i < maara) {
            palautettava.lisaaKortti(kaikki.get(0));
            kaikki.remove(0);
            i++;
        }
        
        return palautettava;
    }
    
    public Pakka uusiPakka() {
        Pakka palautettava = new Pakka();
        for (int i = 0; i < 24; i++) {
            palautettava.lisaaKortti(kaikki.get(0));
            kaikki.remove(0);
        }
        
        return palautettava;
       
    }

        /* korttien kääntäminen */
       


    private void lisaaKaikki(ArrayList<Kortti> kaikki) {
        lisaa(kaikki, "pata", "musta");
        lisaa(kaikki, "risti", "musta");
        lisaa(kaikki, "hertta", "punainen");
        lisaa(kaikki, "ruutu", "punainen");

    }
    
    private void lisaa(ArrayList<Kortti> kaikki, String maa, String vari) {
        for (int i = 1; i < 14; i++) {
            kaikki.add(new Kortti(maa, vari, i));
        }
                 
    /* Testaamista auttavia metodeja: */    
        
    }
    
    public int kaikkienKorttienLkm() {
        return this.kaikki.size();
    }
    
    public ArrayList<Kortti> kaikkiKortit() {
        return this.kaikki;
    }
    
}
