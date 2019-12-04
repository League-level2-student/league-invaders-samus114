import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
JFrame frame;
GamePanel panel = new GamePanel();
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
	public static void main(String[] args) {
	LeagueInvaders league = new LeagueInvaders();
	league.setup();
}
	public LeagueInvaders(){
		frame = new JFrame();
	}
	void setup(){
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}
}  