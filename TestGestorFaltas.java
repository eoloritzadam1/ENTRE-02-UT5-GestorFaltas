/**
 * Punto de entrada a la aplicación
 */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el nº máximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la información solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Error en argumentos\n Sintaxis: java TestGestorFaltas <max_estudiantes>");
        }
        else{
            GestorFaltas gestor = new GestorFaltas(Integer.parseInt(args[0]));

            gestor.leerDeFichero();
            System.out.println(gestor.toString());

            gestor.justificarFaltas("IRISO FLAMARIQUE", 6);

            System.out.println("\nOrdenado de > a < nº de faltas injustificadas\n");
            gestor.ordenar();
            
            System.out.println(gestor.toString());
            
            gestor.anularMatricula();
            System.out.println("Después de anular matrícula\n");
            System.out.println(gestor.toString());
        }
    }
}
