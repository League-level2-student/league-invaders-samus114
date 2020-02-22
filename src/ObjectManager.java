import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> Aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile p) {
		Projectiles.add(p);
	}

	void addAlien() {
		Aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).update();
		}
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).update();
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).draw(g);
		}
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).draw(g);
		}

	}

	void purgeObjects() {
		for (int i = 0; i < Aliens.size(); i++) {
			if (Aliens.get(i).isActive == false) {
				Aliens.remove(i);
			}
		}
		for (int i = 0; i < Projectiles.size(); i++) {
			if (Projectiles.get(i).isActive == false) {
				Projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < Aliens.size(); i++) {
			if (Aliens.get(i).collisionBox.intersects(rocket.collisionBox)) {
				rocket.isActive = false;
			}
			for (int j = 0; j < Projectiles.size(); j++) {
				if (Projectiles.get(j).collisionBox.intersects(Aliens.get(i).collisionBox)) {
					Aliens.get(i).isActive = false;
					Projectiles.get(j).isActive = false;
					score++;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	 int getScore() {
		return score;
	}
}