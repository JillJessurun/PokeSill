import java.awt.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends MouseAdapter {

    private int counterX = 1400;
    private double counterY = 50;
    private boolean rightwards = false;
    private boolean downwards = false;
    private boolean mirror = false;

    private BufferedImage background;
    private BufferedImage gif;
    private BufferedImage gif2;
    private ImageMirror imageMirror;
    private Game game;

    public Menu(BufferedImage background, BufferedImage gif, BufferedImage gif2, ImageMirror imageMirror, Game game) {
        this.background = background;
        this.gif = gif;
        this.gif2 = gif2;
        this.imageMirror = imageMirror;
        this.game = game;
    }

    public void tick() {

    }

    public void render(Graphics g) throws IOException, FontFormatException {
        //fonts
        Font titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\Pokemon Solid.ttf")).deriveFont(140f);
        Font titleFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\Pokemon Hollow.ttf")).deriveFont(140f);
        Font buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\November Night.ttf")).deriveFont(60f);

        //background
        g.drawImage(background, 0, 0, null);

        //gifs
        //g.drawImage(gif, 50, 800, null);//pokeball

        if (counterX < 800) {
            rightwards = true;
            mirror = true;
        }else if (counterX > 1400) {
            rightwards = false;
            mirror = true;
        }else{
            mirror = false;
        }
        if (rightwards) {
            counterX++;
        } else {
            counterX--;
        }
        if (mirror) {
            gif2 = imageMirror.flip(gif2);
            mirror = false;
        }

        if (counterY >= 90){
            downwards = false;
        }else if (counterY <= 50){
            downwards = true;
        }

        if (downwards){
            counterY = counterY + 0.5;
        }else{
            counterY = counterY - 0.5;
        }

        g.drawImage(gif2, counterX, (int) counterY, null);//alakazam
        //g.setColor(Color.black);
        //g.drawRect(counterX, (int) counterY, 230, 241);

        //title
        g.setColor(Color.orange);
        g.setFont(titleFont);
        g.drawString("Pikamon", 190, 200);
        g.setColor(Color.black);
        g.setFont(titleFont2);
        g.drawString("Pikamon", 189, 200);

        //buttons
        g.setFont(buttonFont);
        g.drawString("Play", 260, 440);
        //g.drawRect(260, 395, 138, 50);
        g.drawString("Options", 260, 560);
        //g.drawRect(260, 515, 230, 50);
        g.drawString("Quit", 260, 680);
        //g.drawRect(260, 635, 132, 50);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //play button menu
        if (mouseOver(mx, my, 260, 395, 138, 50)) {
            game.programState = Game.STATE.Game;
            game.gameStarted = true;
        }

        //quit button menu
        if (mouseOver(mx, my, 260, 635, 132, 50)) {
            System.exit(0);
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
