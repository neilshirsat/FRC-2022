package frc.robot.util;

import java.lang.reflect.Field;
import java.util.TreeMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Resolves the Service Dependencies of a
 * class and Injects the Nessessary Dependencies
 * into the class
 * 
 * @author Neil Shirsat
 */
public class Injector {

    /**
     * Stores the Instances of the Services of the Application
     */
    private TreeMap<String, Service> injectionMapping;

    /**
     * Stores the Instances of the Subsystems of the Application
     */
    private TreeMap<String, SubsystemBase> subsystemMapping;

    public Injector() {
        this.injectionMapping = new TreeMap<>();
        this.subsystemMapping = new TreeMap<>();
    }

    public void addService(Service service) {
        this.injectionMapping.put(service.getClass().getName(), service);
    }

    public void addSubsystem(SubsystemBase subsystem) {
        this.subsystemMapping.put(subsystem.getClass().getName(), subsystem);
    }

    public void inject(Component component) {
        for (Field e: component.getClass().getFields()) {
            if (e.isAnnotationPresent(Injectable.class)) {
                try {
                    e.set(component, injectionMapping.get(e.getType().getClass().getName()));
                } catch (IllegalArgumentException | IllegalAccessException e1) {
                    System.err.println(component + "Cannot Inject Field" + e);
                }
            }
            else if (e.isAnnotationPresent(Subsystem.class)) {
                try {
                    e.set(component, subsystemMapping.get(e.getType().getClass().getName()));
                } catch (IllegalArgumentException | IllegalAccessException e1) {
                    System.err.println(component + "Cannot Inject Subsystem" + e);
                }
            }
        }
    }
    
}
