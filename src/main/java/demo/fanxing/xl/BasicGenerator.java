package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 16:22
 */
public class BasicGenerator<T> implements Generator<T>
{
    private Class<T> type;
    
    @Override
    public T next()
    {
        try
        {
            return type.newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public BasicGenerator(Class<T> type)
    {
        this.type = type;
    }
    
    public static <T> Generator<T> create(Class<T> type)
    {
        return new BasicGenerator<>(type);
    }
}
