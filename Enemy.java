import java.util.ArrayList;
import java.util.Random;

/**
 * not to be created directly, recommended to be created through EntityManager
 * creates an enemy that will pursue the player
 */
public class Enemy extends EntityCharacter {
    Random rand = new Random();
    private ArrayList<Point> path = new ArrayList<Point>();
    private String dialog = "";



    public Enemy(int x, int y, char symbol) {
        super(x, y, symbol);
    }

    /**
     * moves the enemy along the A* path towards the player
     */
    public void step() {
        if (path.size() > 0) {
            Point pt = path.get(path.size() - 1);
            this.setX(pt.getX());
            this.setY(pt.getY());
            path.remove(path.size() - 1);
        }
    }

    private double alternateXTime = 0.0;

    /**
     * alternate between capital and lower case
     *
     * @param delta
     */
    public void update(double delta) {
        alternateXTime += delta / 1000;

        if (alternateXTime >= 0.2) {
            alternateXTime = 0;
            //System.out.println("SWITCH");
            if (Character.isLowerCase(this.getSymbol())) {
                this.setSymbol(Character.toUpperCase(this.getSymbol()));
            } else {
                this.setSymbol(Character.toLowerCase(this.getSymbol()));
            }
        }
    }



    /**
     * Returns value of path
     *
     * @return
     */
    public ArrayList<Point> getPath() {
        ArrayList<Point> pathClone = new ArrayList<>();
        for(Point point: path){
            pathClone.add(point.clone());
        }
        return path;
    }

    /**
     * Sets new value of path
     *
     * @param
     */
    public void setPath(ArrayList<Point> path) {
        this.path = path;
    }

    /**
     * Returns value of dialog
     *
     * @return
     */

}
