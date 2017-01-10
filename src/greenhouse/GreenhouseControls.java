/**
 * title: GreenhouseControls.java
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
 * This class holds all of the subclasses that control the various tasks
 * my greenhouse has to perform.
 *</P>
 *<P>
 * This class holds all of the subclasses that control the various tasks
 * my greenhouse has to perform.
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
   public class LightOn extends Event{<BR>
            this holds all of the functions to turn the light on
 *</P>
 * 
 * <p>
    public class LightOff extends Event{
        this holds all of the function to turn the light off
    }
 * </p>
 * 
 * <p>
    public class WaterOn extends Event{
        his holds all of the function to turn the Water On
    }
 * </p>
 * 
 * <p>
    public class WaterOff extends Event{
        his holds all of the function to turn the Water Off
    }
 * </p>
 * 
 * <p>
    public class ThermostatOn extends Event{
        his holds all of the function to turn the thermostat On
    }
 * </p>
 * 
 * * <p>
    public class FanOn extends Event{
        his holds all of the function to turn the fan On
    }
 * </p>
 * 
 * * <p>
    public class FanOff extends Event{
        his holds all of the function to turn the fan off
    }
 * </p>
 * 
 * <p>
    public class Bell extends Event{
        a continue event that rings the bell after a predefined time delay
    }
 * </p>
 * 
 *  <p>
    public class Restart extends Event{
        a continue event that will restart the program after all
        * greenhouse tasks are complete
    }
 * </p>
 * 
 * public class Terminate extends Event{
        a continue event that will terminate the program after all
        * greenhouse tasks are complete
    }
 * </p>
 */

/**
 * CODE...
 */

package greenhouse;
import greenhouse.controls.*;
import java.util.concurrent.*;
import java.io.*;

/**
 *
 * @author ArtaFarahmand1
 */
public class GreenhouseControls extends Controls {
    
    // boolean to define the defult state off our light
    
    private boolean Light = false;
    
    // subclass that defines how the light is turned on 
    
    public class LightOn extends Event {
        
       public LightOn (long delayTime) {
           super (delayTime);
       } 

        @Override
        public void action () {
            Light = true;
        }
        
       @Override
        public String toString () {
            return "Light On";
        }
    }
    
    // subclass that defines how the light is turned off
    
    public class LightOff extends Event {
        public LightOff (long delayTime){
            super (delayTime);
        }
       
        @Override
        public void action () {
            Light = false;
        }
        
        @Override
        public String toString () {
            return "Light Off";
        }
    }
    
    // boolean that defines the defult state for water
    
    private boolean Water = false;
    
    // subclass that defines how the water is turned on
    
    public class WaterOn extends Event {
        public WaterOn (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Water = true;
        }
        
        @Override
        public String toString () {
            return "Water On";
        }
    }
    
    // subclass that defines how the water is turned off
    
    public class WaterOff extends Event {
        public WaterOff (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Water = false;
        }
        
        @Override
        public String toString () {
            return "Water Off";
        }
    }
    
    // boolean to define the defult state 
    
    private boolean Thermostat = false;
    
    // subclass that defines how the theromstate is turned on 
    
    public class ThermostatOn extends Event {
        public ThermostatOn (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Thermostat = true;
        }
        
        @Override
        public String toString () {
            return "Thermostat On";
        }
    }
    
    // subclass that defines how the thermostat is turned off
    
    public class ThermostatOff extends Event {
        public ThermostatOff (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Thermostat = false;
        }
        
        @Override
        public String toString () {
            return "Thermostat Off";
        }
    }
    
    //boolean that defines the defult state of fan
    
    private boolean Fan = false;
    
    // subclass that defines how the fan is turned on
    
    public class FanOn extends Event{
        public FanOn (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Fan = true;
        }
        
        public String toString () {
            return "Fan On";
        }
    }
    
    // subclass that defines how the light is turned off
    
     public class FanOff extends Event{
        public FanOff (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            Fan = false;
        }
        
        @Override
        public String toString () {
            return "Fan Off";
        }
    }
    
    public class Bell extends Event {
        public Bell (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
           addEvent(new Bell(delayTime.toMillis())); 
        }
        
        @Override
        public String toString () {
            return "Bell!";
        }
    }
    
    // subclass that restart the greenhouse tasks
    
    public class Restart extends Event {
        private Event[] EventList;
        public Restart (long delayTime, Event[] EventList) {
            super(delayTime);
            this.EventList = EventList;
            for (Event e: EventList) {
                addEvent(e);
            }
        }
            
        @Override
             public void action () {
                for(Event e: EventList) {
                    e.Start();
                    addEvent(e);
                }
                Start();
                addEvent(this);
            }
            
        @Override
             public String toString () {
                 return "System Restart";
        }
    }
    
    // subclass to terminate the greenhouse tasks.
    
    public static class Terminate extends Event {
        public Terminate (long delayTime) {
            super (delayTime);
        }
        
        @Override
        public void action () {
            System.exit(0);
        }
        
        @Override
        public String toString () {
            return "Program Terminating";
        }
    }
    
  
}
