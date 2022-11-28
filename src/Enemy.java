import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{

    private Handler handler;
    private BufferedImage bufferedImage;
    private BufferedImage enemyTrainer;
    private boolean upwards;
    private Game game;

    public Enemy(float x, float y, ID id, Handler handler, BufferedImage bufferedImage, BufferedImage enemyTrainer, Game game) {
        super(x, y, id);
        this.handler = handler;
        this.bufferedImage = bufferedImage;
        this.enemyTrainer = enemyTrainer;
        this.game = game;
        velX = 4;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        if (y >= 800){
            upwards = false;
        }else if(y <= 770){
            upwards = true;
        }

        if (upwards){
            y = (float) (y + 1.2);
        }else{
            y = y - 1;
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
