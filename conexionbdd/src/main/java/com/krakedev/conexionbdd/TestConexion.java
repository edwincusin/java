package com.krakedev.conexionbdd;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	public static void main(String[] args) {
		//crear variable con valor inicial null de conexion 
		Connection cn=null;
		PreparedStatement ps=null;
		try {
			//REGISTRAR DRIVER - NOMBRE DE LA CLASE PRINCIPAL
			Class.forName("org.postgresql.Driver");
			//
			cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pgadmin4");
			System.out.println("conexion exitosa");
			//preparamos lo que vamos a insertar
			ps=cn.prepareStatement("insert into personas(cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos, estado_civil_codigo)"
					+"values (?,?,?,?,?,?,CAST(? AS money),?,?)");
			ps.setString(1, "1163081011");
			ps.setString(2, "SEBASTIAN");
			ps.setString(3, "CABASCANGO");
			ps.setDouble(4, 1.50);
			//ps.setDate(5, java.sql.Date.valueOf("1999-06-24"));
			//ps.setTime(6, java.sql.Time.valueOf("23:00:00"));

			
			//para la fecha y time la conversion 
			//Date - java.util.Date
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2020/03/22 10:05:04";
			
			try {
				Date fecha=sdf.parse(fechaStr);
				System.out.println(fecha);
				long fechamilis=fecha.getTime();
				System.out.println(fechamilis);
				
				//Date 	- java.sql.Date
				//crea un java.sql.Date, partiendo de un java.util.date
				java.sql.Date fechaSQL=new java.sql.Date(fechamilis);
				System.out.println(fechaSQL);
				
				Time timeSQL=new Time(fechamilis);
				System.out.println(timeSQL);
				
				ps.setDate(5, fechaSQL);
				ps.setTime(6, timeSQL);
				
				ps.setBigDecimal(7, new BigDecimal(200.32));
				ps.setInt(8, 1);
				ps.setString(9, "C");
				
				// ejecuto lo que prepare para insertar
				ps.executeUpdate();
				
				System.out.println("ejecuta insert");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
