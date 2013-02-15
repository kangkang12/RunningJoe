package efficom.runningjoe.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import efficom.runningjoe.RunningJoe;
import efficom.runningjoe.core.RjWorld;
import efficom.runningjoe.services.RunningJoeSound;

public class MainScreen extends AbstractScreen
{
	private RjWorld world;
	
    public MainScreen(RunningJoe game )
    {
        super( game ); 
        world = game.getWorld();
        //world = new RjWorld(game);        
    }
    
    public RjWorld getWorld(){
    	return this.world;
    }
    
    @Override
    public void render(float delta)
    {
    	//if()
    	this.world.render();  
    	super.render(delta); 
    	
    	if(this.world.isStarded())
    		this.getTable().clear();
    }     
    
    @Override
    public void show(){
        super.show();
        
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
        	this.world.getJoe().Jump();
        }
        
        this.world.render();
        
        if(!this.world.isStarded())        
        	this.createMenu();
    }
    
    public void createMenu()
    {
    	// retrieve the default table actor
        this.getTable().add( "Running Joe !" ).spaceBottom( 50 );
        this.getTable().row();
        
        // register the button "start game"
        TextButton startGameButton = new TextButton( 
        		this.getLanguagesManager().getString("Play"), 
        		this.buttonStyle 
        );        
        startGameButton.addListener( new InputListener() {         	    		
        	@Override
            public boolean touchDown( InputEvent event, float x, float y, int pointer, int button )
            {
        		Gdx.app.log( RunningJoe.LOG, "Game start clicked: " + getName() );
        		game.getSoundManager().play( RunningJoeSound.CLICK );
                super.touchUp( event, x, y, pointer, button );  
                world.Start();
                return true;
            }
        });
        
        this.getTable().add(startGameButton).size(300, 60).uniform().spaceBottom(10);
        this.getTable().row();
        
        // register the button "options"
        TextButton optionsButton = new TextButton( 
        		this.getLanguagesManager().getString("Options"), 
        		this.buttonStyle 
        );
        super.getTable().add(optionsButton).size(300, 60).uniform().spaceBottom(10);
        super.getTable().row();
        optionsButton.addListener( new InputListener() {
            @Override
            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button )
            {
            	Gdx.app.log( RunningJoe.LOG, "Game options clicked: " + getName() );
                super.touchUp( event, x, y, pointer, button );
                game.getSoundManager().play( RunningJoeSound.CLICK );
                game.setScreen( new OptionsScreen( game ) );
            	return true;
            }
        } );

        // register the button "high scores"
        TextButton highScoresButton = new TextButton( 
        		this.getLanguagesManager().getString("High scores"), 
        		this.buttonStyle 
        );
        super.getTable().add(highScoresButton).uniform().fill().spaceBottom( 10 );
        super.getTable().row();
        highScoresButton.addListener( new InputListener() {
            @Override
            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button )
            {
            	Gdx.app.log( RunningJoe.LOG, "High scores clicked: " + getName() );
            	game.getSoundManager().play( RunningJoeSound.CLICK );
                super.touchUp( event, x, y, pointer, button );            	
                game.setScreen( new HighScoresScreen( game ) );
            	return true;
            }
        } );
        
        TextButton exitButton = new TextButton( 
        		this.getLanguagesManager().getString("Exit"), 
        		this.buttonStyle 
        );
        super.getTable().add(exitButton).uniform().fill().spaceBottom( 10 );
        super.getTable().row();
        exitButton.addListener( new InputListener() {
            @Override
            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button )
            {
            	Gdx.app.log( RunningJoe.LOG, "Exit clicked: " + getName() );
            	game.getSoundManager().play( RunningJoeSound.CLICK );
            	Gdx.app.exit();
            	return true;
            }
        } );    	
    }
}
