import java.awt.Component;

import javax.swing.ImageIcon;

public class Calendar {
	private int month;
	
	private ImageIcon monthImage;
	
	public Calendar(int month) {
		this.month = month;
		switch (month) { 
        case 1: 
        	monthImage = new ImageIcon("jan.png"); 
            break; 
        case 2: 
        	monthImage = new ImageIcon("feb.png");  
            break; 
        case 3: 
        	monthImage = new ImageIcon("mar.png");  
            break; 
        case 4: 
        	monthImage = new ImageIcon("apr.png");  
            break; 
        case 5: 
        	monthImage = new ImageIcon("may.png");  
            break; 
        case 6: 
        	monthImage = new ImageIcon("jun.png");  
            break; 
        case 7: 
        	monthImage = new ImageIcon("jul.png");  
            break; 
        case 8: 
        	monthImage = new ImageIcon("aug.png"); 
            break; 
        case 9: 
        	monthImage = new ImageIcon("sep.png");  
            break; 
        case 10: 
        	monthImage = new ImageIcon("oct.png");  
            break; 
        case 11: 
        	monthImage = new ImageIcon("nov.png");  
            break; 
        case 12: 
			monthImage = new ImageIcon("dec.png");  
            break;  
        default:   
            break;
		}
	}
	
	public ImageIcon getImage() {
		return monthImage;
	}
	
	public int getMonth() {
		return month;
	}

}
