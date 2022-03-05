import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class Inicializador {
    
public static void main(String[]args){

int anchoVentana=800;
int largoVentana=600;

//activa la acelaracion de graficos en 2 dimensiones
System.setProperty("sun.java2d.opengl","true");

//crea un objeto jframe  que es la ventana donde va a estar el juego
JFrame ventana= new JFrame("Mi juego");

ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
ventana.setLocationRelativeTo(null);

//mostrar ventana
ventana.setVisible(true);

Panel panel= new Panel (anchoVentana,largoVentana);
panel.setBackground(Color.magenta);

ventana.add(panel);


//achicar la ventana lo maximo posible para que entren los componentes
ventana.pack();

//le paso la clase que implmenta el "addmouselistener"
ventana.addMouseMotionListener(panel);
ventana.addKeyListener(panel);
//panel.run(); //animaciones 2

//crear un thread y pasarle como parametro al juego que implementa la interfaz "Runnable"
//panel implementa la interfaz runnable
Thread hilo = new Thread(panel);

//Arrancar el juego
hilo.start();

}

}
