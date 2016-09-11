package demo.fanxing.zyb.tuple;

/**
 * Created by zhangyb on 2016/9/4 0004.
 */
public class TwoTuple<A, B>
{
    public final A first;
    
    public final B second;
    
    public TwoTuple(A a, B b)
    {
        this.first = a;
        this.second = b;
    }
    
    @Override
    public String toString()
    {
        return "TwoTuple{" + "first=" + first + ", second=" + second + '}';
    }
}
