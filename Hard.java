import greenfoot.*;

public class Hard extends AcotorSub
{
   private int thing = 0;
    public void act() 
    {
        if(pressed())
        {
            if(thing == 0)
            {
                thing = 2;
                setImage("HARD2.png");
            }
            else
            {
                thing = 0;
                setImage("HARD.png");
            }
        }
    }    

    public void setThing(int ok)
    {
        if(ok == 0)
        {
            thing = 0;
            setImage("HARD.png");
        }
        else
        {
            thing = 2;
            setImage("HARD2.png");
        }
    }

    public int getThing()
    {
        return thing;
    }

    public boolean pressed()
    {
        Greenfoot gren = new Greenfoot();
        if(gren.mouseClicked(this))
        {
            return true;
        }
        return false;
    }
}
