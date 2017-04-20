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
 * @author eylenius
 */
public class PakkaTest {
    
    public PakkaTest() {
    }
    
    Pakka pakka;
    
    @Before
    public void setUp() {
        pakka = new Pakka();
        pakka.lisaaKortti(new Kortti("hertta", "punainen", 2));
        pakka.lisaaKortti(new Kortti("pata", "musta", 4));
        pakka.lisaaKortti(new Kortti("risti", "punainen", 8));
    }
    
    @Test
    public void onkoOikeaKorttiPaallimmainen() {    
        assertEquals(pakka.getPaallimmainen().getMaa(), "risti");
    }
    
    @Test
    public void siirtyykoSeuraavaanJosPakkaLopussa() {
        pakka.naytaSeuraava();
        assertEquals(pakka.getPaallimmainen().getMaa(), "hertta");
        
    }
    
    public void siirtyykoSeuraavaanPakanKeskella() {
        pakka.naytaSeuraava();
        pakka.naytaSeuraava();
        assertEquals(pakka.getPaallimmainen().getMaa(), "pata");
        
    }
    
    public void onkoKortitOikeinPain() {
        assertEquals(pakka.getPakka().get(0).onkoOikeinPain(), "true");
        
    }
}