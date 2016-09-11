package demo.fanxing.xl;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 14:18
 */
public class TestTuple
{
    public static TwoTuple<String, Integer> testTwoTuple()
    {
        return new TwoTuple<>("two", 2);
    }
    
    public static ThreeTuple<String, String, Integer> testThreeTuple()
    {
        return new ThreeTuple<>("three", "三", 3);
    }
    
    public static SixTuple<String, Double, Float, Integer, Byte, Short> testSixTuple()
    {
        return new SixTuple<>("six", 1.0d, 2.0f, 3, Byte.valueOf("4"), Short.valueOf("5"));
    }
    
    public static void main(String[] args)
    {
        System.out.println(testTwoTuple());
        System.out.println(testThreeTuple());
        System.out.println(testSixTuple());
    }
    
}
