import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
