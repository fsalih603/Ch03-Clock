
/**
 * THIS IS THE 12 HOUR BRANCH  
 * 
 * The ClockDisplay class implements a digital clock display for a
 * American-style 24 hour clock. The clock shows hours and minutes. Hours 
 * always run from 00-11, where 00 needs to be displayed as 12. It is the job 
 * of the clock display to make sure that the change from 11 -> 00 internally
 * triggers a change from AM to PM or from PM to AM as appropriate.
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
    private String meridian;        // Display "AM" or "PM"
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00 AM.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        hours.setValue(12);
        meridian = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * The hour is 1-12 and meridian is "AM" or "PM".
     */
    public ClockDisplay(int hour, int minute, String meridian)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        this.meridian = "AM";
        setTime(hour, minute, meridian);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            incrementHour();
        }
        updateDisplay();
    }

    /**
     * Move the hour forward according to the 12-hours
     *
     */
    private void incrementHour()
    {
        int current = hours.getValue();
        if(current == 11) {
            hours.setValue(12);
            toggleMeridian(); 
        }
        else if(current == 12) {
            hours.setValue(1);
        }
        else {
            hours.increment();
        }
    }
    /*
     * Go between AM and PM
     */
    private void toggleMeridian()
    {
        if(meridian.equals("AM")) {
            meridian = "PM";
        }
        else {
            meridian ="AM";
        }
    }
    
    /**
     * Set the time of the display to the specified hour, meridian, and
     * minute.
     */
    public void setTime(int hour, int minute, String meridian)
    {
        if(hour >= 1 && hour <= 12 &&
        (meridian.equalsIgnoreCase("AM") || meridian.equalsIgnoreCase("PM"))) {
            hours.setValue(hour);
            minutes.setValue(minute);
            this.meridian = meridian.toUpperCase();
            updateDisplay();
        
        }
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " " + meridian;
    }
}
