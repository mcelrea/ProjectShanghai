package damien.com.Sprites;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import damien.com.Map.Map;

public class Grounder extends Enemy{
	
	private long spawnDelay = 10000; //1000 = 1 second
	private long nextSpawn; //the real-life time of next grounder spawn

	public Grounder(Image i) {
		super(i);
		
		//set the first spawn to be = to the current time + the delay
		nextSpawn = System.currentTimeMillis() + spawnDelay;
	}//end constructor

	@Override
	public void act(int delta, Map map, ArrayList<Enemy> enemies, Player player) throws SlickException
	{
		/*
		 * Make a Grounder act like a normal
		 * Enemy first, if he has never
		 * landed before: apply gravity
		 */
		if(grounded == false)
			super.act(delta, map, enemies, player);
		//if he has landed and is not touching map
		else if(!map.collidingWithMap(this))
		{
			speed *= -1;
		}

		//if he hits the map on to the left or right
		if(map.collideLRMap(this))
		{
			speed *= -1;
		}

		if(grounded)
			x -= speed * delta;
		
		
	}//end method act

	//methods
	public void draw(Graphics g)
	{
		if(alive)
		{
			if(speed > 0)
				g.drawImage(image, x, y);
			else
				g.drawImage(image.getFlippedCopy(true, false), x, y);
		}//end if
		
	}//end method draw
	
	public void explode(ArrayList<Bullet> bullets) throws SlickException
	{
		for(int i=0; i < 10; i++)
		{
			Bullet b = new Bullet(new Image("images/sprite_bullet.png"));
			b.alive = true;
			b.x = x;
			b.y = y;
			b.angle = i * 36;
			b.speed = 0.4f;
			b.vx = calcAngleMoveX(b.angle);
			b.vy = calcAngleMoveY(b.angle);
			bullets.add(b);
		}//end for
	}//end explode

}//end class Grounder
