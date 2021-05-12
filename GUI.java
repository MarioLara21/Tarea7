import java.nio.file.FileSystemNotFoundException;
import javax.management.JMRuntimeException;

/*
Elaborado por Mario Lara Molina
carnet: 2020035341

Este programa tiene como funcionalidad el desplegar una pantalla si se oprimen los botones en el
orden correcto, el cual es: primero A, luego B, y por último C.
Si se llega a realizar de cualquier forma diferente a esa se muestra un mensaje de error en consola
para poder utilizar el sistema de excepciones.
*/ 

public class GUI {
    public static void main(String[] args) throws Exception {
        try {
            Ventana ventana = new Ventana();
        } catch (ArithmeticException ae) {
            ae.getMessage();
        } catch (NullPointerException ne){
            ne.getMessage();
        } catch (FileSystemNotFoundException fnse){
            fnse.getMessage();
        } catch (JMRuntimeException jrte){
            jrte.getMessage();
        } catch (Exception a) {
            a.getMessage();
        }
    }
}
