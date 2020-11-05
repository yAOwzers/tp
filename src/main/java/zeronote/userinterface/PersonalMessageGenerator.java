package zeronote.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PersonalMessageGenerator {

    private static final int NUMBER_OF_MESSAGES = 14;
    private String userName;
    private static final String DEFAULT_MESSAGE = "Great idea";

    public PersonalMessageGenerator(String userName) {
        this.userName = userName;
    }

    /**
     * Generates a random personal encouragement message as taken from txt/personalMessages.txt file along
     * with a random user name from txt/nameOfUser file.
     *
     * @return the generated message.
     *
     * @author neilbaner
     * @author yAOwzers
     */
    public String generatePersonalisedMessage() {
        ClassLoader classLoader = PersonalMessageGenerator.class.getClassLoader();
        InputStream personalMessageStream = classLoader.getResourceAsStream("txt/personalMessages.txt");
        BufferedReader personalMessageReader = new BufferedReader(new InputStreamReader(personalMessageStream));
        int messageToDisplay = (int) (Math.random() * (NUMBER_OF_MESSAGES));
        String chosenMessage = "";
        String personalMessage = "";
        try {
            chosenMessage = personalMessageReader.readLine();
            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = personalMessageReader.readLine();
            }
        } catch (IOException e) {
            chosenMessage = DEFAULT_MESSAGE;
        }
        personalMessage = chosenMessage + ", " + userName + ". ";
        return personalMessage;
    }

    public void greetFirstTimeUser() {
        System.out.println("It's nice to meet you " + userName + "!" + " How may I be of service?");
    }

    public void greetUser() {
        System.out.println("Welcome back " + userName + "!" + " Great to have you again.");
    }

}
