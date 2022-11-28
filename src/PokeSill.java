import java.awt.*;
import java.awt.image.BufferedImage;

public class PokeSill{
    private double counter = 720;
    private double counter2 = 750;
    private boolean upwards = true;
    private boolean downwards = true;

    private BufferedImage battlefield;
    private BufferedImage player;
    private BufferedImage enemy;
    private Game game;
    private Player playerGame;

    public PokeSill(BufferedImage battlefield, BufferedImage player, BufferedImage enemy, Game game, Player playerGame){
        this.battlefield = battlefield;
        this.player = player;
        this.enemy = enemy;
        this.game = game;
        this.playerGame = playerGame;
    }

    public void tick(){
        /*
        if (counter >= 750){
            upwards = false;
        }else if(counter <= 720){
            upwards = true;
        }

        if (counter2 >= 750){
            downwards = false;
        }else if(counter2 <= 720){
            downwards = true;
        }

        if (upwards){
            counter = counter + 1.2;
        }else{
            counter = counter - 1;
        }

        if (downwards){
            counter2 = counter2 + 1.2;
        }else{
            counter2 = counter2 - 1;
        }
         */
    }

    public void render(Graphics g){
        if (game.pokemonRenderReady) {
            //background
            g.drawImage(battlefield, 0, -100, null);

            //sprites
            g.drawImage(player, 650, (int)counter, null);
            g.drawImage(enemy, 1350, (int)counter2, null);
        }
    }
}
