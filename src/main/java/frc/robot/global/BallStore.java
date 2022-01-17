package frc.robot.global;

import frc.robot.util.Service;

/**
 * Manages the Robots Global State about
 * the Storage and Actions of Balls
 * 
 * @author Neil Shirsat
 */
public class BallStore implements Service {

    /**
     * The Central Data Store for the Amount of
     * Balls that the Robot Currently Has
     */
    private int balls;

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getBalls() {
        return balls;
    }

}
