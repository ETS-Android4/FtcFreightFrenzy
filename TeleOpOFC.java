package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="TeleOp_OFC", group="Linear Opmode")

public class TeleOpOFC extends LinearOpMode {
	
	
	double vertical;
	double horizontal;
	double sentindo;

	private DcMotor motordf = null;
	private DcMotor motordt = null;
	private DcMotor motoref = null;
	private DcMotor motoret = null;
	private DcMotor motor_carrossel = null;
	private DcMotor garra_direita = null;
	private DcMotor garra_esquerda = null;
	private DcMotor carrossel = null;
	private CRServo coletor = null;
	private Servo braco = null;

	

	@Override
	public void runOpMode() {
		
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		
		motordf = hardwareMap.get(DcMotor.class, "df");
		motordt = hardwareMap.get(DcMotor.class, "dt");
		motoref = hardwareMap.get(DcMotor.class, "ef");
		motoret = hardwareMap.get(DcMotor.class, "et");
		carrossel = hardwareMap.get(DcMotor.class, "carrossel");
		coletor = hardwareMap.get(CRServo.class, "coletor_garra");
		braco = hardwareMap.get(Servo.class, "braco_garra");
		garra_direita = hardwareMap.get(DcMotor.class, "garra_direita");
		garra_esquerda = hardwareMap.get(DcMotor.class, "garra_esquerda");
		
		
		garra_direita.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
		garra_esquerda.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
		
		garra_direita.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		garra_esquerda.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		
		garra_direita.setDirection(DcMotorSimple.Direction.REVERSE);
		
		braco.setPosition(0);
		
		waitForStart();
		
		
		while (opModeIsActive()) {
		
		horizontal = gamepad1.left_stick_x;
		vertical = -gamepad1.right_stick_x;
		sentindo = gamepad1.left_stick_y;
			
		motordt.setPower(0.3*(-sentindo + (vertical - horizontal)));
		motordf.setPower(0.3*(-sentindo + (vertical + horizontal)));
		motoret.setPower(0.3*(sentindo + (vertical + horizontal)));
		motoref.setPower(0.3*(sentindo + (vertical - horizontal)));
		
		garra_direita.setPower(0.6*gamepad2.left_stick_y);
		garra_esquerda.setPower(0.6*gamepad2.left_stick_y);
		
		telemetry.addData("motorGarraD", garra_direita.getCurrentPosition());
		telemetry.addData("motorGarraE", garra_esquerda.getCurrentPosition());
		
 /*	if(gamepad2.dpad_up){
			
				garra_direita.setTargetPosition(-290);
				garra_esquerda.setTargetPosition(-290);
				
				
				garra_direita.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				garra_esquerda.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				
			
				garra_direita.setPower(0.6);
				garra_esquerda.setPower(0.6);
		}
		else if(gamepad2.dpad_down){
				garra_direita.setTargetPosition(-635);
				garra_esquerda.setTargetPosition(-635);
				
				
				garra_direita.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				garra_esquerda.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				
			
				garra_direita.setPower(0.6);
				garra_esquerda.setPower(0.6);
		}
		else if(gamepad2.dpad_left){
				garra_direita.setTargetPosition(0);
				garra_esquerda.setTargetPosition(0);
				
				
				garra_direita.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				garra_esquerda.setMode(DcMotor.RunMode.RUN_TO_POSITION);
				
				garra_direita.setPower(0.6);
				garra_esquerda.setPower(0.6);
		}
		
*/
		
		if(gamepad1.a){
			carrossel.setPower(1);
		}
		else{
			carrossel.setPower(0);
		}
		
	if(braco.getPosition() == 0 && gamepad2.a){
				braco.setPosition(1);
				sleep(1000);
			}
			
	else if(braco.getPosition() == 1 && gamepad2.a){
				braco.setPosition(0);
				sleep(1000);
				
			}

		//braco.setPower(gamepad2.right_stick_y);
		telemetry.addData("Servo", braco.getPosition());
		telemetry.update();
		
		if(gamepad2.right_bumper){
			coletor.setPower(1);
		}
		else if (gamepad2.left_bumper) {
			coletor.setPower(-1);
		}
		else{
			coletor.setPower(0);
		}
			
			
		if(gamepad1.dpad_up){
				motordf.setPower(0.8);
				motordt.setPower(0.8);
				motoref.setPower(-0.8);
				motoret.setPower(-0.8);
			}
			
		else if(gamepad1.dpad_down){
				motordf.setPower(-0.8);
				motordt.setPower(-0.8);
				motoref.setPower(0.8);
				motoret.setPower(0.8);
			}
		else if(gamepad1.dpad_right){
				motordf.setPower(-1);
				motordt.setPower(1);
				motoref.setPower(1);
				motoret.setPower(-1);
		}
		
		}
	}
}
