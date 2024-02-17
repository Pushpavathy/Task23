package Task23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {

	public static void main(String[] args) {

//Providing conectivity details
String db = "jdbc:mysql://localhost:3306/";
String user = "root";
String password ="root";

//establishing connection
try {
	Connection conn = DriverManager.getConnection(db, user, password);
	
	if (conn !=null)
	{
		System.out.println("Connection is successfull");
	}else
	{
		System.out.println("Connection is unsuccessfull");
	}
	
Statement smt = conn.createStatement();
String createDB = "create database empdb";
String use = "use empdb";
String createtable = "create table emptable (empcode int,empname varchar(25),empage int,empsal int)";
String select = "select * from emptable";
String insert = "insert into emptable values (101,'Jenny',25,10000),"
+"(102,'Jacky',30,20000),"
+"(103,'Joe',20,40000),"
+"(104,'John',40,80000),"
+"(105,'Shameer',25,90000)";


//Create db

smt.execute(createDB);

//Use db
smt.execute(use);

//Create table.
smt.execute(createtable);

//Insert data

smt.executeUpdate(insert);
//retrive data
ResultSet s =  smt.executeQuery(select);

while (s.next())
{
	System.out.println(s.getInt("empcode")+""+s.getString("empname")+""
+s.getInt("empage")+""
			+s.getInt("empsal"));
	}
//Close connection

conn.close();
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
	}

}
