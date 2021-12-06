package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Movimento {

        //definindo a porta de entrada do motor
        DcMotor motor1_df = hardwareMap.get(DcMotor.class, "direita_frente");
        DcMotor motor2_dt = hardwareMap.get(DcMotor.class, "direita_tras");
        DcMotor motor3_et = hardwareMap.get(DcMotor.class, "esquerda_tras");
        DcMotor motor4_ef = hardwareMap.get(DcMotor.class, "esquerda_frente");


        //método direcionando a ir para direita
        void andardireita(){
            motor1_df.setPower(1);
            motor2_dt.setPower(-1);
            motor4_ef.setPower(1);
            motor3_et.setPower(-1);
        }

        //método direcionando a ir para esquerda
        void andaresquerda(){
            motor1_df.setPower(-1);
            motor2_dt.setPower(1);
            motor3_et.setPower(1);
            motor4_ef.setPower(-1);
        }

        //4 métodos que dependendo da escolha do usuário irá direcionar de forma diagonal o robô
        void andardiagonal(String dir){
            if (dir == "dirf") {
                motor1_df.setPower(0);
                motor2_dt.setPower(1);
                motor3_et.setPower(0);
                motor4_ef.setPower(1);
            }
            if (dir == "dirt") {
                motor1_df.setPower(-1);
                motor2_dt.setPower(0);
                motor3_et.setPower(-1);
                motor4_ef.setPower(0);
            }
            if (dir == "esqf"){
                motor1_df.setPower(1);
                motor2_dt.setPower(0);
                motor3_et.setPower(1);
                motor4_ef.setPower(0);

            }
            if (dir == "esqt"){
                motor1_df.setPower(0);
                motor2_dt.setPower(-1);
                motor3_et.setPower(0);
                motor4_ef.setPower(-1);
            }
        }

        //método direcionando a dar ré
        void re(){
            motor1_df.setPower(0);
            motor2_dt.setPower(-1);
            motor3_et.setPower(-1);
            motor4_ef.setPower(0);

        }

        //método direcionando a ir para frente
        void frente(){
            motor1_df.setPower(1);
            motor2_dt.setPower(0);
            motor3_et.setPower(0);
            motor4_ef.setPower(1);
        }
    }

