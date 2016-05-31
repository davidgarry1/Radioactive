import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint; 
import java.io.Serializable;
import java.awt.Graphics;
import java.lang.String;
public class ScoreDisplay extends AcotorSub
{
   private int k;
    public ScoreDisplay(int x)
    {
        k = x;

    }
   private int h = 0;
    public void act() 
    {
        if( h < 10)
        {
            GreenfootImage img = new GreenfootImage("Your Score Was: " + (k*10), 30, Color.RED, Color.black);
            this.setImage(img);
            h++;
        }
        else
        {
            GreenfootImage img = new GreenfootImage("Your Score Was: " + (k*10), 30, Color.black, Color.red);
            this.setImage(img);
            h++;
            if(h > 20)
            {
                h = 0;
            }
        }
    }    
}
