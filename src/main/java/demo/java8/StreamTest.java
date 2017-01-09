package demo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest
{
    private static List<String> getFilterOutput(List<String> lines, String filter)
    {
        List<String> result = new ArrayList<>();
        for (String line : lines)
        {
            if (!"mkyong".equals(line))
            {
                result.add(line);
            }
        }
        return result;
    }
    
    @Test
    public void filter_collect_test()
    {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        
        // java7
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result)
        {
            System.out.println(temp); // output : spring node
        }
        
        System.out.println("----------------------------------------------");
        
        // java8
        List<String> result1 = lines.stream() // convert list to stream
            .filter(line -> !"mkyong".equals(line)) // filters the line, equals to "mkyong"
            .collect(Collectors.toList()); // collect the output and convert streams to a List
            
        result1.forEach(System.out::println); // output : spring node
        
        System.out.println(lines.stream().collect(Collectors.joining("-")));
    }
    
    private Person getStudentByName(List<Person> persons, String name)
    {
        
        Person result = null;
        for (Person temp : persons)
        {
            if (name.equals(temp.getName()))
            {
                result = temp;
            }
        }
        return result;
    }
    
    @Test
    public void filter_findAny_orElse()
    {
        List<Person> persons = Arrays.asList(new Person("mkyong"), new Person("michael"), new Person("lawrence"));

        persons.stream().filter(s->s.equals("abc")).forEach(System.out::println);

        // java7
        Person result7 = getStudentByName(persons, "michael");
        System.out.println(result7);

        System.out.println("----------------------------------------------");

        // java 8
        Person result8 = persons.stream() // Convert to steam
//            .filter(x -> "michael".equals(x.getName())) // we want "michael" only
            .filter(x -> x.getName() != null)
            .findAny() // If 'findAny' then return found
            .orElse(null); // If not found, return null
        System.out.println(result8);
    }
}

class Person
{
    private String name;
    
    public Person(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}
