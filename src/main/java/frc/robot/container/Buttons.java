package frc.robot.container;

/**
 * An Enum Mapping out the Joystick Buttons
 * 
 * @author <a href="https://github.com/4639RoboSpartans/2021-Beskar-LimeLight/blob/master/src/main/java/frc/robot/Constants.java">Team 4639</a>
 */
public enum JoystickButtons {

    A_BUTTON(1), 
    B_BUTTON(2), 
    X_BUTTON(3), 
    Y_BUTTON(4), 
    LEFT_BUMPER(5), 
    RIGHT_BUMPER(6), 
    BACK_BUTTON(7), 
    START_BUTTON(8), 
    LEFT_STICK(9), 
    RIGHT_STICK(10);

    private int value;

    private JoystickButtons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
