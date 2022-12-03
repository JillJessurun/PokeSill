import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PokeSill extends MouseAdapter {
    private int counter = 0;
    private int randomNumber1 = 0;
    private int randomNumber2 = 0;

    private BufferedImage battlefield;
    private BufferedImage player;
    private BufferedImage enemy;
    private Game game;
    private Player playerGame;
    private Enemy enemyGame;
    private HUD hud;
    private Random random;
    private Moves moves;
    private SpriteTypes spriteTypes;
    private MoveTypeCheck moveTypeCheck;

    public PokeSill(BufferedImage battlefield, BufferedImage player, BufferedImage enemy, Game game, Player playerGame,
                    Enemy enemyGame, HUD hud, Moves moves, SpriteTypes spriteTypes, MoveTypeCheck moveTypeCheck) {
        this.battlefield = battlefield;
        this.player = player;
        this.enemy = enemy;
        this.game = game;
        this.playerGame = playerGame;
        this.enemyGame = enemyGame;
        this.hud = hud;
        this.moves = moves;
        this.spriteTypes = spriteTypes;
        this.moveTypeCheck = moveTypeCheck;
        random = new Random();
    }

    public void tick() {
        randomNumber1 = random.nextInt(18);
        randomNumber2 = random.nextInt(moves.allMoveArrays[randomNumber1].length - 1);
        playerGame.tick();
        enemyGame.tick();
        hud.tick();

        if (hud.gameOver){
            randomNumber1 = 0;
            randomNumber2 = 0;
            counter = 0;
        }
    }

    public void render(Graphics g) throws IOException, FontFormatException {
        //background
        g.drawImage(battlefield, 0, -100, null);
        Color color = new Color(56, 122, 147);
        g.setColor(color);
        g.fillRect(0, 930, 1800, 70);

        if (game.gameStarted) {
            g.setColor(Color.BLACK);
            Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\SuperMario256.ttf")).deriveFont(35 + counter / 10f);
            g.setFont(textFont);
            g.drawString("Battle!", 700 - counter / 12, 480);
            counter++;
            if (counter >= 1000) {
                counter = 0;
                game.gameStarted = false;
            }
        }
        //sprites
        playerGame.render(g);
        enemyGame.render(g);

        //hud
        if (!game.gameStarted) {
            //heads up display
            hud.render(g);

            //names

            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(30f);
            g.setFont(font);
            if (!hud.gameOver) {
                g.setColor(Color.black);
            }else{
                g.setColor(Color.gray);
            }
            g.drawString(game.names.names[game.pokemonPlayerIndex - 1], 82, 530);
            g.drawString(game.names.names[game.pokemonEnemyIndex - 1], 1290, 530);

            //metronome button
            Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\SuperMario256.ttf")).deriveFont(18f);
            g.setFont(textFont);
            if (!game.metronomePressed) {
                g.setColor(Color.white);
                g.fillRect(800, 893, 150, 40);
                g.setColor(Color.black);
                g.drawRect(800, 893, 150, 40);
                g.drawString("metronome", 810, 920);
            } else {
                g.setColor(Color.lightGray);
                g.fillRect(800, 893, 150, 40);
                g.setColor(Color.gray);
                g.drawRect(800, 893, 150, 40);
                g.drawString("metronome", 810, 920);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //metronome button
        if (mouseOver(mx, my, 800, 893, 150, 40)) {
            if (game.programState == Game.STATE.Game) {
                if (!hud.gameOver) {
                    if (!hud.metronomePressed) {
                        hud.metronomePressed = true;
                        game.move = moves.allMoveArrays[randomNumber1][randomNumber2];
                        game.moveBasePowerIndex1 = randomNumber1;
                        game.moveBasePowerIndex2 = randomNumber2;
                        game.basePower = moves.allBasePowerArrays[randomNumber1][randomNumber2];
                        System.out.println("basepower = " + game.basePower);
                        if (game.yourTurn) {
                            game.yourTurn = false;
                        } else {
                            game.yourTurn = true;
                        }

                        game.metronomePressed = true;
                    }
                }
            }
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
