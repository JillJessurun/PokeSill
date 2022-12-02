import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HUD extends MouseAdapter {

    private Game game;
    private int playerHealth = 1000;
    private int enemeyHealth = 1000;
    private int counter = 0;
    public boolean metronomePressed = false;

    public HUD(Game game){
        this.game = game;
    }

    public void tick(){
        if (game.metronomePressed) {
            counter++;
            if (game.yourTurn) {
                if (counter > 140) {
                    playerHealth = playerHealth - game.basePower;
                    game.metronomePressed = false;
                    metronomePressed = false;
                    counter = 0;
                }
            }else{
                if (counter > 140) {
                    enemeyHealth = enemeyHealth - game.basePower;
                    game.metronomePressed = false;
                    metronomePressed = false;
                    counter = 0;
                }
            }
        }
    }

    public void render(Graphics g) throws IOException, FontFormatException {
        //fonts
        Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(20f);
        Font textFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(30f);
        Font textFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(14f);
        Font HPFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(12f);
        g.setFont(textFont2);

        // your health bar
        g.setColor(Color.black);
        g.fillRoundRect(62,547,506,36,40,40);
        g.setColor(Color.darkGray);
        g.fillRoundRect(65,550,497,28,40,40);
        g.setColor(Color.green);
        g.fillRoundRect(65,550,playerHealth/2,30,40,40);
        g.setColor(Color.black);
        g.setFont(HPFont);
        g.drawString("HP = " + playerHealth, 82,600);
        g.setFont(textFont2);

        // enemy health bar
        g.fillRoundRect(1267,547,506,36,40,40);
        g.setColor(Color.darkGray);
        g.fillRoundRect(1270,550,497,28,40,40);
        g.setColor(Color.red);
        g.fillRoundRect(1270,550,enemeyHealth/2,30,40,40);
        g.setColor(Color.black);
        g.setFont(HPFont);
        g.drawString("HP = " + enemeyHealth, 1290,600);
        g.setFont(textFont2);

        //text bar
        g.setColor(Color.black);
        g.fillRoundRect(588,533,604,74,10,10);
        g.setColor(Color.white);
        g.fillRoundRect(590,535,600,70,10,10);
        g.setColor(Color.black);
        g.setFont(textFont);
        if (game.metronomePressed) {
            g.drawString(game.move, 610, 573);
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
