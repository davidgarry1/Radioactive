import greenfoot.*; 
public class Continue extends AcotorSub
{
   private GreenfootSound sound;
   private Volume volume;
   private SoundEffects sndc;
    public Continue(GreenfootSound snd, Volume vlm, SoundEffects sndcr)
    {
        super();
        sound = snd;
        volume = vlm;
        sndc = sndcr;
    }
    
    public void act() 
    {
          if(volume.isMute() && sound.isPlaying())
        {
            sound.setVolume(0);
        }
        else
        {
            if(!(volume.isMute()) && sound.isPlaying())
            {
                sound.setVolume(70);
            }
        }
        World world = getWorld();
        if(pressed())
        {
            world.removeObjects(world.getObjects(AcotorSub.class));
            PlayButton PlayBut = new PlayButton(sound, volume, sndc);
            world.addObject(PlayBut, 425, 425);
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
