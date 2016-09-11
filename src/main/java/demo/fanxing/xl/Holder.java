package demo.fanxing.xl;

import demo.fanxing.Holder1;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 11:49
 */
public class Holder<T>
{
    private T a, b, c;
    
    public Holder(T a, T b, T c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public T getA()
    {
        return a;
    }
    
    public void setA(T a)
    {
        this.a = a;
    }
    
    public T getB()
    {
        return b;
    }
    
    public void setB(T b)
    {
        this.b = b;
    }
    
    public T getC()
    {
        return c;
    }
    
    public void setC(T c)
    {
        this.c = c;
    }

    public static void main(String[] args){
        Holder<Holder1> holder = new Holder<>(new Holder1(), new Holder1(), new Holder1());
        Holder1 holderA = holder.getA();
        Holder1 holderB = holder.getB();
        Holder1 holderC = holder.getC();
    }
}
