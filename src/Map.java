
import java.util.HashMap;

/**
 *
 * @author Aishwarya
 */
public class Map
{

    HashMap a;

    public HashMap IntegerIntegerMap()
    {
        a = new HashMap<Integer, Integer>();
        return a;
    }

    public HashMap IntegerDoubleMap()
    {
        a = new HashMap<Integer, Double>();
        return a;
    }

    public HashMap IntegerFloatMap()
    {
        a = new HashMap<Integer, Float>();
        return a;
    }

    public HashMap IntegerStringMap()
    {
        a = new HashMap<Integer, String>();
        return a;
    }

    public HashMap IntegerBooleanMap()
    {
        a = new HashMap<Integer, Boolean>();
        return a;
    }

    public HashMap DoubleIntegerMap()
    {
        a = new HashMap<Double, Integer>();
        return a;
    }

    public HashMap DoubleDoubleMap()
    {
        a = new HashMap<Double, Double>();
        return a;
    }

    public HashMap DoubleFloatMap()
    {
        a = new HashMap<Double, Float>();
        return a;
    }

    public HashMap DoubleStringMap()
    {
        a = new HashMap<Double, String>();
        return a;
    }

    public HashMap DoubleBooleanMap()
    {
        a = new HashMap<Double, Boolean>();
        return a;
    }

    public HashMap FloatIntegerMap()
    {
        a = new HashMap<Float, Integer>();
        return a;
    }

    public HashMap FloatDoubleMap()
    {
        a = new HashMap<Float, Double>();
        return a;
    }

    public HashMap FloatFloatMap()
    {
        a = new HashMap<Float, Float>();
        return a;
    }

    public HashMap FloatStringMap()
    {
        a = new HashMap<Float, String>();
        return a;
    }

    public HashMap FloatBooleanMap()
    {
        a = new HashMap<Float, Boolean>();
        return a;
    }

    public HashMap StringIntegerMap()
    {
        a = new HashMap<String, Integer>();
        return a;
    }

    public HashMap StringDoubleMap()
    {
        a = new HashMap<String, Double>();
        return a;
    }

    public HashMap StringFloatMap()
    {
        a = new HashMap<String, Float>();
        return a;
    }

    public HashMap StringStringMap()
    {
        a = new HashMap<String, String>();
        return a;
    }

    public HashMap StringBooleanMap()
    {
        a = new HashMap<String, Boolean>();
        return a;
    }

    public HashMap BooleanIntegerMap()
    {
        a = new HashMap<Boolean, Integer>();
        return a;
    }

    public HashMap BooleanDoubleMap()
    {
        a = new HashMap<Boolean, Double>();
        return a;
    }

    public HashMap BooleanFloatMap()
    {
        a = new HashMap<Boolean, Float>();
        return a;
    }

    public HashMap BooleanStringMap()
    {
        a = new HashMap<Boolean, String>();
        return a;
    }

    public HashMap BooleanBooleanMap()
    {
        a = new HashMap<Boolean, Boolean>();
        return a;
    }

    //returns the size
    public int getSize()
    {
        return a.size();
    }
    
    //returns the size
    public String getString()
    {
        String str = "";
        for(Object temp: a.keySet())
        {

               str = str + (temp + ":" + a.get(temp) + ". ");
            
        }
        return str;
    }

    //removes a key
    public void remove(int item)
    {
        Integer b = new Integer(item);
        a.remove(b);
    }

    public void remove(String item)
    {
        String b = new String(item);
        a.remove(b);
    }

    public void remove(boolean item)
    {
        Boolean b = new Boolean(item);
        a.remove(b);
    }

    public void remove(double item)
    {
        Double b = new Double(item);
        a.remove(b);
    }

    public void remove(float item)
    {
        Float b = new Float(item);
        a.remove(b);
    }
    
    
        //removes a key
    public boolean contains(int item)
    {
        return a.containsKey((Integer)item);
    }

    public boolean contains(String item)
    {
        return a.containsKey((String)item);
    }

    public boolean contains(boolean item)
    {
       return a.containsKey((Boolean)item);
    }

    public boolean contains(double item)
    {
        return a.containsKey((double)item);
    }

    public boolean contains(float item)
    {
      
        return a.containsKey((float)item);
    }

    //gets the correct values depending on the type of the hashmap
    public int getValIntegerInteger(int key)
    {
        return (int) a.get(key);
    }

    public double getValIntegerDouble(int key)
    {
        return (double) a.get(key);
    }

    public float getValIntegerFloat(int key)
    {
        return (float) a.get(key);
    }

    public String getValIntegerString(int key)
    {
        return (String) a.get(key);
    }

    public boolean getValIntegerBoolean(int key)
    {
        return (boolean) a.get(key);
    }

    public int getValDoubleInteger(double key)
    {
        return (int) a.get(key);
    }

    public double getValDoubleDouble(double key)
    {
        return (double) a.get(key);
    }

    public float getValDoubleFloat(double key)
    {
        return (float) a.get(key);
    }

    public String getValDoubleString(double key)
    {
        return (String) a.get(key);
    }

    public boolean getValDoubleBoolean(double key)
    {
        return (boolean) a.get(key);
    }

    public int getValFloatInteger(float key)
    {
        return (int) a.get(key);
    }

    public double getValFloatDouble(float key)
    {
        return (double) a.get(key);
    }

    public float getValFloatFloat(float key)
    {
        return (float) a.get(key);
    }

    public String getValFloatString(float key)
    {
        return (String) a.get(key);
    }

    public boolean getValFloatBoolean(float key)
    {
        return (boolean) a.get(key);
    }

    public int getValStringInteger(String key)
    {
        return (int) a.get(key);
    }

    public double getValStringDouble(String key)
    {
        return (double) a.get(key);
    }

    public float getValStringFloat(String key)
    {
        return (float) a.get(key);
    }

    public String getValStringString(String key)
    {
        return (String) a.get(key);
    }

    public boolean getValStringBoolean(String key)
    {
        return (boolean) a.get(key);
    }

    public int getValBooleanInteger(boolean key)
    {
        return (int) a.get(key);
    }

    public double getValBooleanDouble(boolean key)
    {
        return (double) a.get(key);
    }

    public float getValBooleanFloat(boolean key)
    {
        return (float) a.get(key);
    }

    public String getValBooleanString(boolean key)
    {
        return (String) a.get(key);
    }

    public boolean getValBooleanBoolean(boolean key)
    {
        return (boolean) a.get(key);
    }

    //adds a value.
    public void addIntegerInteger(int key, int value)
    {
        a.put(key, value);
    }

    public void addIntegerDouble(int key, double value)
    {
        a.put(key, value);
    }

    public void addIntegerFloat(int key, float value)
    {
        a.put(key, value);
    }

    public void addIntegerString(int key, String value)
    {
        a.put(key, value);
    }

    public void addIntegerBoolean(int key, boolean value)
    {
        a.put(key, value);
    }

    public void addDoubleInteger(double key, int value)
    {
        a.put(key, value);
    }

    public void addDoubleDouble(double key, double value)
    {
        a.put(key, value);
    }

    public void addDoubleIntegerFloat(double key, float value)
    {
        a.put(key, value);
    }

    public void addDoubleString(double key, String value)
    {
        a.put(key, value);
    }

    public void addDoubleBoolean(double key, boolean value)
    {
        a.put(key, value);
    }

     public void addFloatInteger(float key, int value)
    {
        a.put(key, value);
    }

    public void addFloatDouble(float key, double value)
    {
        a.put(key, value);
    }

    public void addFloatIntegerFloat(float key, float value)
    {
        a.put(key, value);
    }

    public void addFloatString(float key, String value)
    {
        a.put(key, value);
    }

    public void addFloatBoolean(float key, boolean value)
    {
        a.put(key, value);
    }
    
        public void addStringInteger(String key, int value)
    {
        a.put(key, value);
    }

    public void addStringDouble(String key, double value)
    {
        a.put(key, value);
    }

    public void addStringIntegerFloat(String key, float value)
    {
        a.put(key, value);
    }

    public void addStringString(String key, String value)
    {
        a.put(key, value);
    }

    public void addStringBoolean(String key, boolean value)
    {
        a.put(key, value);
    }
    
            public void addBooleanInteger(boolean  key, int value)
    {
        a.put(key, value);
    }

    public void addBooleanDouble(boolean  key, double value)
    {
        a.put(key, value);
    }

    public void addBooleanIntegerFloat(boolean  key, float value)
    {
        a.put(key, value);
    }

    public void addBooleanString(boolean  key, String value)
    {
        a.put(key, value);
    }

    public void addBooleanBoolean(boolean key, boolean value)
    {
        a.put(key, value);
    }
    

    
    
    
}
