/**
 * title: Greenhouse.java
 * description: 
 * date: December 11, 2016
 * @author Arta Farahmand
 * @version 1.0
 * @copyright 2016-2017 Arta Farahmand
 */

/**
 * DOCUMENTATION...
 */

/**                                                                               
 *
 *<H1>Greenhouse</H1>
 *
 *<H3>Purpose and Description</H3>
 *
 *<P>
 * this program employs a package, super classes and subclasses to simulate the various functions
 * of a greenhouse.
 *</P>
 *<P>
 * This program has a number of class that simulate the various functions of a greenhouse.
 *</P>
 *<P>
 * This program requires the Sun Java SDK version 1.8 or better.
 *</P>
 *                                                                              
 *<DL>
 *<DT> Compiling and running instructions</DT>
 *<DT> Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.</DT>
 *<DT> Change to the directory containing the source code.</DT>
 *<DD> Compile:    javac Greenhouse.java</DD>
 *<DD> Run:        java Greenhouse</DD>
 *<DD> Document:   javadoc Greenhouse.java</DD>
 *</DL>
 */

 /**
 *
 * <H3>Classes</H3>
 *
 *<P>
 * public class GreenhouseControls extends Controls {<BR>
 * this class extends controls and event class defineing how various greenhouse
 * controls operate.
 *</P>
 * 
 * <P>
 * public class Greenhouse {<BR>
 * This class holds our main method.
 *</P>
 * 
 * 
 * <H3>GreenhouseControls</H3>
 *
 *<P>
   This holds subclasses for the various greenhouse functions
 *</P>
 *
 *<P>
   public static void main(String args[]) {<BR>
   This method is used to execute the application
 *</P>
 * <p>
 * BufferendReader</BR>
 * Reads the greenhouse_plans.txt
 * </p>
 *<P>
   ArrayList<BR>
  Prints the information from greenhouse_plans.txt
 *</P>
 * <P>
   try / catch method this checks to ensure that our txt file is imported correctly
   * and allows us to perform the various functions from greenhouse_plans.txt
 *</P>
 * <p> 
 * gh.addEvent 
 * </p>
 * 
 * <p>
    public static String getVariableName(String l){
        splits the string at the "=" sign
        * anything before the "=" is considered the variable name
    }
 * </p>
 * 
 * <p>
    public static String[] getVariableValue(String l){
        splits the string again at ","
        * anything after the "=" sign is considered the variable value
    }
 * </p>
 * 
 * <p>
    public static long stringToLong(String s){
        converts variable values from a string to a long
    }
 * </p>
 */

/**
 * CODE...
 */

package greenhouse;
import java.io.*;
import greenhouse.controls.*;
import java.util.*;

/**
 *
 * @author ArtaFarahmand1
 */
public class Greenhouse {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // code to access various sub classes of greenhousecontrols.java
        
        GreenhouseControls gh = new GreenhouseControls();
        
        // code for importing the green_plans.txt file
        
        String GreenhouseLine = null;
        String file = "src/greenhouse/greenhouse_plans.txt";
        ArrayList<String> l;
        
        try {
            File inputfile = new File(file);
            BufferedReader input = new BufferedReader(new FileReader (inputfile));
            l = readLines(input);
            
            /* test
            for (int i = 0; i < l.size()-1 ;i++){
                getVariableName(l.get(i));
                getVariableValue(l.get(i));
            }
            */
            
            //turn light on and off
            
            String[] light;
            light = getVariableValue(l.get(5));
            long light_state; 
            light_state = stringToLong(light[1]);
            
            light = getVariableValue(l.get(5));
            long light_state2;
            light_state2 = stringToLong(light[2]);
            
            // turn thremostat on and off
            
            String[] Thermostat;
            Thermostat = getVariableValue(l.get(3));
            long thermostat_state;
            thermostat_state = stringToLong(Thermostat[1]);
            
            Thermostat = getVariableValue(l.get(9));
            long thermostat_state2;
            thermostat_state2 = stringToLong(Thermostat[1]);
            
            // turn water on and off
            
            String[] Water;
            Water = getVariableValue(l.get(7));
            long water_state;
            water_state = stringToLong(Water[1]);
            
            Water =  getVariableValue(l.get(7));
            long water_state2;
            water_state2 = stringToLong(Water[2]);
            
            // turn fan on and off
            
            String[] Fan;
            Fan = getVariableValue(l.get(11));
            long fan_state;
            fan_state = stringToLong(Fan[1]);
            
            Fan = getVariableValue(l.get(11));
            long fan_state2;
            fan_state2 = stringToLong(Fan[2]);
            
            // ring bell
            
            String[] Bell;
            Bell = getVariableValue(l.get(8));
            long ring_bell;
            ring_bell = stringToLong(Bell[1]);
            
            // varouse function for green house are executed here 
            
            gh.addEvent(gh.new Bell(ring_bell)); // rings bell after a 1 second delay
            Event[] GreenHouseList = {
                gh.new ThermostatOn (thermostat_state), // funtion to turn Thermostate  on  after 1 second
                gh.new ThermostatOff (thermostat_state2), // funtion to turn Thermostate  off  after 7 second
                gh.new LightOn (light_state), // function to turn light  on  after 1 second
                gh.new LightOff (light_state2), // function to turn light  off  after 1 second
                gh.new WaterOn (water_state), // function to turn water  on  after 3 second
                gh.new WaterOff (water_state2), // function to turn water  off  after 5000 second
                gh.new FanOn (fan_state2), // function to turn fan  on  after 2 second
                gh.new FanOff (fan_state) // function to turn fan  off  after 8 second
            };
        
        gh.addEvent(gh.new Restart(15000, GreenHouseList)); // restarts all functions after 10 seconds
        if (args.length == 1)
            gh.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])));
        gh.run();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // function to read the properties in the file line by line.
    public static ArrayList readLines(BufferedReader input) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();
        do {
            lines.add(input.readLine());
            //System.out.println(lines.get(lines.size()-1));
        } while (lines.get(lines.size()-1) != null);
        return lines; 
    }
    
    // function to seperate the string at = sign
    // anything before the string is considered integer or string name
    
    public static String getVariableName(String l){
        String[] name;
        name = l.split("=");
        // System.out.println(name[0]);
        return name[0];
    }
    
    // function to get variables from teh text file
    /* anything after the = is considered the variable of the integer or string
       there is secondary split after "," this is for string or integer names
       that have more than one value */
    
    public static String[] getVariableValue(String l){
        String[] temp;
        String[] name;
        temp = l.split("=");
        name = temp[1].split(",");
        /*
        for(int i = 0; i < name.length; i++){
            System.out.print(name[i]+"\t");
        }
        System.out.println();
        */
        return name;
    }
    
    // function to convert string values to long 
    public static long stringToLong(String s){
        long i = Long.parseLong(s);
        return i;
    }

    
}


