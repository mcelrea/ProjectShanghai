package damien.com.Sprites;

import org.newdawn.slick.Image;


public class Bullet extends Sprite {

	public Sprite owner;
	float damage;
	
	public Bullet(Image i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
	public void update(int delta)
	{
		x += vx * delta * speed;
		y += vy * delta * speed;
	}

}
