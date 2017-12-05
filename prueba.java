import src.buscaminas;
import javax.swing.JFrame;

public class prueba
{
	public static void main(String arg[])
	{
		buscaminas juego = new buscaminas();
		juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego.setSize(300,300);
		juego.setResizable(false);
		juego.setLocation(370,230);
		juego.setVisible(true);
	}
}