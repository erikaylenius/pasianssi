package sovelluslogiikka;

import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;

/**
 * Main-metodin sisältävä luokka, joka käynnistää pelin.
 */

public class Main {
    
    /**
     * Main-metodi.
     * @param args 
     */
    
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);     

    }
    
}
