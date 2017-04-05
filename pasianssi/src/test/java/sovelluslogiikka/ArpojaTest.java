/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eylenius
 */
public class ArpojaTest {
    
    public ArpojaTest() {
    }
    
    Arpoja korttienJako;
    
    @Before
    public void setUp() {
    korttienJako = new Arpoja();
    
    korttienJako.alkuArvonta();
    
    }
    
    
    @Test
    public void onkoPelissa52Korttia() {
        assertEquals(52, korttienJako.kaikkienKorttienLkm());
    }
    
    @Test
    public void onkoPelissaSamaaMaata13() {
        ArrayList<Kortti> samaaMaata = new ArrayList<>();
        for (Kortti kortti : korttienJako.kaikkiKortit()) {
            if (kortti.getMaa().equals("hertta")) {
                samaaMaata.add(kortti);
            }          
        }
        assertEquals(13, samaaMaata.size());
    }
    
    @Test
    public void onkoPelissSamanarvoisia4() {
        ArrayList<Kortti> samanArvoiset = new ArrayList<>();
        for (Kortti kortti : korttienJako.kaikkiKortit()) {
            if (kortti.getArvo() == 2) {
                samanArvoiset.add(kortti);
            }
        }
        assertEquals(4, samanArvoiset.size());
    }
    
    @Test
    public void antaakoOikeanSuuruisenPoytapinon() {
        Poytapino pino = korttienJako.uusiPoytaPino(3);
        assertEquals(3, pino.pinonKoko());
    }
    
    @Test
    public void poistaakoKortinMuidenJoukostaKunSiirrettyPoytapinoon() {
        Poytapino pino = korttienJako.uusiPoytaPino(3);
        assertEquals(49, korttienJako.kaikkienKorttienLkm());
    }
    
    @Test
    public void antaakoOikeanSuuruisenPakan() {
        Pakka pakka = korttienJako.uusiPakka();
        assertEquals(24, pakka.pakanKoko());
    }
    
   
    

/* pakassaEiKahtaSamaaKorttia(), pakanKortitOikeinPain(),
    poytaPinojenKortitOikeinPain()
    */
}
