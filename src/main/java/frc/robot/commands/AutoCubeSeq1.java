// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: SequentialCommandGroup.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
// -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Tram;
import frc.robot.subsystems.Claw;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class AutoCubeSeq1 extends SequentialCommandGroup {

    // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public AutoCubeSeq1(DriveTrain driveTrain, Arm m_arm, Tram m_tram, Claw m_claw){
    //public AutoDriveForTime(DriveTrain driveTrain){

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    addCommands(
        // Add Commands here:
        // Also add parallel commands using the
        //
        // addCommands(
        //      new command1(argsN, subsystem),
        //      parallel(
        //          new command2(argsN, subsystem),
        //          new command3(argsN, subsystem)
        //      )    
        //  );
        new DriveToggleBreakMode(driveTrain),
        new ArmJog(.6, m_arm).withTimeout(2.1),
        new TramJog(1,m_tram).withTimeout(3),
        new WaitCommand(0.25),
       // new DriveWithJoy(() -> .4,() -> 0.0, driveTrain).withTimeout(2),
       new DriveForDistance(23.5, 0.5, 0, driveTrain),

        new WaitCommand(0.25),
        new OpenClaw(m_claw),
        new WaitCommand(0.5),
        //new DriveWithJoy(() -> -0.5,() -> 0.0, driveTrain).withTimeout(3),
       new DriveForDistance(137.25, -0.5, 0, driveTrain),
       new HomeJogging(m_arm, m_claw, m_tram),
        new DriveToggleBreakMode(driveTrain)
       
       
        
        

        );
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
