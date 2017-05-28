import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener , KeyListener{
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SCENE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = MENU_STATE;
	
	public GamePanel(){
		timer = new Timer(1,this);
		
	}
	
	//Menu State
	void updateMenuState(){
		
	}
	void drawMenuState(Graphics g){
		
	}
	
	//Game State
	void updateGameState(){
		
	}
	void drawGameState(Graphics g){
		
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
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
}
