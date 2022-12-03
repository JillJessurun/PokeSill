import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private boolean upwards;
    private int counterPlayer;

    private Handler handler;
    private BufferedImage bufferedImage;
    private BufferedImage trainer;
    private Game game;
    private HUD hud;

    public Player(float x, float y, ID id, Handler handler, BufferedImage bufferedImage, BufferedImage trainer, Game game, HUD hud, int counterPlayer) {
        super(x, y, id);
        this.handler = handler;
        this.bufferedImage = bufferedImage;
        this.trainer = trainer;
        this.game = game;
        this.hud = hud;
        this.counterPlayer = counterPlayer;
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            if (this.getId() == ID.Player) {
                GameObject tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.Enemy) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        //collision code (under here happens when colliding)
                        System.out.println("collision!!");
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        if (hud.playerHealth > 0) {
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

                x = 400;
                counterPlayer = 0;
            } else if (!game.yourTurn) {
                counterPlayer++;

                //y axis
                if (counterPlayer < 110) {
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
                if (counterPlayer > 110) {
                    //GO!
                    y = 800;
                    x = x + 20;
                } else {
                    x = x + 1;
                }
            } else {
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

                x = 400;
                counterPlayer = 0;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (!game.gameStarted){
            g.drawImage(bufferedImage, (int) x, (int) y, null);
        }
        g.drawImage(trainer, 0, 650, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle ((int)x, (int)y, 32, 32);
    }
}
