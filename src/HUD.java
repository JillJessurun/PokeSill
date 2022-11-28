import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HUD extends MouseAdapter {

    private Game game;

    public HUD(Game game){
        this.game = game;
    }

    public void tick(){

    }

    public void render(Graphics g) throws IOException, FontFormatException {
        //fonts
        Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(20f);
        Font textFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(30f);
        Font textFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(14f);
        g.setFont(textFont2);

        // your health bar
        g.setColor(Color.black);
        g.fillRoundRect(47,47,406,36,40,40);
        g.setColor(Color.green);
        g.fillRoundRect(50,50,400,30,40,40);
        g.setColor(Color.black);
        g.drawString("HP", 470,74);

        // enemy health bar
        g.fillRoundRect(1267,47,406,36,40,40);
        g.setColor(Color.red);
        g.fillRoundRect(1270,50,400,30,40,40);
        g.setColor(Color.black);
        g.drawString("HP", 1690,74);

        //text bar
        g.setColor(Color.black);
        g.fillRoundRect(588,33,604,74,10,10);
        g.setColor(Color.white);
        g.fillRoundRect(590,35,600,70,10,10);
        g.setColor(Color.black);
        g.setFont(textFont);
        g.drawString("Do your metronome!", 610,73);

        //main menu button
        g.setFont(textFont3);
        g.drawString("Main menu", 850,125);
        //g.drawRect(850,112,75,15);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //main menu button
        if (mouseOver(mx, my, 850,112,75,15)) {
            if (game.programState == Game.STATE.Game) {
                game.programState = Game.STATE.Menu;
                game.metronomePressed = false;
            }
        }
    }

    public static float getMouseXposition(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        return (float) point.getX();
    }

    public static float getMouseYposition(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        return (float) point.getY();
    }

    public static boolean mouseHover(float x, float y, int width, int height){
        if (getMouseXposition() > (x + width)){
            return false;
        }else if (getMouseXposition() < x){
            return false;
        }else if (getMouseYposition() > (y + height)){
            return false;
        }else if (getMouseYposition() < y){
            return false;
        }else{
            return true;
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
