package damien.com.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import damien.com.Sprites.Sprite;

public class Map {
	
	public TiledMap map;
	
	public Map(String s) throws SlickException
	{
		map = new TiledMap(s);
	}
	
	public void draw(Graphics g)
	{
		map.render(0, 0);
	}
	
	
	public boolean collidingWithMap(Sprite s)
	{
		//top left point 
		int x1 = (int) s.x/48;
		int y1 = (int) s.y/48;
		//bottom left point 
		int x2 = (int) s.x/48;
		int y2 = (int) ((s.y + s.image.getHeight())/48);
		//top right point 
		int x3 = (int) ((s.x + s.image.getWidth())/48);
		int y3 = (int) s.y/48;
		//bottom right point 
		int x4 = (int) ((s.x + s.image.getWidth())/48);
		int y4 = (int) ((s.y + s.image.getHeight())/48);
		
		//Debugging line of code, not needed 
		//System.out.println("color = " + map.getColor(x1,  y1).getRed() +
		//		"," + map.getColor(x1,  y1).getGreen() +
		//		"," + map.getColor(x1,  y1).getBlue());
		
		if(map.getTileId(x1, y1, 0) >= 0 && map.getTileId(x1, y1, 0) <= 100)
		{
			return true;
		}
		if(map.getTileId(x2, y2, 0) >= 0 && map.getTileId(x2, y2, 0) <= 100)
		{
			return true;
		}
		if(map.getTileId(x3, y3, 0) >= 0 && map.getTileId(x3, y3, 0) <= 100)
		{
			return true;
		}
		if(map.getTileId(x4, y4, 0) >= 0 && map.getTileId(x4, y4, 0) <= 100)
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean collideLRMap(Sprite s)
	{
		//right middle 
		int x1 = (int) ((s.x + s.image.getWidth())/48);
		int y1 = (int) ((s.y + (s.image.getHeight()/2))/48);
		//left middle 
		int x2 = (int) (s.x/48);
		int y2 = (int) ((s.y + (s.image.getHeight()/2))/48);
		
		if(map.getTileId(x1, y1, 0) >= 0 && map.getTileId(x1, y1, 0) <= 11)
		{
			return true;
		}
		if(map.getTileId(x2, y2, 0) >= 0 && map.getTileId(x2, y2, 0) <= 11)
		{
			return true;
		}
		
		return false;
	}
	
}





