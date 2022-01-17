package frc.robot.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The Annotation Which Marks a Particular
 * Field of a Component as Needing Dependency
 * Injection
 * 
 * @author Neil Shirsat
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Injectable {
    
}
