package frc.robot.container;

/**
 * An Enum Mapping out the Axes
 * 
 * @author <a href="https://github.com/4639RoboSpartans/2021-Beskar-LimeLight/blob/master/src/main/java/frc/robot/Constants.java">Team 4639</a>
 */
public enum Axes {

    LEFT_STICK_X(0),
    LEFT_STICK_Y(1),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3),
    RIGHT_STICK_X(4),
    RIGHT_STICK_Y(5);

    private final int value;

    Axes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
