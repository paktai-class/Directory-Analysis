import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        File folder;
        File[] files;

        while (true){
            System.out.println("Please enter the path of the folder you would like to open: ");
            String path = scan.nextLine();

            folder = new File(path);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("The path you've entered is not exist");
                continue;
            }
            files = folder.listFiles();
            if(files == null || files.length == 0){
                System.out.println("There is no such file in the folder from the path you gave. \nTry again");
                continue;
            }

            break;
        }

        int javaCount = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                javaCount++;
            }
        }
        int issueCount = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                issueCount++;
            }
        }
        System.out.println("Total number of java files: " + javaCount);
        System.out.println("Total number of issues: " + issueCount);
    }
}