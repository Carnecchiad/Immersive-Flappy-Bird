import java.awt.Graphics;

public class Pipe extends GameObject{
		int x = 400;
		int y;
		Pipe(int y){
			this.y = y;
		}
		void update(){
			x-=2;
		}
		void draw(Graphics g){
			 g.drawImage(GamePanel.pipeImg, x, y, 100,400,null);
			 g.drawImage(GamePanel.pipeImg2, x, y-650,100,400, null);
		}
}
