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
        g.fillRoundRect(47,547,406,36,40,40);
        g.setColor(Color.green);
        g.fillRoundRect(50,550,400,30,40,40);
        g.setColor(Color.black);
        g.drawString("HP", 470,574);

        // enemy health bar
        g.fillRoundRect(1267,547,406,36,40,40);
        g.setColor(Color.red);
        g.fillRoundRect(1270,550,400,30,40,40);
        g.setColor(Color.black);
        g.drawString("HP", 1690,574);

        //text bar
        g.setColor(Color.black);
        g.fillRoundRect(588,533,604,74,10,10);
        g.setColor(Color.white);
        g.fillRoundRect(590,535,600,70,10,10);
        g.setColor(Color.black);
        g.setFont(textFont);
        if (game.metronomePressed) {
            g.drawString(game.move + "!", 610, 573);
            g.drawString("bp  " + game.moves.allBasePowerArrays[game.moveBasePowerIndex1][game.moveBasePowerIndex2],1090, 573);
            g.drawImage(game.moveType, 1050, 550, null);
        }else{
            g.drawString("Do your metronome!", 610, 573);
        }

        //main menu button
        g.setFont(textFont3);
        g.drawString("Main menu", 10,22);
        //g.drawRect(10,9,75,15);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //main menu button
        if (mouseOver(mx, my, 10,9,75,15)) {
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
