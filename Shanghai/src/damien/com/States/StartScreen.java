package damien.com.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import damien.com.Main.Driver;
import damien.com.Sprites.Sprite;

public class StartScreen extends BasicGameState{

	int stateID;
	
	Image background;
	Sprite startButton, exitButton;
	
	boolean onStart, onExit;
	
	public StartScreen(int id)
	{
		stateID = id;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		background = new Image("images/start screen.png");
		
		startButton = new Sprite(new Image("images/button.png"));
		startButton.x = 229;
		startButton.y = 164;
		startButton.alive = true;
		
		exitButton = new Sprite(new Image("images/button.png"));
		exitButton.x = 229;
		exitButton.y = 299;
		exitButton.alive = true;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		background.draw(0,0);
		
		if(onStart)
			g.drawImage(startButton.image, startButton.x, startButton.y, new Color(31,155,212));
		else
			startButton.draw(g);
		
		if(onExit)
			g.drawImage(exitButton.image, exitButton.x, exitButton.y, new Color(31,155,212));
		else
			exitButton.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		/* Get the keyboard, mouse input */
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_ENTER))
		{
			sb.enterState(Driver.GAMEPLAYSCREEN);
		}
		
		if(startButton.spriteCollisionByPoint(input.getMouseX(), input.getMouseY()))
		{
			onStart = true;
		}
		else
		{
			onStart = false;
		}
		
		if(exitButton.spriteCollisionByPoint(input.getMouseX(), input.getMouseY()))
		{
			onExit = true;
		}
		else
		{
			onExit = false;
		}
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && onStart)
		{
			sb.enterState(Driver.GAMEPLAYSCREEN);
		}
		else if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && onExit)
		{
			sb.enterState(Driver.ENDSCREEN);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}










