package controller;

import database.DBConection;
import model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CentroEscolar {

    private Connection connection;
    private PreparedStatement preparedStatement;

    // CRUD

    //insertarAlumno -> logica + llamada al crud (insert)

    public void insertarAlumo(Alumno alumno){

        connection = DBConection.getConnection();
        // INSERT INTO alumnos (nombre, correo, telefono) VALUES....
        // %s -> string %d -> int/long %f -> double/float
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                "alumnos","nombre","correo","telefono");

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alumno.getName());
            preparedStatement.setString(2, alumno.getMail());
            preparedStatement.setInt(3, alumno.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error de SQL");
            System.out.println(e.getMessage());
        }


    }


    //borrarAlumno

    public int borrarAlumno(String name){
        connection = DBConection.getConnection();
        String query = String.format("DELETE FROM %s WHERE %s=?", "alumnos", "nombre");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en sql");
        }
        return 0;
    }


    //obtenerAlumno
    public void obtenerAlumnos(){
        connection = DBConection.getConnection();
        String query = "SELECT * FROM alumnos";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String telefono = resultSet.getString("telefono");
                System.out.println(nombre + " " + correo + " " + telefono);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //modificarAlumno
}
