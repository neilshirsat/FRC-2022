package frc.robot.container;

import java.lang.reflect.InvocationTargetException;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Component;
import frc.robot.util.Injector;
import frc.robot.util.Service;

/**
 * Dyanmically Creates the Runtime Components of
 * the Application and Bootstraps them with the
 * Necessary Dependencies
 * 
 * <p>
 * Use this Class To Create Different Application
 * Components Such as Subsystems, Commands, etc
 * instead of manuel creations
 * 
 * @author Neil Shirsat
 */
public class ComponentFactory {
    
    /**
     * The Underlying Injector Which Takes Care of
     * Wiring up the Dependencies of the Component
     */
    private Injector injector;

    public ComponentFactory() {
        injector = new Injector();
    }

    /**
     * Register a Service with the Applciation
     * 
     * @param service
     */
    public void registerService(Service service) {
        this.injector.addService(service);
    }

    /**
     * Register a Service with the Applciation
     * 
     * @param service
     */
    public void registerSubsystem(SubsystemBase subsystem) {
        this.injector.addSubsystem(subsystem);
    }

    /**
     * Creates and Wires up the Dependencies of a
     * Command (extend CommandBase)
     * 
     * @param commandClass
     * @return
     */
    public CommandBase createCommand(Class<? extends CommandBase> commandClass) {
        CommandBase commandBase = null;
        try {
            commandBase = commandClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        if (commandBase == null) {
            return null;
        }
        Component component = (Component)commandBase;
        injector.inject(component);
        component.constructor();
        return commandBase;
    }

    /**
     * Creates and Wires up the Dependencies of a
     * Subsystem (extend SubsystemBase)
     * 
     * @param subsystemClass
     * @return
     */
    public SubsystemBase createSubsystem(Class<? extends SubsystemBase> subsystemClass) {
        SubsystemBase subsystemBase = null;
        try {
            subsystemBase = subsystemClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        if (subsystemBase == null) {
            return null;
        }
        Component component = (Component)subsystemBase;
        injector.inject(component);
        component.constructor();
        return subsystemBase;
    }

}
