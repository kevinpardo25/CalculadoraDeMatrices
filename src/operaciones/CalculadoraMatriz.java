
package operaciones;

/**
 *
 * @author Kevinpardo
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CalculadoraMatriz {

    public static void main(String[] args) {

        String ax = System.getProperty("os.name"); //variable que toma el nombre del sistema operativo que se tenga instalado
        if (ax.substring(0, 7).equals("Windows")) {//si es un sistema windows se aplica el skin que tiene java para windows
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                interfaz objClasInteMat = new interfaz();
                // TODO code application logic here
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CalculadoraMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ax.equals("Linux")) {//si es un sistema linux se aplica el skin que tiene java para linux
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                interfaz objClasInteMat = new interfaz();
                // TODO code application logic here
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CalculadoraMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ax.equals("Mac OS X")) {
            try {
                interfaz objClasInteMat = new interfaz();
                // Set System L&F
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CalculadoraMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
