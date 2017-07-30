import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bird extends GameObject implements ActionListener {
	boolean shoot;
	public float stamina;
	public float stress;
	public float sanitation;
	public float fame;
	public float oxygen;
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
	
		yVelocity += gravity;
		y += yVelocity;
		
		if(y>467){
			yVelocity = 0;
			
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
		if (canJump) {
			yVelocity = jumpPower;
			canJump = false;
			startTime = -1;
			t = 0;
		}
		currentRotation = -33;

	}

	void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		AffineTransform current = new AffineTransform();
		current.rotate(Math.toRadians(currentRotation), x + (width / 2), y + (height / 2));
		g2.setTransform(current);

		g2.drawImage(GamePanel.birdImg1, x, y, width, height, null);

		g2.transform(old);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
