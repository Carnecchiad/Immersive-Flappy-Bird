import java.awt.Graphics;

public class Bird extends GameObject {
	boolean jump;
	boolean shoot;
	public float stamina;
	public float stress;
	public float sanitation;
	public float fame;
	public float oxygen;
	
	Bird(int x, int y, int width, int height, int speed){
		super();
		stamina = 100;
		stress = 0;
		sanitation = 100;
		fame = 50;
		oxygen = 100;
		
		speed = 6;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update(){
		super.update();
		y+=1;
		if(jump){
		y-=2;	
		}
		if(stamina<101){
			stamina+=0.1;
		}
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.birdImg, x, y, width, height, null);

	}
}
