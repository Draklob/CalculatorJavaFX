package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

enum Calculo {
    SUM, REST, MULT, DIV, NULL,
}
public class HelloController {
    String input = "", historial = "", resultado = "";
    float num1 = 0, num2 = 0;
    Calculo operacion = Calculo.NULL;

    @FXML
    private Label historyLabel;

    @FXML
    private TextField txt_input;

    @FXML
    protected void onHelloButtonClick() {
        historyLabel.setText("Welcome to CalculatorFX Application!");
    }

    @FXML
    protected void onPressedBotonNum( MouseEvent event){
        if(event.getButton() == MouseButton.PRIMARY)
        {
            if ( operacion == Calculo.NULL && !resultado.isEmpty())
            {
                Reiniciar();
            }
            Button btn = (Button) event.getSource();
            ConcatenarEntrada(btn.getText());
        }
    }

    @FXML
    void onBtnDel_Clicked() {
        if (!input.isEmpty()){
            input = input.substring(0, input.length() -1);
            txt_input.setText(input);
        }
    }

    @FXML
    void onBtnSum_Clicked() {
        operacion = Calculo.SUM;

        if (input.isEmpty() )
            return;
//        if (!resultado.isEmpty())
//        {
//            num1 = Float.parseFloat(resultado);
//            num2 = 0;
//        }

        GuardarEntrada();
        // La primera vez que hacemos una operacion y aun tenemos los dos numeros sin escoger, pinta la operacion
        if (num2 == 0)
            ActualizarHistorial(" + ");

        if ( num1 != 0 && num2 != 0) {
//        if(!resultado.isEmpty()){
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " +");
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
        ConcatenarEntrada(",");
    }

    @FXML
    void onBtnCalc_Clicked() {
        if (input.isEmpty())
            return;

//        if (!resultado.isEmpty())
//        {
//            num1 = Float.parseFloat(resultado);
//            num2 = 0;
//        }

        GuardarEntrada();
        LanzarCalculo();
        ActualizarHistorial( num2 + " = ");
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    private void LanzarCalculo(){
        switch (operacion){
            case SUM:
                Sumar( num1, num2);
                //ActualizarHistorial(resultado + " +");
                break;
            case REST:
                break;
            default:
                break;

        }

        System.out.println("Calculo hecho: " +operacion + ". num1= " + num1 +", num2= " + num2 + " y res= " + resultado);
        txt_input.setText(resultado);

    }

    private void Sumar(float num1, float num2){
        System.out.println("SUMANDO " + num1 + " + " + num2);
        float res = num1 + num2;
        resultado = String.valueOf(res);
    }

    private void Restar(float num1, float num2){
        System.out.println("Restando: " + num1 + ", " + num2);
        float res = num1 - num2;
        resultado = String.valueOf(res);
    }

    private void ResetInput(){
        input = "";
    }

    private void Reiniciar(){
        if (!resultado.isEmpty()) {
            num1 = 0;
            num2 = 0;
            resultado = "";
            ResetInput();
            ReiniciarHistorial();
            MostrarHistorial();
            System.out.println("Reiniciando Todo");
        }
    }

    private void ConcatenarEntrada(String newInput){
        input += newInput;
        txt_input.setText(input);
    }

    private void GuardarEntrada() {
        String input_normalizado = input.replace(",", ".");

        if (!resultado.isEmpty()){
            num1 = Float.parseFloat(resultado);
            num2 = 0;
        }

        if ( num1 == 0){
            ActualizarHistorial(input);
            num1 = Float.parseFloat(input_normalizado);
        }
        else if( num2 == 0 ) {
            num2 = Float.parseFloat(input_normalizado);
        }
        System.out.println(num1 + ", "+num2);
        ResetInput();
    }

    private void ActualizarHistorial(String str) {
        historial += str;
//        if ( num1 == 0){
//            switch (operacion){
//                case SUM:
//                    historial += " + ";
//                    break;
//                default:
//                    break;
//            }
//        }
        MostrarHistorial();
    }

    private void MostrarHistorial(){ historyLabel.setText(historial);}

    private void ReiniciarHistorial(){
        historial = "";
    }
}