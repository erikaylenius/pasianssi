/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author eylenius
 */
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
        
    }
    

    
    public boolean peliLapi() {
        if (this.ekaPino.pinoValmis() && this.tokaPino.pinoValmis() 
                && this.kolmasPino.pinoValmis() && this.neljasPino.pinoValmis()) {
            return true;
        }    
    
        return false;
    }
}
