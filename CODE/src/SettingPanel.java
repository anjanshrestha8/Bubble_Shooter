import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class SettingPanel extends JPanel {
//    private MainFrame mainFrame;
    private JLabel scoreLabel;
    private JPanel lowerPanel;
    private JSpinner rowSpinner;
    private JSpinner colorSpinner;
    private JButton newGameButton;
    private JButton stopGameButton;

    public SettingPanel()
    {
        setBorder(BorderFactory.createMatteBorder(0,1,0,0, Color.BLACK));
        setLayout(new BorderLayout());
//        mainFrame=m;
    }
    public void initComponents(){
        scoreLabel=new JLabel("0",SwingConstants.RIGHT);
        scoreLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.blue));
        scoreLabel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X-Constants.FIELD_SIZE_X-5,50));
        scoreLabel.setFont(new Font("Courier",Font.BOLD,34));


        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel,BoxLayout.Y_AXIS));

        JPanel rowsPanel = new JPanel();
        rowsPanel.setPreferredSize(new Dimension(Constants.Window));
    }

}
