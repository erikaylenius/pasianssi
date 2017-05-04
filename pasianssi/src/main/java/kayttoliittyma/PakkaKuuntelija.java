package kayttoliittyma;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import java.awt.Container;

/**
 * Luokka kuuntelee pakkaan kohdistuvia hiiren klikkauksia ja huolehtii seuraavan 
 * kortin näyttämisestä.
 */

public class PakkaKuuntelija implements ActionListener {

    public JLayeredPane nakyvaPakka;
    public Container container;
    
    /**
     * Konstruktori.
     * @param container pakan sisältävä container
     * @param nakyvaPakka pakkaa visualisoiva JLabelKortti-pino
     */
    public PakkaKuuntelija(Container container, JLayeredPane nakyvaPakka) {
        this.container = container;
        this.nakyvaPakka = nakyvaPakka;
    }
    
    /**
     * Metodi siirtää pakan päällimmäisen kortin alimmaiseksi.
     * @param ae hiiren klikkaus
     */

    @Override
    public void actionPerformed(ActionEvent ae) {       
        

        JLabelKortti komponentti = (JLabelKortti) this.nakyvaPakka.getComponent(0);
        this.nakyvaPakka.setLayer(komponentti, -1);

    }
    
}
