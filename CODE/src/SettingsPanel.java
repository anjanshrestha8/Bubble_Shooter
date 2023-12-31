

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


/**
 * a class to display the panel of settings and scores on the right
 * and handle the settings of the game
 *
 */


public class SettingsPanel extends JPanel {

    private MainFrame mainFrame;
    private JLabel scoreLabel;
    private JPanel lowerPanel;
    private JSpinner rowSpinner;
    private JSpinner colorSpinner;
    private JButton newGameButton;
    private JButton stopGameButton;


    /**
     * constructor, initiates the panel and sets the parameter
     * as its mainframe
     */

    public SettingsPanel(MainFrame m) {
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
        setLayout(new BorderLayout());
        mainFrame = m;
    }

    public void initComponents() {
        scoreLabel = new JLabel("0", SwingConstants.RIGHT);
        scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        scoreLabel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        scoreLabel.setFont(new Font("Courier", Font.BOLD, 34));


        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));

        JPanel rowsPanel = new JPanel();
        rowsPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        rowsPanel.setLayout(new BorderLayout());
        SpinnerModel rowsModel = new SpinnerNumberModel(7, 3, 15, 1);
        rowSpinner = new JSpinner(rowsModel);

        JLabel rowsLabel = new JLabel("Initial rows :");
        rowsLabel.setBackground(Color.cyan);
        rowsLabel.setForeground(Color.BLACK);
        rowsLabel.setOpaque(true);
        rowsLabel.setFont(new Font("Courier", Font.BOLD, 14));
        rowsLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        rowsPanel.add(rowsLabel, BorderLayout.WEST);
        rowsPanel.add(rowSpinner, BorderLayout.EAST);
        rowsPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        colorPanel.setLayout(new BorderLayout());
        SpinnerModel colorModel = new SpinnerNumberModel(4, 3, 8, 1);
        colorSpinner = new JSpinner(colorModel);

        JLabel colorLabel = new JLabel("Initial colors :");
        colorLabel.setFont(new Font("Courier", Font.BOLD, 14));
        colorLabel.setBackground(Color.cyan);
        colorLabel.setOpaque(true);
        colorLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        colorPanel.add(colorLabel, BorderLayout.WEST);
        colorPanel.add(colorSpinner, BorderLayout.EAST);
        colorPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        buttonPanel.setOpaque(true);
        newGameButton = new JButton("New game");
        newGameButton.setActionCommand("NEWGAME");
        newGameButton.addActionListener(mainFrame);
        newGameButton.setBackground(Color.GREEN);
        newGameButton.setOpaque(true);

        stopGameButton = new JButton("Stop game");
        stopGameButton.setActionCommand("STOP GAME");
        stopGameButton.addActionListener(mainFrame);
        stopGameButton.setBackground(Color.RED);
        stopGameButton.setOpaque(true);
        buttonPanel.add(newGameButton);
        buttonPanel.add(stopGameButton);

        lowerPanel.setBackground(Color.DARK_GRAY);
        lowerPanel.setOpaque(true);
        lowerPanel.add(rowsPanel);
        lowerPanel.add(colorPanel);
        lowerPanel.add(buttonPanel);
        JPanel spaceholder = new JPanel();
        spaceholder.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 340));
        lowerPanel.add(spaceholder);
        add(scoreLabel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.CENTER);
    }

    public void updateScore(long score) {
        scoreLabel.setText((new Long(score).toString()));
    }

    public int getRow() {

        return (int) rowSpinner.getValue();
    }

    public int getColor() {
        return (int) colorSpinner.getValue();
    }
}
