import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.JMException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{

    //text area component
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wrap = false;

    //top menuBar
    JMenuBar menuBar;
    JMenu menuFile, menuFormat, menuEdit, menuColor, menuWebScraper;

    //fileMenu
    JMenuItem iNew, iOpen, iSave, iExit;
    Function_File file = new Function_File(this);

    //formatMenu   
    Function_Format format = new Function_Format(this);
    //formatMenuItem
    JMenuItem iWrap, iFontArial, iFontCMS, iFontTNR;
    JMenuItem iSize15, iSize18, iSize22, iSize26;
    //Menu inside FormatMenu
    JMenu menuFont, menuSize;

    //Color menuItems
    JMenuItem iWhite, iBlue, iGreen, iPurple, iRed, iOrange, iBlack;
    Function_Color color = new Function_Color(this);

    //Edit Menu
    JMenuItem iUndo, iRedo;
    Function_Edit edit = new Function_Edit(this);
    UndoManager um = new UndoManager();

    //handling keys 
    KeyHandler kHandler = new KeyHandler(this);


    //web scraper
    Function_WebScraper ws = new Function_WebScraper(this);
    JMenuItem iSIBA, iTimes;



    public static void main(String[] args) {
        new GUI();
    }
    
   public  GUI(){
    createWindow();
    createTextArea();
    createMenuBar();
    createFileMenu();
    createFormatMenu();
    createColorMenu();
    createEditMenu();
    createWebScraperMenu();
    format.selectedFont = "Arial";
    format.font(22);
    color.setColor("White");
    window.setVisible(true);
    

   }      //constructor

   public void createWindow(){
    window  = new JFrame("Notepad");
    window.setSize(800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void createTextArea(){
    textArea = new JTextArea();
    textArea.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
        public void undoableEditHappened(UndoableEditEvent e){
            um.addEdit(e.getEdit()); 
        }   
    });

    textArea.addKeyListener(kHandler);
    scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
    window.add(scrollPane);
   }

   public void createMenuBar(){
    menuBar = new JMenuBar();
    window.setJMenuBar(menuBar);

    menuFile = new JMenu("File");
    menuBar.add(menuFile);

    menuEdit = new JMenu("Edit");
    menuBar.add(menuEdit);

    menuFormat = new JMenu("Format");
    menuBar.add(menuFormat);

    menuColor = new JMenu("Color");
    menuBar.add(menuColor);

    menuWebScraper = new JMenu("Web Scraper");
    menuBar.add(menuWebScraper);
  
   }

   public void createFileMenu(){
    iNew = new JMenuItem("New");
    iNew.addActionListener(this);
    iNew.setActionCommand("Untitled");
    menuFile.add(iNew);

    iOpen = new JMenuItem("Open");
    iOpen.addActionListener(this);
    iOpen.setActionCommand("Open");
    menuFile.add(iOpen);

    iSave = new JMenuItem("Save");
    iSave.addActionListener(this);
    iSave.setActionCommand("Save");
    menuFile.add(iSave);

    iExit = new JMenuItem("Exit");
    iExit.addActionListener(this);
    iExit.setActionCommand("Exit");
    menuFile.add(iExit);
   }

   //formatMenu functions
   
   public void createFormatMenu(){
    iWrap = new JMenuItem("Word Wrap : OFF");
    iWrap.addActionListener(this);
    iWrap.setActionCommand("Word Wrap");
    menuFormat.add(iWrap);

    menuFont = new JMenu("Font");
    iFontArial = new JMenuItem("Arial");
    iFontArial.addActionListener(this);
    iFontArial.setActionCommand("Arial");
    menuFont.add(iFontArial);


    iFontCMS = new JMenuItem("Comic Sans MS");
    iFontCMS.addActionListener(this);
    iFontCMS.setActionCommand("Comic Sans MS");
    menuFont.add(iFontCMS);


    iFontTNR = new JMenuItem("Times New Roman");
    iFontTNR.addActionListener(this);
    iFontTNR.setActionCommand("Times New Roman");
    menuFont.add(iFontTNR);

    menuSize = new JMenu("Size");
    iSize15 = new JMenuItem("15");
    iSize15.addActionListener(this);
    iSize15.setActionCommand("15");
    menuSize.add(iSize15);


    iSize18 = new JMenuItem("18");
    iSize18. addActionListener(this);
    iSize18.setActionCommand("18");
    menuSize.add(iSize18);


    iSize22 = new JMenuItem("22");
    iSize22.addActionListener(this);
    iSize22.setActionCommand("22");
    menuSize.add(iSize22);


    iSize26 = new JMenuItem("26");
    iSize26.addActionListener(this);
    iSize26.setActionCommand("26");
    menuSize.add(iSize26);

    menuFormat.add(menuFont);
    menuFormat.add(menuSize);

   }

   public void createColorMenu(){
    iWhite = new JMenuItem("White");
    iWhite.addActionListener(this);
    iWhite.setActionCommand("White");
    menuColor.add(iWhite);


    iBlue = new JMenuItem("Blue");
    iBlue.addActionListener(this);
    iBlue.setActionCommand("Blue");
    menuColor.add(iBlue);

    iBlack = new JMenuItem("Black");
    iBlack.addActionListener(this);
    iBlack.setActionCommand("Black");
    menuColor.add(iBlack);

    iGreen = new JMenuItem("Green");
    iGreen.addActionListener(this);
    iGreen.setActionCommand("Green");
    menuColor.add(iGreen);

    iRed = new JMenuItem("Red");
    iRed.addActionListener(this);
    iRed.setActionCommand("Red");
    menuColor.add(iRed);

    iOrange = new JMenuItem("Orange");
    iOrange.addActionListener(this);
    iOrange.setActionCommand("Orange");
    menuColor.add(iOrange);


    iPurple = new JMenuItem("Purple");
    iPurple.addActionListener(this);
    iPurple.setActionCommand("Purple");
    menuColor.add(iPurple);

   }


   public void createEditMenu(){
    iUndo = new JMenuItem("Undo");
    iUndo.addActionListener(this);
    iUndo.setActionCommand("Undo");

    iRedo = new JMenuItem("Redo");
    iRedo.addActionListener(this);
    iRedo.setActionCommand("Redo");
    menuEdit.add(iUndo);
    menuEdit.add(iRedo);

   }

   public void createWebScraperMenu(){
    iSIBA = new JMenuItem("SIBA Links");
    iSIBA.addActionListener(this);
    iSIBA.setActionCommand("SIBA Links");
    menuWebScraper.add(iSIBA);

    iTimes = new JMenuItem("Python Learning Links");
    iTimes.addActionListener(this);
    iTimes.setActionCommand("Python Learning Links");
    menuWebScraper.add(iTimes);


   }

   @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "Untitled":
            file.newFile();
            break;

            case "Open":
            file.open(); 
            break;

            case "Save":
            file.save();
            break;

            case "Exit":
            file.exit();
            break;

            case "Word Wrap":
            format.wordWrap();
            break;

            case "15":
            format.font(15);
            break;

            case "18":
            format.font(18);
            break;

            case "22":
            format.font(22);
            break;

            case "26": 
            format.font(26);
            break;

            case "Arial":
            format.setFont("Arial");
            break;

            case "Comic Sans MS":
            format.setFont("Comic Sans MS");
            break;

            case "Times New Roman":
            format.setFont("Times New Roman");
            break;   
            
            case "White":
            color.setColor("White");
            break;

            case "Black":
            color.setColor("Black");
            break;

            case "Blue":
            color.setColor("Blue");
            break;

            case "Orange":
            color.setColor("Orange");
            break;

            case "Green":
            color.setColor("Green");
            break;

            case "Purple":
            color.setColor("Purple");
            break;

            case "Red":
            color.setColor("Red");
            break;

            case "Undo":
            edit.undo();
            break;

            case "Redo":
            edit.redo();
            break;

            case "SIBA Links":
            ws.SIBALinks();
            break;

            case "Python Learning Links":
            ws.pythonLinks();
            break;

     }
    } 

}