<<<<<<< HEAD
import java.awt.Rectangle;

public class Obstacle {
    
    public Rectangle core;
    public String type; //can be either Deadly or Passive


    public Obstacle(int x, int y, int width, int height, String type) {

        core = new Rectangle(x, y, width, height);
        this.type = type;
    }



    public String toCSV() {return core.x +";"+ core.y +";"+ core.getWidth() +";"+ core.getHeight() +";";}
=======

import javafx.scene.shape.Rectangle;

public  class Obstacle {
    
    Rectangle rectangle;
    
    String tipo;

    
    public Obstacle(int x, int y, int width, int height, String tipo){
        this.rectangle=new Rectangle(x,y,width,height);
        this.tipo=tipo;
    }
>>>>>>> main
}
