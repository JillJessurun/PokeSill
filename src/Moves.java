public class Moves {
    public String[] normal = {"Body Slam", "Boomburst", "Cut", "Egg Bomb", "Explosion", "Constrict", "Rage", "Pound", "Scratch", "Tackle"};//10
    public String[] fighting = {"Aura Sphere", "Drain Punch", "Close Combat", "Focus Blast", "Mach Punch", "Rock Smash"};//6
    public String[] flying = {"Brave Bird", "Aeroblast", "Gust", "Aerial Ice", "Wing Attack", "Peck", "Pluck"};//7
    public String[] poison = {"Poison Jab", "Gunk Shot", "Poison Sting", "Poison Fang", "Sludge Wave", "Smog", "Acid"};//7
    public String[] ground = {"Earthquake", "Mud-Slap", "Mud Shot", "Thousand Waves", "Bulldoze", "Mud Bomb", "Stomping Tantrum"};//7
    public String[] rock = {"Accelerock", "Rollout", "Stone Edge", "Ancient Power", "Rock Wrecker", "Rock Slide"};//6
    public String[] bug = {"Leech Life", "Megahorn", "Bug Bite", "X-scissor", "Fury Cutter", "Fell Stinger"};//6
    public String[] ghost = {"Astonish", "Shadow Ball", "Lick", "Shadow Claw", "Moongeist Beam", "Ominous Wind", "Shadow Sneak"};//7
    public String[] steel = {"Bullet Punch", "Iron Head", "Meteor Mash", "Sunsteel Strike", "Magnet Bomb", "Metal Claw"};//6
    public String[] fire = {"Fire Punch", "Flare Blitz", "Ember", "Blue Flare", "Flamethrower", "Flame Charge"};//6
    public String[] water = {"Crabhammer", "Hydro Pump", "Bubble", "Surf", "Water gun", "Aqua Jet"};//6
    public String[] grass = {"Absorb", "Giga Drain", "Energy Ball", "Seed Flare", "Leafage", "Mega Drain", "Vine Whip"};//7
    public String[] electric = {"Fusion Bolt", "Charge Beam", "Thunder", "Wild Charge", "Nuzzle", "Thunder Shock"};//6
    public String[] psychic = {"Psychic", "Confusion", "Luster Purge", "Stored Power", "Prismatic Laser", "Psycho Boost"};//6
    public String[] ice = {"Ice Beam", "Blizzard", "Ice Punch", "Ice Shard", "Frost Breath", "Ice Ball"};//6
    public String[] dragon = {"Draco Meteor", "Outrage", "Dragon Claw", "Twister", "Dragon Pulse", "Dragon Breath"};//6
    public String[] dark = {"Crunch", "Bite", "Feint Attack", "Dark Pulse", "Night Slash", "Pursuit", "Assurance", "Power Trip"};//8
    public String[] fairy = {"Fleur Cannon", "Moonblast", "Strange Steam", "Play Rough", "Draining Kiss", "Fairy Wind"};//6

    public String[][] allMoveArrays = {normal, fighting, flying, poison, ground, rock, bug, ghost, steel, fire, water, grass, electric, psychic, ice, dragon, dark, fairy};

    public int[] basePowerNormal = {80, 140, 50, 100,250,20,20,40,40,40,45};
    public int[] basePowerFighting = {80,75,120,140,40,40};
    public int[] basePowerFlying = {120,95,40,60,60,40,60};
    public int[] basePowerPoison = {80,120,10,55,95,30,40};
    public int[] basePowerGround = {100,20,55,90,60,65,75};
    public int[] basePowerRock = {40,20,100,60,150,75};
    public int[] basePowerBug = {80,120,60,80,40,50};
    public int[] basePowerGhost = {20,80,20,70,100,60,40};
    public int[] basePowerSteel = {40,80,95,100,55,70};
    public int[] basePowerFire = {75,125,40,130,95,60};
    public int[] basePowerWater = {100,120,20,90,40,40};
    public int[] basePowerGrass = {20,75,80,120,40,55,40};
    public int[] basePowerElectric = {100,60,140,95,20,40};
    public int[] basePowerPsychic = {95,50,75,20,140,140};
    public int[] basePowerIce = {90,140,75,40,70,30};
    public int[] basePowerDragon = {140,120,80,40,85,60};
    public int[] basePowerDark = {90,60,60,80, 70,40,60,20};
    public int[] basePowerFairy = {130,90,75,95,60,40};

    public int[][] allBasePowerArrays = {basePowerNormal, basePowerFighting, basePowerFlying, basePowerPoison, basePowerGround, basePowerRock, basePowerBug, basePowerGhost,
            basePowerSteel, basePowerFire, basePowerWater, basePowerGrass, basePowerElectric, basePowerPsychic, basePowerIce, basePowerDragon, basePowerDark, basePowerFairy};
}
