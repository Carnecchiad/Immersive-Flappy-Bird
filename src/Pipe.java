import java.awt.Graphics;
import java.util.Random;

public class Pipe extends GameObject{
		int x;
		int speed = 2;
		int y = 450;
		Random random = new Random();
		Pipe(int x){
			this.x = x;
		}
		void update(){
			
			x-=speed;
			if(x < -110) {
				x = 650;
				y = random.nextInt(330) + 350;
			}
		}
		void draw(Graphics g){
			 g.drawImage(GamePanel.pipeImg, x, y, 100,400,null);
			 g.drawImage(GamePanel.pipeImg2, x, y-700,100,400, null);
		}
}