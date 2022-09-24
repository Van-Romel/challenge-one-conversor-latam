package br.com.romel;

import br.com.romel.views.ConversorDeMoneda;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        final String[] MENU_OPCIONES = {"Conversor de Moneda"};
        var input = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, MENU_OPCIONES, MENU_OPCIONES[0]);

        if (Objects.equals(input, MENU_OPCIONES[0])) ConversorDeMoneda.view();
        else {
            JOptionPane.showMessageDialog(new JFrame(), "Not developed yet 😝😝");
        }


    }
}
