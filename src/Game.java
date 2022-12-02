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
    public String move = "";
    public static BufferedImage moveType;
    public int moveBasePowerIndex1 = 0;
    public int moveBasePowerIndex2 = 0;
    public int basePower = 0;
    public int pokemonPlayerIndex;
    public int pokemonEnemyIndex;
    public boolean yourTurn = true;

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
    public Moves moves;
    public Names names;

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
    public BufferedImage bug;
    public static BufferedImage imageLoad9;
    public BufferedImage dark;
    public static BufferedImage imageLoad10;
    public BufferedImage dragon;
    public static BufferedImage imageLoad11;
    public BufferedImage electric;
    public static BufferedImage imageLoad12;
    public BufferedImage fairy;
    public static BufferedImage imageLoad13;
    public BufferedImage fighting;
    public static BufferedImage imageLoad14;
    public BufferedImage fire;
    public static BufferedImage imageLoad15;
    public BufferedImage flying;
    public static BufferedImage imageLoad16;
    public BufferedImage ghost;
    public static BufferedImage imageLoad17;
    public BufferedImage grass;
    public static BufferedImage imageLoad18;
    public BufferedImage ground;
    public static BufferedImage imageLoad19;
    public BufferedImage ice;
    public static BufferedImage imageLoad20;
    public BufferedImage normal;
    public static BufferedImage imageLoad21;
    public BufferedImage poison;
    public static BufferedImage imageLoad22;
    public BufferedImage psychic;
    public static BufferedImage imageLoad23;
    public BufferedImage rock;
    public static BufferedImage imageLoad24;
    public BufferedImage steel;
    public static BufferedImage imageLoad25;
    public BufferedImage water;
    public static BufferedImage imageLoad26;

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
        new Window(WIDTH, HEIGHT, "Pikamon", this);

        Random rand = new Random();
        pokemonPlayerIndex = rand.nextInt(513);
        pokemonEnemyIndex = rand.nextInt(513);

        String s = String.valueOf(pokemonPlayerIndex);
        String number1 = s;
        String st = String.valueOf(pokemonEnemyIndex);
        String number2 = st;

        if (pokemonPlayerIndex < 100 && pokemonPlayerIndex >= 10){ //number with 2 digits
            number1 = "0" + s;
        }else if(pokemonPlayerIndex < 10){ //number with 1 digit
            number1 = "00" + s;
        }

        if (pokemonEnemyIndex < 100 && pokemonEnemyIndex >= 10){ //number with 2 digits
            number2 = "0" + st;
        }else if(pokemonEnemyIndex < 10){ //number with 1 digit
            number2 = "00" + st;
        }


        System.out.println("src\\sprites\\" + number1 + ".png");
        System.out.println("src\\sprites\\" + number2 + ".png");

        //keylisteners
        this.addKeyListener(new KeyInput(handler));

        //declaring path images
        imageLoad = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\background.png");
        imageLoad2 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\pokeball.gif");
        imageLoad3 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\alakazam.gif");
        imageLoad4 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\background2.png");
        imageLoad5 = loader.loadImage("src\\sprites\\" + number1 + ".png");
        imageLoad6 = loader.loadImage("src\\sprites\\" + number2 + ".png");
        imageLoad7 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\ash.png");
        imageLoad8 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\silver.png");
        imageLoad9 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\bug.png");
        imageLoad10 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\dark.png");
        imageLoad11 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\dragon.png");
        imageLoad12 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\electric.png");
        imageLoad13 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\fairy.png");
        imageLoad14 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\fighting.png");
        imageLoad15 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\fire.png");
        imageLoad16 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\flying.png");
        imageLoad17 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\ghost.png");
        imageLoad18 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\grass.png");
        imageLoad19 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\ground.png");
        imageLoad20 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\ice.png");
        imageLoad21 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\normal.png");
        imageLoad22 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\poison.png");
        imageLoad23 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\psychic.png");
        imageLoad24 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\rock.png");
        imageLoad25 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\steel.png");
        imageLoad26 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\types\\water.png");

        Images images = new Images(imageLoad);
        Images images2 = new Images(imageLoad2);
        Images images3 = new Images(imageLoad3);
        Images images4 = new Images(imageLoad4);
        Images images5 = new Images(imageLoad5);
        Images images6 = new Images(imageLoad6);
        Images images7 = new Images(imageLoad7);
        Images images8 = new Images(imageLoad8);
        Images images9 = new Images(imageLoad9);
        Images images10 = new Images(imageLoad10);
        Images images11 = new Images(imageLoad11);
        Images images12 = new Images(imageLoad12);
        Images images13 = new Images(imageLoad13);
        Images images14 = new Images(imageLoad14);
        Images images15 = new Images(imageLoad15);
        Images images16 = new Images(imageLoad16);
        Images images17 = new Images(imageLoad17);
        Images images18 = new Images(imageLoad18);
        Images images19 = new Images(imageLoad19);
        Images images20 = new Images(imageLoad20);
        Images images21 = new Images(imageLoad21);
        Images images22 = new Images(imageLoad22);
        Images images23 = new Images(imageLoad23);
        Images images24 = new Images(imageLoad24);
        Images images25 = new Images(imageLoad25);
        Images images26 = new Images(imageLoad26);

        background = images.grabImage();
        gif = images2.grabImage();
        gif2 = images3.grabImage();
        battlefield = images4.grabImage();
        player = images5.grabImage();
        enemy = images6.grabImage();
        ash = images7.grabImage();
        enemyTrainer = images8.grabImage();
        bug = images9.grabImage();
        dark = images10.grabImage();
        dragon = images11.grabImage();
        electric = images12.grabImage();
        fairy = images13.grabImage();
        fighting = images14.grabImage();
        fire = images15.grabImage();
        flying = images16.grabImage();
        ghost = images17.grabImage();
        grass = images18.grabImage();
        ground = images19.grabImage();
        ice = images20.grabImage();
        normal = images21.grabImage();
        poison = images22.grabImage();
        psychic = images23.grabImage();
        rock = images24.grabImage();
        steel = images25.grabImage();
        water = images26.grabImage();

        //resize images
        bug = images.resizeImage(bug, 30,30);
        dark = images.resizeImage(dark, 30,30);
        dragon = images.resizeImage(dragon, 30,30);
        electric = images.resizeImage(electric, 30,30);
        fairy = images.resizeImage(fairy, 30,30);
        fighting = images.resizeImage(fighting, 30,30);
        fire = images.resizeImage(fire, 30,30);
        flying = images.resizeImage(flying, 30,30);
        ghost = images.resizeImage(ghost, 30,30);
        grass = images.resizeImage(grass, 30,30);
        ground = images.resizeImage(ground, 30,30);
        ice = images.resizeImage(ice, 30,30);
        normal = images.resizeImage(normal, 30,30);
        poison = images.resizeImage(poison, 30,30);
        psychic = images.resizeImage(psychic, 30,30);
        rock = images.resizeImage(rock, 30,30);
        steel = images.resizeImage(steel, 30,30);
        water = images.resizeImage(water, 30,30);
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

        //remove black background typeImages
        Image img1 = makeTransparent.makeColorTransparent(bug, new Color(colour));
        bug = makeTransparent.imageToBufferedImage(img1);
        Image img3 = makeTransparent.makeColorTransparent(dark, new Color(colour));
        dark = makeTransparent.imageToBufferedImage(img3);
        Image img4 = makeTransparent.makeColorTransparent(dragon, new Color(colour));
        dragon = makeTransparent.imageToBufferedImage(img4);
        Image img5 = makeTransparent.makeColorTransparent(electric, new Color(colour));
        electric = makeTransparent.imageToBufferedImage(img5);
        Image img6 = makeTransparent.makeColorTransparent(fairy, new Color(colour));
        fairy = makeTransparent.imageToBufferedImage(img6);
        Image img7 = makeTransparent.makeColorTransparent(fighting, new Color(colour));
        fighting = makeTransparent.imageToBufferedImage(img7);
        Image img8 = makeTransparent.makeColorTransparent(fire, new Color(colour));
        fire = makeTransparent.imageToBufferedImage(img8);
        Image img9 = makeTransparent.makeColorTransparent(flying, new Color(colour));
        flying = makeTransparent.imageToBufferedImage(img9);
        Image img10 = makeTransparent.makeColorTransparent(ghost, new Color(colour));
        ghost = makeTransparent.imageToBufferedImage(img10);
        Image img11 = makeTransparent.makeColorTransparent(grass, new Color(colour));
        grass = makeTransparent.imageToBufferedImage(img11);
        Image img12 = makeTransparent.makeColorTransparent(ground, new Color(colour));
        ground = makeTransparent.imageToBufferedImage(img12);
        Image img13 = makeTransparent.makeColorTransparent(ice, new Color(colour));
        ice = makeTransparent.imageToBufferedImage(img13);
        Image img14 = makeTransparent.makeColorTransparent(normal, new Color(colour));
        normal = makeTransparent.imageToBufferedImage(img14);
        Image img15 = makeTransparent.makeColorTransparent(poison, new Color(colour));
        poison = makeTransparent.imageToBufferedImage(img15);
        Image img16 = makeTransparent.makeColorTransparent(psychic, new Color(colour));
        psychic = makeTransparent.imageToBufferedImage(img16);
        Image img17 = makeTransparent.makeColorTransparent(rock, new Color(colour));
        rock = makeTransparent.imageToBufferedImage(img17);
        Image img18 = makeTransparent.makeColorTransparent(steel, new Color(colour));
        steel = makeTransparent.imageToBufferedImage(img18);
        Image img19 = makeTransparent.makeColorTransparent(water, new Color(colour));
        water = makeTransparent.imageToBufferedImage(img19);

        names = new Names();
        moves = new Moves();
        hud = new HUD(this);
        menu = new Menu(background, gif, gif2, imageMirror, this);
        menuCreated = true;
        playerGame = new Player(400, 770, ID.Player, handler, newPlayer, newTrainer, this, hud);
        enemyGame = new Enemy(1200,800,ID.Enemy, handler, newEnemy, newEnemyTrainer, this, hud);
        pokeSill = new PokeSill(battlefield, newPlayer, newEnemy, this, playerGame, enemyGame, hud, moves);

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

                //typeImage assigning
                if (moveBasePowerIndex1 == 0){
                    moveType = normal;
                }if (moveBasePowerIndex1 == 1){
                    moveType = fighting;
                }if (moveBasePowerIndex1 == 2){
                    moveType = flying;
                }if (moveBasePowerIndex1 == 3){
                    moveType = poison;
                }if (moveBasePowerIndex1 == 4){
                    moveType = ground;
                }if (moveBasePowerIndex1 == 5){
                    moveType = rock;
                }if (moveBasePowerIndex1 == 6){
                    moveType = bug;
                }if (moveBasePowerIndex1 == 7){
                    moveType = ghost;
                }if (moveBasePowerIndex1 == 8){
                    moveType = steel;
                }if (moveBasePowerIndex1 == 9){
                    moveType = fire;
                }if (moveBasePowerIndex1 == 10){
                    moveType = water;
                }if (moveBasePowerIndex1 == 11){
                    moveType = grass;
                }if (moveBasePowerIndex1 == 12){
                    moveType = electric;
                }if (moveBasePowerIndex1 == 13){
                    moveType = psychic;
                }if (moveBasePowerIndex1 == 14){
                    moveType = ice;
                }if (moveBasePowerIndex1 == 15){
                    moveType = dragon;
                }if (moveBasePowerIndex1 == 16){
                    moveType = dark;
                }if (moveBasePowerIndex1 == 17){
                    moveType = fairy;
                }
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
