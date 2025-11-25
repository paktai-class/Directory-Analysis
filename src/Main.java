import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Directory Analyzer");
        File folder;
        File[] files;

        // System will loop until the file path is found
        while (true){
            System.out.println("Please enter the path of the folder you would like to open: ");
            String path = scan.nextLine();

            // System search for the folder path given and check if the path is valid
            folder = new File(path);
            if (!folder.exists() || !folder.isDirectory()) {  // if the path is not valid, it will pop up message
                System.out.println("The path you've entered does not exist");
                continue;  // Return to the question
            }

            // System check if the folder path chosen have any file in it.
            files = folder.listFiles();
            if(files == null || files.length == 0){   // if the folder is empty, it will pop up message.
                System.out.println("There is no such file in the folder from the path you gave. \nTry again");
                continue;
            }

            break;  //  loop stop
        }

        // calculating all java files in the folder path selected
        int javaCount = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {  // if the system found file named java,
                javaCount++;                                          // javaCount is increasing by 1
            }
        }

        // calculating the total of issue found in the folder path selected
        int issueCount = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().contains("issue")) {  // if the system found the file named "issue"
                issueCount++;                                         // issueCount is increasing by 1
            }
        }
        System.out.println("Total number of java files: " + javaCount);  // display total java files found
        System.out.println("Total number of issues: " + issueCount);    // display total issue files found
    }
}