package demo.fanxing.zyb.tuple;

/**
 * Created by zhangyb on 2016/9/4 0004.
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>
{
    public final C third;
    
    public ThreeTuple(A a, B b, C third)
    {
        super(a, b);
        this.third = third;
    }
    
    @Override
    public String toString()
    {
        return "TwoTuple{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
    }
}
