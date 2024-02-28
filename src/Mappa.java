import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
<<<<<<< HEAD

public class Mappa {

    public ArrayList<Obstacle> ostacoli;


    public Mappa(String nomeMappa) {

        ostacoli = new ArrayList<>();

        caricaMappa(nomeMappa);
    }



    public void salvaMappa(String nomeFile) {

        try {
            FileWriter fileWriter = new FileWriter(nomeFile);

            for(Obstacle ostacolo : ostacoli) {

                fileWriter.write(ostacolo.toCSV());
            }

            fileWriter.close();

        } catch(Exception e) {e.printStackTrace();}

    }



    private void caricaMappa(String nomeFile) {

        try {
            FileReader file = new FileReader(nomeFile);
            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String[] tokens = line.split(";");

                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                int width = Integer.parseInt(tokens[2]);
                int height = Integer.parseInt(tokens[3]);
                String type = tokens[4];

                ostacoli.add(new Obstacle(x, y, width, height, type));
            }

            fileReader.close();
            file.close();
        
        } catch(Exception e) {e.printStackTrace();}

    }
    
}
=======
public class Mappa {
    public ArrayList<Obstacle> obstacles;


    public Mappa(String nomeFile){
        obstacles=new ArrayList<>();
        caricaMappa(nomeFile, obstacles);
    }
    public void caricaMappa(String nomeFile, ArrayList<Obstacle> obstacles){
        try{
            FileReader fileReader=new FileReader(nomeFile);
            Scanner scan=new Scanner(fileReader);
            while(scan.hasNextLine()){
                String line=scan.nextLine();
                String [] tokens=line.split(";");
                int xT=Integer.parseInt(tokens[0]);
                int yT=Integer.parseInt(tokens[1]);
                int widthT=Integer.parseInt(tokens[2]);
                int heightT=Integer.parseInt(tokens[3]);
                
                obstacles.add(new Obstacle(xT,yT,widthT,heightT,tokens[4]));
            }
            scan.close();
            fileReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void scaricaMappa(String nomeFile, ArrayList<Obstacle> obstacle){
        try{
            FileWriter fileWriter=new FileWriter("mappe/livello10.csv");
            fileWriter.write(0);
            for(int i=0; i<obstacle.size(); i++){
                fileWriter.write((int)obstacle.get(i).rectangle.getX());
                fileWriter.write(";");
                fileWriter.write((int)obstacle.get(i).rectangle.getY());
                fileWriter.write(";");
                fileWriter.write((int)obstacle.get(i).rectangle.getWidth());
                fileWriter.write(";");
                fileWriter.write((int)obstacle.get(i).rectangle.getHeight());
                fileWriter.write(";");
            }
            fileWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
>>>>>>> main
