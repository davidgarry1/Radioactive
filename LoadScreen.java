import greenfoot.*;
public class LoadScreen extends AcotorSub
{
    private int yolo = -1;
   private GreenfootSound sound;
    public LoadScreen()
    {
        super();
        sound = new GreenfootSound("radio.mp3");
        sound.setVolume(50);
        sound.play();
        //start();
    }

    public void start()
    {
        Greenfoot.delay(10);
        Greenfoot.start();
    }
   private Volume butv;
   private SoundEffects sonido;
    public void act() 
    {
        World world = getWorld();
        if(yolo < 0)
        {
            //Greenfoot.delay(40);
            MonologueBeginning mono = new MonologueBeginning();
            world.addObject(mono,425, 540);

            butv = new Volume();
            world.addObject(butv, 762, 810);
            
           
            
            sonido = new SoundEffects();
            world.addObject(sonido, 740, 750);

            
            Continue cunt = new Continue(sound, butv, sonido);
            world.addObject(cunt,425, 750);
            
            
            yolo = 6;
        }
        if(butv.isMute() && sound.isPlaying())
        {
            sound.setVolume(0);
        }
        else
        {
            if(!(butv.isMute()) && sound.isPlaying())
            {
                sound.setVolume(50);
            }
        }
    }    

}
