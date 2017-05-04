package kayttoliittyma;
import sovelluslogiikka.Kortti;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Container;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Point;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

/**
 * Luokka kuuntelee hiiren klikkauksia ja määrittää niitä seuraavat toimenpiteet.
 * @author eylenius
 */

public class Kortinsiirto extends MouseAdapter {
    
    private JLabelKortti valittuKortti = null;
    private Container container;
    
    /**
     * Konstruktori.
     * @param container container, jonka sisällä hiirtä liikutellaan
     */
    
    public Kortinsiirto(Container container) {
        this.container = container;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Component komponentti = container.findComponentAt(me.getPoint());     
        //kortti "kädessä"
        if (valittuKortti != null) {       
            //tyhjä pöytäpino
            if (komponentti != null && komponentti instanceof JLayeredPanePoytaPino) {
                //jos voi lisätä pöytäpinoon
                if (((JLayeredPanePoytaPino) komponentti).getPoytaPino().voikoLisataPinoon(valittuKortti.getKortti())) {
                    JLayeredPanePoytaPino poytapino = (JLayeredPanePoytaPino) komponentti;
                    poytapino.add(valittuKortti, 0, 0);
                    valittuKortti.setBounds(0, 0, 120, 163);
                    ((JLayeredPanePoytaPino) poytapino).getPoytaPino().lisaaKortti(valittuKortti.getKortti());
                    poytapino.revalidate();
                    poytapino.repaint();
                    valittuKortti = null;
                    container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    //jos ei voi lisätä pöytäpinoon    
                } else {
                    eiVoiLisata();
                } 
            //jos ei tyhjä pino      
            } else if (komponentti != null && komponentti instanceof JLabelKortti) {
                JLayeredPane laskupaikka = (JLayeredPane) komponentti.getParent();  
                //pöytäpino, jossa jo kortteja
                if (laskupaikka instanceof JLayeredPanePoytaPino) {
                    //jos voi lisätä pöytäpinoon
                    if (((JLayeredPanePoytaPino) laskupaikka).getPoytaPino().voikoLisataPinoon(valittuKortti.getKortti())) {
                        int highestLayer = laskupaikka.highestLayer() * 40 + 40;
                        System.out.println(highestLayer);
                        laskupaikka.add(valittuKortti, laskupaikka.highestLayer() + 1, 0);
                        valittuKortti.setLocation(0, highestLayer);
                        laskupaikka.revalidate();
                        laskupaikka.repaint();
                        ((JLayeredPanePoytaPino) laskupaikka).getPoytaPino().lisaaKortti(valittuKortti.getKortti());
                        valittuKortti = null;
                        container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    //jos ei voi lisätä pöytäpinoon
                    } else {
                        eiVoiLisata();
                    }
                }
                    //peruspino, jossa jo kortteja
                if (laskupaikka instanceof JLayeredPanePerusPino) {
                    //jos voi lisätä
                    if (((JLayeredPanePerusPino) laskupaikka).getPerusPino().voikoLisataPinoon(valittuKortti.getKortti())) {
                        laskupaikka.add(valittuKortti, laskupaikka.highestLayer() + 1, 0);
                        valittuKortti.setLocation(0, 0);
                        laskupaikka.revalidate();
                        laskupaikka.repaint();
                        ((JLayeredPanePerusPino) laskupaikka).getPerusPino().lisaaPinoon(valittuKortti.getKortti());
                        valittuKortti = null;
                        container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    //jos ei voi lisätä
                    } else {
                        eiVoiLisata();
                    }
                }
            //tyhjä peruspino
            } else if (komponentti != null && komponentti instanceof JLabel) {  
                JLayeredPane laskupaikka = (JLayeredPane) komponentti.getParent();
                if (laskupaikka instanceof JLayeredPanePerusPino) {
                    if (((JLayeredPanePerusPino) laskupaikka).getPerusPino().voikoLisataPinoon(valittuKortti.getKortti())) {
                        laskupaikka.add(valittuKortti, laskupaikka.highestLayer() + 1, 0);
                        valittuKortti.setLocation(0, 0);
                        laskupaikka.revalidate();
                        laskupaikka.repaint();
                        container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ((JLayeredPanePerusPino) laskupaikka).getPerusPino().lisaaPinoon(valittuKortti.getKortti());
                        valittuKortti = null;
                    } else {
                        eiVoiLisata();
                    }
                }
            //jos kädessä olevaa korttia yritetään siirtää "ei minnekään"    
            } else {
                eiVoiLisata();
            }
        //poimitaan "kortti"
        } else {
            if (komponentti != null && komponentti instanceof JLabelKortti) {
                valittuKortti = (JLabelKortti) komponentti;
                //normaali tapaus   
                if (valittuKortti.oikeinPain()) {
                    JLayeredPane pino = (JLayeredPane) valittuKortti.getParent();
                    valittuKortti.setAiempiPaikka(pino);
                    valittuKortti.setAiempiSijainti(valittuKortti.getBounds());
                    if (valittuKortti.oikeinPain()) {
                        pino.remove(valittuKortti);
                        if (pino instanceof JLayeredPanePoytaPino) {
                            ((JLayeredPanePoytaPino) pino).getPoytaPino().poistaKorttiPinosta(valittuKortti.getKortti());
                        }
                        if (pino instanceof JLayeredPanePerusPino) {
                            ((JLayeredPanePerusPino) pino).getPerusPino().poistaPinosta(valittuKortti.getKortti());
                        }
                        pino.revalidate();
                        pino.repaint();
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
                        ImageIcon kursoriImageIcon = (ImageIcon) valittuKortti.getIcon();
                        Image kursoriImage = kursoriImageIcon.getImage();
                        Cursor kursori = toolkit.createCustomCursor(kursoriImage, new Point(60, 80), "korttikursori");
                        container.setCursor(kursori);
                    } else {
                        valittuKortti = null;
                    }
                // nurin päin olevan kortin kääntäminen
                } else {
                    JLayeredPane pino = (JLayeredPane) valittuKortti.getParent();
                    int kerros = pino.getLayer(valittuKortti);
                    int ylin = pino.highestLayer();
                            
                    if (kerros == ylin) {
                        valittuKortti.getKortti().kaanna();
                        Rectangle kortinPaikka = valittuKortti.getBounds();
                        Kortti kortti = valittuKortti.getKortti();
                        pino.remove(valittuKortti);
                        pino.revalidate();
                        pino.repaint();
                        String tiedostonimi = getTiedostoNimi(kortti);
                        InputStream is = getClass().getClassLoader().getResourceAsStream(tiedostonimi);

                        try {
                            ImageIcon kuvaKortista = new ImageIcon(ImageIO.read(is));
                            valittuKortti.setIcon(kuvaKortista);
                            pino.add(valittuKortti);
                            valittuKortti.setBounds(kortinPaikka);
                            pino.revalidate();
                            pino.repaint();
                        } catch (Exception e) {
                        }
                    }
                    valittuKortti = null;
                }
            } 
        }
    }
    
    /**
     * Metodi palauttaa kortin alkuperäiseen paikkaan ja kursorin normaaliksi, jos korttia ei voi
     * lisätä haluttuun paikkaan.
     */  
    
    public void eiVoiLisata() {
        valittuKortti.getAiempiPaikka().add(valittuKortti);   
        if (valittuKortti.getAiempiPaikka() instanceof JLayeredPanePoytaPino) {
            valittuKortti.setBounds(valittuKortti.getAiempiSijainti());
            ((JLayeredPanePoytaPino) valittuKortti.getAiempiPaikka()).getPoytaPino().lisaaKortti(valittuKortti.getKortti());
        }
        valittuKortti = null;
        container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Metodi muodostaa kuvan tiedostonimen kortin ominaisuuksien perusteella.
     * @param kortti kortti, jolle haetaan kuvaa
     * @return tiedostonimi tekstinä
     */
    
    public String getTiedostoNimi(Kortti kortti) {
        String tiedostonimi = "kortit/" + kortti.getMaa() + kortti.getArvo() + ".png";
        return tiedostonimi;
    }   
}