import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{

    private Handler handler;
    private BufferedImage bufferedImage;
    private BufferedImage enemyTrainer;
    private boolean upwards;
    private Game game;
    private HUD hud;
    private int counter = 0;

    public Enemy(float x, float y, ID id, Handler handler, BufferedImage bufferedImage, BufferedImage enemyTrainer, Game game, HUD hud) {
        super(x, y, id);
        this.handler = handler;
        this.bufferedImage = bufferedImage;
        this.enemyTrainer = enemyTrainer;
        this.game = game;
        this.hud = hud;
        velX = 4;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        if (!hud.metronomePressed) {
            if (y >= 800) {
                upwards = false;
            } else if (y <= 770) {
                upwards = true;
            }

            if (upwards) {
                y = (float) (y + 1.2);
            } else {
                y = y - 1;
            }
            x = 1200;
            counter = 0;
        }else if (game.yourTurn) {
            counter++;

            //y axis
            if (counter < 110) {
                if (y >= 800) {
                    upwards = false;
                } else if (y <= 770) {
                    upwards = true;
                }

                if (upwards) {
                    y = (float) (y + 4.2);
                } else {
                    y = y - 4;
                }
            }

            //x axis
            if (counter > 110) {
                //GO!
                y = 800;
                x = x - 20;
            } else {
                x = x - 1;
            }
        }else{
            if (y >= 800) {
                upwards = false;
            } else if (y <= 770) {
                upwards = true;
            }

            if (upwards) {
                y = (float) (y + 1.2);
            } else {
                y = y - 1;
            }

            x = 1200;
            counter = 0;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1635,725,30,10);
        g.fillRect(1635,810,40,40);
        if (!game.gameStarted) {
            g.drawImage(bufferedImage, (int) x, (int) y, null);
        }
        g.drawImage(enemyTrainer, 1500, 650, null);
    }
}
