package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:05
 */
public class SixTuple<A, B, C, D, E, F> extends FourTuple<A, B, C, D>
{
    public final E e;
    
    public final F f;
    
    public SixTuple(A a, B b, C c, D d, E e, F f)
    {
        super(a, b, c, d);
        this.e = e;
        this.f = f;
    }
    
}
