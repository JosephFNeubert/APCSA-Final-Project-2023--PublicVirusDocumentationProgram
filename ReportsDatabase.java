
/* 
This class will execute all the necessary functions of the program
to organize, sort, add, and find within the database of virus site reports. 
*/
//Import packages
import java.util.ArrayList;

//ReportsDatabase class
public class ReportsDatabase {
    // Sets up the only variable for this class (and scanner too)
    private ArrayList<String[]> reports;

    // Constructor
    public ReportsDatabase(ArrayList<String[]> reports) {
        this.reports = reports;
    }

    // Method to add new report to the database
    public void newReport(String websiteName, String link, String malwareType, String number, String description) {
        websiteName = websiteName.toLowerCase();
        String[] temp = { websiteName, link, malwareType, number, description };

        // Linear search to determine what index this new report is placed in database
        int count = 0;
        int countStart = 0;
        boolean countStartCondition = false;
        for (int i = 0; i < reports.size(); i++) {
            if (temp[0].compareTo(reports.get(i)[0]) == 0) {
                if (countStartCondition == false) {
                    countStart = i;
                    countStartCondition = true;
                }
                count++;
            }
        }
        count = count + countStart + 1;
        if (count != 1) {
            reports.add(count, temp);
        } else {
            reports.add(temp);
        }
    }

    // Method to do the initial search of reports within database
    public ArrayList<String[]> search1(String target, int targetType) {
        ArrayList<String[]> temp = new ArrayList<String[]>();
        int count = 0;
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i)[targetType].equals(target)) {
                count++;
                temp.add(reports.get(i));
            }
        }
        System.out.println("We have found " + count + " reports from your query.");
        return temp;
    }

    // Method to do the deeper search if chosen by user
    public void search2(ArrayList<String[]> temp, int number) {
        if (number == 0) {
            for (String[] i : temp) {
                System.out.println("");
            }
        }
    }
}
