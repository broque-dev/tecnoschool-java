package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Botones_OFF {

    private MouseAdapter disabledMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!((JLabel)e.getSource()).isEnabled()) {
                return; // Do nothing when the label is disabled
            }}
    };

    public void configurarJPlabel(JLabel label, JPanel panel, boolean habilitado) {
        Color habilitadoColor = new Color(204, 153, 255);
        Color deshabilitadoColor = Color.GRAY;
        label.setEnabled(habilitado);
        panel.setBackground(habilitado ? habilitadoColor : deshabilitadoColor);
        for (Component component : panel.getComponents()) {
            component.setEnabled(habilitado);
        }
        if (habilitado) {
            removeDisabledMouseListener(label);
        } else {
            addDisabledMouseListener(label);
        }
    }

    public void habilitarJPlabel(JLabel label, JPanel panel, Color habilitadoColor) {
        label.setEnabled(true);
        panel.setBackground(habilitadoColor);
        for (Component component : panel.getComponents()) {
            component.setEnabled(true);
        }
        removeDisabledMouseListener(label);
    }

    public void deshabilitarJPlabel(JLabel label, JPanel panel) {
        label.setEnabled(false);
        panel.setBackground(Color.GRAY);
        for (Component component : panel.getComponents()) {
            component.setEnabled(false);
        }
        addDisabledMouseListener(label);
    }

    public void addDisabledMouseListener(JLabel label) {
        if (!hasDisabledMouseListener(label)) {
            label.addMouseListener(disabledMouseAdapter);
        }
    }

    public void removeDisabledMouseListener(JLabel label) {
        if (hasDisabledMouseListener(label)) {
            label.removeMouseListener(disabledMouseAdapter);
        }
    }

    public boolean hasDisabledMouseListener(JLabel label) {
        for (MouseListener listener : label.getMouseListeners()) {
            if (listener == disabledMouseAdapter) {
                return true;
            }
        }
        return false;
    }
}
