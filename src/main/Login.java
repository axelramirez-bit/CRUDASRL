
package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {
    JLabel usuarioLbl, passLbl, tituloLbl;
    JTextField user;
    JPasswordField pass;
    JButton iniciarBtn, cancelarBtn;

    ConexionDB conectar = new ConexionDB();

    public Login() {

        setTitle("LOGIN");
        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          // Color de fondo
        getContentPane().setBackground(Color.CYAN);

        // Titulo
        tituloLbl = new JLabel("INICIO DE SESIÓN");
        tituloLbl.setBounds(140, 20, 150, 30);
        add(tituloLbl);

        // Usuario
        usuarioLbl = new JLabel("Usuario:");
        usuarioLbl.setBounds(50, 70, 80, 25);
        add(usuarioLbl);

        user = new JTextField();
        user.setBounds(140, 70, 180, 25);
        add(user);

        // Contraseña
        passLbl = new JLabel("Contraseña:");
        passLbl.setBounds(50, 110, 80, 25);
        add(passLbl);

        pass = new JPasswordField();
        pass.setBounds(140, 110, 180, 25);
        add(pass);

        // Botón iniciar sesión
        iniciarBtn = new JButton("Iniciar Sesión");
        iniciarBtn.setBounds(50, 160, 130, 30);
        add(iniciarBtn);

        // Botón cancelar
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBounds(200, 160, 120, 30);
        add(cancelarBtn);

        // Evento iniciar sesión
        iniciarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String usuario = user.getText();
                    String password = String.valueOf(pass.getPassword());

                    String query = "SELECT * FROM usuarios "
                            + "WHERE usuario='" + usuario
                            + "' AND pass='" + password + "'";

                    Statement st = conectar.getConnection().createStatement();
                    ResultSet rs = st.executeQuery(query);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null,
                                "Bienvenido " + usuario);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Usuario o contraseña incorrecta");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error: " + ex.getMessage());
                }
            }
        });

        // Evento cancelar
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}