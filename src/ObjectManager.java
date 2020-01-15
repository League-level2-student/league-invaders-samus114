import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
ArrayList<Alien> Aliens = new ArrayList<Alien>();
Random random = new Random();
ObjectManager(Rocketship rocket){
	this.rocket = rocket;
}
void addProjectile(Projectile p) {
	Projectiles.add(p);
}
void addAlien() {
	Aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update(){
	for (int i = 0; i < Aliens.size(); i++) {
		Aliens.get(i).update();
	}
}
void draw(Graphics g){
	rocket.draw(g);
	for (int i = 0; i < Aliens.size(); i++) {
		Aliens.get(i);
	}
	for (int i = 0; i < Projectiles.size(); i++) {
		Projectiles.get(i);
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
}