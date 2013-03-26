package damien.com.Sprites;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import damien.com.Map.Map;

public class Grounder extends Enemy{

	public Grounder(Image i) {
		super(i);
	}//end constructor

	@Override
	public void act(int delta, Map map)
	{
		/*
		 * Make a Grounder act like a normal
		 * Enemy first, if he has never
		 * landed before: apply gravity
		 */
		if(grounded == false)
			super.act(delta, map);
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

}//end class Grounder
