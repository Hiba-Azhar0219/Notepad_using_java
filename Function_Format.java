import java.awt.Font;

public class Function_Format{

    GUI gui;
    Font arial, CMS, TNR;
    String selectedFont;

    public Function_Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){
        if(gui.wrap == false){
            gui.wrap = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: ON");

        }
        else if(gui.wrap ==true){
            gui.wrap = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: OFF");
        }
    }

    public void font(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize );
        CMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        TNR = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch(selectedFont){
            case "Arial":
            gui.textArea.setFont(arial);
            break;

            case "Comic Sans MS":
            gui.textArea.setFont(CMS);
            break;

            case "Times New Roman":
            gui.textArea.setFont(TNR);
            break;
        }
    }
}