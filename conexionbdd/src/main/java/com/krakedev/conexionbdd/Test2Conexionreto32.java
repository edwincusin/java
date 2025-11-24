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

public class Test2Conexionreto32 {

	public static void main(String[] args) {
		//VARIABLE DE CONEXION
		Connection cnx=null;
		PreparedStatement ps=null;
		try {
			Class.forName("org.postgresql.Driver"); //REGISTRAR DRIVER - NOMBRE DE LA CLASE PIRNICPAL 
			cnx=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Reto23_relaciones_tablas", "postgres", "pgadmin4");
			System.out.println("conexion exitosa a la BDD");
			System.out.println();			
			String sql= "INSERT INTO public.prestamo(\r\n"
					+ "	codigo, cedula, garante, monto, fecha_prestamo, hora_prestamo)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?);";  //variable string para cargar la consulta
			ps=cnx.prepareStatement(sql);
			ps.setInt(1, 30);
			ps.setString(2, "1753081053");
			ps.setString(3, "YO MISMO");
			ps.setBigDecimal(4, new BigDecimal(4000.200));	
			
			//CONVERSION PARA LA FECHA Y HORA
			//Date - java.util.Date
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2022/02/10 13:13:33";
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
				
				//--------------------------
				ps.setDate(5, fechaSQL);
				ps.setTime(6, timeSQL);
				
				ps.executeUpdate();
				
				System.out.println();
				System.out.println("INSERT EXITOSO");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
