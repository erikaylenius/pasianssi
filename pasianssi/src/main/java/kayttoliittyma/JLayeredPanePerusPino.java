
package kayttoliittyma;

import sovelluslogiikka.Peruspino;

import javax.swing.JLayeredPane;

public class JLayeredPanePerusPino extends JLayeredPane {
    
    private Peruspino peruspino;
    public JLayeredPanePerusPino(Peruspino peruspino) {
        super();
        this.peruspino = peruspino;
    }
    
    public Peruspino getPerusPino() {
        return this.peruspino;
    }
}
