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
    
    @Before
    public void setUp() {
        peli = new Peli();
        pino = new Peruspino();
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
    
    public int josPeliLapiAnna1JosEiAnna0() {
        if (peli.peliLapi()) {
            return 1;
        }
        
        return 0;
    }
}
