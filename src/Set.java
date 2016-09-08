
import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class Set
{

    HashSet a;

    public HashSet SetInteger(int i)
    {
        a = new HashSet<Integer>(i);
        return a;
    }

    public HashSet SetDouble(int i)
    {
        a = new HashSet<Double>(i);
        return a;
    }

    public HashSet SetFloat(int i)
    {
        a = new HashSet<Float>(i);
        return a;
    }

    public HashSet SetString(int i)
    {
        a = new HashSet<String>(i);
        return a;
    }

    public HashSet SetBoolean(int i)
    {
        a = new HashSet<Boolean>(i);
        return a;
    }

    public void add(int item)
    {
        a.add(new Integer(item));
    }

    public void remove(int item)
    {
       Integer b = new Integer(item);
        a.remove(b);
    }

    public void add(String item)
    {
        a.add(item);

    }

    public void remove(String item)
    {
       String b = new String(item);
        a.remove(b);
    }


    public void add(boolean item)
    {
        a.add(item);
    }

    public void remove(boolean item)
    {
        Boolean b = new Boolean(item);
        a.remove(b);
    }

    public void add(double item)
    {
        a.add(item);
    }

    public void remove(double item)
    {
        Double b = new Double(item);
        a.remove(b);
    }

    public void add(float item)
    {
        a.add(item);
    }

    public void remove(float item)
    {
       Float b = new Float(item);
        a.remove(b);
    }

    public boolean contains(int item)
    {
        return a.contains(item);
    }

    public boolean contains(double item)
    {
        return a.contains(item);
    }

    public boolean contains(boolean item)
    {
        return a.contains(item);
    }

    public boolean contains(float item)
    {
        return a.contains(item);
    }

    public boolean contains(String item)
    {
        return a.contains(item);
    }

    public int getSize()
    {
        return a.size();
    }

    public ArrayList getListInteger()
    {
        Object[] b = a.toArray();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < b.length; i++)
        {
            temp.add((int) b[i]);
        }
        return temp;

    }

    public ArrayList getListDouble()
    {
        Object[] b = a.toArray();
        ArrayList<Double> temp = new ArrayList<Double>();
        for (int i = 0; i < b.length; i++)
        {
            temp.add((double) b[i]);
        }
        return temp;

    }

    public ArrayList getListFloat()
    {
        Object[] b = a.toArray();
        ArrayList<Float> temp = new ArrayList<Float>();
        for (int i = 0; i < b.length; i++)
        {
            temp.add((float) b[i]);
        }
        return temp;

    }

    public ArrayList getListBoolean()
    {
        Object[] b = a.toArray();
        ArrayList<Boolean> temp = new ArrayList<Boolean>();
        for (int i = 0; i < b.length; i++)
        {
            temp.add((boolean) b[i]);
        }
        return temp;

    }

    public ArrayList getListString()
    {
        Object[] b = a.toArray();
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < b.length; i++)
        {
            temp.add((String) b[i]);
        }
        return temp;

    }
    
    public String getString()
    {
        String str = "";
        Object[] array = a.toArray();
        for(Object temp: array)
        {
               str = str + (temp + ". ");   
        }
        return str;
    }

}
