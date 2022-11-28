import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{

    private Handler handler;
    private BufferedImage bufferedImage;
    private boolean upwards;

    public Enemy(float x, float y, ID id, Handler handler, BufferedImage bufferedImage) {
        super(x, y, id);
        this.handler = handler;
        this.bufferedImage = bufferedImage;
        velX = 4;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        if (y >= 750){
            upwards = false;
        }else if(y <= 720){
            upwards = true;
        }

        if (upwards){
            y = (float) (y + 1.2);
        }else{
            y = y - 1;
        }
    }

    public void render(Graphics g) {
        g.drawImage(bufferedImage, (int)x,(int)y, null);
    }
}
