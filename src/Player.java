import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Player implements MouseListener {
    
    public Rectangle core; //Width & Height
    public boolean state; //dead="False" || alive="True"

    public int directionY = 0;
    public int directionX = -1;
    public int speed;
    private int gravity = 0;
    private int acceleration = 10;
    private boolean jump = false;

    public Player(int x, int y, int width, int height) {

        core = new Rectangle(x, y, width, height);
        state = true;
        speed = 10;
    }




    public void update(ArrayList<Obstacle> ostacoli) {

        move(ostacoli);

        //core.x += vector.getX()*speed;
        core.y += directionY*(speed+acceleration);

    }



    public void move(ArrayList<Obstacle> ostacoli) {

        //int directionX = 0;
        directionY = 1;

        if(jump) { //SALE

            directionY = -1;

            if(gravity >= 9)
                directionY = 0;
            
            if(gravity >= 13) {
                jump = false;
                gravity = 0;
            }

            gravity++;

        }

        for(int i = 0; i < ostacoli.size(); i++) {

            boolean collisionX = collisionX(ostacoli.get(i), directionX*speed);
            boolean collisionY = collisionY(ostacoli.get(i), directionY*speed);
            
            if(collisionX && collisionY && !ostacoli.get(i).type.equals("deadly")) 
                directionY = 0;
            
            if(collisionX && collisionY && ostacoli.get(i).type.equals("deadly") 
            || (collisionX && collisionY && core.y+core.height > ostacoli.get(i).core.y)) {
                state = false;
                directionX = 0;
            }
        }
    
    }




    public boolean collisionX(Obstacle ostacolo, int dX) {

        int observerX = core.x;
        int observerWidth = core.width;

        int entityX = ostacolo.core.x;
        int entityWidth = ostacolo.core.width;

        return (observerX+observerWidth+dX >= entityX && observerX+dX <= entityX+entityWidth); 
    }

    public boolean collisionY(Obstacle ostacolo, int dY) {

        int observerY = core.y;
        int observerHeight = core.height;

        int entityY = ostacolo.core.y;
        int entityHeight = ostacolo.core.height;

        return (observerY+observerHeight+dY >= entityY && observerY+dY <= entityY+entityHeight); 
    }


    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1 && directionY == 0) {
            jump = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
