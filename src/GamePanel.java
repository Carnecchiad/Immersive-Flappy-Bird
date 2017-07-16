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
	public static BufferedImage birdImg1;
	public static BufferedImage birdImg2;
	public static BufferedImage birdImg3;
	public static String frame;
	public static BufferedImage pipeImg;
	public static BufferedImage phoneImg;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SCENE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = GAME_STATE;
	ObjectManager manager = new ObjectManager();
	Bird bird = new Bird(170, 0, 130, 100, 5);

	public GamePanel() {
		timer = new Timer(1000 / 55, this);
		manager.addObject(bird);
		try {
			birdImg1 = ImageIO.read(this.getClass().getResourceAsStream("1.png"));
			birdImg2 = ImageIO.read(this.getClass().getResourceAsStream("2.png"));
			birdImg3 = ImageIO.read(this.getClass().getResourceAsStream("3.png"));
			pipeImg = ImageIO.read(this.getClass().getResourceAsStream("pipe.png"));
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
		manager.update();
	}

	void drawGameState(Graphics2D g) {
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
