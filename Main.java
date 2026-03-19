import java.util.Scanner;

public class Main {

    int nroUsuarios = 0;
    Persona[] usuarios = new Persona[100];

    public static void main(String[] args) {
        // Crear instancia de Main para poder usar atributos de instancia
        Main app = new Main();
        app.ejecutar();
    }

    public void ejecutar() {
        int opcion = 1;

        // Instanciar cada usuario con valores vacíos
        for (int i = 0; i < 100; i++) {
            usuarios[i] = new Persona("", 0, 0);
        }

        while ((opcion > 0) && (opcion < 6)) {
            opcion = this.menu();
            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    editar();
                    break;
                case 3:
                    consultar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    verUsuarios();
                    break;
                case 6:
                    System.out.println("Gracias por su tiempo");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    // ── METODOS ──────────────────────────────────────────────────────────────

    // Ver todos los usuarios del sistema
    public void verUsuarios() {
        System.out.println("-------------------------------------------");
        System.out.println("         LISTADO DE USUARIOS");
        System.out.println("-------------------------------------------");

        if (nroUsuarios == 0) {
            System.out.println("    No hay usuarios registrados.");
            return;
        }

        for (int i = 0; i < nroUsuarios; i++) {
            System.out.println("Usuario #" + (i + 1));
            System.out.println("  Nombre    : " + usuarios[i].getNombre());
            System.out.println("  Documento : " + usuarios[i].getDocumento());
            System.out.println("  Edad      : " + usuarios[i].getEdad());
            System.out.println("  Sexo      : " + usuarios[i].getSexo());
            System.out.println("  Sueldo    : " + usuarios[i].getSueldo());
            System.out.println("  Cargo     : " + usuarios[i].getCargo());
            System.out.println("-------------------------------------------");
        }
    }

    // Agregar un usuario a la base de datos
    public void agregar() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("         AGREGAR NUEVO USUARIO");
        System.out.println("-------------------------------------------");

        if (this.nroUsuarios >= 100) {
            System.out.println("       MEMORIA LLENA!!!!!");
            return;
        }

        // Leer documento y verificar que no exista
        System.out.print("Escriba el documento de identidad : ");
        int doc = input.nextInt();
        input.nextLine(); // limpiar buffer

        if (buscarPorDocumento(doc) != -1) {
            System.out.println("Ya existe un usuario con ese documento.");
            return;
        }

        System.out.print("Escriba el nombre del nuevo usuario: ");
        usuarios[nroUsuarios].leerNombre();

        System.out.print("Escriba la edad                    : ");
        usuarios[nroUsuarios].setEdad(input.nextInt());
        input.nextLine();

        System.out.print("Escriba el sexo (M/F)              : ");
        usuarios[nroUsuarios].setSexo(input.nextLine().toUpperCase().charAt(0));

        System.out.print("Escriba el sueldo                  : ");
        usuarios[nroUsuarios].setSueldo(input.nextFloat());
        input.nextLine();

        System.out.print("Escriba el cargo                   : ");
        usuarios[nroUsuarios].setCargo(input.nextLine());

        usuarios[nroUsuarios].setDocumento(doc);

        nroUsuarios++; // Apuntar al siguiente espacio en memoria

        System.out.println("Usuario agregado exitosamente!!");
    }

    // Consultar un usuario por documento
    public void consultar() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("         CONSULTAR USUARIO");
        System.out.println("-------------------------------------------");

        System.out.print("Digite el documento de identidad: ");
        int doc = input.nextInt();

        int pos = buscarPorDocumento(doc);

        if (pos == -1) {
            System.out.println("No se encontro un usuario con ese documento.");
        } else {
            System.out.println("-------------------------------------------");
            System.out.println("  Nombre    : " + usuarios[pos].getNombre());
            System.out.println("  Documento : " + usuarios[pos].getDocumento());
            System.out.println("  Edad      : " + usuarios[pos].getEdad());
            System.out.println("  Sexo      : " + usuarios[pos].getSexo());
            System.out.println("  Sueldo    : " + usuarios[pos].getSueldo());
            System.out.println("  Cargo     : " + usuarios[pos].getCargo());
            System.out.println("-------------------------------------------");
        }
    }

    // Editar un usuario por documento
    public void editar() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("         EDITAR USUARIO");
        System.out.println("-------------------------------------------");

        System.out.print("Digite el documento del usuario a editar: ");
        int doc = input.nextInt();
        input.nextLine();

        int pos = buscarPorDocumento(doc);

        if (pos == -1) {
            System.out.println("No se encontro un usuario con ese documento.");
            return;
        }

        System.out.println("Datos actuales -> Nombre: " + usuarios[pos].getNombre()
                + "  |  Documento: " + usuarios[pos].getDocumento());
        System.out.println();

        System.out.print("Nuevo nombre   : ");
        usuarios[pos].setNombre(input.nextLine());

        System.out.print("Nueva edad     : ");
        usuarios[pos].setEdad(input.nextInt());
        input.nextLine();

        System.out.print("Nuevo sexo (M/F): ");
        usuarios[pos].setSexo(input.nextLine().toUpperCase().charAt(0));

        System.out.print("Nuevo sueldo   : ");
        usuarios[pos].setSueldo(input.nextFloat());
        input.nextLine();

        System.out.print("Nuevo cargo    : ");
        usuarios[pos].setCargo(input.nextLine());

        System.out.println("Usuario actualizado exitosamente!!");
    }

    // Eliminar un usuario por documento
    public void eliminar() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("         ELIMINAR USUARIO");
        System.out.println("-------------------------------------------");

        System.out.print("Digite el documento del usuario a eliminar: ");
        int doc = input.nextInt();
        input.nextLine();

        int pos = buscarPorDocumento(doc);

        if (pos == -1) {
            System.out.println("No se encontro un usuario con ese documento.");
            return;
        }

        System.out.println("Usuario encontrado -> Nombre: " + usuarios[pos].getNombre()
                + "  |  Documento: " + usuarios[pos].getDocumento());

        System.out.print("Confirma la eliminacion? (s/n): ");
        String confirmar = input.nextLine();

        if (confirmar.equalsIgnoreCase("s")) {
            // Desplazar los elementos para cerrar el hueco
            for (int i = pos; i < nroUsuarios - 1; i++) {
                usuarios[i].setNombre(usuarios[i + 1].getNombre());
                usuarios[i].setEdad(usuarios[i + 1].getEdad());
                usuarios[i].setDocumento(usuarios[i + 1].getDocumento());
                usuarios[i].setSexo(usuarios[i + 1].getSexo());
                usuarios[i].setSueldo(usuarios[i + 1].getSueldo());
                usuarios[i].setCargo(usuarios[i + 1].getCargo());
            }
            // Limpiar el ultimo espacio que quedó duplicado
            usuarios[nroUsuarios - 1].setNombre("");
            usuarios[nroUsuarios - 1].setEdad(0);
            usuarios[nroUsuarios - 1].setDocumento(0);
            usuarios[nroUsuarios - 1].setSexo('N');
            usuarios[nroUsuarios - 1].setSueldo(0);
            usuarios[nroUsuarios - 1].setCargo("");

            nroUsuarios--;
            System.out.println("Usuario eliminado exitosamente!!");
        } else {
            System.out.println("Operacion cancelada.");
        }
    }

    // Buscar la posicion de un usuario por su documento
    // Retorna el indice si lo encuentra, -1 si no existe
    public int buscarPorDocumento(int doc) {
        for (int i = 0; i < nroUsuarios; i++) {
            if (usuarios[i].getDocumento() == doc) {
                return i;
            }
        }
        return -1;
    }

    // Imprimir el menu y retornar la opcion elegida
    public int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("                       MENU");
        System.out.println("           1 - Crear usuario");
        System.out.println("           2 - Editar usuario");
        System.out.println("           3 - Consultar usuario");
        System.out.println("           4 - Eliminar usuario");
        System.out.println("           5 - Ver usuarios");
        System.out.println("           6 - Salir");
        System.out.println("=====================================================");
        System.out.print("           Digite su opcion ->");
        int opcion = input.nextInt();
        return opcion;
    }
}
