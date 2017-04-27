/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

/**
 *
 * @author eylenius
 */
public class Kortinsiirto extends MouseAdapter {
    
    private JLabelKortti valittuKortti = null;
    private JLayeredPane valittuPino = null;
    private JLayeredPane perusPino = null;
	
    private int xMuutos = 0;
    private int yMuutos = 0;

    public Kortinsiirto (JLayeredPane valittuPino, JLayeredPane perusPino) {
	
	this.valittuPino = valittuPino;
	this.perusPino = perusPino;
	
    }
        @Override
	public void mousePressed(MouseEvent me) {
		Component komponentti = valittuPino.getComponentAt(me.getPoint());
		if (komponentti != null && komponentti instanceof JLabelKortti) {
			valittuKortti = (JLabelKortti) komponentti;
			valittuPino.remove(valittuKortti);
			//valittuPino.revalidate();
			//valittuPino.repaint();
                        
        perusPino.add(valittuKortti, JLayeredPane.DRAG_LAYER);
        //perusPino.revalidate();
        //perusPino.repaint();
        xMuutos = me.getX() - valittuKortti.getX();
        yMuutos = me.getY() - valittuKortti.getY();

            }
        }


   @Override
   public void mouseReleased(MouseEvent me) {
      if (valittuKortti != null) {
         valittuPino.remove(valittuKortti);
         //valittuPino.revalidate();
         //valittuPino.repaint();

         perusPino.add(valittuKortti, 0);
         //perusPino.revalidate();
         //perusPino.repaint();
         valittuKortti = null;
      }
   }

   @Override
   public void mouseDragged(MouseEvent me) {
      if (valittuKortti != null) {
         int x = me.getX() - xMuutos;
         int y = me.getY() - yMuutos;
         valittuKortti.setLocation(x, y);
         //valittuPino.revalidate();
         //valittuPino.repaint();
      }

}
    
    
}
