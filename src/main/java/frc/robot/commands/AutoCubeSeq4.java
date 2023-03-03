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

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class AutoCubeSeq4 extends SequentialCommandGroup {

    // -BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public AutoCubeSeq4(DriveTrain driveTrain, Arm m_arm, Tram m_tram, Claw m_claw){
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
        //INITIALIZATION
        new DriveToggleBreakMode(driveTrain),
        new ResetGyro(driveTrain),
        //Arm Up
        Commands.parallel(
            new ArmJog(1, m_arm).withTimeout(1.125),
            new TramJog(1,m_tram).withTimeout(2),
            new DriverWithHeading(0.3, 23.5, 1, driveTrain).withTimeout(2)
        ),
        new OpenClaw(m_claw),
        // new WaitCommand(0.125),
        Commands.parallel(
           new DriverWithHeading(-0.5, 137.25, 0, driveTrain),
           new ArmJog(-1, m_arm).withTimeout(1.25)
           ),
           new DriveRotateToSetpointFaster(180, driveTrain).withTimeout(3),
            new DriverWithHeading(0.5, 41, 180, driveTrain),//Really 76.25 - 73
       Commands.parallel(
           new CloseClaw(m_claw),
           new ArmJog(1, m_arm).withTimeout(0.25),
           new DriveRotateToSetpointFaster(0, driveTrain).withTimeout(3)
       ),
        Commands.parallel(
             new DriverWithHeading(0.5, 166, 2, driveTrain),//Really 187.5
             new CubeExtend(m_arm, m_claw, m_tram)
        ),
        new OpenClaw(m_claw),
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
