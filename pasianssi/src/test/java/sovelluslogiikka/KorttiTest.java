/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Kortti;
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
public class KorttiTest {
    
    public KorttiTest() {
    }
    
    Kortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Kortti("hertta", "punainen", 3);
    }
    
    
    @Test
    public void onkoOikeinPain() {
        assertEquals(true, kortti.onkoOikeinPain());
    }
    
    @Test
    public void kaantyyko() {
        kortti.kaanna();
        assertEquals(false, kortti.onkoOikeinPain());
    }
    
    
    


}
