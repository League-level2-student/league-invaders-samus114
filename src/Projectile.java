import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 10;
	}

	void update() {
		super.update();
		y -= speed;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
