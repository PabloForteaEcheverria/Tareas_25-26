package Tarea_6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {
	
	private static final String FICHERO = "src/Tarea_6/libros.txt";
	
	private Biblioteca biblioteca;
	private JTable tabla;
	private JTextField tfTitulo, tfAutor, tfIsbn;
    private DefaultTableModel modeloTabla;
	
    public MainGUI() {
    	super("Biblioteca");
    	
    	biblioteca = new Biblioteca();
    	FicheroLibros.leerFichero(FICHERO, biblioteca);
    	construirInterfaz();
    	//refrescarTabla();
    	setSize(700, 500);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

	private void construirInterfaz() {
		setLayout(new BorderLayout(10, 10));
		JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 3, 10));
		
		
		panelFormulario.add(new JLabel("ISBN:"));
		tfIsbn = new JTextField();
        panelFormulario.add(tfIsbn);
		
		panelFormulario.add(new JLabel("Título:"));
		tfTitulo = new JTextField();
		panelFormulario.add(tfTitulo);
	
		panelFormulario.add(new JLabel("Autor:"));
		tfAutor = new JTextField();
		panelFormulario.add(tfAutor);
		
        add(panelFormulario, BorderLayout.NORTH);
        String[] columnas = { "ISBN","Título", "Autor", "Disponible"};
        modeloTabla = new DefaultTableModel(columnas, 15) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // solo lectura
            }
        };
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        add(scroll, BorderLayout.CENTER);
        
 //------> botones:
        JButton btnAnadir = new JButton("Añadir");
        btnAnadir.addActionListener(e -> accionAnadir());
        panelBotones.add(btnAnadir);
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(e -> accionMostrar());
        panelBotones.add(btnMostrar);
        JButton btnPrestar = new JButton("Prestar");
        btnPrestar.addActionListener(e -> accionPrestar());
        panelBotones.add(btnPrestar);
        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.addActionListener(e -> accionDevolver());
        panelBotones.add(btnDevolver);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> accionBuscar());
        panelBotones.add(btnBuscar);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> accionGuardar());
        panelBotones.add(btnGuardar);
       
        add(panelBotones, BorderLayout.SOUTH);
        
	}
	
	private void accionGuardar() {
		FicheroLibros.guardarFichero(FICHERO, biblioteca);
	}

	private void accionBuscar() {
	        String isbn = JOptionPane.showInputDialog(this, "Codigo libro:");
	        if (isbn == null || isbn.trim().isEmpty()) {
	        	return;
	        }
	        Libro libro = biblioteca.buscarConIsbn(isbn.trim());
	        if (libro == null) {
	            JOptionPane.showMessageDialog(this, "Libro no existe", "Resultado", JOptionPane.INFORMATION_MESSAGE);
	        }
	        else {
	            JOptionPane.showMessageDialog(this,
                    "Título: " + libro.getTitulo() + "\n" +
                    "Autor: " + libro.getAutor() + "\n" +
                    "ISBN: " + libro.getIsbn() + "\n" +
                    "Disponible: " + (libro.isDisponible() ? "Sí" : "No"),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }

	private void accionPrestar() {
	        String isbn = JOptionPane.showInputDialog(this, "Codigo del libro:");
	        if (isbn == null || isbn.trim().isEmpty()) {
	        	return;
	        }
	        if (biblioteca.buscarConIsbn(isbn.trim()) == null) {
	            JOptionPane.showMessageDialog(this, "El codigo  no existe", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        if (biblioteca.buscarConIsbn(isbn.trim()).prestar()) {
	            JOptionPane.showMessageDialog(this, "Libro prestado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "Libro no disponible", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        refrescarTabla();
	    }
	
	   private void accionDevolver() {
	        String isbn = JOptionPane.showInputDialog(this, "Codigo del libro:");
	        if (isbn == null || isbn.trim().isEmpty()) {
	        	return;
	        }

	        if (biblioteca.buscarConIsbn(isbn.trim()) == null) {
	            JOptionPane.showMessageDialog(this, "El codigo no existe", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        biblioteca.buscarConIsbn(isbn.trim()).devolver();
	        JOptionPane.showMessageDialog(this, "Libro devuelto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        refrescarTabla();
	    }
	   
	   
	   
	private void accionAnadir() {
		String titulo = tfTitulo.getText().trim();
        String autor = tfAutor.getText().trim();
        String isbn = tfIsbn.getText().trim();
        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if (biblioteca.buscarConIsbn(isbn) != null) {
            JOptionPane.showMessageDialog(this, "Este ISBN ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Libro libro = new Libro(isbn, titulo, autor, true);
        biblioteca.añadirLibro(libro);

        JOptionPane.showMessageDialog(this, "Libro añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarFormulario();
        refrescarTabla();
    }
	private void accionMostrar() {
        refrescarTabla();
    }
// -----> Utilidades:
	
	  private void refrescarTabla() {
	        modeloTabla.setRowCount(0); 
	        List<Libro> libros = biblioteca.getLibros();
	        for (Libro l : libros) {
	            Object[] fila = {
	                    l.getTitulo(),
	                    l.getAutor(),
	                    l.getIsbn(),
	                    l.isDisponible() ? "Sí" : "No"
	            };
	            modeloTabla.addRow(fila);
	        }
	    }
	  
	  private void limpiarFormulario() {
	        tfTitulo.setText("");
	        tfAutor.setText("");
	        tfIsbn.setText("");
	        tfTitulo.requestFocus();
	    }
	  
	  
	  
	  
	  
	public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
