package uam.bases.mybatis.conexion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EstablecerConexion {

	static String driver = "org.postgresql.Driver";
    static String ruta = "jdbc:postgresql://10.99.99.74:5432/erp_comermex_pruebas";
    static String user = "abenitez";
    static String password = "dtmx.2020";

    public static void saveUser(JTextField id, JTextField codPais, JTextField descripcionPais, JTextField nacionalidadPais, JTextField username) {
        try {
            Class.forName(driver);
            Connection conne = DriverManager.getConnection(ruta, user, password);
            Statement consulta = conne.createStatement();
            consulta.executeUpdate("insert into Pais(id, codPais, descripcionPais, nacionalidadPais, username) values('" + id.getText() + "','" + codPais.getText() + "','" + 
            descripcionPais.getText() + "','" + nacionalidadPais.getText() + "','" + username.getText() + "')");
            id.setText(null);
            codPais.setText(null);
            descripcionPais.setText(null);
            nacionalidadPais.setText(null);
            username.setText(null);
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El error esta en: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
  
        JFrame frame = new JFrame("Guardar usuario");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel lId = new JLabel("Id");
        final JTextField id = new JTextField(10);
        JLabel lCodPais = new JLabel("Codigo del pais");
        final JTextField codPais = new JTextField(10);
        JLabel lDescripcionPais = new JLabel("Descripcion del pais");
        final JTextField descripcionPais = new JTextField(10);
        JLabel lNacionalidadPais = new JLabel("Nacionalidad del pais");
        final JTextField nacionalidadPais = new JTextField(10);
        JLabel lUsername = new JLabel("Username");
        final JTextField username = new JTextField(10);
        JButton button = new JButton();
        button.setText("Guardar");

        panel.add(lId);
        panel.add(id);
        panel.add(lCodPais);
        panel.add(codPais);
        panel.add(lDescripcionPais);
        panel.add(descripcionPais);
        panel.add(lNacionalidadPais);
        panel.add(nacionalidadPais);
        panel.add(lUsername);
        panel.add(username);
        
        panel.add(button);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                 saveUser(id, codPais, descripcionPais, nacionalidadPais, username);
            }
        });

    }

}
