package br.com.romel.views;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversorDeMoneda {

    private static final List<String> CONVERTIR_OPCIONES = List.of("De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libra", "De Pesos a Yen", "De Pesos a Real", "De Dólar a Pesos", "De Euro a Pesos", "De Libra a Pesos", "De Yen a Pesos", "De Real a Pesos");
    private static final Map<String, BigDecimal> cotacion;

    static {
        Map<String, BigDecimal> map = new HashMap<>() {{
            put("COP", new BigDecimal(1));
            put("USD", new BigDecimal("0.00023"));
            put("EUR", new BigDecimal("0.00023"));
            put("GBP", new BigDecimal("0.00021"));
            put("JPY", new BigDecimal("0.033"));
            put("BRL", new BigDecimal("0.0012"));
        }};
        cotacion = Collections.unmodifiableMap(map);
    }


    public static void view() {
        var frame = new JFrame();
        boolean inputAccepted = false;
        double cantidadDeDinero = 0;
        while (!inputAccepted) {
            var dinero = JOptionPane.showInputDialog(frame, "Ingressa la cantidad de dinero que deseas convertir:");
            try {
                cantidadDeDinero = Double.parseDouble(dinero);
                inputAccepted = true;
            } catch (Exception ignored) {
            }
        }

        var inputOpcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, CONVERTIR_OPCIONES.toArray(), CONVERTIR_OPCIONES.get(0));

        JOptionPane.showMessageDialog(frame, "Tienes " + monedaResult(cantidadDeDinero, inputOpcion));

    }

    private static String monedaResult(double cantidadDeDinero, String inputOpcion) {
        BigDecimal result;
        switch (CONVERTIR_OPCIONES.indexOf(inputOpcion)) {
            case 0:
                result = new BigDecimal(cantidadDeDinero).multiply(cotacion.get("USD"));
                result = decideScale(result);
                return "$" + result + " Dolares";
            case 1:
                result = new BigDecimal(cantidadDeDinero).multiply(cotacion.get("EUR"));
                result = decideScale(result);
                return "€" + result + " Euros";
            case 2:
                result = new BigDecimal(cantidadDeDinero).multiply(cotacion.get("GBP"));
                result = decideScale(result);
                return "£" + result + " Libras";
            case 3:
                result = new BigDecimal(cantidadDeDinero).multiply(cotacion.get("JPY"));
                result = decideScale(result);
                return "¥" + result + " Yenes";
            case 4:
                result = new BigDecimal(cantidadDeDinero).multiply(cotacion.get("BRL"));
                result = decideScale(result);
                return "R$" + result + " Reales";
            case 5:
                result = new BigDecimal(cantidadDeDinero).divideToIntegralValue(cotacion.get("USD"));
                result = decideScale(result);
                return "$" + result + " Pesos";
            case 6:
                result = new BigDecimal(cantidadDeDinero).divideToIntegralValue(cotacion.get("EUR"));
                result = decideScale(result);
                return "$" + result + " Pesos";
            case 7:
                result = new BigDecimal(cantidadDeDinero).divideToIntegralValue(cotacion.get("GBP"));
                result = decideScale(result);
                return "$" + result + " Pesos";
            case 8:
                result = new BigDecimal(cantidadDeDinero).divideToIntegralValue(cotacion.get("JPY"));
                result = decideScale(result);
                return "$" + result + " Pesos";
            case 9:
                result = new BigDecimal(cantidadDeDinero).divideToIntegralValue(cotacion.get("BRL"));
                result = decideScale(result);
                return "$" + result + " Pesos";
            default:
                return "Error";
        }


    }

    static BigDecimal decideScale(BigDecimal result) {
        if (result.compareTo(BigDecimal.valueOf(1)) > 0)
            return result.setScale(2, RoundingMode.HALF_EVEN);
        return result;
    }
}
