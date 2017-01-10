/**
 * title: Event.java
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
 * superclass to define the various event functionality for greenhouse.java
 *</P>
 *<P>
 * This superclass defines the key functionality that is needed for the various
 * events.
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
 * public abstract class Event {<BR>
 * holds the variables and methods for events
 *</P>
 * 
 * <P>
 * public abstract class Event {<BR>
 * This class holds the main variable for greenhouse events
 *</P>
 * 
 * 
 * <H3>Event</H3>
 *
 *<P>
   these methods and constructors hold the values for greenhouse events
 *</P>
 *
 *<P>
   private Instant eventTime; 
   * takes an instant of Time
    protected final Duration delayTime;
    * Define the duration of time before a tasks start & stopes
 *</P>
 * 
 * <p>
   public void Start () {
        function to interpret how the delaytime should be executed
 * <p>
    public boolean ready() {
        function that defines when event is ready for execution
    }
 * </p>
 * 
 * * <p>
    public abstract void action();
        executes the event according to business requirements 
 * </p>
 
/**
 * CODE...
 */

package greenhouse.controls;
import java.time.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author ArtaFarahmand1
 */
public abstract class Event {
    
    private Instant eventTime; // takes an instant of Time
    protected final Duration delayTime;  // defines the duration of time delay
    
    public Event (long millisecondDelay){
        delayTime = Duration.ofMillis(millisecondDelay); // defins the delay seconds
        Start();
    }
    
    // function to intrupet how the delaytime shoue be exectured
    
    public void Start () {
        eventTime = Instant.now().plus(delayTime); 
    }
    
    // function that defines when event is ready for execution
    
    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }
    
    // executes the event according to business requirements
    
    public abstract void action();
}
