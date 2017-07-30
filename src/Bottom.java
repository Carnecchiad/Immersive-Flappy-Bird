import java.awt.Graphics;

public class Bottom extends GameObject{
	int x = 0;
	Bottom(){
		
	}
	void update(){
	
		x-=2;
	if(x == -50){
		x =0;
	}
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.bottomImg,x,360,550,500,null);
	}
}
