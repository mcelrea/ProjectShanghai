package damien.com.Camera;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import damien.com.Main.Driver;
import damien.com.Map.Map;

public class Camera {
	public Rectangle viewPort;
	float viewPortWidth;
	float viewPortHeight;
	Map map;
	
	
	public Camera(float height, float width,float x1,float y1,Map map1){
		this.viewPortHeight = height;
		this.viewPortWidth = width;
		this.viewPort = new Rectangle((Driver.app.getWidth()/2),y1,this.viewPortWidth,this.viewPortHeight);
		this.map = map1;
	}
	
	public void drawCamera(Graphics g){
		g.translate(-viewPort.getX()+(Driver.app.getWidth()/2), 0);
	}
	
	public void translate(float x1){
		System.out.print(x1<(Driver.app.getWidth()/2));
		System.out.println(x1 -(Driver.app.getWidth()) > this.map.map.getWidth()*48);
		//when to translate
		if(x1>(Driver.app.getWidth()/2) && x1 < (this.map.map.getWidth()*48)-Driver.app.getWidth()/2)
		this.viewPort.setX(x1);
	}
	
}
