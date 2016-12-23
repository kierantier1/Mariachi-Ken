package gdx.menu.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import gdx.menu.GdxMenu;
import gdx.menu.TbMenu;
import gdx.menu.TbsMenu;

/**
 * Created by luke on 2016-04-05.
 */
public class ScrPlay implements Screen, InputProcessor {
    GdxMenu gdxMenu;
    TbsMenu tbsMenu;
    TbMenu tbMenu, tbOptions, tbGameover;
    Stage stage;
    SpriteBatch batch;
    BitmapFont screenName;
    Texture grass;
    Sprite grassmap;
    Texture tree;
    Sprite treeobject;
    Texture rock;
    Sprite rockobject;

    public ScrPlay(GdxMenu _gdxMenu) {  //Referencing the main class.
        gdxMenu = _gdxMenu;
    }

    public void show() {
        grass = new Texture("Grass Tile Demo.png");
        grassmap = new Sprite(grass);
        tree = new Texture("tree.png");
        treeobject = new Sprite(tree);
        rock = new Texture("Rock.png");
        rockobject = new Sprite(rock);
        stage = new Stage();
        tbsMenu = new TbsMenu();
        batch = new SpriteBatch();
        screenName = new BitmapFont();
        tbGameover = new TbMenu("LOSE", tbsMenu);
        tbGameover.setY(100);
        tbGameover.setX(440);
        tbOptions = new TbMenu("OPTIONS", tbsMenu);
        tbOptions.setY(0);
        tbOptions.setX(440);
        stage.addActor(tbOptions);
        stage.addActor(tbGameover);
        Gdx.input.setInputProcessor(stage);
        btnGameoverListener();
        btnOptionsListener();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1); //blue background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(grassmap, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(treeobject, -200,180,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(rockobject, 200,180,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act();
        stage.draw();
        
    }

    public void btnOptionsListener() {
        tbOptions.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                gdxMenu.currentState = gdxMenu.gameState.OPTI;
                gdxMenu.updateState();
            }
        });
    }
    public void btnGameoverListener(){
        tbGameover.addListener(new ChangeListener(){
            public void changed(ChangeListener.ChangeEvent event, Actor actor){
                gdxMenu.currentState = gdxMenu.gameState.OVER;
                gdxMenu.updateState();
            }
        });
    }
   

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}