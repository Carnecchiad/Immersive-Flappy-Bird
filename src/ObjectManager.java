import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	public ObjectManager(){
		objects = new ArrayList<GameObject>();
	}
	
	public void addObject(GameObject o){
		objects.add(o);
	}
	
	public void update(Graphics g){
		for(int i = 0; i < objects.size(); i++){
		GameObject o = objects.get(i);	
			o.update();
		}
		purgeObjects();
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}
	
	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}
	
	public void reset(){
		objects.clear();
	}
	
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				if(o1.CollisionBox.intersects(o2.CollisionBox)){
					if((o1 instanceof Bird && o2 instanceof Pipe)){
						o1.isAlive = false;
						o2.isAlive = true;
					}	
				}
			}
		}
	}
}

