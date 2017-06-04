import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener , KeyListener{
	public static BufferedImage birdImg;
	public static BufferedImage pipeImg;
	public static BufferedImage phoneImg;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SCENE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = GAME_STATE;
	ObjectManager manager = new ObjectManager();
	Bird bird = new Bird(0,0,70,70,5);
	public GamePanel(){
		timer = new Timer(1,this);
		manager.addObject(bird);
		try {
			birdImg = ImageIO.read(this.getClass().getResourceAsStream("bird.png"));
			pipeImg = ImageIO.read(this.getClass().getResourceAsStream("pipe.png"));
			//phoneImg = ImageIO.read(this.getClass().getResourceAsStream("phone.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void paintComponent(Graphics g){
		drawGameState(g);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		updateGameState();
		repaint();
	}
	//Menu State	
	void updateMenuState(){
		
	}
	void drawMenuState(Graphics g){
		
	}
	
	//Game State
	void updateGameState(){
		
		manager.update();
	}
	void drawGameState(Graphics g){
		manager.draw(g);
		
		
	}		
			
	//Scene State
	void updateSceneState(){
		
	}
	void drawSceneState(Graphics g){
		
	}
	
	//End State
	void updateEndState(){
		
	}
	void drawEndState(Graphics g){
		
	}
	
	void startGame(){
		 timer.start();
		}
	
	public static void main(String[] args) {
		
	}
		
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			bird.jump = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			bird.jump = false;
	}
	
	
}
