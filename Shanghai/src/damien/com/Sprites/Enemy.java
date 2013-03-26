package damien.com.Sprites;

import org.newdawn.slick.Image;

import damien.com.Map.Map;
import damien.com.States.Gameplay;

public class Enemy extends Sprite{
	
	public boolean grounded = false;
	
	public Enemy(Image i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	public void act(int delta, Map map)
	{
		/*
		 * Gravity Code
		 */
		if(!map.collidingWithMap(this))
		{
			y+=Gameplay.GRAVITY*delta;
		}
		else
		{
			grounded = true;
		}
	}

}
