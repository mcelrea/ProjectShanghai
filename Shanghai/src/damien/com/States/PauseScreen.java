package damien.com.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import damien.com.Main.Driver;

public class PauseScreen extends BasicGameState{
	
	int stateID;
	
	public PauseScreen(int id)
	{
		stateID = id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		g.drawString("PAUSE", 300, 10);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		/* Get the keyboard, mouse input */
		Input input = gc.getInput();
		
		/*
		 * If to handle the changing of the game state
		 */
		if(input.isKeyPressed(Input.KEY_P))
		{
			sb.enterState(Driver.GAMEPLAYSCREEN);
		}
		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			sb.enterState(Driver.ENDSCREEN);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
