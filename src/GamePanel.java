import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    Timer frameDraw;
    int currentState = MENU;
    ObjectManager object;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font subFont = new Font("Arial", Font.PLAIN, 26);
    GamePanel() {
    	frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    object = new ObjectManager(rocket);
    }
    @Override
	public void paintComponent(Graphics g) {
    	if(currentState == MENU){
    	    drawMenuState(g);
    	}else if(currentState == GAME){
    	    drawGameState(g);
    	}else if(currentState == END){
    	    drawEndState(g);
    	}
	}
    void updateMenuState() {
    	
    }
    void updateGameState() {
    	object.update();
    	
    }
    void updateEndState()  {
    	
    }
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("LEAGUE INVADERS", 25, 100);
    	g.setFont(subFont);
    	g.drawString("Press ENTER to start", 100, 300);
    	g.drawString("Press SPACE for instructions", 50, 400);
    }
    void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
object.draw(g);
    }
    void drawEndState(Graphics g)  {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setColor(Color.YELLOW);
    	g.setFont(titleFont);
    	g.drawString("GAME OVER", 100, 100);
    	g.setFont(subFont);
    	g.drawString("You killed enemies", 100, 200);
    	g.drawString("Press ENTER to restart", 80, 400);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action");
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}

repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} else if (e.getKeyCode()==KeyEvent.VK_UP) {
	    rocket.up();
	    } else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    rocket.down();
		    } else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.left();
			    } else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				    rocket.right();	
				    }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}