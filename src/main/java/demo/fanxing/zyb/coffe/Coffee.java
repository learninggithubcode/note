package demo.fanxing.zyb.coffe;

/**
 * Created by zhangyb on 2016/9/4 0004.
 */
public class Coffee
{
    private static long counter = 0;
    
    private final long id = counter++;
    
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "  " + id;
    }
}
