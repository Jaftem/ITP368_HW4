import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
public class Menu {
    public Menu(String filename) {
        readFromFile(filename);
    }

    public boolean readFromFile(String filename) {
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(System.out::println);
        } 
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String toString() {
        String menuString = "";

        return menuString;
    }
}