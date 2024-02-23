import java.util.Calendar;

/**
 * The Clock class represents a concurrent clock that continuously prints the current time.
 * It extends the Thread class and overrides the run() method to continuously update the time and print it.
 */
/**
 * The Clock class represents a concurrent clock that continuously prints the current time.
 * It extends the Thread class to run as a separate thread.
 */
public class Clock extends Thread {

    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;
    Calendar calendar = Calendar.getInstance();

    /**
     * The run method is the entry point for the Clock thread.
     * It continuously updates the time and prints it every second.
     */
    public void run() {
        while (true) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            second = calendar.get(Calendar.SECOND);
            minute = calendar.get(Calendar.MINUTE);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH) + 1;
            year = calendar.get(Calendar.YEAR);
            printTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * The printTime method prints the current time in the format "Time: HH:MM:SS DD-MM-YYYY".
     */
    public void printTime() {
        System.out.printf("Time: %02d:%02d:%02d %02d-%02d-%04d\n", hour, minute, second, day, month, year);
    }

    /**
     * The main method creates an instance of the Clock class, sets its priority to maximum,
     * and starts the clock thread.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.setPriority(Thread.MAX_PRIORITY);
        clock.start();
    }
}
