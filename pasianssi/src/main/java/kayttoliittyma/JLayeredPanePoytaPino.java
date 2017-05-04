
package kayttoliittyma;

/**
 * Luokka yhdistää pöytäpinoa visualisoivan JLayeredPanen siihen liittyvään pöytäpinoon, jotta
 * kyseisen pöytäpinon tilaa päästäisiin muokkaamaan käyttöliittymän kautta hiirtä käyttämällä. 
 * Tällöin sovelluslogiikalla on ajantasaista tietoa käyttöliittymässä näkyvien pöytäpinojen
 * tilanteesta, jolloin sovelluslogiikkaan kirjatut pelin säännöt toimivat myös pelin edetessä.
 */

import sovelluslogiikka.Poytapino;

import javax.swing.JLayeredPane;

public class JLayeredPanePoytaPino extends JLayeredPane {
    
    private Poytapino poytapino;
    
    /**
     * Konstruktori.
     * @param poytapino pöytäpino, jota JLayeredPane visualisoi
     */
    
    public JLayeredPanePoytaPino(Poytapino poytapino) {
        super();
        this.poytapino = poytapino;
    }
    
    /**
     * Metodi, jolla päästään käsiksi JLayeredPanen visualisoimaan pöytäpinoon.
     * @return pöytäpino
     */
    
    public Poytapino getPoytaPino() {
        return this.poytapino;
    }
}
