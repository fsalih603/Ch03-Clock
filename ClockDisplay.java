
/**
 * THIS IS THE 24Hour Branch 
 * 
 * The ClockDisplay class implements a digital clock display for a
 * American-style 24 hour clock. Internally the hours are stored as 00-23.
 * The clock shows hours and minutes. The 
 * range of the clock is 12:00 AM (midnight) to 11:59 AM (one minute before 
 * Noon) and 12:00 PM (noon) to 11:59 PM (one minute before midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Fatimah Salih
 * @version 09-28-26
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM AM/PM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     * The interna; 0-23 hour is converted to 1-12 adding AM/PM only for
     * the display.
     */
    private void updateDisplay()
    {
        int hour = hours.getValue();
        String meridian;
        
        if(hour < 12) {
            meridian = "AM";
        }
        else {
            meridian = "PM";
        }
        
        if(hour == 0) {
            hour = 12;
        }
        else if (hour > 12) {
            hour = hour - 12;
        }
        displayString = hour + ":" + minutes.getDisplayValue() + " " +
        meridian;
    }
}
