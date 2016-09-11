package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:29
 */
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D>
{
    public final E five;
    
    public FiveTuple(A a, B b, C c, D d, E e)
    {
        super(a, b, c, d);
        this.five = e;
    }
    
    @Override
    public String toString()
    {
        return "(" + first + "," + second + "," + third + "," + four + "," + five + ")";
    }
}
