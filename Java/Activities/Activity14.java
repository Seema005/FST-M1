package Activities;

import org.apache.commons.io.FileUtils;

        import java.io.File;
        import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) {
        try {
            // Create a new text file using the default File Class
            File file = new File("filepath");
            boolean fStatus = file.createNewFile();

            if (fStatus) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // Write some text into the text file
            FileUtils.writeStringToFile(file, "Hello, this is some text in the file.", "UTF-8");

            // Read data from the file
            System.out.println("Data in file: " + FileUtils.readFileToString(file, "UTF-8"));

            // Create a new directory named "resources"
            File destDir = new File("resources");
            if (!destDir.exists()) {
                destDir.mkdir();
                System.out.println("Directory 'resources' created successfully.");
            } else {
                System.out.println("Directory 'resources' already exists.");
            }

            // Copy the text file into the "resources" directory
            FileUtils.copyFileToDirectory(file, destDir);
            System.out.println("File copied to directory 'resources'.");

            // Get file from the new directory
            File newFile = FileUtils.getFile(destDir, "filepath");

            // Read data from the new file
            String newFileData = FileUtils.readFileToString(newFile, "UTF-8");
            System.out.println("Data in new file: " + newFileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
