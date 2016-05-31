import greenfoot.*;
import java.lang.Class;
import java.lang.Object;
import java.util.List;
public class VortexicWorld extends World
{
    int[] xs;
    int[] ys;
    int m;
    int s;
    public VortexicWorld()
    {    
        //600x400 cells, 1x1 pixels.
        super(850, 850, 1, true);
        m = 1;
        s = (int)(350.0/2.0);
        int[] pool = {(int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s) ,(int)(m*154 + s) ,(int)(m*73 + s) ,(int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s) ,(int)(m*250 + s), (int)(m*346 + s), (int)(m*426 + s) ,(int)(m*481 + s)};
        int[] boop = {((int)(m*250 + s)), (int)(m*346 + s), (int)(m*426 + s), (int)(m*481 + s), (int)(m*500 + s), (int)(m*481 + s), (int)(m*426 + s), (int)(m*346 + s), (int)(m*250 + s), (int)(m*154 + s), (int)(m*73 + s), (int)(m*19 + s), (int)(m*0 + s), (int)(m*19 + s), (int)(m*73 + s), (int)(m*154 + s)};
        xs = boop;
        ys = pool;
        LoadScreen load = new LoadScreen();
        addObject(load, 425, 425);

      //  Greenfoot.start();

    }
}
