package br.com.romel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final Object[] OPTIONS = {"Conversor de Moneda", "asdas"};
        var input = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);

        System.out.println(input);
    }
}
