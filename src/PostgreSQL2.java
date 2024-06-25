
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgreSQL2 {
    
    public static void main(String[] args) {
        try {
            
        //Hacer conexion
        Connection conectar=null;
        String url="jdbc:postgresql://localhost:5432/instituto";
        conectar=DriverManager.getConnection(url, "instituto", "1234");
        System.out.println("Sesion establecida");
       
        //borraTabla(conectar);
        //creaTipoDato(conectar);
        creaTabla(conectar);
        
        //insertarDatos(conectar);
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
        }
        
    }// Fin clase Main
    
    
    private static void creaTabla(Connection connection) throws SQLException{
        
        String query="create table ciclos(id_ciclo integer primary key, nombre varchar(20));"
                +"create table alumnos(id_alu integer primary key, nombre varchar(20), domicilio varchar(30), ciclo integer, foreign key (ciclo) references ciclos(id_ciclo));";
        Statement statement=connection.createStatement();
        statement.execute(query);
        statement.close();
        
    }
    
    
    
    
}//Fin de progama
