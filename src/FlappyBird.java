import javax.swing.JFrame;

public class FlappyBird {
	JFrame frame;
	GamePanel panel;
	public static final int width = 600;
	public static final int height = 900;

	FlappyBird() {
		frame = new JFrame();
		panel = new GamePanel();

		frame.addKeyListener(panel);
		setup();

	}

	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.add(panel);
		panel.startGame();
	}

	public static void main(String[] args) {
		FlappyBird game = new FlappyBird();
	}
}
