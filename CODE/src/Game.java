
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;

public class Game implements ActionListener {
    private ArrayList<RowList> bubbles;
    public LinkedList<Bubble> upcoming;
    private MovingBubble moving_bubble;
    private int initial_rows;
    private int colors;
    private Timer timer;
    private Canvas canvas;
    private int shotCount;
    private int numOfBubbles;
    private MainFrame mainFrame;
    private long score;
    private boolean stopped;
    public static final int ROW_COUNT =16;
    public static final int COL_COUNT_FULL= 14;
    public static final int COL_COUNT =13;
    public static final int SCORE_SHOT =10;
    public static final int SCORE_COHERENT =20;
    public static final int SCORE_FLOATING=40;

    public Game(int row,int colors,Canvas c){
        canvas =c;
        stopped = false;
        initial_rows = row;
        this.colors=colors;
        shotCount=0;
        numOfBubbles =0;
        score=0;
        bubbles = new ArrayList<RowList>();
        for(int i =0;i<ROW_COUNT;i++){
            RowList r = new RowList((i%2==0 ? true :false));
            bubbles.add(r);

        }

    }
    public void setMainFrame(MainFrame mainFrame) {
    }
    public void stop() {
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }



}
