
import javafx.scene.shape.Rectangle;

public  class Obstacle {
    
    Rectangle rectangle;
    
    String tipo;

    
    public Obstacle(int x, int y, int width, int height, String tipo){
        this.rectangle=new Rectangle(x,y,width,height);
        this.tipo=tipo;
    }
}
