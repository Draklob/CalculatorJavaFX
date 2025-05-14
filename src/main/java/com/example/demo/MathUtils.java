package com.example.demo;

public class MathUtils {
    private static boolean modoGrados = true;

    public static void setModoGrados(boolean grados) {
        modoGrados = grados;
    }

    public static boolean isModoGrados() {
        return modoGrados;
    }

    public static double convertirAngulo(double angulo) {
        return modoGrados ? Math.toRadians(angulo) : angulo;
    }

    public static double convertirResultado(double resultado) {
        return modoGrados ? Math.toDegrees(resultado) : resultado;
    }
}
