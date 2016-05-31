import greenfoot.*;  

public class Lives extends AcotorSub
{
   private String[] lid = new String[6];
    public Lives()
    {
        lid[0] = "OneLife.png";
        lid[1] = "TwoLives.png";
        lid[2] = "ThreeLives.png";
        lid[3] = "FourLives.png";
        lid[4] = "FiveLives.png";
        lid[5] = "SixLives.png";
    }
    public void act() 
    {
    }    
    public void setLives(int set)
    {
        setImage(lid[set]);
    }
}
