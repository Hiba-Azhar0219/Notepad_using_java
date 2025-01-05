
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyHandler implements KeyListener{
    GUI gui;

    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        }
        else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
            gui.file.open();
        }

        else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){
            gui.file.newFile();
        }

        else if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.menuFile.doClick();
        }

        else if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E){
            gui.menuEdit.doClick();
        }

        else if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_M){
            gui.menuFormat.doClick();
        }

        else if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_C){
            gui.menuColor.doClick() ;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
  
}