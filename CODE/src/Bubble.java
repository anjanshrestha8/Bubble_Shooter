import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
public class Bubble {
    Color color;
    public static final int RADIUS=14;
    private boolean visible;
    Point loc;
    private boolean marked;
    public Bubble(Color c){
        color =c;
        marked=false;
    }
    public int getRow(){
        return loc.y/(Constants.ROW_DISTANCE/2);
    }
    public int getCol(){
        return loc.x/((Bubble.RADIUS+1)*2);
    }
    public void mark(){
        marked=true;
    }
    public void unmark(){
        marked=false;
    }
    public boolean isMarked(){
        return marked;
    }
    public Color getColor(){
        return color;
    }
    public void setVisible(boolean v){
        visible =v;
    }

    public boolean isVisible() {
        return visible;
    }
    public void setLocation(Point p){
        this.loc=p;
    }
    public Point getLocation(){
        return loc;
    }
    public Point getCenterLocation(){
        return new Point(loc.x+RADIUS+1,loc.y+RADIUS+1);
    }
    public void paintBubble(Graphics2D g2d){
        if(isVisible()){
            g2d.setColor(color);
            g2d.fillOval(loc.x,loc.y,RADIUS*2,RADIUS*2);
        }
    }
    public static Color getRandomColor(int bound){
        int rnd = (int)(bound<=8 ? Math.random()*bound : Math.random()*8);
    }
}
