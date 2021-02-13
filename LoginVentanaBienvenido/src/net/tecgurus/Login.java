package net.tecgurus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	// Instanciamos la clase Usuario creando el objeto alumno
	// para acceder a sus atributos (usr y pss).
	Usuario alumno = new Usuario();
	
	// Creamos el objeto teclado para settear el usuario y password.
	Scanner teclado = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		System.out.println("Ingresa el usuario a settear: ");
		alumno.setUsr(teclado.nextLine());
		System.out.println("Ingresa el password a settear: ");
		alumno.setPss(teclado.nextLine());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("* Usuario:");
		lblUsuario.setBounds(57, 85, 74, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("* Password:");
		lblPassword.setBounds(57, 133, 74, 14);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(219, 82, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(219, 130, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(132, 171, 89, 23);
		// Agregamos el metodo de consultarUsuario al boton de "Entrar"
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarUsuario();
			}
		});
		contentPane.add(btnEntrar);
	}
	
	public void consultarUsuario(){
		
		String usuario = txtUsuario.getText();
		String password = String.valueOf(txtPassword.getPassword());
		
		if(usuario.isEmpty()){
			JOptionPane.showMessageDialog(null, "El campo de USUARIO es requerido", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else if (password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo de PASSWORD es requerido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

//		***Se comienza por esta validacion.***
//		// Validamos si el usuario es correcto.
//		if (usuario.equals(alumno.getUsr())) {
//			System.out.println("Usuario correcto");
//		} else {
//			System.out.println("Usuario incorrecto");
//		}
		
//		// Validamos si el usuario es correcto.
//		if (password.equals(alumno.getPass())) {
//			System.out.println("Password correcto");
//		} else {
//			System.out.println("Password incorrecto");
//		}
		
		// Validamos el usuario
		if (usuario.equals(alumno.getUsr())) {
			System.out.println("El usuario es correcto");
		} else {
			System.out.println("El usuario es incorrecto");
		}
		
		// Validamos la contraseña
		if (password.equals(alumno.getPss())){
			System.out.println("El password es correcto");
		} else {
			System.out.println("El password es incorrecto");
		}
		
		// Validamos tanto el usuario como la contraseña y mandamos
		// A la pantala de bienveida.
		if (usuario.equals(alumno.getUsr()) && password.equals(alumno.getPss())) {
			// Hacemos visible la ventana de "Bienvenido"
			Bienvenido bienvenido = new Bienvenido();
			bienvenido.setVisible(true);
			cerrarLogin();
		}
	}
	
	// Ocultamos la ventana de Login
	public void cerrarLogin() {
		this.setVisible(false);
	}
}