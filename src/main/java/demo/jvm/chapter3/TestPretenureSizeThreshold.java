package demo.jvm.chapter3;

/**
 * 注：PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效
 * 测试-XX:PretenureSizeThreshold参数（代码没验证出来）
 *
 * vm参数：-Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @author xiongl
 * @create 2016-08-21 15:32
 */
public class TestPretenureSizeThreshold
{
    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args)
    {
        byte[] allocation;
        allocation = new byte[4 * _1MB];//直接分配在老年代中
    }
}
