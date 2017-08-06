import java.awt.Graphics;

public class Background extends GameObject{
	
	Background(){
		
	}
	void update(){
		
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.backgroundImg, 0,0,600,900,null);
	}
}
