import greenfoot.*;  

public class PlayBlinkie extends AcotorSub
{
   private int x = 0;
    public void act() 
    
    {
        if(x>10)
        {
            x++;
            setImage("PressWhite.png");
            if(x>20)
            {
                x = 0;
            }
        }
        else
        {
            x++;
            setImage("PressRed.png");
        }
    }    
}
