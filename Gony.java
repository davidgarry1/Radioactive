import greenfoot.*; 
import java.lang.Class;
import java.lang.Object;
import java.util.List;
public class Gony extends AcotorSub
{
    private  int[] xs;
    private  int[] ys;
    private  int m;
    private  int s;
    private int difficulty;
    private  Reid reid;
    private  Lives lives;
    private  Rollers one;
    private  Rollers two;
    private   Rollers three;
    private CurrentScore scores;
    private  ScoreDisplay dis;
    private  GreenfootSound sound;
    private  GreenfootSound music;
    private  SoundEffects sonido;
    private  String[] musicnames = new String[7];
    private  SoundEffects snd;
    private  int numlives = -1;
    private  int yobo = 0;
    private  int yoao = 0;
    private  int yojo = 0;
    private  int roob = 1;
    private  int bv = 0;
    private  int av = 0;
    private  int nj = 0;
    private  int stop = -1;
    private  int x = 50;
    private  int stort = 0;
    private  int nft;
    private  double foh = 0;
    private   boolean needstobereset = true;
    private  Volume volume;
    private  int soundy= 0;
    public Gony (int x, GreenfootSound sn, Volume vlm, SoundEffects sndcf)
    {
        super();
        m = 1;
        difficulty = x;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        ys = pool;
        reid = new Reid(difficulty);
        lives = new Lives();
        sound = sn;
        scores = new CurrentScore();
        volume = vlm;
        musicnames[0]="NH(4146-4620).mp3";
        musicnames[1]="NH(2830-3216).mp3";
        musicnames[2]="NH(2110-2500).mp3";
        musicnames[3]="NH(1639-1810).mp3";
        musicnames[4]="NH(1309-1534).mp3";
        musicnames[5]="NH(823-1140).mp3";
        musicnames[6]="NH(24-500).mp3";
        //    musicnames[7]="finger.mp3";
        int hobg = (int)(Greenfoot.getRandomNumber(7));

        music = new GreenfootSound(musicnames[hobg]);
        music.play();
        if(volume.isMute() && music.isPlaying())
        {
            music.setVolume(0);
        }
        else
        {
            music.setVolume(50);
        }
        snd = sndcf;
    }

    public Gony (int x, Volume vlm)
    {
        super();
        m = 1;
        difficulty = x;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        ys = pool;
        reid = new Reid(difficulty);
        lives = new Lives();
        soundy = 1;
        scores = new CurrentScore();
        volume = vlm;
        musicnames[0]="NH(4146-4620).mp3";
        musicnames[1]="NH(2830-3216).mp3";
        musicnames[2]="NH(2110-2500).mp3";
        musicnames[3]="NH(1639-1810).mp3";
        musicnames[4]="NH(1309-1534).mp3";
        musicnames[5]="NH(823-1140).mp3";
        musicnames[6]="NH(24-500).mp3";
        // musicnames[7]="finger.mp3";

        int hobg = (int)(Greenfoot.getRandomNumber(7));

        music = new GreenfootSound(musicnames[hobg]);
        music.play();
        if(volume.isMute() && music.isPlaying())
        {
            music.setVolume(0);
        }
        else
        {
            if(!(volume.isMute()) && music.isPlaying())
            {
                music.setVolume(50);
            }
        }

    }

    public void act() 
    {
        Greenfoot.setSpeed(44);
        foh += Math.pow(0.12, .5);
        if(volume.isMute() && music.isPlaying())
        {
            music.setVolume(0);
        }
        else
        {
            if(!(volume.isMute()) && music.isPlaying())
            {
                music.setVolume(50);
            }
        }
        if(stop<0)
        {
            stop = 1;
            // sonido = new SoundEffects();
            //getWorld().addObject(sonido, 810, 720);
            getWorld().addObject(reid, xs[0], ys[0]);
            // getWorld().addObject(lives, 770, 75);
            getWorld().addObject(lives, 770, 100);
            getWorld().addObject(scores, 75, 770);
            createRollers();
        }
        if(soundy == 0)
        {
            if(x >0)
            {
                x-=3;
                sound.setVolume(x);
            }
            else
            {
                sound.stop();
            }
        }
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
        if(needstobereset)
        {
            if(roob % 4 == 0)
            {
                this.setImage("16-gon red.png");
                roob = 1;
            }
            else
            {
                roob ++;
            }
        }

        checkLives();

    }    

    public void checkLives()
    {
        if(difficulty == 2)
        {
            int x = one.getLives() + two.getLives();

            int ty = one.getLives();
            int yu = two.getLives();

            if(stort == 0)
            {
                stort = 5;
                nj = yojo;
                bv = yobo;
            }

            yobo = ty;
            yojo = yu;
            if(nft > 2)
            {
                if(yobo != bv)
                {
                    explode(one.getPosition());
                }
                if(yojo != nj)
                {
                    explode(two.getPosition());
                }

            }
            else
            {
                nft++;
            }
            bv= yobo;
            nj = yojo;

            if (x <= 0)
            {
                reset();
                return;
            }
            x--;
            lives.setLives(x);
        }
        else
        {

            if(stort == 0)
            {
                stort = 5;
                nj = yojo;
                bv = yobo;
            }

            int x = three.getLives();
            yoao = x;
            if(nft > 2)
            {
                if(yoao != av)
                {
                    explode(three.getPosition());
                }

            }
            else
            {
                nft++;
            }
            av = yoao;
            if (x <= -3)
            {
                reset();
                return;
            }
            x--;
            x+=3;
            lives.setLives(x);
        }
    }

    public void explode(int dob)
    {
        //String non = "16" + dob + ".png";
        //  int h = dob;
        if(dob == 15)
        {
            dob = 9;
        }
        else
        {
            if(dob == 9)
            {
                dob = 15;
            }
        }
        if(dob == 14)
        {
            dob = 10;
        }
        else
        {
            if(dob == 10)
            {
                dob = 14;
            }
        }
        if(dob == 13)
        {
            dob = 11;
        }
        else
        {
            if(dob == 11)
            {
                dob = 13;
            }
        }

        if(dob == 1)
        {
            dob = 7;
        }
        else
        {
            if(dob == 7)
            {
                dob = 1;
            }
        }
        if(dob == 2)
        {
            dob = 6;
        }
        else
        {
            if(dob == 6)
            {
                dob = 2;
            }
        }
        if(dob == 3)
        {
            dob = 5;
        }
        else
        {
            if(dob == 5)
            {
                dob = 3;
            }
        }
        if(dob == 0)
        {
            dob = 8;
        }
        else
        {
            if(dob == 8)
            {
                dob = 0;
            }
        }

        String non = "16" + dob + ".png";
        // System.out.println(dob);
        this.setImage(non);
        //Greenfoot.delay(1);
        needstobereset = true;
    }

    public void reset()
    {
        World worf = getWorld();

        worf.removeObjects(worf.getObjects(AcotorSub.class));

        ResetButton reb = new ResetButton(music, volume, snd);
        worf.addObject(reb, 425, 625);

        dis = new ScoreDisplay(scores.getScoreTen());
        worf.addObject(dis, 425, 490);

        MonologueEng mono = new MonologueEng();
        worf.addObject(mono, 425, 225);
    }

    public void createRollers()
    {
        if(difficulty == 2)
        {
            int math = (int)(8.0 + foh);
            int mathy = (int)(5.0 + foh);
            one = new Rollers(math, snd);
            two = new Rollers(mathy, snd);
            getWorld().addObject(one, getWorld().getHeight()/2, getWorld().getWidth()/2);
            getWorld().addObject(two, getWorld().getHeight()/2, getWorld().getWidth()/2);
        }
        else
        {
            if(difficulty == 1)
            {
                int mathy = (int)(8.0 + foh);
                three = new Rollers(mathy, snd);
                getWorld().addObject(three, getWorld().getHeight()/2, getWorld().getWidth()/2);
            }
            else
            {
                System.out.println("ERROR");
            }
        }
    }
}
