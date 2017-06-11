import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.Timer;

public class Bird extends GameObject implements ActionListener{
	boolean shoot;
	public float stamina;
	public float stress;
	public float sanitation;
	public float fame;
	public float oxygen;
	int yVelocity = 0;
	int gravity = 1;
	int jumpPower =  -19;
	boolean canJump;
	long startTime = -1;
	AffineTransform a = new AffineTransform();
	Bird(int x, int y, int width, int height, int speed){
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
	void update(){
		a.rotate(1,x,y);
		yVelocity += gravity;
		y+=yVelocity;
		
		if(startTime == -1){
			startTime = System.currentTimeMillis();
		}
		if(System.currentTimeMillis() - startTime  >= 300){
			canJump = true;
		}
	}
	void jump(){
		if(canJump){
			yVelocity = jumpPower;
			canJump = false;
			startTime = -1;
		}
		
	}
	
	void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		a.rotate(1,x+(width/2),y+(height/2));
		g2.setTransform(a);
		g2.drawImage(GamePanel.birdImg, x, y, width, height, null);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
