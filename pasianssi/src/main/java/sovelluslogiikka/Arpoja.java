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
    
    /**
     * Luo kaikki 52 korttia ja sekoittaa ne satunnaiseen järjestykseen.
     */
    
    public void alkuArvonta() {
        lisaaKaikki(this.kaikki);
        Collections.shuffle(kaikki);        
    }
    
    /**
     * Luo uuden, halutun kokoisen pöytäpinon.
     * @param maara korttien määrä pinossa
     * @return uusi, halutun määrän korteja sisältävä pöytäpino
     */  
    
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
    
    /**
     * Luo uuden pakan peliin.
     * @return uusi, 24 korttia sisältävä pakka
     */
    
    public Pakka uusiPakka() {
        Pakka palautettava = new Pakka();
        for (int i = 0; i < 24; i++) {
            palautettava.lisaaKortti(kaikki.get(0));
            kaikki.remove(0);
        }
        
        return palautettava;
       
    }

        /* korttien kääntäminen */
       

    /**
     * Metodin alkuArvonta() apumetodi. 
     * @param kaikki lista, jolle kaikki kortit tarkoitus lisätä
     */
    private void lisaaKaikki(ArrayList<Kortti> kaikki) {
        lisaa(kaikki, "pata", "musta");
        lisaa(kaikki, "risti", "musta");
        lisaa(kaikki, "hertta", "punainen");
        lisaa(kaikki, "ruutu", "punainen");

    }
    
    /**
     * Metodin lisaaKaikki() apumetodi.
     * @param kaikki lista, jolle kaikki pelin luodut kortit lisätään
     * @param maa lisättävän ja luodun uuden kortin maa
     * @param vari lisättävän ja luodun uuden kortin väri
     */
    
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
