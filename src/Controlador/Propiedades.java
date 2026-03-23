
package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Propiedades {
    
public void mostrarMensajeError(String mensaje, String ruta, String dialogo) {
        UIManager.put("OptionPane.background", new Color(32, 139, 223));
        UIManager.put("Panel.background", new Color(32, 139, 223));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 20));
        UIManager.put("OptionPane.messageForeground", Color.white);

        JButton btn1 = new JButton("Aceptar");
        btn1.setBackground(Color.green);
        btn1.setForeground(Color.white);

        JLabel messageLabel = new JLabel(mensaje, getIcon(ruta, 50, 50), JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 139, 223));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(messageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btn1);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(dialogo);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("OptionPane.messageForeground", null);
    }
    


public String mostrarMensajeEntrada(String mensaje, String ruta, String dialogo) {
        UIManager.put("OptionPane.background", new Color(32, 139, 223));
        UIManager.put("Panel.background", new Color(32, 139, 223));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 20));
        UIManager.put("OptionPane.messageForeground", Color.white);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.green);
        btnAceptar.setForeground(Color.white);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.red);
        btnCancelar.setForeground(Color.white);

        JLabel messageLabel = new JLabel(mensaje, getIcon(ruta, 50, 50), JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(Color.white);

        JTextField textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(200, 30));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 139, 223));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(messageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnAceptar);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnCancelar);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(dialogo);

        final String[] input = new String[1]; // Array to store the user input

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input[0] = textField.getText();
                dialog.dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input[0] = null; // Set input to null if cancelled
                dialog.dispose();
            }
        });

        dialog.setVisible(true);

        // Reset UIManager properties
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("OptionPane.messageForeground", null);

        return input[0];
    }


        private Icon getIcon(String path, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(path))
                .getImage().getScaledInstance(w, h, 0));
    }
}

