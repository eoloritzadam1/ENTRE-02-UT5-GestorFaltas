/**
 * Un objeto de esta clase guarda la información de un estudiante
 * 
 * @author Elorri Oloritz
 */
public class Estudiante {
    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;
    private tipoApercibimiento apercibimiento;

    /**
     *  
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
        String[] datos = lineaDatos.split(SEPARADOR);
        nombre = crearNombre(datos[0].trim());
        apellidos = datos[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(datos[2].trim());
        faltasJustificadas = Integer.parseInt(datos[3].trim());
    }

    /**
     * 
     * Compone el nombre
     */
    private String crearNombre(String nombre)
    {
        String[] nombres = nombre.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombres.length; i++){
            if (i == nombres.length - 1){
                sb.append(nombres[i].toUpperCase().charAt(0));
                sb.append(nombres[i].substring(1));
            }
            else if (nombres[i] != " "){
                sb.append(nombres[i].toUpperCase().charAt(0));
                sb.append(". ");
            }
        }
        return sb.toString();
    }

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el nº de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        String str = "";
        String apercibimientos = "";
        String nombreCompleto = apellidos + ", " + nombre;
        if (faltasNoJustificadas >= 10){
            apercibimientos = apercibimiento.DIEZ.toString();
        }
        if (faltasNoJustificadas >= 20){
            apercibimientos = apercibimiento.DIEZ.toString() + " " +
            apercibimiento.VEINTE.toString();
        }
        if (faltasNoJustificadas >= 30){
            apercibimientos = apercibimiento.DIEZ.toString() + " " + 
            apercibimiento.VEINTE.toString() + " " +
            apercibimiento.TREINTA.toString();
        }
        else{
            apercibimientos = "Sin apercibimientos";
        }
        str += String.format("%-25s%-35s\n","Apellidos y Nombre: ",nombreCompleto);
        str += String.format("%-25s%-35d\n","Faltas No Justificadas: ",faltasNoJustificadas);
        str += String.format("%-25s%-35d\n","Faltas Justificadas: ",faltasJustificadas);
        str += String.format("%-25s%-35s\n","Apercibimientos: ",apercibimientos);
        str += "\n";
        return str;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai  ,  Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}
