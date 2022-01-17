package frc.robot.container;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.constants.OIConstants;

/**
 * Controls the OI Layout of the
 * Robot
 * 
 * @author Neil Shirsat
 * @author <a href="https://github.com/4639RoboSpartans/2021-Beskar-LimeLight/blob/master/src/main/java/frc/robot/Constants.java">Team 4639</a>
 */
public class OI {
    
    /**
     * Controls the Input Coming from the
     * Joysticks
     */
    private final Joystick[] joysticks;

    /**
     * Handles the Controls Coming from
     * a Joystick button
     * 
     * Joystick Buttons allow for 360 angle
     * Movement For Controling Something
     */
    private final Button[][] buttons;

    /**
     * Handles POV Buttons
     * 
     * POV Buttons Have Distinct Buttons
     * For Up, Down, Right, Left Controls
     */
    private final Button[][] povButtons;

    public OI() {

		joysticks = new Joystick[OIConstants.CONTROLLERS];
        buttons = new JoystickButton[OIConstants.CONTROLLERS][10];
		povButtons = new POVButton[OIConstants.CONTROLLERS][8];

    }

    /**
     * 
     * @param joystick
     * @param button
     * @return The Button corresponding to the Joystick
     * and the Button type
     */
    public Button getButton(int joystick, Buttons button) {
        return buttons[joystick][button.getValue()];
    }

    /**
     * @param joystick
     * @param angle
     * @return The POV Button on the Joystick corresponding to
     * the specified angle 
     */
    public Button getPOVButton(int joystick, int angle) {
        if (angle > 360 || angle % 45 != 0 ) {
            throw new IllegalArgumentException("Angle Must Be Less than 360 and a Multiple of 45");
        }
        return povButtons[joystick][angle];
    }

}
