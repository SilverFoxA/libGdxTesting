package com.silverfox.Avi;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MyGdxGame implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Stage stage;
    private TextureAtlas buttonsAtlas;
    private Skin buttonSkin;
    private TextButton button, button1, button2, button3, button4;
    private BitmapFont font,font1;
    Sound peacokc, Lion,rooster,frog,cow,parrot;
    private TextButtonStyle style;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        buttonsAtlas = new TextureAtlas("data/buttons.txt");
        buttonSkin = new Skin();
        buttonSkin.addRegions(buttonsAtlas);
        stage = new Stage();
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        //Sound variable initialised
        peacokc = Gdx.audio.newSound(Gdx.files.internal("data/peacock.mp3"));
        Lion = Gdx.audio.newSound(Gdx.files.internal("data/lion.mp3"));
        rooster=Gdx.audio.newSound(Gdx.files.internal("data/rooster.mp3"));
        frog=Gdx.audio.newSound(Gdx.files.internal("data/frog.mp3"));
        cow=Gdx.audio.newSound(Gdx.files.internal("data/cow.mp3"));
        parrot= Gdx.audio.newSound(Gdx.files.internal("data/parot.mp3"));

        style = new TextButtonStyle();
        style.up = buttonSkin.getDrawable("button");
        style.down = buttonSkin.getDrawable("button_color");
        font = new BitmapFont();
        font.getData().setScale(2);
        font.setColor(Color.RED);
        font1= new BitmapFont();
        font1.setColor(Color.BLACK);
        font1.getData().setScale(4);
        style.font = font;
        String[] names = {"Peacock", "Lion", "Rooster", "Frog", "Cow", "Parrot"};
        button = new TextButton(names[0], style);
        button.setPosition(100, 100);
        button.setHeight(150);
        button.setWidth(300);
        button1 = new TextButton(names[1], style);
        button1.setPosition(230, 300);
        button1.setHeight(150);
        button1.setWidth(300);

        button2 = new TextButton(names[2], style);
        button2.setPosition(430, 170);
        button2.setHeight(150);
        button2.setWidth(300);

        button3 = new TextButton(names[3], style);
        button3.setPosition(630, 370);
        button3.setHeight(150);
        button3.setWidth(300);

        button4 = new TextButton(names[4], style);
        button4.setPosition(790, 170);
        button4.setHeight(150);
        button4.setWidth(300);

        button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                peacokc.play();
                peacokc.loop();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                peacokc.pause();
            }
        });
        button1.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Lion.play();
                Lion.loop();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Lion.pause();
            }
        });
        button2.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rooster.play();
                rooster.loop();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rooster.pause();
            }
        });
        button3.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                frog.play();
                frog.loop();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                frog.pause();
            }
        });
        button4.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                cow.play();
                cow.loop();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                cow.pause();
            }
        });
        stage.addActor(button);
        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
    }

    @Override
    public void dispose() {
        batch.dispose();
        buttonSkin.dispose();
        buttonsAtlas.dispose();
        stage.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        stage.draw();
        font1.draw(batch, "Hello World", 100, 100);
        batch.end();
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
}
