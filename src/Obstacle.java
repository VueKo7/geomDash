import java.awt.Rectangle;

public class Obstacle {
    
    public Rectangle core;
    public String type; //can be either Deadly or Passive


    public Obstacle(int x, int y, int width, int height, String type) {

        core = new Rectangle(x, y, width, height);
        this.type = type;
    }



    public String toCSV() {return core.x +";"+ core.y +";"+ core.getWidth() +";"+ core.getHeight() +";";}
}
