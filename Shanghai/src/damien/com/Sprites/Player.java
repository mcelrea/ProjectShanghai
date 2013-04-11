package damien.com.Sprites;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import damien.com.Camera.Camera;

public class Player extends Sprite{
	
	public int health;

	public Player(Image i) {
		super(i);
		
		health = 300;
	}

	public Bullet shootBullet(int locx, int locy, Camera camera) throws SlickException
	{
		Bullet b = new Bullet(new Image("images/sprite_bullet.png"));
		b.x = this.x;
		b.y = this.y;
		b.alive = true;
		b.angle = (float) computeAngleBetweenPoints(locx+camera.viewPort.getX()-400, locy, b.x, b.y) - 180;
		b.vx = calcAngleMoveX(b.angle);
		b.vy = calcAngleMoveY(b.angle);
		b.image.setRotation(b.angle-180);
		b.speed = 1.0f;
		b.owner = this;
		b.damage = 0.5f;
		
		return b;
	}
}
