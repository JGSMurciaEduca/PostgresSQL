
import java.sql.*;


public class PostgresSQL {
    
    
    public static void main(String[] args) {
        try {
            
        //Hacer conexion
        Connection conectar=null;
        String url="jdbc:postgresql://localhost:5432/Libros";
        conectar=DriverManager.getConnection(url, "Librero", "1234");
        System.out.println("Sesion establecida");
       
        //borraTabla(conectar);
        //creaTipoDato(conectar);
        //creaTabla(conectar);
        
        insertarDatos(conectar);
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
        }
        
    }// Fin clase Main
    
    
    private static void creaTabla(Connection connection) throws SQLException{
        
        String query="create table autor(id_autor int primary key, nombre varchar(30), localizacion lugar);" + 
                "create table libro(id_libro int primary key, titulo varchar(50), id_aut int, foreign key (id_aut)references autor(id_autor));";
        Statement statement=connection.createStatement();
        statement.execute(query);
        statement.close();
        
    }
    
    
    private static void borraTabla(Connection connection) throws SQLException{
        
        String query="drop table if exists libro;"
                +"drop table if exists autor;"
                +"drop type if exists lugar;";
        Statement statement=connection.createStatement();
        statement.execute(query);
        statement.close();
    }
    
    private static void creaTipoDato(Connection connection) throws SQLException{
        
        String query="create type lugar as (pais varchar(15), ciudad varchar(15), cp int);";
        Statement statement=connection.createStatement();
        statement.execute(query);
        statement.close();
    }
    
    
    private static void insertarDatos(Connection connection) throws SQLException{
        
        String consulta="insert into autor values(1,'Murakami',ROW('Japon','Tokyo',2345));"
                +"insert into autor values(2,'Patric Routhfuss',ROW('EEUU','Dakota',30150));"
                +"insert into autor values(3,'Tolkien',ROW('Irlanda','Dublin',2345));";
        Statement statement=connection.createStatement();
        statement.execute(consulta);
        statement.close();
    }
    
    
    
    
    
    
    
    
}//Fin programa
