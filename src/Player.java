
//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnno
import javafx.scene.shape.Rectangle;

public class Player {
    
    public Rectangle core;
    public Vector2D vector2D;
    public double speed;
    public boolean state;

    public Player(int x, int y, int width, int height, double speed)
    {
        this.core=new Rectangle(x, y, width, height);
        this.vector2D=new Vector2D(0,0);
        this.speed=speed;
        this.state=true;
    }
    
}
