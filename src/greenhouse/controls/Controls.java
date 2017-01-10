/**
 * title: Controls.java
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
 * superclass to define how the greenhouse controls will operate
 *</P>
 *<P>
 * This superclass defines the key functionality that is needed to run the various
 * tasks for the greenhouse
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
 * public class  Controls {<BR>
 * holds the variables and methods that are needed to run greenhouse tasks
 *</P>
 * 
 * <P>
 * public class Greenhouse {<BR>
 * This class holds the main variable for greenhouse controls
 *</P>
 * 
 * 
 * <H3>Controls</H3>
 *
 *<P>
   these methods and constructors hold the values for greenhouse tasks
 *</P>
 *
 *<P>
   private List<Event> GreenhouseList = new ArrayList<>();<BR>
       arraylist to hold the variouse function that 
       Green house needs to perform.
 *</P>
 * 
 * <p>
   public void addEvent(Event c)
        defines how events can be added to the arraylist
 * </p>
 * 
 * <p>
    public void run() {
        method that defines how program events are to be executed.
    }
 * </p>
 
/**
 * CODE...
 */

package greenhouse.controls;
import java.util.*;
import java.lang.*;
/**
 *
 * @author ArtaFarahmand1
 */
public class Controls {
    
    /* 
        arraylist to hold the variouse function that 
       Green house needs to perform.
    */
    
    private List<Event> GreenhouseList = new ArrayList<>();
    
    // function to pass event to our arraylist
    
    public void addEvent(Event c) {
        GreenhouseList.add(c);
    }
    
    // function that defines run different actions from our arraylist
    
    public void run() {
        while(GreenhouseList.size() > 0){
            for (Event e: new ArrayList<>(GreenhouseList)){
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    GreenhouseList.remove(e);
                }
            }
        }
            
    }
}



