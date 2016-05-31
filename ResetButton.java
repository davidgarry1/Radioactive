import greenfoot.*;

public class ResetButton extends AcotorSub
{
   private GreenfootSound sound;
   private Volume volume;
   private SoundEffects snd;
    public ResetButton(GreenfootSound sndr, Volume vlm, SoundEffects sndc)
    {
        super();
        sound = sndr;
        volume = vlm;
        snd = sndc;
    }
   private int x = 50;
    public void act() 
    {
        // if(x>0)
        //   {
        //       x--;
        //        sound.setVolume(x);
        //   }
        //  else
        //   {
        //       sound.stop();
        //    }
        
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
        if(pressed())
        {
            World world = getWorld();
            world.removeObjects(world.getObjects(AcotorSub.class));
            PlayButton play = new PlayButton(sound, volume, snd);
            world.addObject(play, 425, 425);
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
}
