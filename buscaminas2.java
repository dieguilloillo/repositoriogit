import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.*;

import java.awt.*;
import java.util.Random;


public class buscaminas2 extends JFrame implements ActionListener{
	public 	JButton botones[][];//arreglo de botones
	public JButton reiniciar;
	private JPanel panelprimeralinea;
	private JPanel panelBotones;//Panel superior
	private JTextField txtcantidad;
	private JTextField txtminas;
	private JRadioButtonMenuItem niveles[];
	private ButtonGroup nivelesButtonGroup;
	private int puntos=0;
	private int nivel=0;
	private int minas=10;
	private int arreglo[][]= new int [7][7];
	private Icon error = new ImageIcon(getClass().getResource("error.png"));
	private Icon carita = new ImageIcon(getClass().getResource("carita.png"));
	
	public buscaminas2()
	{
		super("Juego de Buscaminas");
		initmenu();
		initcomponents();
		insertarelementos();
		valoresiniciales();
		
	}
	
	public void actionPerformed(ActionEvent evento)
	{
			
	int boton[][]= new int[7][7]; 
	for (int cuenta=0; cuenta<7; cuenta++)
	{
		for (int cuentadentro=0; cuentadentro<7; cuentadentro++)
		{
		if (evento.getSource()==botones[cuenta][cuentadentro])
		{
			botones[cuenta][cuentadentro].setBackground(Color.white);
					
			if (arreglo[cuenta][cuentadentro]==0)
			{
				for (int fila=0; fila<7; fila++)
				{
					for (int columna=0; columna<7; columna++)
					{
						if (arreglo[fila][columna]==0)
						{
							botones[fila][columna].setIcon(error);
							botones[fila][columna].setBackground(Color.white);
						}
					}
					
				}
				int continuar=Integer.parseInt(JOptionPane.showInputDialog("Has Perdido\n1.Continuar\n2.Salir"));
							if (continuar==1)
								{
									removerelementos();
									insertarelementos();
									valoresiniciales();
									panelBotones.setVisible(false);
									panelprimeralinea.setVisible(false);
									panelBotones.setVisible(true);
									panelprimeralinea.setVisible(true);																	
								}
								
							else
								System.exit(0);
			}
			else
			{
			botones[cuenta][cuentadentro].setText(String.valueOf(arreglo[cuenta][cuentadentro]));
			puntos+=arreglo[cuenta][cuentadentro];
			txtcantidad.setText(String.valueOf(puntos));
			}
				
			
				
					
		}
		}
	}
	
		
	}
	
	public void initcomponents()
	{
		txtcantidad= new JTextField(2);
		txtminas=new JTextField(2);
		botones=new JButton[7][7];
		reiniciar=new JButton(carita);
		panelBotones = new JPanel();
		panelprimeralinea= new JPanel();
		panelBotones.setLayout(new GridLayout(7,7));
		panelprimeralinea.setLayout(new FlowLayout());
		panelprimeralinea.add(txtminas);
		panelprimeralinea.add(reiniciar);
		reiniciar.setBackground(Color.white);
		panelprimeralinea.add(txtcantidad);
		txtminas.disable();
		txtcantidad.disable();
		txtminas.setDisabledTextColor(Color.RED);
		txtcantidad.setDisabledTextColor(Color.RED);
		txtminas.setFont(new Font("Serif",Font.BOLD,14));
		txtcantidad.setFont(new Font("Serif",Font.BOLD,14));
		
		reiniciar.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		removerelementos();
		insertarelementos();
		valoresiniciales();
		panelBotones.setVisible(false);
		panelprimeralinea.setVisible(false);
		panelBotones.setVisible(true);
		panelprimeralinea.setVisible(true);	
			}
		}
		);
		
		
	}
	
	public void insertarelementos()
	{
		for (int cuenta=0; cuenta<7;cuenta++)
		{
			for (int cuentadentro=0; cuentadentro<7; cuentadentro++)
			{
				botones[cuenta][cuentadentro]=new JButton();
				panelBotones.add(botones[cuenta][cuentadentro]);
				botones[cuenta][cuentadentro].addActionListener(this);
			}
		}
		
		add(panelprimeralinea,BorderLayout.NORTH);
		add(panelBotones,BorderLayout.CENTER);
			
	}
	
	public void numerosminas()
	{
		Random aleatorio= new Random();
	 for (int f=0; f<7; f++)
	 {
	 	for (int c=0; c<7; c++)
	 	{
	 		arreglo[f][c]=1+aleatorio.nextInt(4);
	 	}
	 }
	}
	
	public void numerosceros(int n)
	{
		Random cualquiera= new Random();
		int num1=0;
		int num2=0;
		for (int aleatorio=0; aleatorio<n; aleatorio++)
		{
			num1=1+cualquiera.nextInt(6);
			num2=1+cualquiera.nextInt(6);
			
			if (arreglo[num1][num2]!=0)
				arreglo[num1][num2]=0;
			else
				aleatorio--;
		}
	}
	public void valoresiniciales()
	{
		puntos=0;
		txtcantidad.setText("");
		
	txtminas.setText(String.valueOf(minas));
	txtcantidad.setText(String.valueOf(puntos));
	numerosminas();
	numerosceros(minas);
	
	}
	
public void removerelementos()
{
	for (int cuenta=0; cuenta<7;cuenta++)
		{
			for (int cuentadentro=0; cuentadentro<7; cuentadentro++)
			{
				panelBotones.remove(botones[cuenta][cuentadentro]);
				
			}
		}
	
}
public void initmenu()
{

	JMenuBar barra= new JMenuBar();
	setJMenuBar(barra);
	
	String nombreniveles[]={"Facil", "Medio", "Dificil"};
	
	JMenu menuArchivo= new JMenu("Archivo");
	menuArchivo.setMnemonic('A');
	JMenuItem opcsalir= new JMenuItem("Salir al sistema");
	menuArchivo.setMnemonic('S');
	
	opcsalir.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		);
	
	niveles= new JRadioButtonMenuItem[nombreniveles.length];
	nivelesButtonGroup=new ButtonGroup();
	manejadorniveles manejadorNiveles=new manejadorniveles();
	
	for (int cuenta=0; cuenta<niveles.length; cuenta++)
	{
		niveles[cuenta]=new JRadioButtonMenuItem(nombreniveles[cuenta]);
		menuArchivo.add(niveles[cuenta]);
		nivelesButtonGroup.add(niveles[cuenta]);
		niveles[cuenta].addItemListener(manejadorNiveles);
				
	}
	
menuArchivo.addSeparator();
menuArchivo.add(opcsalir);
barra.add(menuArchivo);
}

public class manejadorniveles implements ItemListener
{
	public void itemStateChanged(ItemEvent e)
	{
		minas=0;
		
		if (niveles[0].isSelected())
		{
			minas=10;
		}
			
		if(niveles[1].isSelected())
		{
			minas=20;
		}
		if(niveles[2].isSelected())
		{
			minas=30;
		}
			
		removerelementos();
		insertarelementos();
		valoresiniciales();
		panelBotones.setVisible(false);
		panelprimeralinea.setVisible(false);
		panelBotones.setVisible(true);
		panelprimeralinea.setVisible(true);	
		
	}
}
}
