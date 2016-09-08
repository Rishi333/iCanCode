
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class List
{

    ArrayList a;

    //String.
    public ArrayList ListString()
    {
        a = new ArrayList<String>();
        return a;
    }

    //Integer.
    public ArrayList ListInteger()
    {
        a = new ArrayList<Integer>();
        return a;
    }



    //Double
    public ArrayList ListDouble()
    {
        a = new ArrayList<Double>();
        return a;
    }


    //Float
    public ArrayList ListFloat()
    {
        a = new ArrayList<Float>();
        return a;
    }


    //Boolean
    public ArrayList ListBoolean()
    {
        a = new ArrayList<Boolean>();
        return a;
    }

    public void remove(boolean item)
    {
        Boolean b = new Boolean(item);
        a.remove(b);
        // return a;
    }

    public void remove(int item)
    {
        Integer b = new Integer(item);
        a.remove(b);
        // return a;
    }

    public void remove(float item)
    {
       Float b = new Float(item);
        a.remove(b);
        // return a;
    }

    public void remove(double item)
    {
        Float b = new Float(item);
        a.remove(b);
        
        // return a;
    }
    
        public void remove(String item)
    {
        String b = new String(item);
        a.remove(b);
        // return a;
    }


    public void setVal(int pos, String value)
    {
        a.set(pos, value);
        //return value;
    }

    public void setVal(int pos, int value)
    {
        a.set(pos, value);
        //return value;
    }

    public void setVal(int pos, double value)
    {
        a.set(pos, value);
        //return value;
    }

    public void setVal(int pos, float value)
    {
        a.set(pos, value);
        //return value;
    }

    public void setVal(int pos, boolean value)
    {
        a.set(pos, value);
        //return value;
    }

    public void add(String item)
    {
        a.add(item);

    }

    public void add(int item)
    {
        a.add(item);

    }

    public void add(boolean item)
    {
        a.add(item);

    }

    public void add(double item)
    {
        a.add(item);

    }

    public void add(float item)
    {
        a.add(item);

    }


    public int getIndex(String value)
    {
        int b = a.indexOf(value);
        return b;
    }
    
    
    public int getIndex(float value)
    {
        int b = a.indexOf(value);
        return b;
    }

    
    public int getIndex(boolean value)
    {
        int b = a.indexOf(value);
        return b;
    }
    
    
    public int getIndex(double value)
    {
        return a.indexOf(value);

    }
    
        public int getIndex(int value)
    {
        return a.indexOf(value);
    }
        
    public String getValString(int pos)
    {
        return (String) a.get(pos);

    }

    public int getValInteger(int pos)
    {
        return (int) a.get(pos);

    }

    public double getValDouble(int pos)
    {
        return (double) a.get(pos);

    }

    public boolean getValBoolean(int pos)
    {
        return (boolean) a.get(pos);

    }

    public float getValFloat(int pos)
    {
        return (float) a.get(pos);

    }

    public int getSize()
    {
        return a.size();

    }

}
