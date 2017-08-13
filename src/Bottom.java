import java.awt.Graphics;

public class Bottom extends GameObject {
	int speed = 0;
	int x = 0;

	Bottom(int speed) {
		this.speed = speed;
	}

	void update() {

		x -= speed;
		if (x == -84) {
			x = 0;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bottomImg, x, 360, 900, 1030, null);
	}
}
