package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 15:09
 */
public class Coffee
{
    private static long counter = 0;
    
    private final long id = counter++;
    
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "_" + id;
    }
}
