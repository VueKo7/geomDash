import javax.swing.JFrame;

public class Game extends JFrame implements Runnable  {
    Player player;
    Mappa mappa;
    public Game (){
        player=new Player(100, 100, 20, 20, 2);
        mappa=new Mappa("mappe/livello1.csv");
        
    }

    public void update(){

    }


    public void render(){

    }



































    @Override
    public void run() {
        final double updateRate = 1.0d/60.0d;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        //long nextStatTime = System.currentTimeMillis() + 1000;

        while(player.state) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if(accumulator >= updateRate) {

                while(accumulator >= updateRate) {

                    try {update();}

                    catch(Exception e) {System.out.println(e.getMessage());}

                    finally {accumulator -= updateRate;}
                }
                render();
            }
        }
    }
    
}
