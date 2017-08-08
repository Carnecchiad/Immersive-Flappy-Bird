import java.awt.Graphics;
import java.util.Random;

public class Pipe extends GameObject{
		int x;
		int y = 450;
		Random random = new Random();
		Pipe(int x){
			x = this.x;
		}
		void update(){
			System.out.println(y);
			x-=2;
			if(x < -110) {
				x = 650;
				y = random.nextInt(330) + 350;
			}
		}
		void draw(Graphics g){
			 g.drawImage(GamePanel.pipeImg, x, y, 100,400,null);
			 g.drawImage(GamePanel.pipeImg2, x, y-650,100,400, null);
		}
}