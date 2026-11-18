import controller.CentroEscolar;
import database.DBConection;
import model.Alumno;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        CentroEscolar centroEscolar = new CentroEscolar();
        centroEscolar.insertarAlumo(new Alumno("Maria", "Maria@gmail.com"));
        centroEscolar.insertarAlumo(new Alumno("Juan", "Maria@gmail.com", 657898721));
        System.out.println("Se han borrado " + centroEscolar.borrarAlumno("Maria"));

    }
}
