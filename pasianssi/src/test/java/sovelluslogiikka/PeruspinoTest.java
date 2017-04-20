
package sovelluslogiikka;

import sovelluslogiikka.Peruspino;
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
public class PeruspinoTest {
    
    public PeruspinoTest() {
    }
    
    Peruspino pino;
    
    @Before
    public void setUp() {
        pino = new Peruspino();
        pino.lisaaPinoon(new Kortti("hertta", "punainen", 1));
        pino.lisaaPinoon(new Kortti("hertta", "punainen", 2));
    }
    
    @Test
    public void lisaakoOikeanlaisenKortin() {
        pino.lisaaPinoon(new Kortti("hertta", "punainen", 3));
        assertEquals(3, pino.pinonKoko());
    }
    
    @Test
    public void jattaakoVaaranlaisenKortinLisaamatta() {
        pino.lisaaPinoon(new Kortti("pata", "musta", 8));
        assertEquals(2, pino.pinonKoko());
    }
    
    @Test
    public void lisaakoOikeinJosPinoTyhja() {
        pino.poistaPinosta(pino.getKortti(0));
        pino.poistaPinosta(pino.getKortti(0));
        pino.lisaaPinoon(new Kortti("pata", "musta", 1));
        assertEquals(1, pino.pinonKoko());
    }
    
    @Test
    public void jattaakoVaaranlaisenKortinLisaamattaJosPinoTyhja() {
        pino.poistaPinosta(pino.getKortti(0));
        pino.poistaPinosta(pino.getKortti(0));
        pino.lisaaPinoon(new Kortti("pata", "musta", 11));
        assertEquals(0, pino.pinonKoko());
    }
    
    @Test
    public void onkoValmiissaPinossa13Korttia() {
        for (int i = 1; i < 14; i++) {
            pino.lisaaPinoon(new Kortti("hertta", "punainen", i));
        }    
        assertEquals(13, pino.pinonKoko());    
        
    }
    
    
}

/* onkoKortitOikeinPain */
