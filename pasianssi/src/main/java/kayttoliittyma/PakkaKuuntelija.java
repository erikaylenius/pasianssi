/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 *
 * @author eylenius
 */
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import java.awt.Container;
import sovelluslogiikka.Kortti;
import sovelluslogiikka.Peli;

public class PakkaKuuntelija implements ActionListener {

public JLayeredPane nakyvaPakka;
public Peli peli;
public Container container;


    public PakkaKuuntelija(Container container, JLayeredPane nakyvaPakka, Peli peli) {
        this.container = container;
        this.nakyvaPakka = nakyvaPakka;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {       
        

        JLabelKortti komponentti = (JLabelKortti) this.nakyvaPakka.getComponent(0);
            this.nakyvaPakka.setLayer(komponentti, -1);

        }
    
    
        public String getTiedostoNimi(Kortti kortti) {
        String tiedostonimi = "kortit/" + kortti.getMaa() + kortti.getArvo() + ".png";
        return tiedostonimi;
    }
}
