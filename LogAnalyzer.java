/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    /**
     * Return the number of accesses recorded in the log file.
     */
    public int numberOfAccesses() {
        int total = 0;
        for(int num = 0; num < hourCounts.length; num++) {
            total += hourCounts[num];
        }
        
        return total;
    }
    
    /**
     * Find the busiest hour
     * Return the busiest hour
     */
    public void busiestHour() {
        int maxCount = 0;
        int busiestHour = 0;
        for(int hour = 0; hour < hourCounts.length; hour++) {
            if(hourCounts[hour] > maxCount) {
                busiestHour = hour;
                maxCount = hourCounts[hour];
            }
        } 
        
        //return busiestHour;
        
    }
    
    /**
     * Find the quietest hour
     * Return the quietest hour
     */
    public void quietestHour() {
        int minCount = numberOfAccesses();
        int quietestHour = 0;
        for(int hour = 0; hour < hourCounts.length; hour++) {
            if(hourCounts[hour] < minCount) {
                quietestHour = hour;
                minCount = hourCounts[hour];
            }
        } 
        
        //return quietestHour;
        
    }
    
    /**
     * Find the busiest two hour
     * Return the busiest two hour
     */
    public void busiestTwoHour() {
        int maxCount = 0;
        int busiestTwoHour = 0;
        for(int hour = 0; hour < hourCounts.length/2; hour++) {
            int hourPair = hourCounts[hour * 2] + hourCounts[hour * 2 + 1];
            if (hourPair > maxCount) {
                busiestTwoHour = hour;
            }
        }
         
        
        //return busiestTwoHour;
        
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
