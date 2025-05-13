package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    String input = "";
    int num1 = 0, num2 = 0;

    @FXML
    private Label historyLabel;

    @FXML
    private TextField txt_input;

    @FXML
    protected void onHelloButtonClick() {
        historyLabel.setText("Welcome to CalculatorFX Application!");
    }

    @FXML
    void onBtn1_Clicked() {
        ConcatenarEntrada("1");
    }

    @FXML
    void onBtn2_Clicked() {
        ConcatenarEntrada("2");
    }

    @FXML
    void onBtn3_Clicked() {
        ConcatenarEntrada("3");
    }

    @FXML
    void onBtn4_Clicked() {
        ConcatenarEntrada("4");

    }

    @FXML
    void onBtn5_Clicked() {
        ConcatenarEntrada("5");
    }

    @FXML
    void onBtn6_Clicked() {
        txt_input.setText("6");
    }

    @FXML
    void onBtn7_Clicked() {
        txt_input.setText("7");
    }

    @FXML
    void onBtn8_Clicked() {
        txt_input.setText("8");
    }

    @FXML
    void onBtn9_Clicked() {
        txt_input.setText("9");
    }

    @FXML
    void onBtn0_Clicked() {
        txt_input.setText("0");
    }

    @FXML
    void onBtnDel_Clicked() {

    }

    @FXML
    void onBtnSum_Clicked() {
        if( num1 == 0) {
            num1 = Integer.parseInt(input);
            ResetInput();
        }

    }

    @FXML
    void onBtnRest_Clicked() {

    }

    @FXML
    void onBtnDiv_Clicked() {

    }

    @FXML
    void onBtnMult_Clicked() {

    }

    @FXML
    void onBtnDecimal_Clicked() {

    }

    @FXML
    void onBtnCalc_Clicked() {
        num2 = Integer.parseInt(input);
        System.out.println(num1 + " " + num2);
        txt_input.setText(Sumar( num1, num2));
    }

    private void ConcatenarEntrada(String newInput){
        input += newInput;
        txt_input.setText(input);
    }

    private String Sumar(int num1, int num2){
        int res = num1 + num2;
        return String.valueOf(res);
    }

    private void ResetInput(){
        input = "";
        txt_input.setText(input);
    }
}