

packagepruebas_oracle;

//importconectandooracle.ConectandoOracle;
importjava.sql.Connection;
importjava.sql.DriverManager;
importjava.sql.PreparedStatement;
importjava.sql.ResultSet;
importjava.sql.SQLException;
importjava.sql.Statement;
importjava.util.logging.Level;
importjava.util.logging.Logger;
importoracle.jdbc.driver.OracleDriver;
importjava.sql.*;

publicclassPrueba_conexion {

    //Usuario de la BD
private final String USUARIO = "usuario02";

    //Contraseña del usuario de la BD
private final String PASS = "usuario02";

    //SID de la BD, este lo registramos en la instalación
private final String SID = "XE";

    //Host donde se encuentra la BD
private final String HOST = "cpc-am-01-02.aws.smartcloud.cl";

    //puerto 1521 es el estándar para este tipo de instalaciones
private final int PUERTO = 1521;

    //Objeto donde se almacenará la conexión
privateConnectionconnection;

publicConnectiongetConnection() {
returnconnection;
    }

publicvoidregistrarDriver() throwsSQLException {
OracleDriveroracleDriver = new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(oracleDriver);
    }

publicvoid conectar() throwsSQLException {
if (connection == null || connection.isClosed() == true) {
            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
registrarDriver();
connection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);
        }
    }

publicvoid cerrar() throwsSQLException {
if (connection != null&&connection.isClosed() == false) {
connection.close();
        }
    }


 
  /* Método principal  Main   */
publicstaticvoidmain(String args[]) {

Prueba_conexionconexionOracle = new Prueba_conexion();
try {
conexionOracle.conectar();
Connectionconn = conexionOracle.getConnection();
try ( // driver@machineName:port:SID,userid,password
Statementstmt = conn.createStatement()) {
System.out.println("Conexión establecida.");
                String query="select * from cliente";
PreparedStatement buscar = conn.prepareStatement(query);
ResultSetrs = buscar.executeQuery();

while(rs.next()){
System.out.println(rs.getString(1)+" "+rs.getString(2));
                }
            }





    