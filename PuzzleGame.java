import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleGame extends JFrame {

    private final int WIDTH = 500;
    private int HEIGHT = 500; //going to change later
    JPanel panel;
    private final int COLUMNS = 3, ROWS = 4;
    private ArrayList<FancyButton> buttonList;

    private BufferedImage imageSource; //original image
    private BufferedImage imageResized; 

    
    public PuzzleGame() {
        super("Puzzle Game");

        panel = new JPanel(); //sets a new instance of the JPanel
        panel.setLayout(new GridLayout(ROWS, COLUMNS));
        add(panel); //adds panel to the jframe.

        try{
            imageSource = loadImage();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(rootPane, "Error loading the image");
        }

        buttonList = new ArrayList<FancyButton>();
        
        for(int i = 0; i < COLUMNS * ROWS; i++) {
            FancyButton btn = new FancyButton();
            buttonList.add(btn);
            panel.add(btn);  
        }

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLocation(700, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    private BufferedImage loadImage() throws IOException{

        return ImageIO.read(new File("duck.jpg"));
    }
}
