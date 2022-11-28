import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    private Enemy enemyGame;
    private HUD hud;

    public PokeSill(BufferedImage battlefield, BufferedImage player, BufferedImage enemy, Game game, Player playerGame, Enemy enemyGame, HUD hud){
        this.battlefield = battlefield;
        this.player = player;
        this.enemy = enemy;
        this.game = game;
        this.playerGame = playerGame;
        this.enemyGame = enemyGame;
        this.hud = hud;
    }

    public void tick(){
        playerGame.tick();
        enemyGame.tick();
        hud.tick();
    }

    public void render(Graphics g) throws IOException, FontFormatException {
        if (game.pokemonRenderReady) {
            //background
            g.drawImage(battlefield, 0, -100, null);

            //sprites
            playerGame.render(g);
            enemyGame.render(g);

            hud.render(g);
        }
    }
}
