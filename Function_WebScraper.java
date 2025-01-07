import java.io.BufferedReader;
import java.io.FileReader;

public class Function_WebScraper {
    
    GUI gui;

    public Function_WebScraper(GUI gui){
        this.gui = gui;

    }
    public void SIBALinks(){

        try {
            String pythonScript = "SIBAScraping.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonScript);
            Process process = pb.start();
            process.waitFor();

            BufferedReader br = new BufferedReader(new FileReader("data/SIBA.txt")); 
            gui.textArea.setText("");  
            String line = null; 
            while((line = br.readLine())!=null){
                gui.textArea.append(line+"\n");
                

                }
                br.close();
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           }

           
    public void pythonLinks(){
        try {
            String pythonScript = "timesScraping.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonScript);
            Process process = pb.start();  
            process.waitFor();

            BufferedReader br = new BufferedReader(new FileReader("data/timesLinks.txt")); 
            gui.textArea.setText("");  
            String line = null; 
            while((line = br.readLine())!=null){
                gui.textArea.append(line+"\n");
            }
            br.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    
    
}
