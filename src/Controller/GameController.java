import java.util.ArrayList;

public class GameController {
    public ArrayList<Monster> monster;
    public Player player;
    public static GameController instance = null;

    public static GameController getInstance(){
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public GameController(){
        monster = new ArrayList<Monster>();
        // add monster when game start
        for(int i=0;i<10;i++){
            monster.add(randomMonster());
        }

    }

    private Monster randomMonster(){
        int max = 3, min = 1;
        int randnum = min + (int)(Math.random() * ((max - min) + 1));
        if (randnum == 1){
            return new Zombie();
        }
        if (randnum == 2){
            return new Skeleton();
        }
        if (randnum == 3){
            return new Creeper();
        }
        else{
            return new Boss();
        }
    }

    public void removeDeadMonster(){
        for (int i=0;i<monster.size();i++){
            if(monster.get(i).getHp() == 0){
                monster.remove(i);
                i--;
            }
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }
    public ArrayList<Monster> getMonster(){
        return monster;
    }
}