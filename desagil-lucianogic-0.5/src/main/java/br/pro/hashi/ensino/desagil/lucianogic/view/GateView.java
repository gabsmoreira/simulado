package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.net.URL;
import java.awt.event.MouseListener; 
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.model.Switch;


public class GateView extends FixedPanel implements ItemListener, MouseListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	private Image image;

	private JCheckBox[] inBoxes;
	private JCheckBox outBox;

	private Switch[] switches;
	boolean on_1;
	boolean on_2;
	boolean on_3;
	private Gate gate;


	public GateView(Gate gate) {
		super(220, 180);

		this.gate = gate;

		image = loadImage(gate.toString());

		int size = gate.getSize();

		inBoxes = new JCheckBox[size];

		switches = new Switch[size];

		for(int i = 0; i < size; i++) {
			inBoxes[i] = new JCheckBox();

			inBoxes[i].addItemListener(this);

			switches[i] = new Switch();

			gate.connect(switches[i], i);
		}

		outBox = new JCheckBox();

		outBox.setEnabled(false);
		this.addMouseListener(this);

		//if(size == 1) {
			//add(inBoxes[0], 0, 60, 20, 20);			
		//}
		//else {
			//for(int i = 0; i < size; i++) {
				//add(inBoxes[i], 0, (i + 1) * 40, 20, 20);			
			//}			
		//}

		add(outBox, 194, 60, 20, 20);

		outBox.setSelected(gate.read());
	}


	@Override
	public void itemStateChanged(ItemEvent event) {
		int i;
		for(i = 0; i < inBoxes.length; i++) {
			if(inBoxes[i] == event.getSource()) {
				break;
			}
		}

		switches[i].setOn(inBoxes[i].isSelected());

		outBox.setSelected(gate.read());
	}


	// Necessario para carregar os arquivos de imagem.
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	@Override
	public void paintComponent(Graphics g) {
		// Evita bugs visuais em alguns sistemas operacionais.
		super.paintComponent(g);

		g.drawImage(image, 20, 20, 184, 140, null);
		if (gate.getSize() == 2){
			g.fillArc(12, 50, 10, 10, 0, 180);
			g.fillArc(12, 90, 10, 10, 0, 180);

			if ((switches[0].read() == false) && (switches[1].read() == false)){
				int angle = 60; 
	
				//Second Lever
				
			    int startX = 7;
			    int startY = 75;
			    int length = 20 ;
	
			    int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
			    int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
	
			    g.drawLine(startX, startY, endX, endY);
				g.fillOval(2,70,6,6);

      // First Lever
  
  int angle_2 = 60; 

    int startX_2 = 7;
    int startY_2 = 35;
    int length_2 = 20 ;

    int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
    int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);

    g.drawLine(startX_2, startY_2, endX_2, endY_2);
  g.fillOval(2,30,6,6);

  }
if ((switches[1].read() == true) && (switches[0].read() == true)){

        // First Lever

      int angle_2 = 120; 

      int startX_2 = 27;
      int startY_2 = 35;
      int length_2 = 20 ;

      int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
      int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);

      g.drawLine(startX_2, startY_2, endX_2, endY_2);
      g.fillOval(25,30,6,6);

      int angle = 120; 
      
    //Second Lever
    
      int startX = 27;
      int startY = 75;
      int length = 20 ;

      int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
      int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);

      g.drawLine(startX, startY, endX, endY);
    g.fillOval(25,70,6,6);

      }
				    
if ((switches[0].read() == true) && (switches[1].read() == false)){
		int angle = 120; 

            // First Lever

          int angle_2 = 120; 

          int startX_2 = 27;
          int startY_2 = 35;
          int length_2 = 20 ;

          int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
          int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);

          g.drawLine(startX_2, startY_2, endX_2, endY_2);
          g.fillOval(25,30,6,6);

          int angle2 = 60; 

            
            //Second Lever
  					
  				    int startX = 7;
  				    int startY = 75;
  				    int length = 20 ;
  		
  				    int endX = startX + (int)(Math.cos(Math.toRadians(angle2)) * length);
  				    int endY = startY + (int)(Math.sin(Math.toRadians(angle2)) * length);
  		
  				    g.drawLine(startX, startY, endX, endY);
  					g.fillOval(2,70,6,6);
}

    if ((switches[1].read() == true) && (switches[0].read() == false)){
              // First Lever

              int angle_2 = 60; 

              int startX_2 = 7;
              int startY_2 = 35;
              int length_2 = 20 ;

              int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
              int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);

              g.drawLine(startX_2, startY_2, endX_2, endY_2);
              g.fillOval(2,30,6,6);



              //Second Lever
              int angle = 120;
              
                int startX = 27;
                int startY = 75;
                int length = 20 ;
        
                int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
                int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
        
                g.drawLine(startX, startY, endX, endY);
              g.fillOval(25,70,6,6);

      }
		}
		
		if (gate.getSize() == 1){
		    g.fillArc(12, 70, 10, 10, 0, 180);
		    if (switches[0].read() == false){
				int angle = 60; 
	
				//First Lever
				
			    int startX = 7;
			    int startY = 55;
			    int length = 20 ;
	
			    int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
			    int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
	
			    g.drawLine(startX, startY, endX, endY);
				g.fillOval(2,50,6,6);
		    }
		    else{
		    	int angle = 120; 
		    	
				//First Lever
				
			    int startX = 27;
			    int startY = 55;
			    int length = 20 ;
	
			    int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
			    int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
	
			    g.drawLine(startX, startY, endX, endY);
				g.fillOval(25,50,6,6);
		    }
			
			}
		if (gate.getSize() == 3){
			if ((switches[2].read() == true) && (switches[1].read() == false) && (switches[0].read() == false)) {
				//First Lever
				int angle = 60;
				
			    int startX = 7;
			    int startY = 75;
			    int length = 20 ;

			    int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
			    int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
			    g.fillArc(12, 90, 10, 10, 0, 180);

			    g.drawLine(startX, startY, endX, endY);
				g.fillOval(2,70,6,6);
				
				
				// Second Lever
				
				int angle_2 = 60; 

			    int startX_2 = 7;
			    int startY_2 = 35;
			    int length_2 = 20 ;

			    int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
			    int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);
			    g.fillArc(12, 50, 10, 10, 0, 180);

			    g.drawLine(startX_2, startY_2, endX_2, endY_2);
				g.fillOval(2,30,6,6);
				
				
				
				// Third Lever
				
				int angle_3 = 120; 

			    int startX_3 = 27;
			    int startY_3 = 115;
			    int length_3 = 20 ;

			    int endX_3 = startX_3 + (int)(Math.cos(Math.toRadians(angle_3)) * length_3);
			    int endY_3 = startY_3 + (int)(Math.sin(Math.toRadians(angle_3)) * length_3);
			    g.fillArc(12, 130, 10, 10, 0, 180);

			    g.drawLine(startX_3, startY_3, endX_3, endY_3);
				g.fillOval(25,110,6,6);
				
			}
			else{
			int angle = 60; 

			//First Lever
			
		    int startX = 7;
		    int startY = 75;
		    int length = 20 ;

		    int endX = startX + (int)(Math.cos(Math.toRadians(angle)) * length);
		    int endY = startY + (int)(Math.sin(Math.toRadians(angle)) * length);
		    g.fillArc(12, 90, 10, 10, 0, 180);

		    g.drawLine(startX, startY, endX, endY);
			g.fillOval(2,70,6,6);
			
			
			// Second Lever
			
			int angle_2 = 60; 

		    int startX_2 = 7;
		    int startY_2 = 35;
		    int length_2 = 20 ;

		    int endX_2 = startX_2 + (int)(Math.cos(Math.toRadians(angle_2)) * length_2);
		    int endY_2 = startY_2 + (int)(Math.sin(Math.toRadians(angle_2)) * length_2);
		    g.fillArc(12, 50, 10, 10, 0, 180);

		    g.drawLine(startX_2, startY_2, endX_2, endY_2);
			g.fillOval(2,30,6,6);
			
			
			// Third Lever
			
						int angle_3 = 60; 

					    int startX_3 = 7;
					    int startY_3 = 115;
					    int length_3 = 20 ;

					    int endX_3 = startX_3 + (int)(Math.cos(Math.toRadians(angle_3)) * length_3);
					    int endY_3 = startY_3 + (int)(Math.sin(Math.toRadians(angle_3)) * length_3);
					    g.fillArc(12, 130, 10, 10, 0, 180);

					    g.drawLine(startX_3, startY_3, endX_3, endY_3);
						g.fillOval(2,110,6,6);
			}
			}

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }

	//@Override
	public void mouseClicked(MouseEvent e) {
	    int screenX = e.getX();
	    int screenY = e.getY();
	    System.out.println(screenX + " " +screenY);
	    
	    if (gate.getSize() == 1 ){
		    if ( screenX>=2 && screenX<= 24 ) {
		    	if ( screenY>=53  && screenY<= 74){
		    		switches[0].setOn(!switches[0].read());
		    		outBox.setSelected(gate.read());
		    	}
		    }
	    }
	    
	    if (gate.getSize() == 2 ){
		    if ( screenX>=2 && screenX<= 24 ) {
		    	if ( screenY>=73  && screenY<= 96){
		    		switches[1].setOn(!switches[1].read());
		    		outBox.setSelected(gate.read());
		    		
		    	}
		    	else if ( screenY>=31  && screenY<= 55){
		    		switches[0].setOn(!switches[0].read());
		    		outBox.setSelected(gate.read());
		    	}
		    }
	    }
	    
	    
	    if (gate.getSize() == 3 ){
		    if ( screenX>=2 && screenX<= 24 ) {
		    	if ( screenY>=73  && screenY<= 96){
		    		switches[1].setOn(!switches[1].read());
		    		outBox.setSelected(gate.read());
	
		    		
		    	}
		    	else if ( screenY>=31  && screenY<= 55){
		    		switches[0].setOn(!switches[0].read());
		    		outBox.setSelected(gate.read());

		    	}
		    	
		    	else if ( screenY>=112  && screenY<= 133){
		    		switches[2].setOn(!switches[2].read());
		    		outBox.setSelected(gate.read());
		    	}
		    }
	    }
	    
	    this.repaint();
	    
	    }
	



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
