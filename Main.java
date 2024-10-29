
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    /**
     * 
     */
    public static void main(String[] args) {
        LogfileCreator creator = new LogfileCreator();
        creator.createFile("demo.log", 255);
        
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.analyzeHourlyData();
        analyzer.printHourlyCounts();
        System.out.println(analyzer.numberOfAccesses());
    }
}
