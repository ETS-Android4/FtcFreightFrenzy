package org.firstinspires.ftc.teamcode;


import org.firstinspires.*;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="TELEOP", group="Linear Opmode") //Setando o programa é o grupo que ele pertence e que é tele operado

public class TeleOperada extends LinearOpMode { //Criando a class BasiscOpMode_Linear e exentendo a LinearOpMode
    Garra victor = new Garra();

    private ElapsedTime runtime = new ElapsedTime(); //Criando o obejeto runtime
    private DcMotor motor_cirilo = null;
    private DcMotor motor_base = null;
    private DcMotor motor_braco = null;
    private Servo servo_polegar = null;

    private DcMotor motordf = null;
    private DcMotor motordt= null;
    private DcMotor motoref = null;
    private DcMotor motoret = null;

    double gatilho1 = gamepad2.left_trigger;  // gatilho esquerdo
    double gatinho2 = gamepad2.right_trigger; // gatilho direito
    boolean bumperes = gamepad2.left_bumper;  // bumper esquerdo
    boolean bumperd = gamepad2.right_bumper; // bumper direito

    double sentido;
    double horizontal;
    double vertical;
    double garra_n1;
    double garra_n2;

    @Override
    public void runOpMode() throws InterruptedException { //Criando o metodo runOpMode, tudo que o robor vai executar

        //Motores da garra
        motor_cirilo = hardwareMap.get(DcMotor.class, "cirilo"); //Motor do carrosel

        //Motores andar
        motordf  = hardwareMap.get(DcMotor.class, "direita_frente"); //Lado direita superior
        motordt  = hardwareMap.get(DcMotor.class, "direita_tras"); //Lado direta inferior
        motoref  = hardwareMap.get(DcMotor.class, "esquerda_frente"); //Lado esquerdo superior
        motoret  = hardwareMap.get(DcMotor.class, "esquerda_tras"); //Lado esquerdo inferior
        motor_base = hardwareMap.get(DcMotor.class, "base_garra");
        motor_braco = hardwareMap.get(DcMotor.class, "braco_garra");
        servo_polegar = hardwareMap.get(Servo.class, "polegar_garra");


        motordf.setDirection(DcMotor.Direction.REVERSE);
        motordt.setDirection(DcMotor.Direction.REVERSE);

        //Tudo o que for necesario para setar os motores e variaveis

        waitForStart(); //Esperando o motorista apertar start
        if (isStopRequested()) return;

        while (opModeIsActive()) { //Laço de repetição, ao apertar o start

            vertical =  gamepad1.right_stick_x;
            horizontal = gamepad1.left_stick_x;
            sentido = - gamepad1.left_stick_y;
            garra_n1 = gamepad2.left_stick_y;
            garra_n2 = gamepad2.right_stick_y;

            if (gamepad1.a){
                    motor_cirilo.setPower(1);
            }else{
                    motor_cirilo.setPower(0);
            }

            if (gamepad1.left_bumper){
                motordf.setPower(1*0.5);
                motordt.setPower(1*0.5);
                motoref.setPower(1*0.5);
                motoret.setPower(1*0.5);
            }

            motor_base.setPower(garra_n1);
            motor_braco.setPower(garra_n2);
            motordf.setPower(-sentido + (vertical - horizontal));
            motordt.setPower(-sentido + (vertical + horizontal));
            motoref.setPower(sentido + (vertical + horizontal));
            motoret.setPower(sentido + (vertical - horizontal));

        }
    }


}

