import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

//hoi

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1800;
    public static final int HEIGHT = 1000;
    private Thread thread;
    private boolean running = true;
    private boolean isRunning = false;
    private boolean menuCreated = false;

    //instances
    private Handler handler;
    private PokeSill pokeSill;
    private Menu menu;
    private BufferedImageLoader loader;
    private ImageMirror imageMirror;

    //images
    private BufferedImage background;
    private static BufferedImage imageLoad;

    private BufferedImage gif;
    private static BufferedImage imageLoad2;

    private BufferedImage gif2;
    private static BufferedImage imageLoad3;

    //pages
    public enum STATE {
        Menu,
        Game
    }
    public STATE programState = STATE.Menu;

    //constructor
    public Game() throws IOException {
        //bufferedimageloader
        loader = new BufferedImageLoader();
        imageMirror = new ImageMirror();

        handler = new Handler();
        new Window(WIDTH, HEIGHT, "PokeSill", this);

        //keylisteners
        this.addKeyListener(new KeyInput(handler));

        //declaring path images
        imageLoad = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\background.jpg");
        imageLoad2 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\pokeball.gif");
        imageLoad3 = loader.loadImage("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Pics\\alakazam.gif");

        Image image = new Image(imageLoad);
        Image image2 = new Image(imageLoad2);
        Image image3 = new Image(imageLoad3);

        background = image.grabImage();
        gif = image2.grabImage();
        gif2 = image3.grabImage();

        //image.resizeImage(background, 1800, 1000);

        menu = new Menu(background, gif, gif2, imageMirror, this);
        menuCreated = true;
        pokeSill = new PokeSill();

        //adding objects at startup program
        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
        handler.addObject(new Enemy(300, 300, ID.Enemy, handler));

        this.addMouseListener(menu);

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
        //handler.tick();
        //hud.tick();
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
                //handler.render(g);
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
