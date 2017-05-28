import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	boolean isAlive;
	Rectangle CollisionBox;
	int x; 
	int y;
	int width;
	int height;
	
	GameObject(){
		isAlive = true;
		CollisionBox = new Rectangle(x,y,width,height);
		
	}
	void update(){
		CollisionBox.setBounds(CollisionBox);
	}
	void draw(Graphics g){
		
	}
	
	//Getters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	
	//Setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
}
