package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

enum Calculo {
    SUM, REST, MULT, DIV, POW, RESTO, RAIZ, SEN, COS, TAN, ASIN, ACOS, ATAN, NULL,
}

public class HelloController {
    String input = "", historial = "", resultado = "";
    float num1 = 0, num2 = 0;
    Calculo operacion = Calculo.NULL;

    @FXML
    private ToggleButton btnModoAngulo;

    @FXML
    private Label historyLabel;

    @FXML
    private TextField txt_input;

    // Inicializador
    @FXML
    public void initialize(){
        btnModoAngulo.selectedProperty().addListener((obs, oldVal, newVal) -> {
            MathUtils.setModoGrados(oldVal);
            btnModoAngulo.setText(oldVal ? "Grados" : "Radianes");
        });
    }



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

        GuardarEntrada();
        // La primera vez que hacemos una operacion y aun tenemos los dos numeros sin escoger, pinta la operacion
        if (num2 == 0)
            ActualizarHistorial(" + ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " +");
        }
    }

    @FXML
    void onBtnRest_Clicked() {
        operacion = Calculo.REST;

        if (input.isEmpty() )
            return;

        GuardarEntrada();

        if (num2 == 0)
            ActualizarHistorial(" - ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " -");
        }
    }

    @FXML
    void onBtnDiv_Clicked() {
        operacion = Calculo.DIV;

        if (input.isEmpty() )
            return;

        GuardarEntrada();

        if (num2 == 0)
            ActualizarHistorial(" / ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " /");
        }
    }

    @FXML
    void onBtnMult_Clicked() {
        operacion = Calculo.MULT;

        if (input.isEmpty() )
            return;

        GuardarEntrada();

        if (num2 == 0)
            ActualizarHistorial(" * ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " *");
        }
    }

    @FXML
    void onBtnDecimal_Clicked() {
        ConcatenarEntrada(",");
    }

    @FXML
    void onBtnCalc_Clicked() {
        if (input.isEmpty())
            return;

        GuardarEntrada();
        LanzarCalculo();
        ActualizarHistorial( num2 + " = ");
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    void onBtnPotenciar_Clicked(){
        operacion = Calculo.POW;

        if (input.isEmpty() )
            return;

        GuardarEntrada();

        if (num2 == 0)
            ActualizarHistorial(" ^ ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " ^");
        }

    }

    @FXML
    void onBtnRaiz_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.RAIZ;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    void onBtnPorcentaje_Clicked(){

        if (input.isEmpty() )
            return;

        operacion = Calculo.RESTO;
        GuardarEntrada();

        if (num2 == 0)
            ActualizarHistorial(" % ");

        if ( num1 != 0 && num2 != 0) {
            LanzarCalculo();
            ReiniciarHistorial();
            ActualizarHistorial(resultado + " %");
        }
    }

    @FXML
    private void onBtnSeno_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.SEN;
        GuardarEntrada();
        //num1 = Float.parseFloat(txt_input.getText());
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnCoseno_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.COS;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnTan_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.TAN;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnAsin_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.ASIN;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnAcos_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.ACOS;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnAtan_Clicked(){
        if (input.isEmpty())
            return;

        operacion = Calculo.ATAN;
        GuardarEntrada();
        LanzarCalculo();
        ReiniciarHistorial();
        operacion = Calculo.NULL;
    }

    @FXML
    private void onBtnCE_Clicked(){
        num1 = 0;
        num2 = 0;
        resultado = "";
        ResetInput();
        ReiniciarHistorial();
        MostrarHistorial();
        txt_input.setText("");
    }

    private void LanzarCalculo(){
        switch (operacion){
            case SUM:
                Sumar();
                //ActualizarHistorial(resultado + " +");
                break;
            case REST:
                Restar();
                break;
            case MULT:
                Multiplicar();
                break;
            case DIV:
                Dividir();
                break;
            case POW:
                Potenciar();
                break;
            case RESTO:
                DividirConResto();
                break;
            case RAIZ:
                CalcularRaiz();
                ActualizarHistorial("√");
                break;
            case SEN:
                CalcularSeno();
                ActualizarHistorial(" sen");
                break;
            case COS:
                CalcularCoseno();
                ActualizarHistorial(" cos");
                break;
            case TAN:
                CalcularTangente();
                ActualizarHistorial(" tan");
                break;
            case ASIN:
                CalcularArcoseno();
                ActualizarHistorial(" asin");
                break;
            case ACOS:
                CalcularArcocoseno();
                ActualizarHistorial(" acos");
                break;
            case ATAN:
                CalcularArcotangente();
                ActualizarHistorial(" atan");
            default:
                break;

        }

        System.out.println("Calculo hecho: " +operacion + ". num1= " + num1 +", num2= " + num2 + " y res= " + resultado);
        if (!resultado.isEmpty())
            txt_input.setText(resultado);

    }

    private void Sumar(){
        System.out.println("SUMANDO " + num1 + " + " + num2);
        float res = num1 + num2;
        resultado = String.valueOf(res);
    }

    private void Restar(){
        System.out.println("Restando: " + num1 + ", " + num2);
        float res = num1 - num2;
        resultado = String.valueOf(res);
    }

    private void Multiplicar( )
    {
        System.out.println("Multiplicando: "+ num1 + " * " + num2 + " res= " + resultado);
        float res = num1 * num2;
        resultado = String.valueOf(res);
    }

    private void Dividir( ){
        if( num1 == 0) {
            resultado = "0";
            return;
        }
        if( num2 == 0)
        {
            resultado = "infinito";
            return;
        }
        float res = num1 / num2;
        resultado = String.valueOf(res);
        System.out.println("Dividiendo: "+ num1 + " / " + num2 + " res= " + resultado);
    }

    private void Potenciar(){
        double res = Math.pow(num1, num2);
        resultado = String.valueOf(res);
        System.out.println("Potenciando: "+ num1 + " ^ " + num2 + " res= " + resultado);
    }

    private void DividirConResto(){
        if( num1 == 0) {
            resultado = "0";
            return;
        }
        if( num2 == 0)
        {
            resultado = "infinito";
            return;
        }
        float res = num1 % num2;
        resultado = String.valueOf(res);
        System.out.println("Resto: "+ num1 + " % " + num2 + " res= " + resultado);
    }

    private void CalcularRaiz(){
        double res = Math.sqrt(num1);
        resultado = String.valueOf(res);
        System.out.println("Calculando raiz de: " + num1 + ". Resultado= "+ resultado);
    }

    private void CalcularSeno() {
        double angulo = MathUtils.convertirAngulo(num1);
        num1 = (float) angulo;
        double res = Math.sin(num1);
        resultado = String.valueOf(res);
        System.out.println("Calculando seno de " + num1 + " con resultado: " + resultado);
    }

    private void CalcularCoseno(){
        double res = Math.cos(MathUtils.convertirAngulo(num1));
        resultado = String.valueOf(res);
        System.out.println("Calculando coseno de " + num1 + " con resultado: " + resultado);
    }

    private void CalcularTangente(){
        double res = Math.tan(MathUtils.convertirAngulo(num1));
        resultado = String.valueOf(res);
        System.out.println("Calculando tangente de " + num1 + " con resultado: " + res);
    }

    private void CalcularArcoseno(){
        // Validar rango para arcoseno [-1, 1]
        if (num1 < -1 || num1 > 1) {
            txt_input.setText("Error: Fuera de rango");
            return;
        }

        double res= Math.asin(num1);
        res = MathUtils.convertirResultado(res);
        resultado = String.valueOf(res);
    }

    private void CalcularArcocoseno(){
         // Validar rango para arcoseno [-1, 1]
        if (num1 < -1 || num1 > 1) {
            txt_input.setText("Error: Fuera de rango");
            System.out.println(txt_input.getText());
            return;
        }

        double res= Math.acos(num1);
        res = MathUtils.convertirResultado(res);
        resultado = String.valueOf(res);
    }

    private void CalcularArcotangente(){
        double res= Math.atan(num1);
        res = MathUtils.convertirResultado(res);
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