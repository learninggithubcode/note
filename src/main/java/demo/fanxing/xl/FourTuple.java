package demo.fanxing.xl;

import demo.fanxing.xl.ThreeTuple;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:12
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C>
{
    public final D four;
    
    public FourTuple(A a, B b, C c, D d)
    {
        super(a, b, c);
        this.four = d;
    }
    
    @Override
    public String toString()
    {
        return "(" + first + "," + second + "," + third + "," + four + ")";
    }
}
