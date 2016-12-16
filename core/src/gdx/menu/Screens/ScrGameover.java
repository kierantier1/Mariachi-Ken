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

public class ScrGameover implements Screen, InputProcessor {
    GdxMenu gdxMenu;
    TbsMenu tbsMenu;
    TbMenu tbMenu, tbOptions;
    Stage stage;
    SpriteBatch batch;
    BitmapFont screenName;
    Texture gameOver;
    Sprite Over;

    public ScrGameover(GdxMenu _gdxMenu) {  //Referencing the main class.
        gdxMenu = _gdxMenu;
    }

    public void show() {
        //gameOver = new Texture("")
        stage = new Stage();
        tbsMenu = new TbsMenu();
        batch = new SpriteBatch();
        screenName = new BitmapFont();
        tbMenu = new TbMenu("Menu", tbsMenu);
        tbMenu.setY(0);
        tbMenu.setX(0);
        tbOptions = new TbMenu("Options", tbsMenu);
        tbOptions.setY(0);
        tbOptions.setX(440);
        stage.addActor(tbOptions);
        stage.addActor(tbMenu);
        Gdx.input.setInputProcessor(stage);
        btnMenuListener();
        btnOptionsListener();
    }

    public void render(float delta) {
        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        screenName.draw(batch, "Game Over, my dude", 230, 275);
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
    public void btnMenuListener() {
    tbMenu.addListener(new ChangeListener(){
        public void changed(ChangeListener.ChangeEvent event, Actor actor){
            gdxMenu.currentState = gdxMenu.gameState.MENU;
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