import greenfoot.*;
public class Rollers extends AcotorSub
{
   private int speed;

  private  int[] xs;
  private  int[] ys;
  private  int m;
  private  int s;

   private int jackX;
   private int finY;
   private int next;
   private int lives = 3;
  private  int stop = -1;
  private  String[] names = new String[3];
  private  SoundEffects sonido;
  private  int position;
    public Rollers(int sp, SoundEffects spc)
    {
        super();
        next = (int)(Math.random()*15);
        m = 1;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        ys = pool;

        speed = sp;
        setNames();
        sonido = spc;
        position = next;
    }

    public void setLesorFin()
    {
        if (getX() > xs[next])
        {
            jackX = 0;
        }
        else
        {
            jackX = 1;
        }
        if (getY() > ys[next])
        {
            finY = 0;
        }
        else
        {
            finY = 1;
        }
    }

    public void setNames()
    {
        names[0] = "p3.png";
        names[1] = "p4.png";
        names[2] = "p5.png";
    }

    public boolean cfr()
    {
        if(getNeighbours(35, true, Reid.class).size() > 0)
        {
            return true;
        }
        return false;
    }

    public void act() 
    {
        World world = getWorld();
        int temp = (int)(Math.random()*2.0 + .5);
        setImage(names[temp]);
        if(stop <0)
        {
            stop = 1;
            setLesorFin();
        }

        if(jackX == 1 && finY == 1)
        {
            //System.out.println("1, 1");
            if(getX()+20 > xs[next] && getY()+20 > ys[next])
            {
                next = simplify((int)(Math.random()*6+next+4));
                this.turnTowards(xs[next], ys[next]);
                if(!cfr())
                {
                    errorm();
                }
                move(speed);
                setLesorFin();
            }
            else
            {
                this.turnTowards(xs[next], ys[next]);
                move(speed);
                position = next;
            }

        }
        else
        {
            if(jackX == 1 && finY == 0)
            {

                //System.out.println("1, 0");

                if(getX()+20 > xs[next] && getY()-20 < ys[next])
                {
                    //next = simplify((int)(Math.random()*6+3+next));
                    next = simplify((int)(Math.random()*6+next+4));
                    this.turnTowards(xs[next], ys[next]);

                    if(!cfr())
                    {
                        errorm();
                    }

                    move(speed);
                    setLesorFin();
                }
                else
                {
                    this.turnTowards(xs[next], ys[next]);
                    move(speed);
                    position = next;
                }

            }
            else
            {
                if(jackX == 0 && finY == 1)
                {
                    // System.out.println("0, 1");
                    if(getX()-20 < xs[next] && getY()+20 > ys[next])
                    {
                        next = simplify((int)(Math.random()*6+next+4));
                        //next = simplify((int)(Math.random()*6+3+next));
                        this.turnTowards(xs[next], ys[next]);

                        if(!cfr())
                        {
                            errorm();
                        }

                        move(speed);
                        setLesorFin();
                    }
                    else
                    {
                        this.turnTowards(xs[next], ys[next]);
                        move(speed);
                        position = next;
                    }

                }
                else
                {
                    if(jackX == 0 && finY == 0)
                    {//System.out.println("0, 0");

                        if(getX()-20 < xs[next] && getY()-20 < ys[next])
                        {
                            next = simplify((int)(Math.random()*6+next+4));
                            //next = simplify((int)(Math.random()*6+3+next));
                            this.turnTowards(xs[next], ys[next]);

                            if(!cfr())
                            {
                                errorm();
                            }

                            move(speed);
                            setLesorFin();
                        }
                        else
                        {
                            this.turnTowards(xs[next], ys[next]);
                            move(speed);
                            position = next;
                        }

                    }
                }
            }

        }
    }    

    public int getPosition()
    {
        return position;
    }

    public int getLives()
    {
        return lives;
    }

    public void errorm()
    {
        lives--;
        if(!(sonido.isMute()))
        {
            GreenfootSound die = new GreenfootSound("die3.mp3");
            die.play();
        }
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
