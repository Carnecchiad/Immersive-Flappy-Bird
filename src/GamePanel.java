import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage backgroundImg;
	public static BufferedImage birdImg1;
	public static BufferedImage bottomImg;
	public static BufferedImage birdImg2;
	public static BufferedImage birdImg3;
	public static String frame;
	public static BufferedImage pipeImg2;
	public static BufferedImage pipeImg;
	public static BufferedImage phoneImg;
	Timer timer;
	int speed = 2;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SCENE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = GAME_STATE;
	ObjectManager manager = new ObjectManager();
	Bird bird = new Bird(170, 0, 80, 80, 5);
	Background b = new Background();
	Bottom bottom  = new Bottom(speed);
	Pipe pipe = new Pipe(400);
	public GamePanel() {
		timer = new Timer(1000 / 55, this);
		manager.addObject(bird);
		try {
			birdImg1 = ImageIO.read(this.getClass().getResourceAsStream("Bird.png"));
			bottomImg = ImageIO.read(this.getClass().getResourceAsStream("bottom.png"));
			backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("Background.jpg"));
			pipeImg = ImageIO.read(this.getClass().getResourceAsStream("pipe.png"));
			pipeImg2 = ImageIO.read(this.getClass().getResourceAsStream("pipe2.png"));
			
			// phoneImg =
			// ImageIO.read(this.getClass().getResourceAsStream("phone.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		drawGameState(g2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateGameState();
		repaint();
	}

	// Menu State
	void updateMenuState() {

	}

	void drawMenuState(Graphics2D g) {

	}

	// Game State
	void updateGameState() {
	
		if(bird.y > 669){
			bottom.speed = 0;
		}
		pipe.update();
		bottom.update();
		manager.update();
	}

	void drawGameState(Graphics2D g) {
		
		b.draw(g);
		pipe.draw(g);
		bottom.draw(g);
		manager.draw(g);

	}

	// Scene State
	void updateSceneState() {

	}

	void drawSceneState(Graphics2D g) {

	}

	// End State
	void updateEndState() {

	}

	void drawEndState(Graphics2D g) {

	}

	void startGame() {
		timer.start();
	}

	public static void main(String[] args) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bird.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
