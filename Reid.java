import greenfoot.*;
public class Reid extends AcotorSub
{
  private  int[] xs;
  private  int[] ys;
  private  int m;
  private  int s;
  private  int cur;
  private  int shipy;
    public Reid(int rod)
    {
        super();
        m = 1;
        cur = 0;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        ys = pool;
        shipy = rod-1;
        if(shipy != 0)
        {
            setImage("spaceship2b.png");
        }
    }
 private   boolean h = true;
 private   boolean y = true;
 private   int timer = -1;
    public void act() 
    {
        if(!(isRight()&&isLeft()))
        {
            if(isLeft())
            {
                if(shipy == 0)
                {
                    setImage("sp2.png");
                }
                else
                {
                    setImage("spaceship2b.png");
                }
                cur = simplify(cur+1);
                setLocation(xs[cur], ys[cur]);
                if(h)
                {
                    setRotation(getRotation()-22);
                    h = false;
                }
                else
                {
                    setRotation(getRotation()-23);
                    h = true;
                }
                if(!(timer == -1))
                {
                    Greenfoot.delay(3);
                }
            }
            else
            {
                if(isRight())
                {
                    if(shipy == 0)
                    {
                        setImage("sp.png");
                    }
                    else
                    {
                        setImage("spaceship2.png");
                    }
                    cur = simplify(cur-1);
                    setLocation(xs[cur], ys[cur]);
                    if(y)
                    {
                        setRotation(getRotation()+22);
                        y = false;
                    }
                    else
                    {
                        setRotation(getRotation()+23);
                        y = true;
                    }
                    if(!(timer == -1))
                    {
                        Greenfoot.delay(3);
                    }
                }
            }
        }
        if(!(isRight() || isLeft()))
        {
            timer += 6;
        }
        else
        {
            timer = -1;
        }

    }    

    public boolean isRight()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            return true;
        }
        return false;
    }

    public boolean isLeft()
    {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            return true;
        }
        return false;
    }

    public int simplify(int num)
    {
        //System.out.println("ORG: " + num);
        if(num>15)
        {
            while(num>15)
            {
                num = num-16;
            }
        }
        else
        {
            while(num<0)
            {
                num = num+16;

            }
        }
        //System.out.println("CHG: " + num);
        return num;
    }
}
