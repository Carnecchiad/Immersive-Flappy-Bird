import java.awt.Color;
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
	public static BufferedImage jones;
	public static BufferedImage ded;
	public static String frame;
	public static BufferedImage pipeImg2;
	public static BufferedImage pipeImg;
	public static BufferedImage phoneImg;
	Color brown= new Color(139,69,19);
	Timer timer;
	int speed = 2;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SCENE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = 1;
	ObjectManager manager = new ObjectManager();
	Bird bird = new Bird(170, 100, 150, 100, 5);
	Background b = new Background();
	
	Bottom bottom = new Bottom(speed);
	Pipe pipe = new Pipe(380);
	Pipe pipe2 = new Pipe(0);

	public GamePanel() {
		timer = new Timer(1000 / 55, this);
		manager.addObject(bird);
		try {
			ded = ImageIO.read(this.getClass().getResourceAsStream("fat.png"));
			jones = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
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
		
		if (bird.y > 669) {
			bottom.speed = 0;
			bird.collide = true;
		}
		if (bird.y > pipe.y - 50 && bird.x > pipe.x - 65 && bird.x < pipe.x + 65) {
			pipe.speed = 0;
			pipe2.speed = 0;
			bottom.speed = 0;
			CURRENT_STATE = 3;
			bird.collide = true;
		}
		if (bird.y < pipe.y - 340 && bird.x > pipe.x - 65 && bird.x < pipe.x + 65) {
			pipe.speed = 0;
			pipe2.speed = 0;
			bottom.speed = 0;
			CURRENT_STATE = 3;
		}
		if (bird.y > pipe2.y - 50 && bird.x > pipe2.x - 65 && bird.x < pipe2.x + 65) {
			pipe.speed = 0;
			pipe2.speed = 0;
			bottom.speed = 0;
			CURRENT_STATE = 3;
			bird.collide = true;
		}
		if (bird.y < pipe2.y - 340 && bird.x > pipe2.x - 65 && bird.x < pipe2.x + 65) {
			pipe.speed = 0;
			pipe2.speed = 0;
			bottom.speed = 0;
			CURRENT_STATE = 3;
			bird.collide = true;
		}

		pipe.update();
		pipe2.update();
		bottom.update();
		manager.update();
	}

	void drawGameState(Graphics2D g) {
		
		b.draw(g);
		pipe.draw(g);
		pipe2.draw(g);
		bottom.draw(g);
		g.drawString("Indefatigability", 40, 795);
		g.drawRect(40,800,100,30);
		;
		g.fillRect(40, 800, (int) bird.stamina, 30);
		g.drawString("Serendipity", 40, 845);
		g.drawRect(40,850,100,30);
		g.fillRect(40, 850, (int)bird.robbie, 30);
		g.drawString("Accentuation", 150, 795);
		g.drawRect(150,800,100,30);
		g.fillRect(150, 800, (int)bird.stress, 30);
		g.drawString("Oxygen", 150, 845);
		g.drawRect(150,850,100,30);
		g.fillRect(150, 850, (int)bird.oxygen, 30);
		g.setColor(brown);
		g.drawString("Hold Enter to increase", 300, 820);
		g.drawString("Indefatigability and Accentuation", 300, 840);
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
		b.draw(g);
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
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			bird.hardWork = 4;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			bird.hardWork = 1;
		}
	}
}
