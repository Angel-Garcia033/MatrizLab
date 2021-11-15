package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import vista.GUI_MatrizLab;
import modelo.*;

public class Controlador
{
	private int temp = 0, temp2 = 0, temp3 = 0, temp4 = 0, Asimetrica1 = 0, Asimetrica2 = 0, a = 0, b = 0, relaciones = 0;
	private boolean Reflexiva, Antireflexiva, Simetrica, Asimetrica, Antisimetrica, Transitiva;
	
	private GUI_MatrizLab Comunicador_GUI;
	private Matriz Comunicador_Matriz;
	
	private JLabel[] nodos;
	private int[][] aristas;

	public Controlador() 
	{
		Comunicador_GUI = new GUI_MatrizLab();
		Comunicador_Matriz = new Matriz();

		listenerBtn();
	}

	public void Controlar() 
	{
		Comunicador_GUI.Ventana();
	}
	
	//==========================================================================
	
	private void llenarTabla ()
	{
		try 
		{
			int e = 0;
			aristas = new int[relaciones][2];
			
			for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
			{
				for (int j = 0; j < Comunicador_Matriz.getMatriz().length; j++) 
				{
					if (Comunicador_Matriz.getMatriz()[i][j] == true) 
					{
						Comunicador_GUI.getTblMatriz().setValueAt(1, i, j);
						
						aristas [e][0]= i;
						aristas [e][1]= j;
						e++;
					}			
					else
					{
						Comunicador_GUI.getTblMatriz().setValueAt(0, i, j);
					}
				}
				
				DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
				Alinear.setHorizontalAlignment(SwingConstants.CENTER);
				Comunicador_GUI.getTblMatriz().getColumnModel().getColumn(i).setCellRenderer(Alinear);
			}
		}
		catch (Exception o) 
		{
			Comunicador_GUI.errorGenerico();
		}
	}
	
	private boolean comprobarReflexiva ()
	{
		for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
		{
			if (Comunicador_Matriz.getMatriz()[i][i] == false)
			{
				Reflexiva = false;
				return false;
			}
		}
		
		Reflexiva =  true;
		return true;
	}
	
	private boolean comprobarAntireflexiva ()
	{
		for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
		{
			if (Comunicador_Matriz.getMatriz()[i][i] == true)
			{
				Antireflexiva = false;
				return false;
			}
		}
		
		Antireflexiva = true;
		return true;
	}
	
	private void comprobarSimetria ()
	{
		for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
		{
			for (int j = 0; j < Comunicador_Matriz.getMatriz().length; j++) 
			{
				if (i != j)
				{
					if (Comunicador_Matriz.getMatriz()[i][j] == true)
					{
						if (Comunicador_Matriz.getMatriz()[i][j] == true && Comunicador_Matriz.getMatriz()[j][i] == true)
						{
							Asimetrica1 ++;
						}
						else if (Comunicador_Matriz.getMatriz()[i][j] == true && Comunicador_Matriz.getMatriz()[j][i] == false)
						{
							Asimetrica2 ++;
						}	
					}
				}
			}
		}
		
		if (Asimetrica1 > 0 && Asimetrica2 == 0) 
		{
			Simetrica = true;
		}
		else
		{
			Simetrica = false;
		}
		
		if (Asimetrica1 > 0 && Asimetrica2 > 0)
		{
			Asimetrica = true;
		}
		else
		{
			Asimetrica = false;
		}
		
		if (Asimetrica1 == 0 && Asimetrica2 > 0)
		{
			Antisimetrica = true;
		}
		else 
		{
			Antisimetrica = false;
		}
	}
	
	private void comprobarTransitiva ()
	{		
		for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
	    {
			for (int j = 0; j < Comunicador_Matriz.getMatriz().length; j++)
	    	{
				if (i != j)
				{
					if (Comunicador_Matriz.getMatriz()[i][j] == true)//i1, j3 k4
					{
						for (int k = 0; k < Comunicador_Matriz.getMatriz().length; k++)
						{
							if (Comunicador_Matriz.getMatriz()[j][k] == true)
							{
								temp2++;
								
								if (Comunicador_Matriz.getMatriz()[i][k] == false)
								{
									temp3++;
								}
								else 
								{
									temp4++;
								}
							}
						}
					}
				}
	    	}
	    }  
		
		if (temp3 != 0)
		{
			Transitiva = false;
		}
		else if (temp2 == 0 && temp3 == 0 && temp4 == 0)
		{
			Transitiva = false;
		}
		else if (temp2 == temp4 && temp2 != 0)
		{
			Transitiva = true;
		}
	}
	
	private void llenadoChckbx ()
	{
		if (Reflexiva == true)
		{
			Comunicador_GUI.getChckbxReflexiva().setSelected(true);
		}
		else
		{
			Comunicador_GUI.getChckbxReflexiva().setSelected(false);
		}
		
		if (Antireflexiva == true)
		{
			Comunicador_GUI.getChckbxAntireflexiva().setSelected(true);
		}
		else 
		{
			Comunicador_GUI.getChckbxAntireflexiva().setSelected(false);
		}
		
		if (Simetrica == true)
		{
			Comunicador_GUI.getChckbxSimetrica().setSelected(true);
		}
		else 
		{
			Comunicador_GUI.getChckbxSimetrica().setSelected(false);
		}
		
		if (Asimetrica == true)
		{
			Comunicador_GUI.getChckbxAsimetrica().setSelected(true);
		}
		else 
		{
			Comunicador_GUI.getChckbxAsimetrica().setSelected(false);
		}
		
		if (Antisimetrica == true)
		{
			Comunicador_GUI.getChckbxAntisimetrica().setSelected(true);
		}
		else 
		{
			Comunicador_GUI.getChckbxAntisimetrica().setSelected(false);
		}
		
		if (Transitiva == true)
		{
			Comunicador_GUI.getChckbxTransitiva().setSelected(true);
		}
		else 
		{
			Comunicador_GUI.getChckbxTransitiva().setSelected(false);
		}
		
		if (Reflexiva == true && Simetrica == true && Transitiva == true)
		{
			Comunicador_GUI.getChckbxEquivalencia().setSelected(true);
			Comunicador_GUI.getChckbxOrdenTotal().setSelected(true);
		}
		else
		{
			Comunicador_GUI.getChckbxEquivalencia().setSelected(false);
			Comunicador_GUI.getChckbxOrdenTotal().setSelected(false);
		}
		
		if (Antisimetrica == true && Transitiva == true)
		{
			Comunicador_GUI.getChckbxOrdenEstricto().setSelected(true);
		}
		else
		{
			Comunicador_GUI.getChckbxOrdenEstricto().setSelected(false);
		}
		
		if (Reflexiva == true && Antisimetrica == true && Transitiva == true)
		{
			Comunicador_GUI.getChckbxOrdenParcial().setSelected(true);
		}
		else
		{
			Comunicador_GUI.getChckbxOrdenParcial().setSelected(false);
		}
	}

	private void crearNodos ()
	{
		int x = 95, y = 360, x2 = 0, y2 = 0, num;
		String num2;
		
		int radio = 35;
		float angulo;
		
		for (int i = 0; i < Comunicador_GUI.getTamano(); i++)
		{
			x += 10;
			y += 10;
			radio += 10;
		}
		
		angulo = 360/Comunicador_GUI.getTamano();
		angulo = (float) Math.toRadians(angulo);
		
		nodos = new JLabel[Comunicador_GUI.getTamano()];
		
		for (int i = 0; i < Comunicador_GUI.getTamano(); i++)
		{			
			num = i+1;
			num2 = ("" + num);
			
			x2 = (int)(x+radio*Math.cos(i * angulo));
			y2 = (int) (y-radio * Math.sin(i * angulo));
			
			JLabel Nodo = new JLabel(num2);
			Nodo.setBounds(y2, x2, 50, 50);
			Nodo.setBackground(Color.WHITE);
			Nodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circle-png.png")));
			
			JLabel txtNum = new JLabel(num2);
			txtNum.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			txtNum.setHorizontalAlignment(SwingConstants.CENTER);
			txtNum.setBounds(y2, x2, 50, 50);
			
			nodos[i] = Nodo;
			
			Comunicador_GUI.getPanelGrafo().add(txtNum);
			Comunicador_GUI.getPanelGrafo().add(Nodo);
		}
	}
	
	private void reiniciar ()
	{
		Comunicador_GUI.reiniciarRelaciones();
		Comunicador_GUI.getPanelGrafo().removeAll();
		
		temp = 0;
		temp2 = 0;
		temp3 = 0;
		temp4 = 0;
		Asimetrica1 = 0;
		Asimetrica2 = 0;
		relaciones = 0;
	}

	// ========================================================================================================================

	public void listenerBtn() 
	{
		// -----------------------------Al oprimir el boton de crear matriz----------------------------------------------------
		Comunicador_GUI.getBtnCrear_matriz().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(1);

				try 
				{
					Comunicador_GUI.setTamano(Integer.parseInt(Comunicador_GUI.getTxtTamano_matriz().getText()));
				} 
				catch (Exception o) 
				{
					Comunicador_GUI.Error();
					Comunicador_GUI.setOpcion(0);
				}

				if (Comunicador_GUI.getTamano() > 0) 
				{
					Comunicador_Matriz.crearMatriz(Comunicador_GUI.getTamano());
					crearNodos();
				} 
				else 
				{
					Comunicador_GUI.Error();
					Comunicador_GUI.setOpcion(0);
				}

				Comunicador_GUI.Ventana();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------

		// -------------------------------Al oprimir el boton de insertar------------------------------------------------------
		Comunicador_GUI.getBtnInsertar().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(1);

				try 
				{
					a = Integer.parseInt(Comunicador_GUI.getTxtCoordenada1().getText());
					b = Integer.parseInt(Comunicador_GUI.getTxtCoordenada2().getText());
				} 
				catch (Exception o) 
				{
					Comunicador_GUI.Error();
					Comunicador_GUI.setOpcion(1);
				}

				if (a > 0 && b > 0) 
				{
					try 
					{
						Comunicador_Matriz.getMatriz()[a - 1][b - 1] = true;
						
						if (temp != 0)
						{
							Comunicador_GUI.setRelaciones(";");
						}
						
						if (temp == 8)
						{
							Comunicador_GUI.setRelaciones("\n");
							temp = 1;
						}
						
						Comunicador_GUI.setRelaciones("(" + a + "," + b + ")");
						temp++;
						relaciones++;

						Comunicador_GUI.insertarCorrecta();
					} 
					catch (Exception o) 
					{
						Comunicador_GUI.errorGenerico();
					}
				} 
				else 
				{
					Comunicador_GUI.setOpcion(1);
				}

				Comunicador_GUI.Ventana();
			}
		});

		// --------------------------------------------------------------------------------------------------------------------

		// -------------------------------Al oprimir el boton de rellenar------------------------------------------------------
		Comunicador_GUI.getBtnRellenar_ceros().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(1);
				Comunicador_GUI.rellenarCorrecta();
				Comunicador_GUI.Ventana();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------

		// ---------------------------------Al oprimir el boton de random------------------------------------------------------
		Comunicador_GUI.getBtnRandom().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(2);

				try 
				{
					int Campo;
					
					for (int i = 0; i < Comunicador_Matriz.getMatriz().length; i++) 
					{
						for (int j = 0; j < Comunicador_Matriz.getMatriz().length; j++) 
						{
							Campo = (int) (Math.random() * 2 + 1);

							if (Campo == 2) 
							{
								if (temp != 0)
								{
									Comunicador_GUI.setRelaciones(";");
								}
								
								if (temp == 8)
								{
									Comunicador_GUI.setRelaciones("\n");
									temp = 1;
								}
								
								Comunicador_Matriz.getMatriz()[i][j] = true;
								
								a = i;
								b = j;
								
								Comunicador_GUI.setRelaciones("(" + (i+1) + "," + (j+1) + ")");
								temp++;
								relaciones++;
							} 
						}
					}

					Comunicador_GUI.generarCorrecta();
					Comunicador_GUI.setRelaciones("}");
				} 
				catch (Exception o) 
				{
					Comunicador_GUI.errorGenerico();
				}

				Comunicador_GUI.Ventana();
				llenarTabla();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------

		// ------------------------------Al oprimir el boton de continuar------------------------------------------------------
		Comunicador_GUI.getBtnContinuar().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setRelaciones("}");
				Comunicador_GUI.setOpcion(2);
				Comunicador_GUI.Ventana();
				
				llenarTabla();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------
		
		// ------------------------------Al oprimir el boton de siguiente------------------------------------------------------
		Comunicador_GUI.getBtnSiguiente().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				comprobarReflexiva();
				comprobarAntireflexiva();
				comprobarSimetria();
				comprobarTransitiva();
				
				llenadoChckbx();
				
				Comunicador_GUI.setOpcion(3);
				Comunicador_GUI.Ventana();

			}
		});
		// --------------------------------------------------------------------------------------------------------------------
		
		// ------------------------------Al oprimir el boton de continuar2-----------------------------------------------------
		Comunicador_GUI.getBtnContinuar2().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(4);
				Comunicador_GUI.Ventana();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------
		
		// ------------------------------Al oprimir el boton de inicio---------------------------------------------------------
		Comunicador_GUI.getBtnInicio().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.setOpcion(0);
				Comunicador_GUI.Ventana();
				reiniciar();
			}
		});
		// --------------------------------------------------------------------------------------------------------------------
				
		// ------------------------------Al oprimir el boton de salir----------------------------------------------------------
		Comunicador_GUI.getBtnSalir().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		// --------------------------------------------------------------------------------------------------------------------
		
		// ------------------------------Al oprimir el boton de imprimirAristas------------------------------------------------
		Comunicador_GUI.getBtnAristas().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Comunicador_GUI.crearAristas(aristas, nodos, relaciones);
			}
		});
		// --------------------------------------------------------------------------------------------------------------------
	}
}