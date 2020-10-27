package seedu.duke.userinterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PersonalMesssageGenerator {

    private static String personalMessage;
    private static final int NUMBER_OF_MESSAGES = 14;
    private static String chosenName;
    private static String firstTimeUserName;

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

            int messageToDisplay = (int) (Math.random() * (NUMBER_OF_MESSAGES));

            String chosenMessage = personalMessageReader.readLine();

            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = personalMessageReader.readLine();
            }

            if (chosenName == null) {
                personalMessage = chosenMessage + ", " + firstTimeUserName + ". ";
            } else {
                BufferedReader namesReader = new BufferedReader(new InputStreamReader(namesOfUserInputStream));
                chosenName = namesReader.readLine();
                personalMessage = chosenMessage + ", " + chosenName + ". ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("no file detected!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return personalMessage;
        }
    }

    public static void greetFirstTimeUser() {
        System.out.println("It's nice to meet you " + firstTimeUserName + "!"
                + " How may I be of service?");
    }

    public void setChosenName(String chosenName) {
        this.firstTimeUserName = chosenName;
    }

    public void greetUser() throws IOException {
        ClassLoader classLoader = PersonalMesssageGenerator.class.getClassLoader();
        InputStream namesOfUserInputStream = classLoader.getResourceAsStream("txt/nameOfUser.txt");
        BufferedReader namesReader = new BufferedReader(new InputStreamReader(namesOfUserInputStream));
        chosenName = namesReader.readLine();
        System.out.println("Welcome back " + chosenName + "!"
                + " Great to have you again.");
    }

}
