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
import javax.swing.Icon;
import java.awt.Point;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

public class Kortinsiirto extends MouseAdapter {
    
    private JLabelKortti valittuKortti = null;
    private JLayeredPane valittuPino = null;
    private JLayeredPane perusPino = null;
    private Container container;
	

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
                        //copypaste
                        valittuKortti.getAiempiPaikka().add(valittuKortti);
    //TÄÄ                    
                        if (valittuKortti.getAiempiPaikka() instanceof JLayeredPanePoytaPino) {
                            valittuKortti.setBounds(valittuKortti.getAiempiSijainti());
                            ((JLayeredPanePoytaPino) valittuKortti.getAiempiPaikka()).getPoytaPino().lisaaKortti(valittuKortti.getKortti());
                        }
                        valittuKortti = null;
                        container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    } 
                }
                    
                //jos ei tyhjä pöytäpino  
                else if (komponentti != null && komponentti instanceof JLabelKortti) {
                        
                    JLayeredPane laskupaikka = (JLayeredPane) komponentti.getParent();
                    
                    //poytapino, jossa jo kortteja
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
        //TÄÄ                
                        //jos ei voi lisätä pöytäpinoon
                        } else {
                            //copypaste
                            valittuKortti.getAiempiPaikka().add(valittuKortti);
                                if (valittuKortti.getAiempiPaikka() instanceof JLayeredPanePoytaPino) {
                            valittuKortti.setBounds(valittuKortti.getAiempiSijainti());
                            ((JLayeredPanePoytaPino) valittuKortti.getAiempiPaikka()).getPoytaPino().lisaaKortti(valittuKortti.getKortti());
                        }
                           
                            valittuKortti = null;
                            container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }
                    }
                    
                    //peruspino, jossa jo kortteja
                    //jos voi lisätä
                    if (laskupaikka instanceof JLayeredPanePerusPino) {
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
                            //copypaste
                            valittuKortti.getAiempiPaikka().add(valittuKortti);
                            valittuKortti.setBounds(valittuKortti.getAiempiSijainti());
                            valittuKortti = null;
                            container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
                                //copypaste
                                valittuKortti.getAiempiPaikka().add(valittuKortti);
                                valittuKortti.setBounds(valittuKortti.getAiempiSijainti());
                                valittuKortti = null;
                                container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            }
                        }
                        
                    }

                //poimitaan "kortti"
                } else {
                
                    if (komponentti != null && komponentti instanceof JLabelKortti) {
                    
			valittuKortti = (JLabelKortti) komponentti;

                        //normaali    
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
        
        
        public String getTiedostoNimi(Kortti kortti) {
        String tiedostonimi = "kortit/" + kortti.getMaa() + kortti.getArvo() + ".png";
        return tiedostonimi;
    }       
}


