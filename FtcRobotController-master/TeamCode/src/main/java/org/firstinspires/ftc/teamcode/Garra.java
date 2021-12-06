package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

public class Garra{

    DcMotor motor_base = hardwareMap.get(DcMotor.class, "base_garra");
    DcMotor motor_braco = hardwareMap.get(DcMotor.class, "braco_garra");
    Servo servo_polegar = hardwareMap.get(Servo.class, "polegar_garra");

    void basegarra(int posicao){
        motor_base.setPower(1 * posicao);
    }
    void bracogarra(int sentido){
        motor_braco.setPower(1 * sentido);
    }
    void polegargarra(int angulo){
        servo_polegar.setPosition(1 * angulo);
    }

}
