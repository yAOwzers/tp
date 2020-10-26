package seedu.duke.userinterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PersonalMesssageGenerator {

    private static String personalMessage;
    private static final int NUMBER_OF_MESSAGES = 12;
    private static final int NUMBER_OF_NAMES = 1;

    /**
     * Generates a random personal encouragement message as taken from txt/personalMessages.txt file along
     * with a random user name from txt/nameOfUser file.
     *
     * @return the generated message.
     *
     * @author neilbaner
     * @author yAOwzers
     */
    public static String generatePersonalisedMessage() {
        ClassLoader classLoader = PersonalMesssageGenerator.class.getClassLoader();
        InputStream personalMessageStream = classLoader.getResourceAsStream("txt/personalMessages.txt");
        InputStream namesOfUserInputStream = classLoader.getResourceAsStream("txt/nameOfUser.txt");
        try {

            BufferedReader personalMessageReader = new BufferedReader(new InputStreamReader(personalMessageStream));
            BufferedReader namesReader = new BufferedReader(new InputStreamReader(namesOfUserInputStream));

            int messageToDisplay = (int) (Math.random() * (NUMBER_OF_MESSAGES));
            int nameToDisplay = (int) (Math.random() * (NUMBER_OF_NAMES));

            String chosenMessage = personalMessageReader.readLine();
            String chosenName = namesReader.readLine();

            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = personalMessageReader.readLine();
            }
            for (int i = 0; i < nameToDisplay; i++) {
                chosenName = namesReader.readLine();
            }

            personalMessage = chosenMessage + ", " + chosenName + ". ";
        } catch (FileNotFoundException e) {
            System.out.println("no file detected!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return personalMessage;
        }
    }
}
