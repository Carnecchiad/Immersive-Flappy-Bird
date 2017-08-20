import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Bird extends GameObject implements ActionListener,KeyListener {
	Random random = new Random();
	boolean shoot;
	boolean collide;
	public float stamina;
	public float stress;
	public float sanitation;
	public float fame;
	public float oxygen;
	public float robbie = 100;
	int hardWork = 1;
	int yVelocity = 0;
	int currentRotation = 0;
	int gravity = 1;
	int t = 0;
	int jumpPower = -19;
	boolean canJump;
	long startTime = -1;

	BufferedImage currentImg;
	long start = 0;
	int imageCount = 0;

	AffineTransform a = new AffineTransform();

	Bird(int x, int y, int width, int height, int speed) {
		super();
		
		stamina = 100;
		stress = 0;
		sanitation = 100;
		fame = 50;
		oxygen = 100;
		canJump = true;

		speed = 6;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		if(robbie > 100) {
			robbie = 100;
		}
		robbie += 0.983;
		robbie -= random.nextInt(3);
		if (robbie < 1) {
			gravity = 100;
		}
		if (hardWork > 1) {
			if (stress < 101) {
				stress += 1.2;
			}
		}
		if (y < 50) {
			oxygen-=8;
		}
		if(oxygen < 100) {
		oxygen += 0.4;
		}
		if (stamina < 101) {
			stamina += 0.2 * hardWork;
		}
		yVelocity += gravity;
		y += yVelocity;

		if (y > 670) {
			yVelocity = 0;

			y = 670;
			gravity = 0;
			jumpPower = 0;
			currentRotation = 0;
		}

		if (canJump = true) {

			t++;

			if (t > 23) {
				currentRotation += 6;
			}
		}
		if (currentRotation > 90) {
			currentRotation = 90;
		}
		if (startTime == -1) {
			startTime = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - startTime >= 300) {
			canJump = true;
		}
	}

	void jump() {
	if(collide == false) {
		if (oxygen > 0) {
			if (stress < 100) {
				if (stamina >= 10) {
					if (canJump) {
						yVelocity = jumpPower;
						stamina -= 10;
						canJump = false;
						startTime = -1;
						t = 0;
					}
				}
				}
			}
	}
		currentRotation = -33;

	}

	void draw(Graphics g) {
		currentImg = GamePanel.ded;
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		AffineTransform current = new AffineTransform();
		current.rotate(Math.toRadians(currentRotation), x + (width / 2), y + (height / 2));
		g2.setTransform(current);

		g2.drawImage(currentImg, x, y, width, height, null);
		
		g2.transform(old);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			currentImg = GamePanel.pipeImg;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
