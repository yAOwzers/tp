package seedu.duke.userinterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PersonalMesssageGenerator {

    private static String personalMessage;
    private static final int NUMBER_OF_MESSAGES = 12;
    public static String chosenName;

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

            String chosenMessage = personalMessageReader.readLine();
            chosenName = namesReader.readLine();

            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = personalMessageReader.readLine();
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

    public static void printGreetUser() {
        System.out.println(chosenName);
    }
}
