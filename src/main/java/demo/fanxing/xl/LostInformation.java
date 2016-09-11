package demo.fanxing.xl;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author xiongl
 * @create 2016-09-04 16:44
 */
class Frob
{
}

class Fnorkle
{
}

class Quark<Q>
{
}

class Particle<POSITION, MOMENTUM>
{
}

public class LostInformation
{
    public static void main(String[] args)
    {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> p = new Particle<Long, Double>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
    
}
