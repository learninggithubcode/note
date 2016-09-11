package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:05
 */
public class TwoTuple<A, B>
{
    public final A first;
    
    public final B second;
    
    public TwoTuple(A a, B b)
    {
        first = a;
        second = b;
    }
    
    @Override
    public String toString()
    {
        return "(" + first + "," + second + ")";
    }
}
