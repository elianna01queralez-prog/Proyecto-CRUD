import java.util.Scanner;

public class Persona {

    // Atributos de Clase
    private String nombre = "";
    private int edad = 0;
    private int documento = 0;
    private char sexo = 'N';
    private float sueldo = 0;
    private String cargo = "";

    // Constructor de clase
    Persona(String nombre_, int edad_, int documento_) {
        this.nombre = nombre_;
        this.edad = edad_;
        this.documento = documento_;
    }

    // Metodos de clase

    // Leer variables
    public void leerNombre() {
        Scanner input = new Scanner(System.in);
        this.nombre = input.nextLine();
    }

    // Setters
    public void setNombre(String nombre_) {
        this.nombre = nombre_;
    }

    public void setEdad(int edad_) {
        this.edad = edad_;
    }

    public void setDocumento(int doc_) {
        this.documento = doc_;
    }

    public void setSexo(char sexo_) {
        this.sexo = sexo_;
    }

    public void setSueldo(float sueldo_) {
        this.sueldo = sueldo_;
    }

    public void setCargo(String cargo_) {
        this.cargo = cargo_;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getDocumento() {
        return this.documento;
    }

    public char getSexo() {
        return this.sexo;
    }

    public float getSueldo() {
        return this.sueldo;
    }

    public String getCargo() {
        return this.cargo;
    }
}
