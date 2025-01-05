
import java.awt.Color;

public class Function_Color {
    GUI gui;

    public Function_Color(GUI gui){
        this.gui = gui;
    }

    public void setColor(String color){
        switch (color) {
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;

                case "Purple":
                gui.window.getContentPane().setBackground(Color.MAGENTA);
                gui.textArea.setBackground(new Color(121,45,170));
                gui.textArea.setForeground(Color.white);
                break;

                case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.white);
                break;

                
                case "Green":
                gui.window.getContentPane().setBackground(new Color(204,231,76));
                gui.textArea.setBackground(new Color(204,231,76));
                gui.textArea.setForeground(Color.BLACK);
                break;

                case "Orange":
                gui.window.getContentPane().setBackground(new Color(232,122,8));
                gui.textArea.setBackground(new Color(232,122,8));
                gui.textArea.setForeground(Color.WHITE);
                break;

                case "Red":
                gui.window.getContentPane().setBackground(new Color(214,31,48));
                gui.textArea.setBackground(new Color(214,31,48));
                gui.textArea.setForeground(Color.WHITE);
                break;

                case "Blue":
                gui.window.getContentPane().setBackground(new Color(0, 150, 255));
                gui.textArea.setBackground(new Color(0, 150, 255));
                gui.textArea.setForeground(Color.BLACK);
                break;           
        }
    }
}
