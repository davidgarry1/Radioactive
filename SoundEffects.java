import greenfoot.*;

public class SoundEffects extends Actor
{
   private boolean now = true;
   // SoundTitle title;
    public SoundEffects()
    {
        super();
      //  title = new SoundTitle();
    }
   private int cob = 0;
    public void act() 
    {
        if(cob == 0)
        {
            cob ++;
        //    getWorld().addObject(title, 750, 750);
        }
        if(pressed())
        {
            if(now)
            {
                now = false;
                setImage("soundeffectsvolume2.png");
                //mute();
            }
            else
            {
                now = true;
                setImage("soundeffectsvolume1.png");
                //  unmute();
            }
        }
    }    

    public boolean isMute()
    {
        if(now == false)
        {
            return true;
        }
        return false;
    }

    public boolean pressed()
    {
        if(Greenfoot.mouseClicked(this))
        {
            return true;
        }
        return false;
    }
}
