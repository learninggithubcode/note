package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:09
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>
{
    public final C third;
    
    public ThreeTuple(A a, B b, C c)
    {
        super(a, b);
        this.third = c;
    }
    
    @Override
    public String toString()
    {
        return "(" + first + "," + second + "," + third + ")";
    }
}
