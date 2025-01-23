package mooc.logic;

import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface userInterface;


    public ApplicationLogic(UserInterface ui) {
        this.userInterface = ui;
    }

    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Application logic is working");
            userInterface.update();
        }
    }
}
