package demo.fanxing.xl;

import java.util.Iterator;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 15:15
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>
{
    private Class[] types = {Americano.class, Breve.class, Cappuccino.class, Latte.class, Mocha.class};
    
    private static Random rand = new Random(47);
    
    public CoffeeGenerator()
    {
    }
    
    private int size;
    
    public CoffeeGenerator(int size)
    {
        this.size = size;
    }
    
    @Override
    public Coffee next()
    {
        try
        {
            return (Coffee)types[rand.nextInt(types.length)].newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Iterator<Coffee> iterator()
    {
        return new CoffeeIterator();
    }
    
    class CoffeeIterator implements Iterator<Coffee>
    {
        int count = size;
        
        public boolean hasNext()
        {
            return count > 0;
        }
        
        public Coffee next()
        {
            count--;
            return CoffeeGenerator.this.next();
        }
        
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args)
    {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
        {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5))
        {
            System.out.println(c);
        }
    }
}
