package damien.com.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import damien.com.Sprites.Sprite;

public class Map {
	
	Image map;
	
	public Map(Image m)
	{
		map = m;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(map, 0, 0);
	}
	
	public boolean collidingWithMap(Sprite s)
	{
		/* top left point */
		int x1 = (int) s.x;
		int y1 = (int) s.y;
		/* bottom left point */
		int x2 = (int) s.x;
		int y2 = (int) (s.y + s.image.getHeight());
		/* top right point */
		int x3 = (int) (s.x + s.image.getWidth());
		int y3 = (int) s.y;
		/* bottom right point */
		int x4 = (int) (s.x + s.image.getWidth());
		int y4 = (int) (s.y + s.image.getHeight());
		
		/* Debugging line of code, not needed */
		System.out.println("color = " + map.getColor(x1,  y1).getRed() +
				"," + map.getColor(x1,  y1).getGreen() +
				"," + map.getColor(x1,  y1).getBlue());
		
		if((map.getColor(x1, y1)).equals(new Color(255,0,255)))
		{
			return true;
		}
		if((map.getColor(x2, y2)).equals(new Color(255,0,255)))
		{
			return true;
		}
		if((map.getColor(x3, y3)).equals(new Color(255,0,255)))
		{
			return true;
		}
		if((map.getColor(x4, y4)).equals(new Color(255,0,255)))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean collideLRMap(Sprite s)
	{
		/* right middle */
		int x1 = (int) (s.x + s.image.getWidth());
		int y1 = (int) (s.y + (s.image.getHeight()/2));
		/* left middle */
		int x2 = (int) (s.x);
		int y2 = (int) (s.y + (s.image.getHeight()/2));
		
		if((map.getColor(x1, y1)).equals(new Color(255,0,255)))
		{
			return true;
		}
		if((map.getColor(x2, y2)).equals(new Color(255,0,255)))
		{
			return true;
		}
		
		return false;
	}

}





