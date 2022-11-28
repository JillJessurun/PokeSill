/*
author: Jill Jessurun
date: december 2022
goal: pokemon metronome game

ideas:
- audio
- types
- moves
- more gens
- abilities
- items
 */

import javax.imageio.IIOException;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1800;
    public static final int HEIGHT = 1000;
    private Thread thread;
    private boolean running = true;
    private boolean isRunning = false;
    private boolean menuCreated = false;
    public boolean gameStarted = false;
    public boolean metronomePressed = false;

    //instances
    private Handler handler;
    private PokeSill pokeSill;
    private Menu menu;
    private BufferedImageLoader loader;
    private ImageMirror imageMirror;
    private MakeTransparent makeTransparent;
    private Player playerGame;
    private Enemy enemyGame;
    private HUD hud;

    //images
    private BufferedImage background;
    private static BufferedImage imageLoad;

    private BufferedImage gif;
    private static BufferedImage imageLoad2;

    private BufferedImage gif2;
    private static BufferedImage imageLoad3;

    private BufferedImage battlefield;
    private static BufferedImage imageLoad4;

    private BufferedImage player;
    private static BufferedImage imageLoad5;

    private BufferedImage enemy;
    private static BufferedImage imageLoad6;

    private BufferedImage ash;
    private static BufferedImage imageLoad7;

    private BufferedImage enemyTrainer;
    private static BufferedImage imageLoad8;

    //pages
    public enum STATE {
        Menu,
        Game
    }
    public STATE programState = STATE.Menu;

    //constructor
    public Game() throws IOException {
        //bufferedimageloader
        makeTransparent = new MakeTransparent();
        loader = new BufferedImageLoader();
        imageMirror = new ImageMirror();

        handler = new Handler();
        new Window(WIDTH, HEIGHT, "PokeSill", this);

        Random rand = new Random();
        int randomgetal1 = rand.nextInt(511);
        int randomgetal2 = rand.nextInt(511);

        String s = String.valueOf(randomgetal1);
        String number1 = s;
        String st = String.valueOf(randomgetal2);
        String number2 = st;

        if (randomgetal1 < 100 && randomgetal1 >= 10){ //number with 2 digits
            number1 = "0" + s;
        }else if(randomgetal1 < 10){ //number with 1 digit
            number1 = "00" + s;
        }

        if (randomgetal2 < 100 && randomgetal2 >= 10){ //number with 2 digits
            number2 = "0" + st;
        }else if(randomgetal2 < 10){ //number with 1 digit
            number2 = "00" + st;
        }


        System.out.println("src\\sprites\\" + number1 + ".png");
        System.out.println("src\\sprites\\" + number2 + ".png");

        //keylisteners
        this.addKeyListener(new KeyInput(handler));

        //declaring path images
        imageLoad = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\background.jpg");
        imageLoad2 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\pokeball.gif");
        imageLoad3 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\alakazam.gif");
        imageLoad4 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\background2.png");
        imageLoad5 = loader.loadImage("src\\sprites\\" + number1 + ".png");
        imageLoad6 = loader.loadImage("src\\sprites\\" + number2 + ".png");
        imageLoad7 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\ash.png");
        imageLoad8 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\silver.png");

        Images images = new Images(imageLoad);
        Images images2 = new Images(imageLoad2);
        Images images3 = new Images(imageLoad3);
        Images images4 = new Images(imageLoad4);
        Images images5 = new Images(imageLoad5);
        Images images6 = new Images(imageLoad6);
        Images images7 = new Images(imageLoad7);
        Images images8 = new Images(imageLoad8);

        background = images.grabImage();
        gif = images2.grabImage();
        gif2 = images3.grabImage();
        battlefield = images4.grabImage();
        player = images5.grabImage();
        enemy = images6.grabImage();
        ash = images7.grabImage();
        enemyTrainer = images8.grabImage();

        //resize images
        ash = images.resizeImage(ash, 300,300);
        enemyTrainer = images.resizeImage(enemyTrainer, 300,300);
        player = images.resizeImage(player, 170, 170);
        enemy = images.resizeImage(enemy, 170, 170);

        //remove black background player/enemy and flip player
        int colour = player.getRGB(0, 0);
        Image newImage = makeTransparent.makeColorTransparent(player, new Color(colour));
        BufferedImage newPlayer = makeTransparent.imageToBufferedImage(newImage);
        Image newImage2 = makeTransparent.makeColorTransparent(enemy, new Color(colour));
        BufferedImage newEnemy = makeTransparent.imageToBufferedImage(newImage2);
        newPlayer = imageMirror.flip(newPlayer);

        //remove black background trainers
        Image img = makeTransparent.makeColorTransparent(ash, new Color(colour));
        BufferedImage newTrainer = makeTransparent.imageToBufferedImage(img);
        newTrainer = imageMirror.flip(newTrainer);
        Image img2 = makeTransparent.makeColorTransparent(enemyTrainer, new Color(colour));
        BufferedImage newEnemyTrainer = makeTransparent.imageToBufferedImage(img2);
        //newEnemyTrainer = imageMirror.flip(newEnemyTrainer);

        hud = new HUD(this);
        menu = new Menu(background, gif, gif2, imageMirror, this);
        menuCreated = true;
        playerGame = new Player(400, 770, ID.Player, handler, newPlayer, newTrainer, this);
        enemyGame = new Enemy(1200,800,ID.Enemy, handler, newEnemy, newEnemyTrainer, this);
        pokeSill = new PokeSill(battlefield, newPlayer, newEnemy, this, playerGame, enemyGame, hud);

        this.addMouseListener(menu);
        this.addMouseListener(hud);
        this.addMouseListener(pokeSill);

        isRunning = true;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            System.out.println("The thread cannot join :(");
        }
    }

    public void tick() {
        if (menuCreated) {
            if (programState == STATE.Menu) {
                menu.tick();
            }else if(programState == STATE.Game){
                pokeSill.tick();
            }
        }
    }

    public void render() throws IOException, FontFormatException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (menuCreated) {
            if (programState == STATE.Menu) {
                menu.render(g);
            }else if(programState == STATE.Game){
                pokeSill.render(g);
            }
        }

        g.dispose();
        bs.show();

    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (IOException | FontFormatException e) {
                    throw new RuntimeException(e);
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //clamp method: if the var is at the max, it stays at the max (same with the min)
    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }

}
