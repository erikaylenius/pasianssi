package sovelluslogiikka;



import sovelluslogiikka.Kortti;
import sovelluslogiikka.Poytapino;
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
public class PoytapinoTest {
    
    public PoytapinoTest() {
    }
    
    Poytapino pino;
    
    @Before
    public void setUp() {
    
        pino = new Poytapino();    
        pino.lisaaKortti(new Kortti("hertta", "punainen", 1));
        pino.lisaaKortti(new Kortti("pata", "musta", 13));
        pino.lisaaKortti(new Kortti("risti", "punainen", 5));
        pino.alusta();
    }
   

    @Test
    public void onkoPaallimmainenKorttiOikeinpain() {
        assertEquals(true, pino.getKortti(pino.pinonKoko() - 1).onkoOikeinPain());
    }
    
    @Test
    public void onkoAlimmainenKorttiNurinpain() {
        assertEquals(false, pino.getKortti(0).onkoOikeinPain());
    }
    
    @Test
    public void lisaakoSaantojenSallimanKortinPinonPaalle() {
        Kortti kortti = new Kortti("pata", "musta", 4);
        pino.lisaaKorttiPaalle(kortti);
        assertEquals(4, pino.pinonKoko());
    }
    
    @Test
    public void jattaakoVaaranlaisenKortinLisaamattaPinonPaalle() {
        Kortti kortti = new Kortti("risti", "punainen", 2);
        pino.lisaaKorttiPaalle(kortti);
        assertEquals(3, pino.pinonKoko());
    }
    
    @Test
    public void lisaakoKuninkaanTyhjaanPinoon() {
        for (int i = 0; i < 3; i++) {
            pino.poistaKorttiPinosta(pino.getKortti(0));     
        }
        Kortti kunkku = new Kortti("pata", "musta", 13);
        pino.lisaaKorttiPaalle(kunkku);
        assertEquals(1, pino.pinonKoko());
    }
    
    @Test
    public void lisaakoMuunKuinKuninkaanTyhjaanPinoon() {
        for (int i = 0; i < 3; i++) {
            pino.poistaKorttiPinosta(pino.getKortti(0));     
        }
        
        Kortti muu = new Kortti("pata", "musta", 2);
        pino.lisaaKorttiPaalle(muu);
        assertEquals(0, pino.pinonKoko());
    }
    
    @Test
    public void voikoLisataPinoon() {
        Kortti muu = new Kortti("pata", "musta", 2);
        assertEquals(false, pino.voikoLisataPinoon(muu));
    }
    
}
