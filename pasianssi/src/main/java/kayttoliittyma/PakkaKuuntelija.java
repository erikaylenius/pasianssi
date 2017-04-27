package kayttoliittyma;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import java.awt.Container;
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
    
    /**
     * Metodi siirtää pakan päällimmäisen kortin alimmaiseksi.
     * @param ae hiiren klikkaus
     */

    @Override
    public void actionPerformed(ActionEvent ae) {       
        

        JLabelKortti komponentti = (JLabelKortti) this.nakyvaPakka.getComponent(0);
        this.nakyvaPakka.setLayer(komponentti, -1);

    }
    
    /**
     * Metodi muodostaa korttia vastaavan kuvan tiedostonimen hyödyntämällä kortin tietoja.
     * @param kortti kortti, jota vastaavan kuvan tiedostonimeä haetaan
     * @return korttia vastaavan kuvan tiedostonimi
     */
}
