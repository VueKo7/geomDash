import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
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