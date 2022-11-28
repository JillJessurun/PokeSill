import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HUD {
    public HUD(){

    }

    public void tick(){

    }

    public void render(Graphics g) throws IOException, FontFormatException {
        Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\textFont.otf")).deriveFont(25f);
        Font textFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(30f);
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
    }
}
