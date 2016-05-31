import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint; 
import java.io.Serializable;
import java.awt.Graphics;
import java.lang.String;
public class CurrentScore extends AcotorSub
{
    private int x = 0;
    //GreenfootImage img = new GreenfootImage(100,50);
    //r,g,b (255)
    // Color red = new Color(255,0,0);
    // Color blue = new Color(0,0,255);
    public void act() 
    {
        x++;
        GreenfootImage img = new GreenfootImage("Score: " + (x*10), 20, Color.RED, Color.black);
        this.setImage(img);
    }   

    public int getScoreTen()
    {
        return x;
    }
}
