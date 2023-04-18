package java_HW2;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
public class task_3_p2_HW2 {
    private static final Logger logger = Logger.getLogger(task_3_p2_HW2.class.getName());
    public static void task_3_p2_HW2(String[] args) {
        String url = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String name = "John Doe";
        String filename = "file.txt";
        try {
            String fileContent = downloadFile(url);
            String replacedContent = replaceName(fileContent, name);
            saveToFile(replacedContent, filename);
            String savedFileContent = readFile(filename);
            logger.log(Level.INFO, savedFileContent);
            deleteFile(filename);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred: ", e);
        }
    }
    private static String downloadFile(String url) throws IOException {
        URL fileURL = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileURL.openStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        reader.close();
        return content.toString();
    }
    private static String replaceName(String content, String name) {
        return content.replace("%s", name);
    }
    private static void saveToFile(String content, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
    private static String readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        reader.close();
        return content.toString();
    }
    private static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            logger.log(Level.INFO, "File deleted successfully");
        } else {
            logger.log(Level.WARNING, "Failed to delete file");
        }
    }
}