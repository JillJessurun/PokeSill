import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

public class HUD extends MouseAdapter {

    private Game game;
    private MoveTypeCheck moveTypeCheck;
    private SpriteTypes spriteTypes;

    public int playerHealth = 1000;
    public int enemeyHealth = 1000;
    private int counter = 0;
    public boolean metronomePressed = false;
    public String type1;//type enemy
    public String type2;//type enemy
    public String type3;//type player
    public String type4;//type player
    private double multiplierBasepower = 1;
    public boolean gameOver = false;

    public HUD(Game game, MoveTypeCheck moveTypeCheck, SpriteTypes spriteTypes){
        this.game = game;
        this.moveTypeCheck = moveTypeCheck;
        this.spriteTypes = spriteTypes;
    }

    public void tick(){
        if (game.metronomePressed) {
            counter++;
            if (game.yourTurn) {
                if (counter > 140) {
                    double basepower = game.basePower * multiplierBasepower;
                    playerHealth = (int) (playerHealth - basepower);
                    game.metronomePressed = false;
                    metronomePressed = false;
                    counter = 0;
                }
            }else{
                if (counter > 140) {
                    double basepower = game.basePower * multiplierBasepower;
                    enemeyHealth = (int) (enemeyHealth - basepower);
                    game.metronomePressed = false;
                    metronomePressed = false;
                    counter = 0;
                }
            }
        }

        //GAME OVER
        if (playerHealth <= 0 || enemeyHealth <= 0){
            gameOver = true;
        }
    }

    public void render(Graphics g) throws IOException, FontFormatException {
        //fonts and colours
        Color green = new Color(10, 166, 0);
        Color opacitive = new Color(255, 255, 255,100);
        Font textFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(20f);
        Font textFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(30f);
        Font textFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(14f);
        Font HPFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(12f);
        Font gameoverFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jillj\\IdeaProjects\\PokeSill\\src\\Fonts\\fatText.otf")).deriveFont(90f);
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
        if (!gameOver) {
            g.setColor(Color.black);
            g.fillRoundRect(588, 533, 604, 74, 10, 10);
            g.setColor(Color.white);
            g.fillRoundRect(590, 535, 600, 70, 10, 10);
            g.setColor(Color.black);
            g.setFont(textFont);
        }
        if (game.metronomePressed) {
            if (!gameOver) {
                g.drawString(game.move, 610, 573);
                g.drawString("bp  " + game.moves.allBasePowerArrays[game.moveBasePowerIndex1][game.moveBasePowerIndex2], 1090, 573);
                g.drawImage(game.moveType, 1050, 550, null);
            }

            //MOVE TYPE MULTIPLIER ALGORITHMMMMMM
            //drawing type player
            if (!game.yourTurn) {
                if (spriteTypes.allTypeArrays[game.pokemonEnemyIndex - 1].length == 1) {
                    type3 = spriteTypes.allTypeArrays[game.pokemonEnemyIndex - 1][0];
                    double multiplier = findMultiplier(type3, game.currentMoveType, moveTypeCheck);
                    if (!gameOver) {
                        if (multiplier == 0.0) {
                            g.setColor(Color.red);
                            g.drawString("No effect!", 845, 630);
                        } else if (multiplier < 1) {
                            g.setColor(Color.red);
                            g.drawString("Not very effective!", 790, 630);
                        } else if (multiplier > 1) {
                            g.setColor(green);
                            g.drawString("Its super effective!", 785, 630);
                        }
                    }
                    //g.setColor(Color.black);
                    //g.drawString("multiplier = " + multiplier, 200, 250);
                    //g.drawString(type3, 200, 200);

                    multiplierBasepower = multiplier;
                } else {
                    type3 = spriteTypes.allTypeArrays[game.pokemonEnemyIndex - 1][0];
                    type4 = spriteTypes.allTypeArrays[game.pokemonEnemyIndex - 1][1];
                    double multiplier = findMultiplier(type3, game.currentMoveType, moveTypeCheck) * findMultiplier(type4, game.currentMoveType, moveTypeCheck);

                    if (!gameOver) {
                        if (multiplier == 0.0) {
                            g.setColor(Color.red);
                            g.drawString("No effect!", 845, 630);
                        } else if (multiplier < 1) {
                            g.setColor(Color.red);
                            g.drawString("Not very effective!", 790, 630);
                        } else if (multiplier > 1) {
                            g.setColor(green);
                            g.drawString("Its super effective!", 785, 630);
                        }
                    }
                    //g.setColor(Color.black);
                    //g.drawString("multiplier = " + multiplier, 200, 250);
                    //g.drawString(type3, 200, 200);
                    //g.drawString(type4, 400, 200);

                    multiplierBasepower = multiplier;
                }
            }else{
                //drawing type enemy
                if (spriteTypes.allTypeArrays[game.pokemonPlayerIndex - 1].length == 1) {
                    type1 = spriteTypes.allTypeArrays[game.pokemonPlayerIndex - 1][0];
                    double multiplier = findMultiplier(type1, game.currentMoveType, moveTypeCheck);

                    if (!gameOver) {
                        if (multiplier == 0.0) {
                            g.setColor(Color.red);
                            g.drawString("No effect!", 845, 630);
                        } else if (multiplier < 1) {
                            g.setColor(Color.red);
                            g.drawString("Not very effective!", 790, 630);
                        } else if (multiplier > 1) {
                            g.setColor(green);
                            g.drawString("Its super effective!", 785, 630);
                        }
                    }
                    //g.setColor(Color.black);
                    //g.drawString(type1, 1400, 200);
                    //g.drawString("multiplier = " + multiplier, 1400, 250);

                    multiplierBasepower = multiplier;
                }else{
                    type1 = spriteTypes.allTypeArrays[game.pokemonPlayerIndex - 1][0];
                    type2 = spriteTypes.allTypeArrays[game.pokemonPlayerIndex - 1][1];
                    double multiplier = findMultiplier(type1, game.currentMoveType, moveTypeCheck) * findMultiplier(type2, game.currentMoveType, moveTypeCheck);

                    if (!gameOver) {
                        if (multiplier == 0.0) {
                            g.setColor(Color.red);
                            g.drawString("No effect!", 845, 630);
                        } else if (multiplier < 1) {
                            g.setColor(Color.red);
                            g.drawString("Not very effective!", 790, 630);
                        } else if (multiplier > 1) {
                            g.setColor(green);
                            g.drawString("Its super effective!", 785, 630);
                        }
                    }
                    //g.setColor(Color.black);
                    //g.drawString("multiplier = " + multiplier, 1400, 250);
                    //g.drawString(type1, 1400, 200);
                    //g.drawString(type2, 1600, 200);

                    multiplierBasepower = multiplier;
                }
            }
        }else{
            if (!gameOver) {
                g.drawString("Do your metronome!", 610, 573);
            }
        }

        //main menu button
        g.setFont(textFont3);
        g.drawString("Main menu", 10,22);
        //g.drawRect(10,9,75,15);

        //GAME OVER
        if (gameOver){
            game.metronomePressed = true;
            g.setColor(opacitive);
            g.fillRect(0,0,1800,1000);

            g.setFont(gameoverFont);
            g.setColor(Color.black);
            if (playerHealth<=0) {
                g.drawString("GAME OVER", 600, 300);
            }else{
                g.drawString("CONGRATULATIONS!", 400, 300);
            }
            g.setFont(textFont2);
            if (playerHealth<=0){
                playerHealth = 0;
                g.setColor(Color.red);
                g.drawString("You lost!", 800, 400);
            }else{
                enemeyHealth = 0;
                g.setColor(green);
                g.drawString("You won!", 800, 400);
            }

            g.setColor(Color.black);
            g.setFont(textFont);
            g.drawString("Menu", 840, 450);
            //g.drawRect(840,435,55,15);
        }
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //main menu button
        if (mouseOver(mx, my, 10,9,75,15)) {
            if (game.programState == Game.STATE.Game) {
                if (!gameOver) {
                    game.programState = Game.STATE.Menu;
                    game.metronomePressed = false;
                    multiplierBasepower = 1;
                    counter = 0;
                    playerHealth = 1000;
                    enemeyHealth = 1000;
                    game.counterPlayer = 0;
                }
            }
        }

        //game over menu button
        if (mouseOver(mx, my, 840,435,55,15)) {
            if (game.programState == Game.STATE.Game) {
                if (gameOver) {
                    game.programState = Game.STATE.Menu;
                    game.metronomePressed = false;
                    playerHealth = 1000;
                    multiplierBasepower = 1;
                    counter = 0;
                    enemeyHealth = 1000;
                    gameOver = false;
                    game.counterPlayer = 0;
                }
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

    public static double findMultiplier(String pokemonType, String moveType, MoveTypeCheck moveTypeCheck){
        switch (pokemonType) {
            case "bug":
                return moveTypeCheck.bug(moveType);
            case "dark":
                return moveTypeCheck.dark(moveType);
            case "dragon":
                return moveTypeCheck.dragon(moveType);
            case "electric":
                return moveTypeCheck.electric(moveType);
            case "fairy":
                return moveTypeCheck.fairy(moveType);
            case "fighting":
                return moveTypeCheck.fighting(moveType);
            case "fire":
                return moveTypeCheck.fire(moveType);
            case "flying":
                return moveTypeCheck.flying(moveType);
            case "ghost":
                return moveTypeCheck.ghost(moveType);
            case "grass":
                return moveTypeCheck.grass(moveType);
            case "ground":
                return moveTypeCheck.ground(moveType);
            case "ice":
                return moveTypeCheck.ice(moveType);
            case "normal":
                return moveTypeCheck.normal(moveType);
            case "poison":
                return moveTypeCheck.poison(moveType);
            case "psychic":
                return moveTypeCheck.psychic(moveType);
            case "rock":
                return moveTypeCheck.rock(moveType);
            case "steel":
                return moveTypeCheck.steel(moveType);
            case "water":
                return moveTypeCheck.water(moveType);
            default:
                System.out.println("ERROR: NO MATCHING TYPE");
                return 0;
        }
    }
}
