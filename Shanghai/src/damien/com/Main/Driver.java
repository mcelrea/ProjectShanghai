package damien.com.Main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import damien.com.States.EndScreen;
import damien.com.States.Gameplay;
import damien.com.States.StartScreen;

public class Driver extends StateBasedGame{

	/* This is where you define the states of the game */
	public static final int STARTSCREEN = 1;
	public static final int GAMEPLAYSCREEN = 2;
	public static final int ENDSCREEN = 3;
	
	public Driver() {
		super("Project Shanghai");
		
		/* Add the states to the game */
		this.addState(new StartScreen(STARTSCREEN));
		this.addState(new Gameplay(GAMEPLAYSCREEN));
		this.addState(new EndScreen(ENDSCREEN));
	}
	
	public static void main(String args[]) throws SlickException {
		
		AppGameContainer app = new AppGameContainer(new Driver());
		
		/* 800x600 resolution, not in fullscreen */
		app.setDisplayMode(800, 600, false);
		
		app.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(STARTSCREEN).init(gc, this);
		this.getState(GAMEPLAYSCREEN).init(gc, this);
		this.getState(ENDSCREEN).init(gc, this);
	}
	
}
