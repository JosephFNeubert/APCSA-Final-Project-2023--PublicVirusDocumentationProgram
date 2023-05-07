
/*  Runner class for the virus website documentation program. Uses additional "ReportsDatabase" class
 *  to correctly execute all necessary functions. Program stores reports of virus websites in a ArrayList of string arrays,
 *  allows new reports to be made, and allows for anybody to find a read other reports.
 */
//Import packages
import java.util.Scanner;
import java.util.ArrayList;

//Runner
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create the database for reports
        ArrayList<String[]> reportsList = new ArrayList<String[]>();
        ReportsDatabase database = new ReportsDatabase(reportsList);
        System.out.println(
                "Welcome to the prototype Malware Site Documenter. \nHere, you may make reports of sites with apparent malware or conduct searches to check if a site has had malware before visiting!\n");

        // Beginning of executed program
        while (true) {
            System.out.println(
                    "If you'd like to make a report, type \"1\". If you'd like to make a search query, type \"2\".");
            String flag1 = scan.nextLine();

            // Process to create a new report
            if (flag1.equals("1")) {
                // To collect all necessary information to enter a report
                System.out.println("If this was a mistake, simply type \"STOP\" right now to go back.");
                System.out.println("To create a report, please enter the exact name of the website.");
                String websiteName = scan.nextLine();
                if (!websiteName.equals("STOP")) {
                    System.out.println("Please enter the link to the website.");
                    String link = scan.nextLine();
                    System.out.println(
                            "Please enter the type of malware you believe is attached to this website.\nIf it's a virus, type \"1\".\nIf it's a trojan, type \"2\".\nIf it's ransomware, type \"3\".\nIf it's spyware, type \"4\".\nIf it's adware, type \"5\".\nIf it's unknown or you're not sure, type \"6\".");
                    String malwareType = "";
                    boolean malwareTypeValid = false;
                    while (malwareTypeValid == false) {
                        malwareType = scan.nextLine();
                        if (malwareType.equals("1")) {
                            malwareType = "Virus";
                            malwareTypeValid = true;
                        } else if (malwareType.equals("2")) {
                            malwareType = "Trojan";
                            malwareTypeValid = true;
                        } else if (malwareType.equals("3")) {
                            malwareType = "Ransomware";
                            malwareTypeValid = true;
                        } else if (malwareType.equals("4")) {
                            malwareType = "Spyware";
                            malwareTypeValid = true;
                        } else if (malwareType.equals("5")) {
                            malwareType = "Adware";
                            malwareTypeValid = true;
                        } else if (malwareType.equals("6")) {
                            malwareType = "Unknown";
                            malwareTypeValid = true;
                        } else {
                            System.out.println("Please type a valid number.");
                        }
                    }
                    System.out.println("Please write a short description of the malware.");
                    String description = scan.nextLine();

                    // Enter report now that information is gathered
                    database.newReport(websiteName, link, malwareType, description);
                    System.out.println("Your report has been filed against " + websiteName + ". Thank you!\n");
                }
            }

            // Process to search within the report database
            else if (flag1.equals("2")) {
                // TODO
            }

            // Reset due to invalid input
            else {
                System.out.println("This is an invalid decision. Please try again.");
            }
        }
    }
}
