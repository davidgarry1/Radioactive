import greenfoot.*;
import java.util.List.*;
import java.lang.Object.*;
import java.lang.Class.*;
public class PlayButton extends AcotorSub
{
    private  int[] xs;
    private  int[] ys;
    private   int m;
    private   int s;
    private   Hard har;
    private   Easy eas;
    private  int difficulty;
    private  int stop;
    private  GreenfootSound sound;
    private  int soundy = 0;
    private  Volume volume;
    private  SoundEffects snd;
    private int theone = -1;
    private  int yolo = -1;
    private int tone = 0;

    public PlayButton(GreenfootSound sn, Volume vlm, SoundEffects sndic)
    {
        super();
        sound = sn;
        m = 1;
        difficulty = -1;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        stop = -200;
        ys = pool;
        volume = vlm;
        snd = sndic;
    }

    public PlayButton()
    {
        super();
        soundy = 1;
        m = 1;
        difficulty = -1;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        stop = -200;
        ys = pool;

    }

    public void addButtons()
    {
        if(stop < 1)
        {
            har = new Hard();
            eas = new Easy();
            //  System.out.println(getWorld());
            getWorld().addObject(har, 550, 675);
            getWorld().addObject(eas, 300, 675);
            stop = 7;
        }
    }

    public void checkForDouble()
    {
        if(har.getThing() < 1 && eas.getThing() < 1)
        {
            BeginError bed = new BeginError();
            getWorld().addObject(bed, 425, 140);
        }
        else
        {
            if(har.getThing() > 0 && eas.getThing() > 0)
            {
                BeginError bed = new BeginError();
                getWorld().addObject(bed, 425, 140);
            }
            else
            { if(har.getThing() > 0)
                {
                    difficulty = 2;
                }
                else
                {
                    difficulty = 1;
                }
            }
        }

    }

    public void act() 
    {

        addButtons();
        if(volume.isMute() && sound.isPlaying())
        {
            sound.setVolume(0);
        }
        else
        {
            if(!(volume.isMute()) && sound.isPlaying())
            {
                sound.setVolume(50);
            }
        }
        //  toggleButtons();
        if(pressed())
        {
            checkForDouble();
            if(difficulty > 0)
            {
                setImage("playbutton2.png");
                Greenfoot.delay(5);

                World world = getWorld();
                deleteOldObjects();
                if(soundy == 0)
                {
                    Gony goni = new Gony(difficulty, sound, volume, snd);
                    world.addObject(goni, world.getHeight()/2, world.getWidth()/2);
                }
                else
                {
                    Gony goni = new Gony(difficulty, volume);
                    world.addObject(goni, world.getHeight()/2, world.getWidth()/2);
                }
                //System.out.println(world);

                // if(soundy == 0)
                //  {
                //    sound.stop();
                //  }
                // startNewGame();
            }
            else
            {
                har.setThing(0);
                eas.setThing(0);
            }
        }
    }    

    public boolean pressed()
    {
        if(Greenfoot.mouseClicked(this))
        {
            return true;
        }
        return false;
    }

    public void startNewGame()
    {

        // getWorld().getWidth()/2, getWorld().getHeight()/2);

        // (xs[0] + xs[8])/(2), (ys[0] + ys[8])/(2));

    }

    public void deleteOldObjects()
    {
        getWorld().removeObjects(getWorld().getObjects(AcotorSub.class));
    }


    public void setter()
    {
        if(tone == 0)
        {
            if(har.getThing() > 0)
            {
                tone = 2;
            }
            else
            {
                if(eas.getThing() > 0)
                {
                    tone = 1;
                }
            }
        }
    }

    public void toggleButtons()
    {
        setter();
        if(theone != -1)
        {
            if(har.getThing() > 0 && eas.getThing() > 0)
            {
                yolo = tone;
            }
        }
        else
        {
            if(har.getThing() > 0)
            {
                theone = 1;
            }
            if(eas.getThing() > 0)
            {
                theone = 1;
            }
        }
        if(yolo > 0)
        {
            if (yolo == 1)
            {
                eas.setThing(1);
                har.setThing(0);
            }
            if (yolo == 2)
            {
                eas.setThing(0);
                har.setThing(2);
            }
        }
    }
}

 