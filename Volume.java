import greenfoot.*;

public class Volume extends Actor
{
    private boolean now = true;
    public Volume()
    {
        super();
    }

    public void act() 
    {
        if(pressed())
        {
            if(now)
            {
                now = false;
                setImage("musicvolume2.png");
                //mute();
            }
            else
            {
                now = true;
                setImage("musicvolume1.png");
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
    // public void mute()
    //   {

    //  }

    // public void unmute()
    //    {
    //  }

    public boolean pressed()
    {
        if(Greenfoot.mouseClicked(this))
        {
            return true;
        }
        return false;
    }
}
