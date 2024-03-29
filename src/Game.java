import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends JFrame implements Runnable {

    final public static int BOARD_WIDTH = 1580;
    final public static int BOARD_HEIGHT = 720;
    Canvas canvas;

    Mappa mappa;

    Player player;


    public Game() {

        player = new Player(BOARD_WIDTH/3, 500-50, 50, 50);

        mappa = new Mappa("mappe/livello1.csv");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        canvas.setFocusable(false);
        add(canvas);

        canvas.addMouseListener(player);
        
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);

    }




    
    public void update() {

        for(Obstacle ostacolo : mappa.ostacoli) {

            ostacolo.core.x += player.directionX*(player.speed+3);
        }

        player.update(mappa.ostacoli);

    }



    public void render() {
    
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();


        //VISUALIZZAZIONE CANVAS
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        //VISUALIZZAZIONE PLAYER
        graphics.setColor(Color.BLUE);
        graphics.fillRect(player.core.x, player.core.y, (int)player.core.getWidth(), (int)player.core.getHeight());
        

        //VISUALIZZAZIONE OSTACOLI
        mappa.ostacoli.forEach((Obstacle ostacolo) -> {

            if(ostacolo.type.equals("deadly"))
                graphics.setColor(Color.RED);    
            else 
                graphics.setColor(Color.GREEN);

            graphics.fillRect(ostacolo.core.x, 
                                ostacolo.core.y, 
                                (int)ostacolo.core.getWidth(), 
                                (int)ostacolo.core.getHeight());    
        });

        graphics.dispose();
        bufferStrategy.show();
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
