import java.io.BufferedReader;
import java.io.FileReader;

public class Function_WebScraper {
    
    GUI gui; 
   

    public Function_WebScraper(GUI gui){
        this.gui = gui;
        

    }

    public void title(String url){
        
        
        try {
            String pythonScript = "titleScraping.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonScript, url);
            Process process = pb.start();  
            process.waitFor();

            BufferedReader br = new BufferedReader(new FileReader("data/Title.txt")); 
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



    
    
    public void links(String url){
        
        try {
            String pythonScript = "linksScraping.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonScript, url);
            Process process = pb.start();  
            process.waitFor();

            BufferedReader br = new BufferedReader(new FileReader("data/Links.txt")); 
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
