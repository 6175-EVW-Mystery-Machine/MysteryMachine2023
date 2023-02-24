// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.button.POVButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Tram m_tram = new Tram();
    public final Claw m_claw = new Claw();
    public final Arm m_arm = new Arm();
    public final DriveTrain m_driveTrain = new DriveTrain();

// Joysticks
private final Joystick joystick2 = new Joystick(3);
private final Joystick joystick1 = new Joystick(2);
private final XboxController xboxController = new XboxController(0);
private final PS4Controller driverController = new PS4Controller(1);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Open Claw", new OpenClaw( m_claw ));
    SmartDashboard.putData("Close Claw", new CloseClaw( m_claw ));
    SmartDashboard.putData("Tram Jog: forward", new TramJog(0.2, m_tram));
    SmartDashboard.putData("Tram Jog: reverse", new TramJog(-0.2, m_tram));
    SmartDashboard.putData("Arm Jog: up", new ArmJog(0.1, m_arm));
    SmartDashboard.putData("Arm Jog: down", new ArmJog(-0.1, m_arm));
    SmartDashboard.putData("AutoDriveForTime", new AutoDriveForTime( m_driveTrain ));
    SmartDashboard.putData("Drive For Distance: Auto1", new DriveForDistance(30, -.5, 0, m_driveTrain));
    SmartDashboard.putData("Drive For Distance: Auto2", new DriveForDistance(30, .5, 0, m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveTrain.setDefaultCommand(new DriveWithJoy(() -> joystick1.getRawAxis(2), () -> -joystick2.getRawAxis(1), m_driveTrain));


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    m_chooser.addOption("Auto Drive Distance Seq 1", new AutoDriveDistance_Seq1(m_driveTrain));
    m_chooser.addOption("AutoDriveForTime", new AutoDriveForTime( m_driveTrain ));
    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      povButtons();
    
        // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton closeClawButton = new JoystickButton(joystick1, 1);        
closeClawButton.onTrue(new CloseClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
  
final JoystickButton openClawButton = new JoystickButton(joystick2, 1);        
openClawButton.onTrue(new OpenClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

//Tram Jog
final POVButton tramJogForwardButton = new POVButton(joystick2, 0);        
tramJogForwardButton.whileTrue(new TramJog(-0.4, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton tramJogBackwardButton = new POVButton(joystick2, 180);        
tramJogBackwardButton.whileTrue(new TramJog(-0.4, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton tramJogForwardNOW = new JoystickButton(joystick2,4);        
tramJogForwardNOW.whileTrue(new TramJog(1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton tramJogBackwardNOW = new JoystickButton(joystick2,3);        
tramJogBackwardNOW.whileTrue(new TramJog(-1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

//Arm Jog
final POVButton armJogUp1 = new POVButton(joystick1, 0);        
armJogUp1.whileTrue(new ArmJog(0.2, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton armJogUp2 = new POVButton(joystick1, 45);        
armJogUp2.whileTrue(new ArmJog(0.4, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton armJogUp3 = new POVButton(joystick1, 90);        
armJogUp3.whileTrue(new ArmJog(0.6, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));


final POVButton armJogDown1 = new POVButton(joystick1, 180);        
armJogDown1.whileTrue(new ArmJog(-0.2, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton armJogDown2 = new POVButton(joystick1, 225);        
armJogDown2.whileTrue(new ArmJog(-0.4, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton armJogDown3 = new POVButton(joystick1, 270);        
armJogDown3.whileTrue(new ArmJog(-0.6, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton armJogUpNOW = new JoystickButton(joystick1,4);        
armJogUpNOW.whileTrue(new ArmJog(1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton armJogDownNOW = new JoystickButton(joystick1, 3);        
armJogDownNOW.whileTrue(new ArmJog(-1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));



/*final JoystickButton xboxArmJogDown = new JoystickButton(xboxController, XboxController.Button.kB.value);        
xboxArmJogDown.whileTrue(new ArmJog(-0.1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton xboxArmJogUp = new JoystickButton(xboxController, XboxController.Button.kY.value);        
xboxArmJogUp.whileTrue(new ArmJog(0.1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton xboxTramJogBackward = new JoystickButton(xboxController, XboxController.Button.kLeftBumper.value);        
xboxTramJogBackward.whileTrue(new TramJog(-0.2, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Tram Jog Backward",new TramJog(-0.2, m_tram));
                        
final JoystickButton xboxTramJogForward = new JoystickButton(xboxController, XboxController.Button.kRightBumper.value);        
xboxTramJogForward.whileTrue(new TramJog(0.2, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Tram Jog Forward",new TramJog(0.2, m_tram));
                        
final JoystickButton xboxOpenClaw = new JoystickButton(xboxController, XboxController.Button.kX.value);        
xboxOpenClaw.onTrue(new OpenClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Open Claw",new OpenClaw( m_claw ));
                        
final JoystickButton xboxCloseClaw = new JoystickButton(xboxController, XboxController.Button.kA.value);        
xboxCloseClaw.onTrue(new CloseClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Close Claw",new CloseClaw( m_claw ));
                        
final JoystickButton closeClawButton = new JoystickButton(driverController, PS4Controller.Button.kCross.value);        
closeClawButton.onTrue(new CloseClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton openClawButton = new JoystickButton(driverController, PS4Controller.Button.kSquare.value);        
openClawButton.onTrue(new OpenClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton xboxArmJogDown = new JoystickButton(driverController, XboxController.Button.kB.value);        
xboxArmJogDown.whileTrue(new ArmJog(-0.6, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton xboxArmJogUp = new JoystickButton(driverController, XboxController.Button.kY.value);        
xboxArmJogUp.whileTrue(new ArmJog(0.6, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        


final JoystickButton xboxTramJogBackward = new JoystickButton(driverController, XboxController.Button.kLeftBumper.value);        
xboxTramJogBackward.whileTrue(new TramJog(-1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Tram Jog Backward",new TramJog(-0.2, m_tram));
                        
final JoystickButton xboxTramJogForward = new JoystickButton(driverController, XboxController.Button.kRightBumper.value);        
xboxTramJogForward.whileTrue(new TramJog(1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Tram Jog Forward",new TramJog(0.2, m_tram));
                        
final JoystickButton xboxOpenClaw = new JoystickButton(driverController, XboxController.Button.kX.value);        
xboxOpenClaw.onTrue(new OpenClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Open Claw",new OpenClaw( m_claw ));
                        
final JoystickButton xboxCloseClaw = new JoystickButton(driverController, XboxController.Button.kA.value);        
xboxCloseClaw.onTrue(new CloseClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Close Claw",new CloseClaw( m_claw ));
                    
final JoystickButton pS4ArmJogDown = new JoystickButton(driverController, 7);        
pS4ArmJogDown.whileTrue(new ArmJog(-1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton pS4ArmJogUp = new JoystickButton(driverController, 8);        
pS4ArmJogUp.whileTrue(new ArmJog(1, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton pS4TramJogReverse = new JoystickButton(driverController, PS4Controller.Button.kL1.value);        
pS4TramJogReverse.whileTrue(new TramJog(-1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton pS4TramJogForward = new JoystickButton(driverController, PS4Controller.Button.kR1.value);        
pS4TramJogForward.whileTrue(new TramJog(1, m_tram).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton pS4CloseClawButton = new JoystickButton(driverController, PS4Controller.Button.kCross.value);        
pS4CloseClawButton.onTrue(new CloseClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton pS4OpenClawButton = new JoystickButton(driverController, PS4Controller.Button.kSquare.value);        
pS4OpenClawButton.onTrue(new OpenClaw( m_claw ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
     */                   

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
}
private void xboxButtons(){



}
private void povButtons(){
/* final POVButton armDown = new POVButton(driverController, 180);        
  armDown.whileTrue(new ArmJog(-0.2, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

  final POVButton armUp = new POVButton(driverController, 0);        
  armUp.whileTrue(new ArmJog(0.2, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

  final POVButton tramExtend = new POVButton(driverController, 90);
  tramExtend.whileTrue(new TramJog(0.2, m_tram));

  final POVButton tramRetract = new POVButton(driverController, 270);
  tramRetract.whileTrue(new TramJog(-0.2, m_tram));
  */
  }

    // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getDriverController() {
      return joystick1;
    }
/*
public XboxController getXboxController() {
      return xboxController;
    }
*/

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

