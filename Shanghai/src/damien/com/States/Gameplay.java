package damien.com.States;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import damien.com.Camera.Camera;
import damien.com.Main.Driver;
import damien.com.Map.Map;
import damien.com.Sprites.Bullet;
import damien.com.Sprites.Enemy;
import damien.com.Sprites.Grounder;
import damien.com.Sprites.Player;
import damien.com.Sprites.Sprite;

public class Gameplay extends BasicGameState{

	int stateID;
	Player player;
	Map map1;
	Camera camera;
	Sound gun1, level1Music, coinPickUp;
	
	Random rand = new Random();
	
	long grounderSpawnDelay = 5000;
	long spawnNextGrounder;
	
	//list of all the enemies currently in the game
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	//list of all the bullets currently on the screen
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	//list of all the coins currently in the game
	ArrayList<Sprite> coins = new ArrayList<Sprite>();
	
	public static final float GRAVITY = 0.2f;
	
	public Gameplay(int id)
	{
		stateID = id;
	}
	
	public void initEnemies() throws SlickException
	{
		/*
		Enemy e = new Grounder(new Image("images/grounder.png"));
		e.x = 1300; //e.setX(1300);
		e.y = 335; //e.setY(335);
		e.speed = 0.05f; //e.setSpeed(0.05);
		e.alive = true;
		enemies.add(e);//add to the list of enemies
		
		e = new Grounder(new Image("images/grounder.png"));
		e.x = 1900;
		e.y = 35;
		e.speed = 0.05f;
		e.alive = true;
		enemies.add(e);//add to the list of enemies
		*/
		Grounder e = new Grounder(new Image("images/grounder.png"));
		e.x = 400;
		e.y = 35;
		e.speed = 0.05f;
		e.alive = true;
		e.health = 3;
		enemies.add(e);//add to the list of enemies
		/*
		e = new Grounder(new Image("images/grounder.png"));
		e.x = 2100;
		e.y = 35;
		e.speed = 0.05f;
		e.alive = true;
		enemies.add(e);//add to the list of enemies
		
		e = new Grounder(new Image("images/grounder.png"));
		e.x = 2500;
		e.y = 35;
		e.speed = 0.05f;
		e.alive = true;
		enemies.add(e);//add to the list of enemies
		*/
	}
	
	public void initCoinsLevel1() throws SlickException
	{
		Sprite c = new Sprite(new Image("images/coin.png"));
		c.x = 1100;
		c.y = 545;
		c.alive = true;
		
		coins.add(c);//add the coin to the coin list
		
		c = new Sprite(new Image("images/coin.png"));
		c.x = 4800;
		c.y = 500;
		c.alive = true;
		
		coins.add(c);//add the coin to the coin list
		
		c = new Sprite(new Image("images/coin.png"));
		c.x = 4820;
		c.y = 110;
		c.alive = true;
		
		coins.add(c);//add the coin to the coin list
		
		c = new Sprite(new Image("images/coin.png"));
		c.x = 3600;
		c.y = 95;
		c.alive = true;
		
		coins.add(c);//add the coin to the coin list
	}
	
	public void enter(GameContainer gc, StateBasedGame sb) throws SlickException
	{
		if(!level1Music.playing())
			level1Music.loop();
		
		initCoinsLevel1();
		spawnNextGrounder = System.currentTimeMillis() + grounderSpawnDelay;
	}
	
	public void leave(GameContainer gc, StateBasedGame sb)
	{
		
	}
	
	public void loadSounds() throws SlickException
	{
		gun1 = new Sound("sounds/gunShot1.wav");
		level1Music = new Sound("sounds/QuickSilver.wav");
		coinPickUp = new Sound("sounds/coinPickUp.wav");
	}//end loadSounds
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		loadSounds();
		initEnemies();
		
		player = new Player(new Image("images/Guy_Sprite.PNG"));
		player.x = 300;
		player.y = 300;
		player.speed = 1.2f;
		player.alive = true;
		player.jumpSpeed = -1.25f;
		this.camera = new Camera(Driver.app.getHeight(), Driver.app.getHeight(),0,0,map1);
		map1 = new Map("data/map1.tmx");
		
	}

	public void renderBullets(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		//for every bullet in the list
		for(int i=0; i < bullets.size(); i++)
		{
			Bullet b = bullets.get(i); //get the current bullet
			b.draw(g); //draw the bullet to the screen
		}//end for
		
	}//end renderBullets
	
	public void renderEnemies(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		//for every enemy
		for(int i=0; i < enemies.size(); i++)
		{
			Enemy e = enemies.get(i);//get current enemy
			e.draw(g);//draw the current enemy
		}
	}
	
	public void renderCoins(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		//for every coin
		for(int i=0; i < coins.size(); i++)
		{
			Sprite c = coins.get(i); //get the current coin
			c.draw(g); //draw the current coin
		}//end for
	}//end renderCoins
	
	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		//System.out.println(map1.map.getWidth()*48);
		//System.out.println(player.x + "player");
		camera.drawCamera(g);
		
	
		map1.draw(g);
		player.draw(g);
		renderBullets(gc, sb, g);
		renderEnemies(gc, sb, g);
		renderCoins(gc, sb, g);
		g.drawString("jumping = " + player.jumping, 300, 10);
		g.drawString("Player (" + player.x + ", " + player.y + ")", player.x, player.y-50);
		g.drawString("Camera (" + camera.viewPort.getX() + ", " + camera.viewPort.getY() + ")", 300, 50);
	}

	public void updatePlayer(GameContainer gc, StateBasedGame sb, int delta, Input input)
			throws SlickException {
		
		/* remember his location BEFORE he moves */
		float oldx = player.x;
		float oldy = player.y;
		
		/*
		 * Gravity Code
		 */
		if(!map1.collidingWithMap(player))
		{
			player.y+=GRAVITY*delta;
			
			//check to see if he fell inside the map
			if(map1.collidingWithMap(player))
			{
				player.y = oldy; //place him back above the collision
			}
		}
		
		
		
		/* jump code */
		if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP))
		{
			player.jump(delta);
		}
		player.updateJump(delta, GRAVITY, map1);
		
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
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			Bullet b = player.shootBullet(input.getMouseX(), input.getAbsoluteMouseY(), camera);
			bullets.add(b); //add the new bullet to the list
			gun1.play(1.0f, 0.5f);
		}
	}
	
	public void spawnGrounders(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		if(System.currentTimeMillis() >= spawnNextGrounder)
		{
			Grounder e = new Grounder(new Image("images/grounder.png"));
			e.x = rand.nextInt(map1.map.getWidth()*map1.map.getTileWidth());
			System.out.println(map1.map.getWidth());
			e.y = 35;
			e.speed = 0.05f;
			e.alive = true;
			e.health = 3;
			enemies.add(e);//add to the list of enemies
			
			spawnNextGrounder = System.currentTimeMillis() + grounderSpawnDelay;
		}
	}
	
	public void updateCoins(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		//for every coin
		for(int i=0; i < coins.size(); i++)
		{
			Sprite c = coins.get(i); //get the current coin
			if(player.spriteCollision(c))
			{
				coinPickUp.play(); //play the sound
				coins.remove(i); //kill the coin
				i--; //subtract one from the size list
			}//end if
		}//end for
	}//end updateCoins
	
	public void updateEnemies(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {

		//for each enemy
		for(int i=0; i < enemies.size(); i++)
		{
			Enemy e = enemies.get(i); //get the current enemy
			e.act(delta, map1, enemies, player); //make the enemy act

			//if enemy collides with player
			if(e.spriteCollision(player))
			{
				//if the enemy is a Grounder
				if(e instanceof Grounder)
				{
					player.health -= 3; //take 3 health away from the player
					sb.enterState(Driver.ENDSCREEN);
				}
			}

		}//end for loop

	}//end method updateEnemies
	
	public void updateBullets(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		//for every bullet in the list
		for(int i=0; i < bullets.size(); i++)
		{
			Bullet b = bullets.get(i); //get the current bullet
			b.update(delta); //move the bullet
			
			//for every enemy
			for(int j=0; j < enemies.size(); j++)
			{
				//get the current enemy
				Enemy e = enemies.get(j);
				
				//if the bullet collides with the enemy && the bullet was not
				//shot by the enemy
				if(b.spriteCollision(e) && b.owner != e)
				{
					//subtract one health from enemy (he was shot)
					e.health--;
					//if the enemies health reaches less than or equal to 0
					if(e.health <= 0)
					{
						enemies.remove(j); //remove the enemy from the game (it died)
						j--; //decrement the size of the list of enemies (one died)
						if(e instanceof Grounder)
						{
							((Grounder) e).explode(bullets);
						}
					}//end if
					
					bullets.remove(i); //remove the bullet from the game (it died)
					i--; //decrement the size of the list of bullets (one died)
				}//end if		
			}//end for
			
			if(b.spriteCollision(player) && b.owner != player)
			{
				player.health--;
				if(player.health <= 0)
				{
					sb.enterState(Driver.ENDSCREEN);
				}
				
				bullets.remove(i); //remove the bullet from the game (it died)
				i--; //decrement the size of the list of bullets (one died)
			}
		}//end for
		
	}//end updateBulletsw
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		/* Get the keyboard, mouse input */
		Input input = gc.getInput();
		
		updatePlayer(gc, sb, delta, input);
		updateBullets(gc, sb, delta);
		updateEnemies(gc, sb, delta);
		updateCoins(gc, sb, delta);
		
		spawnGrounders(gc, sb, delta);
		
		this.camera.translate(player.x);
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
