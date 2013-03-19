package damien.com.States;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import damien.com.Main.Driver;
import damien.com.Map.Map;
import damien.com.Sprites.Sprite;

public class Gameplay extends BasicGameState{

	int stateID;
	Sprite player;
	Map map1;
	
	public static final float GRAVITY = 0.2f;
	
	public Gameplay(int id)
	{
		stateID = id;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		player = new Sprite(new Image("images/Guy_Sprite.PNG"));
		player.x = 300;
		player.y = 300;
		player.speed = 0.2f;
		player.alive = true;
		
		map1 = new Map("data/map1.tmx");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		map1.draw(g);
		player.draw(g);
	}

	public void updatePlayer(GameContainer gc, StateBasedGame sb, int delta, Input input)
			throws SlickException {
		
		/*
		 * Gravity Code
		 */
		if(!map1.collidingWithMap(player))
		{
			player.y+=GRAVITY*delta;
		}
		
		/* remember his location BEFORE he moves */
		float oldx = player.x;
		float oldy = player.y;
		
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
		{
			player.y-=0.4f*delta;
		}
		
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
		{
			player.moveLeft(delta);
			if(map1.collideLRMap(player))
			{
				player.x = oldx;
			}
		}
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
		{
			player.moveRight(delta);
			if(map1.collideLRMap(player))
			{
				player.x = oldx;
			}
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		/* Get the keyboard, mouse input */
		Input input = gc.getInput();
		
		updatePlayer(gc, sb, delta, input);
		
		/*
		 * If to handle the changing of the game state
		 */
		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			sb.enterState(Driver.ENDSCREEN);
		}
		if(input.isKeyPressed(Input.KEY_P))
		{
			sb.enterState(Driver.PAUSESCREEN);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
