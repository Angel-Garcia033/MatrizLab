package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class GUI_MatrizLab extends JFrame 
{
	private int Opcion, Tamano;
	private String Relaciones;
	
	private JPanel Panel_Menu, Panel_Matriz, Panel_Relaciones, Panel_TipoR, Panel_Grafo;
	private JScrollPane scrollMatriz, scrollRelaciones, scrollPaneGrafo;
	private JTextField txtTamano_matriz, txtCoordenada1, txtCoordenada2;
	private JTextArea txtAreaInstrucciones, txtAreaInstrucciones2, txtAreaRelacion;
	private JTable tblMatriz;
	private JButton btnCrear_matriz, btnRellenar_ceros, btnInsertar, btnRandom, btnContinuar, btnSiguiente, btnContinuar2;
	private JButton btnSalir, btnInicio, btnAristas;
	private JLabel lblMensaje_bienvenida, lblRellenar_cero, lblCoordenada1, lblCoordenada2, lblGenerar_random;
	private JLabel lblTitulo2, lblRelaciones, lblTitulo4, lblOrden_total, lblOrden_parcial, lblOrden_estricto;
	private JLabel lblEquivalencia, lblTransitiva, lblAntisimetrica, lblASimetrica, lblSimetrica, lblAntireflexiva;
	private JLabel lblReflexiva, lblTitulo3;
	private JCheckBox chckbxReflexiva, chckbxAntireflexiva, chckbxTransitiva, chckbxEquivalencia, chckbxOrdenTotal;
	private JCheckBox chckbxSimetrica, chckbxAsimetrica, chckbxAntisimetrica, chckbxOrdenEstricto, chckbxOrdenParcial;
	private JCheckBox chckbxEje1, chckbxEje2;
	private JPanel panelGrafo;

	public GUI_MatrizLab() 
	{
		Panel_Menu = new JPanel();
		Panel_Matriz = new JPanel();
		Panel_Relaciones = new JPanel();
		Panel_TipoR = new JPanel();
		Panel_Grafo = new JPanel();
		panelGrafo = new JPanel();
		
		scrollMatriz = new JScrollPane();
		scrollRelaciones = new JScrollPane();
		scrollPaneGrafo = new JScrollPane();
		
		txtAreaInstrucciones = new JTextArea();
		txtAreaInstrucciones2 = new JTextArea();
		txtAreaRelacion = new JTextArea();
		
		txtTamano_matriz = new JTextField();
		txtCoordenada1 = new JTextField();
		txtCoordenada2 = new JTextField();
		
		lblMensaje_bienvenida = new JLabel("BIENVENIDO!");
		lblRellenar_cero = new JLabel("Rellenar espacios vacios con 0 (falso)");
		lblCoordenada1 = new JLabel("Coordenada 1:");
		lblCoordenada2 = new JLabel("Coordenada 2:");
		lblGenerar_random = new JLabel("Generar matriz autom\u00E1ticamente");
		lblTitulo2 = new JLabel("Matriz y sus relaciones");
		lblRelaciones = new JLabel("Relaciones:");
		lblOrden_total = new JLabel("Relaci\u00F3n de orden total:");
		lblOrden_parcial = new JLabel("Relaci\u00F3n de orden parcial:");
		lblOrden_estricto = new JLabel("Relaci\u00F3n de orden estricto:");
		lblEquivalencia = new JLabel("Relaci\u00F3n de equivalencia:");
		lblTransitiva = new JLabel("Relaci\u00F3n transitiva:");
		lblAntisimetrica = new JLabel("Relaci\u00F3n antisim\u00E9trica:");
		lblASimetrica = new JLabel("Relaci\u00F3n asim\u00E9trica:");
		lblSimetrica = new JLabel("Relaci\u00F3n sim\u00E9trica:");
		lblAntireflexiva = new JLabel("Relaci\u00F3n antireflexiva:");
		lblReflexiva = new JLabel("Relaci\u00F3n reflexiva:");
		lblTitulo3 = new JLabel("Relaciones de orden");
		lblTitulo4 = new JLabel("Grafo de la matriz");
		
		btnCrear_matriz = new JButton("Crear matriz");	
		btnRellenar_ceros = new JButton("Rellenar");
		btnInsertar = new JButton("Insertar");
		btnRandom = new JButton("Generar");
		btnContinuar = new JButton("Continuar");
		btnSiguiente = new JButton("Continuar");
		btnContinuar2 = new JButton("Continuar");
		btnSalir = new JButton("Salir");
		btnInicio = new JButton("Inicio");
		btnAristas = new JButton("Imprimir Aristas");
		
		tblMatriz = new JTable();
		
		chckbxEje1 = new JCheckBox("");
		chckbxEje2 = new JCheckBox("");
		chckbxReflexiva = new JCheckBox("");
		chckbxAntireflexiva = new JCheckBox("");
		chckbxTransitiva = new JCheckBox("");
		chckbxEquivalencia = new JCheckBox("");
		chckbxOrdenTotal = new JCheckBox("");
		chckbxSimetrica = new JCheckBox("");
		chckbxAsimetrica = new JCheckBox("");
		chckbxAntisimetrica = new JCheckBox("");
		chckbxOrdenEstricto = new JCheckBox("");
		chckbxOrdenParcial = new JCheckBox("");
		
		Opcion = 0;		
		Relaciones = "{";

		Ventana();
	}
	
	
	
	//==========================================================================

	public void Ventana() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finalizar ejecución con la x
		setBounds(100, 100, 840, 480); //Tamaño de la ventana en formato 16:9
		setLocationRelativeTo(null); //Coloca la ventana en el centro de la pantalla
		setVisible(true); //Hace visible la ventana
		
		switch (Opcion) 
		{
			case 0:
				Menu();
				setTitle("MatrizLab");				
	
				Panel_Menu.setVisible(true);
				Panel_Matriz.setVisible(false);
				Panel_Relaciones.setVisible(false);
				Panel_TipoR.setVisible(false);
				Panel_Grafo.setVisible(false);
	
				break;
	
			case 1:
				Matriz();
				setTitle("MatrizLab - Rellenar matriz");				
	
				Panel_Menu.setVisible(false);
				Panel_Matriz.setVisible(true);
				Panel_Relaciones.setVisible(false);
				Panel_TipoR.setVisible(false);
				Panel_Grafo.setVisible(false);
	
				break;
				
			case 2:
				Relaciones();
				setTitle("MatrizLab - Relaciones de la matriz");
				
				Panel_Menu.setVisible(false);
				Panel_Matriz.setVisible(false);
				Panel_Relaciones.setVisible(true);
				Panel_TipoR.setVisible(false);
				Panel_Grafo.setVisible(false);
				
				break;
				
			case 3:
				tipoRelaciones();
				setTitle("MatrizLab - Relaciones de orden");
				
				Panel_Menu.setVisible(false);
				Panel_Matriz.setVisible(false);
				Panel_Relaciones.setVisible(false);
				Panel_TipoR.setVisible(true);
				Panel_Grafo.setVisible(false);
				break;
				
			case 4:
				Grafo();
				setTitle("MatrizLab - Grafo de la matriz");
				
				Panel_Menu.setVisible(false);
				Panel_Matriz.setVisible(false);
				Panel_Relaciones.setVisible(false);
				Panel_TipoR.setVisible(false);
				Panel_Grafo.setVisible(true);
				
				break;
		}
	}
	
	//==========================================================================
	
	public void Error ()
	{
		JOptionPane.showMessageDialog(this, "¡Error! La cantidad ingresada no es valida. Recuerde que debe ingresar un número positivo mayor que cero", "Opción invalida", 0);
	}
	
	public void errorGenerico ()
	{
		JOptionPane.showMessageDialog(this, "¡A ocurrido un error inesperado! Por favor vuelvalo a intentar", "Opción invalida", 0);
	}
	
	public void insertarCorrecta ()
	{
		JOptionPane.showMessageDialog(this, "Se ha insertado el valor correctamente", "Insertado con éxito", 1);
	}
	
	public void rellenarCorrecta ()
	{
		JOptionPane.showMessageDialog(this, "Se ha rellenado los espacios vacios de la matriz con 0 (falso) correctamente", "Rellenado con éxito", 1);
	}
	
	public void generarCorrecta ()
	{
		JOptionPane.showMessageDialog(this, "Se ha generado la matriz correctamente", "Generado con éxito", 1);
	}
	
	public void reiniciarRelaciones ()
	{
		Relaciones = "{";
	}
	
	public void crearAristas (int[][] aristas, JLabel[] nodos, int relaciones)
	{
		/*double angulo, pendiente;
		int carreo_x, carreo_y;*/
		
		Graphics figuras = panelGrafo.getGraphics();	
		/*Graphics g = panelGrafo.getGraphics();
		Graphics2D triangulo = (Graphics2D) g;
		Polygon cabeza = new Polygon ();
		g.setColor(Color.CYAN);*/
		
		for (int i = 0; i < relaciones; i++)
		{
			if (aristas[i][0] == aristas[i][1])
			{
				figuras.setColor(Color.BLUE);
				figuras.drawOval((nodos[aristas[i][0]].getX() - 25), (nodos[aristas[i][0]].getY() - 25), 35, 35);
				figuras.drawLine(nodos[aristas[i][0]].getX(), (nodos[aristas[i][0]].getY() + 10), (nodos[aristas[i][0]].getX() - 10), (nodos[aristas[i][0]].getY() + 20));
				figuras.drawLine(nodos[aristas[i][0]].getX(), (nodos[aristas[i][0]].getY() + 10), (nodos[aristas[i][0]].getX() - 10), nodos[aristas[i][0]].getY());
			}
			else
			{
				figuras.setColor(Color.CYAN);
				figuras.drawLine((nodos[aristas[i][0]].getX() + 25), (nodos[aristas[i][0]].getY() + 25), (nodos[aristas[i][1]].getX() + 25), (nodos[aristas[i][1]].getY() + 25));
				figuras.fillOval(nodos[aristas[i][1]].getX() + 20, nodos[aristas[i][1]].getY() + 20, 10, 10);
				
				/*carreo_x = (nodos[aristas[i][1]].getX() + 25) - (nodos[aristas[i][0]].getX() + 25);
				carreo_y = (nodos[aristas[i][1]].getY() + 25) - (nodos[aristas[i][0]].getY() + 25);
				
				if (carreo_x != 0)
				{
					pendiente = (carreo_y / carreo_x);
					angulo = Math.atan(pendiente) * -1;
					
					cabeza.reset();
					cabeza.addPoint((nodos[aristas[i][1]].getX() + 25), (nodos[aristas[i][1]].getY() + 25));
					cabeza.addPoint((nodos[aristas[i][1]].getX() + 10), (nodos[aristas[i][1]].getY() + 15));
					cabeza.addPoint((nodos[aristas[i][1]].getX() + 10), (nodos[aristas[i][1]].getY() + 35));
					
					System.out.println(angulo);
					triangulo.rotate(angulo);
					triangulo.translate(-155, -432);
					triangulo.fillPolygon(cabeza);
				}*/
			}
		}
	}
	
	//==========================================================================
	
	private void Menu ()
	{
		Panel_Menu.setBounds(0, 0, 826, 455);
		Panel_Menu.setBackground(Color.ORANGE);
		Panel_Menu.setLayout(null);
		
		txtTamano_matriz.setColumns(10);
		txtTamano_matriz.setBounds(602, 230, 195, 33);		
		txtTamano_matriz.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		txtAreaInstrucciones.setWrapStyleWord(true);
		txtAreaInstrucciones.setText("Para continuar por favor ingrese el tama\u00F1o del que desea crear su matriz:");
		txtAreaInstrucciones.setLineWrap(true);
		txtAreaInstrucciones.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		txtAreaInstrucciones.setBackground(Color.ORANGE);
		txtAreaInstrucciones.setBounds(10, 157, 816, 128);
		
		lblMensaje_bienvenida.setForeground(new Color(25, 25, 112));
		lblMensaje_bienvenida.setFont(new Font("Comic Sans MS", Font.ITALIC, 80));
		lblMensaje_bienvenida.setBounds(129, 11, 584, 84);
		
		btnCrear_matriz.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		btnCrear_matriz.setBackground(new Color(210, 105, 30));
		btnCrear_matriz.setBounds(278, 367, 280, 49);
		
		Panel_Menu.removeAll ();
		Panel_Menu.add(txtTamano_matriz);
		Panel_Menu.add(txtAreaInstrucciones);
		Panel_Menu.add(lblMensaje_bienvenida);
		Panel_Menu.add(btnCrear_matriz);
		
		this.getContentPane().add(Panel_Menu);
	}

	private void Matriz ()
	{
		Panel_Matriz.setBounds(0, 0, 826, 455);
		Panel_Matriz.setBackground(Color.ORANGE);
		Panel_Matriz.setLayout(null);
		
		btnRellenar_ceros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRellenar_ceros.setBounds(630, 267, 159, 39);
		btnRellenar_ceros.setBackground(new Color(210, 105, 30));
		
		btnRandom.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRandom.setBounds(630, 327, 159, 39);
		btnRandom.setBackground(new Color(210, 105, 30));
		
		btnInsertar.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnInsertar.setBounds(630, 175, 159, 39);
		btnInsertar.setBackground(new Color(210, 105, 30));
		
		btnContinuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnContinuar.setBounds(341, 393, 169, 39);
		btnContinuar.setBackground(new Color(210, 105, 30));
		
		txtCoordenada2.setBounds(341, 181, 45, 45);
		txtCoordenada2.setColumns(10);
		txtCoordenada2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		txtCoordenada1.setColumns(10);
		txtCoordenada1.setBounds(10, 181, 45, 45);
		txtCoordenada1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		txtAreaInstrucciones2.setBackground(Color.ORANGE);
		txtAreaInstrucciones2.setWrapStyleWord(true);
		txtAreaInstrucciones2.setLineWrap(true);
		txtAreaInstrucciones2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		txtAreaInstrucciones2.setText("Por favor inserte las coordenadas en las que quiera a\u00F1adir un valor de 1 (verdadero) en la matriz");
		txtAreaInstrucciones2.setBounds(10, 11, 806, 102);
		
		lblRellenar_cero.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 29));
		lblRellenar_cero.setBounds(10, 267, 547, 39);
		
		lblCoordenada1.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
		lblCoordenada1.setBounds(15, 131, 208, 39);
		
		lblCoordenada2.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
		lblCoordenada2.setBounds(341, 131, 208, 39);
		
		lblGenerar_random.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 29));
		lblGenerar_random.setBounds(10, 317, 514, 39);
		
		Panel_Matriz.removeAll ();
		Panel_Matriz.add(btnRellenar_ceros);
		Panel_Matriz.add(lblRellenar_cero);
		Panel_Matriz.add(txtCoordenada2);
		Panel_Matriz.add(txtCoordenada1);
		Panel_Matriz.add(txtAreaInstrucciones2);
		Panel_Matriz.add(lblCoordenada1);
		Panel_Matriz.add(lblCoordenada2);
		Panel_Matriz.add(btnInsertar);
		Panel_Matriz.add(lblGenerar_random);
		Panel_Matriz.add(btnRandom);
		Panel_Matriz.add(btnContinuar);
		
		this.getContentPane().add(Panel_Matriz);
	}
	
	private void Relaciones ()
	{
		Panel_Relaciones.setBounds(0, 0, 826, 455);
		Panel_Relaciones.setBackground(Color.ORANGE);
		Panel_Relaciones.setLayout(null);
		
		lblTitulo2.setBounds(26, 0, 769, 101);
		lblTitulo2.setForeground(Color.BLUE);
		lblTitulo2.setFont(new Font("Comic Sans MS", Font.ITALIC, 70));
		
		scrollMatriz.setBounds(26, 112, 769, 191);
		scrollMatriz.setViewportView(tblMatriz);
		
		scrollRelaciones.setBounds(26, 360, 769, 78);
		scrollRelaciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollRelaciones.setViewportView(txtAreaRelacion);
		
		tblMatriz.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		DefaultTableModel modelo = (DefaultTableModel) tblMatriz.getModel();
		modelo.setRowCount(Tamano);
		modelo.setColumnCount(Tamano);
		
		txtAreaRelacion.setBackground(Color.ORANGE);
		txtAreaRelacion.setLineWrap(true);
		txtAreaRelacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtAreaRelacion.setText("R: " + Relaciones);
		
		lblRelaciones.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblRelaciones.setBounds(26, 325, 155, 40);
		
		btnSiguiente.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnSiguiente.setBounds(668, 333, 127, 23);
		btnSiguiente.setBackground(new Color(210, 105, 30));
		
		Panel_Relaciones.removeAll();
		Panel_Relaciones.add(lblTitulo2);
		Panel_Relaciones.add(scrollMatriz);
		Panel_Relaciones.add(scrollRelaciones);
		Panel_Relaciones.add(lblRelaciones);
		Panel_Relaciones.add(btnSiguiente);
		
		this.getContentPane().add(Panel_Relaciones);
	}
	
	private void tipoRelaciones ()
	{
		Panel_TipoR.setBounds(0, 0, 826, 455);
		Panel_TipoR.setBackground(Color.ORANGE);
		Panel_TipoR.setLayout(null);

		chckbxEje2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxEje2.setEnabled(false);
		chckbxEje2.setBackground(Color.ORANGE);
		chckbxEje2.setBounds(260, 148, 21, 21);

		chckbxEje1.setEnabled(false);
		chckbxEje1.setSelected(true);
		chckbxEje1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxEje1.setBackground(Color.ORANGE);
		chckbxEje1.setBounds(193, 148, 21, 21);
		
		chckbxReflexiva.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxReflexiva.setEnabled(false);
		chckbxReflexiva.setBackground(Color.ORANGE);
		chckbxReflexiva.setBounds(286, 196, 21, 21);

		chckbxAntireflexiva.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxAntireflexiva.setEnabled(false);
		chckbxAntireflexiva.setBackground(Color.ORANGE);
		chckbxAntireflexiva.setBounds(286, 235, 21, 21);

		chckbxTransitiva.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxTransitiva.setEnabled(false);
		chckbxTransitiva.setBackground(Color.ORANGE);
		chckbxTransitiva.setBounds(286, 274, 21, 21);

		chckbxEquivalencia.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxEquivalencia.setEnabled(false);
		chckbxEquivalencia.setBackground(Color.ORANGE);
		chckbxEquivalencia.setBounds(286, 313, 21, 21);

		chckbxOrdenTotal.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxOrdenTotal.setEnabled(false);
		chckbxOrdenTotal.setBackground(Color.ORANGE);
		chckbxOrdenTotal.setBounds(286, 352, 21, 21);

		chckbxSimetrica.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxSimetrica.setEnabled(false);
		chckbxSimetrica.setBackground(Color.ORANGE);
		chckbxSimetrica.setBounds(795, 196, 21, 21);

		chckbxAsimetrica.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxAsimetrica.setEnabled(false);
		chckbxAsimetrica.setBackground(Color.ORANGE);
		chckbxAsimetrica.setBounds(795, 235, 21, 21);

		chckbxAntisimetrica.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxAntisimetrica.setEnabled(false);
		chckbxAntisimetrica.setBackground(Color.ORANGE);
		chckbxAntisimetrica.setBounds(795, 274, 21, 21);

		chckbxOrdenEstricto.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxOrdenEstricto.setEnabled(false);
		chckbxOrdenEstricto.setBackground(Color.ORANGE);
		chckbxOrdenEstricto.setBounds(795, 313, 21, 21);

		chckbxOrdenParcial.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxOrdenParcial.setEnabled(false);
		chckbxOrdenParcial.setBackground(Color.ORANGE);
		chckbxOrdenParcial.setBounds(795, 352, 21, 21);

		txtAreaInstrucciones2.setBackground(Color.ORANGE);
		txtAreaInstrucciones2.setWrapStyleWord(true);
		txtAreaInstrucciones2.setLineWrap(true);
		txtAreaInstrucciones2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtAreaInstrucciones2.setText("A continuaci\u00F3n se muestran los tipos de relaciones de orden que existen y a cual de ellas pertenece   o no   nuestra matriz:");
		txtAreaInstrucciones2.setToolTipText("");
		txtAreaInstrucciones2.setBounds(10, 112, 806, 58);
		
		lblTitulo3.setBounds(57, 0, 769, 101);
		lblTitulo3.setForeground(Color.BLUE);
		lblTitulo3.setFont(new Font("Comic Sans MS", Font.ITALIC, 70));

		lblReflexiva.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblReflexiva.setBounds(23, 189, 191, 28);

		lblAntireflexiva.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblAntireflexiva.setBounds(23, 228, 222, 28);

		lblSimetrica.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblSimetrica.setBounds(478, 189, 222, 28);

		lblASimetrica.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblASimetrica.setBounds(478, 228, 222, 28);

		lblAntisimetrica.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblAntisimetrica.setBounds(478, 267, 222, 28);

		lblTransitiva.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblTransitiva.setBounds(23, 267, 222, 28);

		lblEquivalencia.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblEquivalencia.setBounds(23, 306, 238, 28);

		lblOrden_estricto.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblOrden_estricto.setBounds(478, 306, 264, 28);

		lblOrden_parcial.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblOrden_parcial.setBounds(478, 345, 264, 28);

		lblOrden_total.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblOrden_total.setBounds(23, 345, 238, 28);

		btnContinuar2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnContinuar2.setBounds(336, 393, 168, 28);
		btnContinuar2.setBackground(new Color(210, 105, 30));

		Panel_TipoR.removeAll();
		Panel_TipoR.add(chckbxEje2);
		Panel_TipoR.add(chckbxEje1);
		Panel_TipoR.add(lblTitulo3);
		Panel_TipoR.add(txtAreaInstrucciones2);
		Panel_TipoR.add(lblReflexiva);
		Panel_TipoR.add(lblAntireflexiva);
		Panel_TipoR.add(lblSimetrica);
		Panel_TipoR.add(lblASimetrica);
		Panel_TipoR.add(lblAntisimetrica);
		Panel_TipoR.add(lblTransitiva);
		Panel_TipoR.add(lblEquivalencia);
		Panel_TipoR.add(lblOrden_estricto);
		Panel_TipoR.add(lblOrden_parcial);
		Panel_TipoR.add(lblOrden_total);
		Panel_TipoR.add(btnContinuar2);
		Panel_TipoR.add(chckbxReflexiva);
		Panel_TipoR.add(chckbxAntireflexiva);
		Panel_TipoR.add(chckbxTransitiva);
		Panel_TipoR.add(chckbxEquivalencia);
		Panel_TipoR.add(chckbxOrdenTotal);
		Panel_TipoR.add(chckbxSimetrica);
		Panel_TipoR.add(chckbxAsimetrica);
		Panel_TipoR.add(chckbxAntisimetrica);
		Panel_TipoR.add(chckbxOrdenEstricto);
		Panel_TipoR.add(chckbxOrdenParcial);
		
		this.getContentPane().add(Panel_TipoR);
	}
	
	private void Grafo ()
	{
		Panel_Grafo.setBounds(0, 0, 826, 455);
		Panel_Grafo.setBackground(Color.ORANGE);
		Panel_Grafo.setLayout(null);

		scrollPaneGrafo.setBounds(10, 101, 806, 281);
		scrollPaneGrafo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneGrafo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		lblTitulo4.setBounds(80, 0, 736, 90);
		lblTitulo4.setForeground(Color.BLUE);
		lblTitulo4.setFont(new Font("Comic Sans MS", Font.ITALIC, 70));

		btnInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnInicio.setBounds(648, 393, 168, 28);
		btnInicio.setBackground(new Color(210, 105, 30));
		
		btnSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnSalir.setBackground(new Color(210, 105, 30));
		btnSalir.setBounds(10, 393, 168, 28);
		
		btnAristas.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnAristas.setBackground(new Color(210, 105, 30));
		btnAristas.setBounds(315, 393, 199, 28);
		
		scrollPaneGrafo.setViewportView(panelGrafo);
		panelGrafo.setLayout(null);
		panelGrafo.setBackground(Color.WHITE);
		panelGrafo.setPreferredSize(new Dimension(9999, 1999));
		
		Panel_Grafo.removeAll();
		Panel_Grafo.add(scrollPaneGrafo);
		Panel_Grafo.add(lblTitulo4);
		Panel_Grafo.add(btnInicio);
		Panel_Grafo.add(btnSalir);
		Panel_Grafo.add(btnAristas);
		
		this.getContentPane().add(Panel_Grafo);
	}

//==========================================================================

	public JTextField getTxtTamano_matriz() {
		return txtTamano_matriz;
	}

	public void setTxtTamano_matriz(JTextField txtTamano_matriz) {
		this.txtTamano_matriz = txtTamano_matriz;
	}

	public JButton getBtnCrear_matriz() {
		return btnCrear_matriz;
	}

	public void setBtnCrear_matriz(JButton btnCrear_matriz) {
		this.btnCrear_matriz = btnCrear_matriz;
	}
	
	public int getTamano() {
		return Tamano;
	}

	public void setTamano(int tamano) {
		Tamano = tamano;
	}

	public int getOpcion() {
		return Opcion;
	}

	public void setOpcion(int opcion) {
		Opcion = opcion;
	}
	
	public JTextField getTxtCoordenada1() {
		return txtCoordenada1;
	}

	public void setTxtCoordenada1(JTextField txtCoordenada1) {
		this.txtCoordenada1 = txtCoordenada1;
	}

	public JTextField getTxtCoordenada2() {
		return txtCoordenada2;
	}

	public void setTxtCoordenada2(JTextField txtCoordenada2) {
		this.txtCoordenada2 = txtCoordenada2;
	}

	public JButton getBtnRellenar_ceros() {
		return btnRellenar_ceros;
	}

	public void setBtnRellenar_ceros(JButton btnRellenar_ceros) {
		this.btnRellenar_ceros = btnRellenar_ceros;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public void setBtnInsertar(JButton btnInsertar) {
		this.btnInsertar = btnInsertar;
	}

	public JButton getBtnRandom() {
		return btnRandom;
	}

	public void setBtnRandom(JButton btnRandom) {
		this.btnRandom = btnRandom;
	}

	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}
	
	public String getRelaciones() {
		return Relaciones;
	}

	public void setRelaciones(String relaciones) {
		Relaciones += relaciones;
	}
	
	public JTable getTblMatriz() {
		return tblMatriz;
	}

	public void setTblMatriz(JTable tblMatriz) {
		this.tblMatriz = tblMatriz;
	}
	
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}
	
	public JButton getBtnContinuar2() {
		return btnContinuar2;
	}

	public void setBtnContinuar2(JButton btnContinuar2) {
		this.btnContinuar2 = btnContinuar2;
	}

	public JCheckBox getChckbxReflexiva() {
		return chckbxReflexiva;
	}

	public void setChckbxReflexiva(JCheckBox chckbxReflexiva) {
		this.chckbxReflexiva = chckbxReflexiva;
	}

	public JCheckBox getChckbxAntireflexiva() {
		return chckbxAntireflexiva;
	}

	public void setChckbxAntireflexiva(JCheckBox chckbxAntireflexiva) {
		this.chckbxAntireflexiva = chckbxAntireflexiva;
	}

	public JCheckBox getChckbxTransitiva() {
		return chckbxTransitiva;
	}

	public void setChckbxTransitiva(JCheckBox chckbxTransitiva) {
		this.chckbxTransitiva = chckbxTransitiva;
	}

	public JCheckBox getChckbxEquivalencia() {
		return chckbxEquivalencia;
	}

	public void setChckbxEquivalencia(JCheckBox chckbxEquivalencia) {
		this.chckbxEquivalencia = chckbxEquivalencia;
	}

	public JCheckBox getChckbxOrdenTotal() {
		return chckbxOrdenTotal;
	}

	public void setChckbxOrdenTotal(JCheckBox chckbxOrdenTotal) {
		this.chckbxOrdenTotal = chckbxOrdenTotal;
	}

	public JCheckBox getChckbxSimetrica() {
		return chckbxSimetrica;
	}

	public void setChckbxSimetrica(JCheckBox chckbxSimetrica) {
		this.chckbxSimetrica = chckbxSimetrica;
	}

	public JCheckBox getChckbxAsimetrica() {
		return chckbxAsimetrica;
	}

	public void setChckbxAsimetrica(JCheckBox chckbxAsimetrica) {
		this.chckbxAsimetrica = chckbxAsimetrica;
	}

	public JCheckBox getChckbxAntisimetrica() {
		return chckbxAntisimetrica;
	}

	public void setChckbxAntisimetrica(JCheckBox chckbxAntisimetrica) {
		this.chckbxAntisimetrica = chckbxAntisimetrica;
	}

	public JCheckBox getChckbxOrdenEstricto() {
		return chckbxOrdenEstricto;
	}

	public void setChckbxOrdenEstricto(JCheckBox chckbxOrdenEstricto) {
		this.chckbxOrdenEstricto = chckbxOrdenEstricto;
	}

	public JCheckBox getChckbxOrdenParcial() {
		return chckbxOrdenParcial;
	}

	public void setChckbxOrdenParcial(JCheckBox chckbxOrdenParcial) {
		this.chckbxOrdenParcial = chckbxOrdenParcial;
	}
	
	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public void setBtnInicio(JButton btnInicio) {
		this.btnInicio = btnInicio;
	}
	
	public JPanel getPanelGrafo() {
		return panelGrafo;
	}

	public void setPanelGrafo(JPanel panelGrafo) {
		this.panelGrafo = panelGrafo;
	}
	
	public JButton getBtnAristas() {
		return btnAristas;
	}

	public void setBtnAristas(JButton btnAristas) {
		this.btnAristas = btnAristas;
	}
}