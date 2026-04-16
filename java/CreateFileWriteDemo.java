import java.io.FileWriter;
import java.io.IOException;

public class CreateFileWriteDemo {
    public static void main(String[] args) {
        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter("output.txt"); // file will be created in project folder

            // Write data to the file
            writer.write("Hello, this is a simple text file.\n");
            writer.write("Java is writing this content for you!\n");
            writer.write("End of file.\n");

            // Close the writer
            writer.close();

            System.out.println("Data successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
