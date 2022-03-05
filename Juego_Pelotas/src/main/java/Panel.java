import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
//implementa el metodo runnabel esto lo que hace es que pueda ser corrido en un hilo

//MouseMotionListener //para el mouse
public class Panel extends JPanel implements Runnable, KeyListener, MouseMotionListener{
    
    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int largoJuego;

        //pelota 1
    private int pelotarojaposicionX;
    private int pelotarojaposicionY;
    private int pelotarojavelocidadX;
    private int pelotarojavelocidadY;
    private int pelotarojaAncho;
    private int pelotarojaLargo;
    
        //pelota 2
    private int pelotaazulposicionX1;
    private int pelotaazulposicionY1;
    private int pelotaazulvelocidadX1;
    private int pelotaazulvelocidadY1;
    private int pelotaazulAncho;
    private int pelotaazulLargo;


            //pelota 3
    private int pelota3posicionX1;
    private int pelota3posicionY1;
    private int pelota3velocidadX1;
    private int pelota3velocidadY1;
    private int pelota3Ancho;
    private int pelota3Largo;
    
                //pelota 4
    private int pelota4posicionX1;
    private int pelota4posicionY1;
    private int pelota4velocidadX1;
    private int pelota4velocidadY1;
    private int pelota4Ancho;
    private int pelota4Largo;
        
                //pelota 5
    private int pelota5posicionX1;
    private int pelota5posicionY1;
    private int pelota5velocidadX1;
    private int pelota5velocidadY1;
    private int pelota5Ancho;
    private int pelota5Largo;
    
                    //pelota 6
    private int pelota6posicionX1;
    private int pelota6posicionY1;
    private int pelota6velocidadX1;
    private int pelota6velocidadY1;
    private int pelota6Ancho;
    private int pelota6Largo;
    
    
    public Panel(int anchoJuego, int largoJuego) {
        inicializarVentana(anchoJuego, largoJuego);
        
        inicializarPelotaroja();
        inicializarPelotaazul();
        
        inicializarpelota3();
        inicializarpelota4();
        inicializarpelota5();
        inicializarpelota6();
    }
    
    
    
    
    
    
    private void inicializarPelotaroja() {
        this.pelotarojaAncho = 20;
        this.pelotarojaLargo = 20;
        this.pelotarojaposicionX = 500;
        this.pelotarojaposicionY = 400;
        this.pelotarojavelocidadX = 0;
        this.pelotarojavelocidadY = 0;
    }
    
    private void inicializarPelotaazul() {
        this.pelotaazulAncho = 20;
        this.pelotaazulLargo = 20;
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 100;
        this.pelotaazulvelocidadX1 = 0;
        this.pelotaazulvelocidadY1 = 0;
    }
    
    
        private void inicializarpelota3() {
        this.pelota3Ancho = 40;
        this.pelota3Largo = 40;
        this.pelota3posicionX1 = 200;
        this.pelota3posicionY1 = 300;
        this.pelota3velocidadX1 = 10;
        this.pelota3velocidadY1 = 0;
    }
    
        private void inicializarpelota4() {
        this.pelota4Ancho = 20;
        this.pelota4Largo = 20;
        this.pelota4posicionX1 = 250;
        this.pelota4posicionY1 = 150;
        this.pelota4velocidadX1 = -4;
        this.pelota4velocidadY1 = -10;
    }
    
        private void inicializarpelota5() {
        this.pelota5Ancho = 20;
        this.pelota5Largo = 20;
        this.pelota5posicionX1 = 200;
        this.pelota5posicionY1 = 500;
        this.pelota5velocidadX1 = 4;
        this.pelota5velocidadY1 = -10;
    }
        
        private void inicializarpelota6() {
        this.pelota6Ancho = 40;
        this.pelota6Largo = 40;
        this.pelota6posicionX1 = 300;
        this.pelota6posicionY1 = 200;
        this.pelota6velocidadX1 = 0;
        this.pelota6velocidadY1 = 10;
    }        
        
        
    private void inicializarVentana(int anchoJuego, int largoJuego) {
        this.anchoJuego = anchoJuego;
        this.largoJuego = largoJuego;
        
    }


@Override //se hace yun override para que el framewoar obtenga la dimension que yo quiero usar
public Dimension getPreferredSize(){
return new Dimension(anchoJuego, largoJuego);
}

///////////////// animacion
@Override
public void run(){
        while(true){
           actualizarAmbiente();
            repintar();
            esperar(10);
        }
}


/*
//actualiza las coordenadas en 1
private void actualizarAmbiente(){
    
    //pelota 1
  posicionX=posicionX+velocidadX;
  posicionY=posicionY+velocidadY;
  
  //pelota 2
  posicionX1=posicionX1+velocidadX1;
  posicionY1=posicionY1+velocidadY1;
    //posicionX1++;
    //posicionY1++; 
}
*/

    private void actualizarAmbiente() {
        verificarEstadoAmbiente();
        moverPelotaroja();
        moverPelotaazul();
        moverPelota3();
        moverPelota4();
        moverPelota5();
        moverPelota6();
    }
    
    private void verificarEstadoAmbiente() {
       verificarchoqueentrePelota3Amarrilla();
       verificarchoqueentrePelota4Amarrilla();
       verificarchoqueentrePelota5Amarrilla();
       verificarchoqueentrePelota6Amarrilla();
       
       
       verificarchoqueentrePelotaRojayPelotaAzul();
        
       verificarRebotePelota3ContraParedLateral();
  
        
       verificarRebotePelota4ContraParedLateral();
        
       verificarRebotePelota4ContraLaParedInferior();
        
       verificarRebotePelota5ContraParedLateral();
       
       verificarRebotePelota5ContraLaParedInferior();
       
       verificarRebotePelota6ContraParedLateral();
       
       verificarRebotePelota6ContraLaParedInferior();
      
    }
    
    private void verificarchoqueentrePelotaRojayPelotaAzul() {
        if (hayColision(pelotarojaposicionX,pelotarojaposicionY,pelotarojaAncho,pelotarojaLargo,
                        pelotaazulposicionX1,pelotaazulposicionY1,pelotaazulAncho,pelotaazulLargo)) {
            //pelotarojavelocidadY = pelotarojavelocidadY;
            //System.out.println("chocaron");
            
            JOptionPane.showMessageDialog(null, "Felicitaciones lo agarraste", "GANASTE", JOptionPane.DEFAULT_OPTION);
            
            
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 10;
            
            
        }
    }
    
    private void verificarchoqueentrePelota3Amarrilla() {
        if (hayColision(pelotarojaposicionX,pelotarojaposicionY,pelotarojaAncho,pelotarojaLargo,
                        pelota3posicionX1,pelota3posicionY1,pelota3Ancho,pelota3Largo)) {
            //pelotarojavelocidadY = pelotarojavelocidadY;
            //System.out.println("chocaron");
            
            JOptionPane.showMessageDialog(null, "Lo siento :(", "PERDISTE....INTENTA DE NUEVO", JOptionPane.DEFAULT_OPTION);
    
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 10;
   
        }
    }
    
        private void verificarchoqueentrePelota4Amarrilla() {
        if (hayColision(pelotarojaposicionX,pelotarojaposicionY,pelotarojaAncho,pelotarojaLargo,
                        pelota4posicionX1,pelota4posicionY1,pelota4Ancho,pelota4Largo)) {
            //pelotarojavelocidadY = pelotarojavelocidadY;
            //System.out.println("chocaron");
            
            JOptionPane.showMessageDialog(null, "Lo siento :(", "PERDISTE....INTENTA DE NUEVO", JOptionPane.DEFAULT_OPTION);
    
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 10;
   
        }
    }
        
    private void verificarchoqueentrePelota5Amarrilla() {
        if (hayColision(pelotarojaposicionX,pelotarojaposicionY,pelotarojaAncho,pelotarojaLargo,
                        pelota5posicionX1,pelota5posicionY1,pelota5Ancho,pelota5Largo)) {
            //pelotarojavelocidadY = pelotarojavelocidadY;
            //System.out.println("chocaron");
            
            JOptionPane.showMessageDialog(null, "Lo siento :(", "PERDISTE....INTENTA DE NUEVO", JOptionPane.DEFAULT_OPTION);
    
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 10;
   
        }
    }
    
        private void verificarchoqueentrePelota6Amarrilla() {
        if (hayColision(pelotarojaposicionX,pelotarojaposicionY,pelotarojaAncho,pelotarojaLargo,
                        pelota6posicionX1,pelota6posicionY1,pelota6Ancho,pelota6Largo)) {
            //pelotarojavelocidadY = pelotarojavelocidadY;
            //System.out.println("chocaron");
            
            JOptionPane.showMessageDialog(null, "Lo siento :(", "PERDISTE....INTENTA DE NUEVO", JOptionPane.DEFAULT_OPTION);
    
        this.pelotaazulposicionX1 = 10;
        this.pelotaazulposicionY1 = 10;
   
        }
    }
    
    
        // se verifica si la pelota colisiona contra la pared lateral, si es asi, se hace rebotar la pelota en el eje X
    private void verificarRebotePelota3ContraParedLateral() {
        if (pelota3posicionX1 <= 0 || pelota3posicionX1 + pelota3Ancho >= anchoJuego) {
            pelota3velocidadX1 = -pelota3velocidadX1;
            ;
        }
    }


    
            // se verifica si la pelota colisiona contra la pared lateral, si es asi, se hace rebotar la pelota en el eje X
    private void verificarRebotePelota4ContraParedLateral() {
        if (pelota4posicionX1 <= 0 || pelota4posicionX1 + pelota4Ancho >= anchoJuego) {
            pelota4velocidadX1 = -pelota4velocidadX1;
        }
    }
    
            private void verificarRebotePelota4ContraLaParedInferior() {

 if (pelota4posicionY1 == 0 || pelota4posicionY1 + pelota4Largo >= anchoJuego) {
            pelota4velocidadY1 = -pelota4velocidadY1;
       }
    }
    

    private void verificarRebotePelota5ContraParedLateral() {
        if (pelota5posicionX1 <= 0 || pelota5posicionX1 + pelota5Ancho >= anchoJuego) {
            pelota5velocidadX1 = -pelota5velocidadX1;
        }
    }

    
        private void verificarRebotePelota5ContraLaParedInferior() {
 if (pelota5posicionY1 == 0 || pelota5posicionY1 + pelota5Largo >= anchoJuego) {
            pelota5velocidadY1 = -pelota5velocidadY1;
       }
    }

         private void verificarRebotePelota6ContraParedLateral() {
        if (pelota6posicionX1 <= 0 || pelota6posicionX1 + pelota6Ancho >= anchoJuego) {
            pelota6velocidadX1 = -pelota6velocidadX1;
        }
    }

    
        private void verificarRebotePelota6ContraLaParedInferior() {
 if (pelota6posicionY1 == 0 || pelota6posicionY1 + pelota6Largo >= anchoJuego) {
            pelota6velocidadY1 = -pelota6velocidadY1;
       }
    }   
        
        
//va a repintar la animacion actualizar el panel //es un metodo del padre
private void repintar(){
    this.repaint();
}

@Override //aca se llama al  metodo dibujar
protected void paintComponent(Graphics g){
super.paintComponent(g);
dibujar(g);
}


public void dibujar(Graphics graphics){
dibujarPelotaazul(graphics);
dibujarPelotaroja(graphics);
dibujarPelota3(graphics);
dibujarPelota4(graphics);
dibujarPelota5(graphics);
dibujarPelota6(graphics);

//graphics.setColor(Color.BLUE);
//graphics.fillOval(pelotaazulposicionY1,pelotaazulposicionX1,20,20);
//graphics.setColor(new Color (125,125,125));
//graphics.fillOval(40,40,20,20);
//graphics.setColor(Color.blue);
//graphics.fillRect(90,120,200,300);
//graphics.setFont(new Font("Arial",8,20));
//graphics.drawString("Hola manola", 100,100);

}


//con esto lo dibujado espera
//si yo no le pungo try.. se captura la exepcion que necesita se r manejada y tira un nuevo runtime
private void esperar(int milisegundos){
    try{
        Thread.sleep(milisegundos);
    } catch (Exception el){
        throw new RuntimeException(el);
    }
}
 //Exception el
    @Override //presionar la teclar y soltar
    public void keyTyped(KeyEvent e) {
    
    }

    @Override //apretar la tecla // en key press recibo un argumento que tecla apreto
    public void keyPressed(KeyEvent arg0) {
        
        
    if(arg0.getKeyCode()==38){
        pelotaazulvelocidadY1=-1;
    }
    
        if(arg0.getKeyCode()==40){
        pelotaazulvelocidadY1=1;
    }
            
        if(arg0.getKeyCode()==37){
        pelotaazulvelocidadX1=-1;
    }
            
        if(arg0.getKeyCode()==39){
        pelotaazulvelocidadX1=1;
    }
        
    }

    @Override //soltar la teclar
    public void keyReleased(KeyEvent e) {
        
        pelotaazulvelocidadX1=0;
        pelotaazulvelocidadY1=0;

    }


@Override
    public void mouseDragged(MouseEvent e) {
    this.pelotarojaposicionX=e.getX();
    this.pelotarojaposicionY=e.getY();
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    this.pelotarojaposicionX=e.getX();
    this.pelotarojaposicionY=e.getY();
//System.out.println("X: " + e.getX());
System.out.println("roja Y: " + e.getY());

    }

    private void dibujarPelotaroja(Graphics graphics){
 
//ImageIcon piedra = new ImageIcon(getClass().getResource("images/piedra.png"));
//graphics.drawImage(piedra.getImage(),50,50,15,15,null);
graphics.setColor(Color.RED);
graphics.fillOval(pelotarojaposicionX,pelotarojaposicionY,20,20);

    }
    
    private void dibujarPelotaazul(Graphics graphics){
        
graphics.setColor(Color.BLUE);
graphics.fillOval(pelotaazulposicionX1,pelotaazulposicionY1,20,20);

    }
    
    
    private void dibujarPelota3(Graphics graphics){
        
graphics.setColor(Color.YELLOW);
graphics.fillOval(pelota3posicionX1,pelota3posicionY1,40,40);

    }

private void dibujarPelota4(Graphics graphics){
        
graphics.setColor(Color.YELLOW);
graphics.fillOval(pelota4posicionX1,pelota4posicionY1,20,20);

    }

private void dibujarPelota5(Graphics graphics){
        
graphics.setColor(Color.YELLOW);
graphics.fillOval(pelota5posicionX1,pelota5posicionY1,20,20);

    }   

private void dibujarPelota6(Graphics graphics){
        
graphics.setColor(Color.YELLOW);
graphics.fillOval(pelota6posicionX1,pelota6posicionY1,40,40);

    }  
    
    private void moverPelotaroja() {
        pelotarojaposicionX = pelotarojaposicionX + pelotarojavelocidadX; 
        pelotarojaposicionY = pelotarojaposicionY + pelotarojavelocidadY;
        
        //System.out.println("X: " + pelotarojaposicionX);
        //System.out.println("Y: " + pelotarojaposicionY);
    }
    
    private void moverPelotaazul() {
        pelotaazulposicionX1 = pelotaazulposicionX1 + pelotaazulvelocidadX1; 
        pelotaazulposicionY1 = pelotaazulposicionY1 + pelotaazulvelocidadY1;
        
        //System.out.println("X: " + pelotaazulposicionX1);
        System.out.println("azul Y: " + pelotaazulposicionY1);
        
    }
    
    private void moverPelota3() {
        pelota3posicionX1 = pelota3posicionX1 + pelota3velocidadX1; 
        pelota3posicionY1 = pelota3posicionY1 + pelota3velocidadY1;
        
        //System.out.println("X: " + pelotarojaposicionX);
        //System.out.println("Y: " + pelotarojaposicionY);
    }

    private void moverPelota4() {
        pelota4posicionX1 = pelota4posicionX1 + pelota4velocidadX1; 
        pelota4posicionY1 = pelota4posicionY1 + pelota4velocidadY1;
        
        //System.out.println("X: " + pelotarojaposicionX);
        //System.out.println("Y: " + pelotarojaposicionY);
    }

    private void moverPelota5() {
        pelota5posicionX1 = pelota5posicionX1 + pelota5velocidadX1; 
        pelota5posicionY1 = pelota5posicionY1 + pelota5velocidadY1;
        
        //System.out.println("X: " + pelotarojaposicionX);
        //System.out.println("Y: " + pelotarojaposicionY);
    }
    
    private void moverPelota6() {
        pelota6posicionX1 = pelota6posicionX1 + pelota6velocidadX1; 
        pelota6posicionY1 = pelota6posicionY1 + pelota6velocidadY1;
        
        //System.out.println("X: " + pelotarojaposicionX);
        //System.out.println("Y: " + pelotarojaposicionY);
    }  
    
    
    
        private boolean hayColision (
            int elemento1PosicionX, int elemento1PosicionY, int elemento1Ancho, int elemento1Largo,
            int elemento2PosicionX, int elemento2PosicionY, int elemento2Ancho, int elemento2Largo) {
        if (
            haySolapamientoDeRango(
                elemento1PosicionX,
                elemento1PosicionX+elemento1Ancho,
                elemento2PosicionX,
                elemento2PosicionX+elemento2Ancho)
            &&     
            haySolapamientoDeRango(
                elemento1PosicionY,
                elemento1PosicionY+elemento1Largo,
                elemento2PosicionY,
                elemento2PosicionY+elemento2Largo)) {
            return true;
        }
        return false;
    }
    
    private boolean haySolapamientoDeRango(int a, int b, int c, int d) {
        if (a < d && b > c  ) {
            return true;
        }
        return false;
    }

    
    /*
    private void setContentPane(ImagenFondo ejemplo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class ImagenFondo extends JPanel{
        //ATRIBUTOS
        private Image imagen;
        //METODOS
        @Override
        public void paint (Graphics g){
            imagen= new ImageIcon(getClass().getResource("../images/piedra.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
            
        }
        
        
    }
*/
    
    
}

