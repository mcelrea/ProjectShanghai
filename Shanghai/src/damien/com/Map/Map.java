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
		int x1 = (int) s.x;
		int y1 = (int) s.y;
		
		System.out.println("color = " + map.getColor(x1,  y1));
		
		if((map.getColor(x1, y1)).equals(new Color(255,0,255)))
		{
			return true;
		}
		
		return false;
	}

}
