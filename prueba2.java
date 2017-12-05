import javax.swing.JFrame;


public class prueba2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buscaminas2 juego = new buscaminas2();
		juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego.setSize(300,300);
		juego.setResizable(false);
		juego.setLocation(370,230);
		juego.setVisible(true);
	}

}
