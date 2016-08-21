package demo.jvm.chapter3;

/**
 * VM参数： -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author xiongl
 * @create 2016-08-21 14:02
 */
public class TestAllocation
{
    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args)
    {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次Minor GC
    }
}
