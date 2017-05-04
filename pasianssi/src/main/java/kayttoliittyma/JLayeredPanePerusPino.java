
package kayttoliittyma;

import sovelluslogiikka.Peruspino;

import javax.swing.JLayeredPane;

/**
 * Luokka erottaa peruspinoja visualisoivat pinot muista pinoista, jotta 
 * Kortinsiirto-kuuntelija toimisi niiden tapauksessa määrätyllä tavalla.
 */

public class JLayeredPanePerusPino extends JLayeredPane {
    
    private Peruspino peruspino;
    
    /**
     * Konstruktori.
     * @param peruspino peruspino, jota kyseinen JLayeredPanePerusPino visualisoi
     */
    
    public JLayeredPanePerusPino(Peruspino peruspino) {
        super();
        this.peruspino = peruspino;
    }
    
    public Peruspino getPerusPino() {
        return this.peruspino;
    }
}
