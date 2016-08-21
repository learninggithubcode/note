package demo.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyb on 2016/8/21 0021.
 *
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM
{
    static class OOMObject
    {
    
    }
    
    public static void main(String[] args)
    {
        List<OOMObject> list = new ArrayList<>();
        while (true)
        {
            list.add(new OOMObject());
        }
    }
}
