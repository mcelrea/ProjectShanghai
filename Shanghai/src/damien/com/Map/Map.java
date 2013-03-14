package damien.com.Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

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

}
