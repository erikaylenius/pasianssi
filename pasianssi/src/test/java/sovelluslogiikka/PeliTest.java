/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class PeliTest {
    
    public PeliTest() {
    }
    
    Peli peli;
    Peruspino pino;
    Poytapino poytapino;
    
    @Before
    public void setUp() {
        peli = new Peli();
        pino = new Peruspino();
        poytapino = new Poytapino();
    }
    
    @Test
    public void pakkaOlemassa() {
        assertTrue(peli.getPakka() != null);
    }
    
    @Test
    public void kaikkiPoytaPinotOlemassa() {
        assertEquals(7, peli.getPoytaPinot().size());
    }
    
    @Test
    public void kaikkiPerusPinotOlemassa() {
        assertEquals(4, peli.getPerusPinot().size());
    }
    
    
    @Test
    public void siirtaakoKortinPakastaPerusPinoonOikein() {
        Kortti kortti = null;
        while (true) {
            if (peli.getPakka().getPaallimmainen().getArvo() == 1) {
                kortti = peli.getPakka().getPaallimmainen();
                break;
            }
            peli.getPakka().naytaSeuraava();
        }
        
        peli.setValittuKortti(kortti);
        peli.siirraKorttiPerusPinoon(peli.getPerusPinot().get(0));
        assertEquals(1, peli.getPerusPinot().get(0).pinonKoko());
    }
    
}
