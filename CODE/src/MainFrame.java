import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;


/**
 * this class produces the window and gives a frame to the
 * whole application
 *
 */
public class MainFrame extends JFrame implements ActionListener {
    private SettingPanel rightPanel;
    private Canvas leftPanel;

    /**
     * constructor, initiates the components, and sets the
     * properties of the frame
     */
    public MainFrame(){
        setLayout(new BorderLayout());

        rightPanel = new SettingsPanel(this);
        rightPanel.initComponents();

        leftPanel = new Canvas();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bubble Shooter");
        setSize(Constants.WINDOW_SIZE_X, Constants.WINDOW_SIZE_Y);
        setResizable(true);
        setVisible(true);
        setSize(2*Constants.WINDOW_SIZE_X-getContentPane().getSize().width,
                2*Constants.WINDOW_SIZE_Y-getContentPane().getSize().height);

    }

    /**
     * makes the left panel display the highscores
     */
    public void init(){
        leftPanel.displayHighscore(0,true);
    }

/**
 * can be called when the game is won, displays the highscores
 *  */

    public void gameWon(long score){
        rightPanel.updateScore(score);
        leftPanel.dispalayHightScore(score,false);

    }


    public void updateScore(long score){
        rightPanel.updateScore(score);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NEW GAME"));{
            leftPanel.newGame(rightPanel.getRow(),rightPanel.getColor());
            leftPanel.getGame().setMainFrame(this);
        }
         else if (e.getActionCommand().equals("STOP GAME")){
            if(leftPanel.getGame()!=null){
                leftPanel.getGame().stop();
                leftPanel.displayHighScore(0,true);
            }
         }
    }
}
