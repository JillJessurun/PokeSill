import java.util.Objects;

public class MoveTypeCheck {

    // these methods are for the defending pokemon. The parameter is the type of the move which hits it.

    public double normal(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 2;
        }else if (type.equals("ghost")){
            multiplier = 0;// no effect
        }
        return multiplier;
    }

    public double fighting(String type){
        double multiplier = 1;
        if (type.equals("flying")){
            multiplier = multiplier * 2;
        }else if (type.equals("rock")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("psychic")){
            multiplier = multiplier * 2;
        }else if (type.equals("dark")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double flying(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier / 2;
        }else if (type.equals("ground")){
            multiplier = 0;
        }else if (type.equals("rock")){
            multiplier = multiplier * 2;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("electric")){
            multiplier = multiplier * 2;
        }else if (type.equals("ice")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double poison(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("poison")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ground")){
            multiplier = multiplier * 2;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("psychic")){
            multiplier = multiplier * 2;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double ground(String type){
        double multiplier = 1;
        if (type.equals("poison")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("rock")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("water")){
            multiplier = multiplier * 2;
        }else if (type.equals("grass")){
            multiplier = multiplier * 2;
        }else if (type.equals("electric")){
            multiplier = 0;
        }else if (type.equals("ice")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double rock(String type){
        double multiplier = 1;
        if (type.equals("normal")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fighting")){
            multiplier = multiplier * 2;
        }else if (type.equals("flying")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("poison")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ground")){
            multiplier = multiplier * 2;
        }else if (type.equals("steel")){
            multiplier = multiplier * 2;
        }else if (type.equals("fire")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("water")){
            multiplier = multiplier * 2;
        }else if (type.equals("grass")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double bug(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("flying")){
            multiplier = multiplier * 2;
        }else if (type.equals("ground")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("rock")){
            multiplier = multiplier * 2;
        }else if (type.equals("fire")){
            multiplier = multiplier * 2;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double ghost(String type){
        double multiplier = 1;
        if (type.equals("normal")){
            multiplier = 0;
        }else if (type.equals("fighting")){
            multiplier = 0;
        }else if (type.equals("poison")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ghost")){
            multiplier = multiplier * 2;
        }else if (type.equals("dark")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double steel(String type){
        double multiplier = 1;
        if (type.equals("normal")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fighting")){
            multiplier = multiplier * 2;
        }else if (type.equals("flying")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("poison")){
            multiplier = 0;
        }else if (type.equals("ground")){
            multiplier = multiplier * 2;
        }else if (type.equals("rock")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("steel")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fire")){
            multiplier = multiplier * 2;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("psychic")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ice")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("dragon")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double fire(String type){
        double multiplier = 1;
        if (type.equals("ground")){
            multiplier = multiplier * 2;
        }else if (type.equals("rock")){
            multiplier = multiplier * 2;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("steel")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fire")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("water")){
            multiplier = multiplier * 2;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ice")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double water(String type){
        double multiplier = 1;
        if (type.equals("steel")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fire")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("water")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("grass")){
            multiplier = multiplier * 2;
        }else if (type.equals("electric")){
            multiplier = multiplier * 2;
        }else if (type.equals("ice")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double grass(String type){
        double multiplier = 1;
        if (type.equals("flying")){
            multiplier = multiplier * 2;
        }else if (type.equals("poison")){
            multiplier = multiplier * 2;
        }else if (type.equals("ground")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("bug")){
            multiplier = multiplier * 2;
        }else if (type.equals("fire")){
            multiplier = multiplier * 2;
        }else if (type.equals("water")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("electric")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ice")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double electric(String type){
        double multiplier = 1;
        if (type.equals("flying")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ground")){
            multiplier = multiplier * 2;
        }else if (type.equals("steel")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("electric")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double psychic(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("bug")){
            multiplier = multiplier * 2;
        }else if (type.equals("ghost")){
            multiplier = multiplier * 2;
        }else if (type.equals("psychic")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("dark")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double ice(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 2;
        }else if (type.equals("rock")){
            multiplier = multiplier * 2;
        }else if (type.equals("steel")){
            multiplier = multiplier * 2;
        }else if (type.equals("fire")){
            multiplier = multiplier * 2;
        }else if (type.equals("ice")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

    public double dragon(String type){
        double multiplier = 1;
        if (type.equals("fire")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("water")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("grass")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("electric")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("ice")){
            multiplier = multiplier * 2;
        }else if (type.equals("dragon")){
            multiplier = multiplier * 2;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double dark(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 2;
        }else if (type.equals("bug")){
            multiplier = multiplier * 2;
        }else if (type.equals("ghost")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("psychic")){
            multiplier = 0;
        }else if (type.equals("dark")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("fairy")){
            multiplier = multiplier * 2;
        }
        return multiplier;
    }

    public double fairy(String type){
        double multiplier = 1;
        if (type.equals("fighting")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("poison")){
            multiplier = multiplier * 2;
        }else if (type.equals("bug")){
            multiplier = multiplier * 0.5;
        }else if (type.equals("steel")){
            multiplier = multiplier * 2;
        }else if (type.equals("dragon")){
            multiplier = 0;
        }else if (type.equals("dark")){
            multiplier = multiplier * 0.5;
        }
        return multiplier;
    }

}
