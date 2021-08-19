import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSingleton {
	private static JDBCSingleton jdbc;

	// JDBCSingleton prevents the instantiation from any other class.
	private JDBCSingleton() {
	}

	// Now we are providing gloabal point of access.
	public static JDBCSingleton getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCSingleton();
		}
		return jdbc;
	}

	// to get the connection from methods like insert, view etc.
	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;
		 Class.forName("oracle.jdbc.driver.OracleDriver");
         String connectionpath = "jdbc:oracle:thin:@10.199.62.121:1521:cspm";
         String dbuname = "cspmdba";
         String passdb = "Var#56#Kut";
         con = DriverManager.getConnection(connectionpath, dbuname, passdb);
		return con;

	}

	 public int insert(String name, String pass,String id) throws SQLException  
     {  
         Connection c=null;  
           
         PreparedStatement ps=null;  
           
         int recordCounter=0;  
           
         try {  
               
                 c=this.getConnection();  
                 ps=c.prepareStatement("insert into TEST_TABEL_DEMO(fname,lname,id)values(?,?,?)");  
                 ps.setString(1, name);  
                 ps.setString(2, pass); 
                 ps.setString(3, id);  
                 recordCounter=ps.executeUpdate();  
                   
         } catch (Exception e) { e.printStackTrace(); } finally{  
               if (ps!=null){  
                 ps.close();  
             }if(c!=null){  
                 c.close();  
             }   
         }  
        return recordCounter;  
     }  

//to view the data from the database        
 public  void view(String id) throws SQLException  
 {  
           Connection con = null;  
   PreparedStatement ps = null;  
   ResultSet rs = null;  
             
           try {  
                 
                   con=this.getConnection();  
                   ps=con.prepareStatement("select fname,lname,id from TEST_TABEL_DEMO where id=?");  
                   ps.setString(1, id);  
                   rs=ps.executeQuery();  
                   while (rs.next()) {  
                             System.out.println("Name= "+rs.getString("fname")+"\t"+"lname= "+rs.getString("lname")+"\t"+"lname= "+rs.getString("id"));      
                    
                   }  
           
     } catch (Exception e) { System.out.println(e);}  
     finally{  
               if(rs!=null){  
                   rs.close();  
               }if (ps!=null){  
                 ps.close();  
             }if(con!=null){  
                 con.close();  
             }   
           }  
 }  
   
// to update the password for the given username  
 public int update(String name, String lname,String id) throws SQLException  {  
         Connection c=null;  
         PreparedStatement ps=null;  
           
         int recordCounter=0;  
         try {  
                 c=this.getConnection();  
                 ps=c.prepareStatement(" update TEST_TABEL_DEMO set fname=?,lname=? where id=?");  
                 ps.setString(1, name);  
                 ps.setString(2, lname);  
                 ps.setString(3, id);  
                 recordCounter=ps.executeUpdate();  
         } catch (Exception e) {  e.printStackTrace(); } finally{  
                 
             if (ps!=null){  
                 ps.close();  
             }if(c!=null){  
                 c.close();  
             }   
          }  
        return recordCounter;  
     }  
       
//to delete the data from the database   
    public int delete(String id) throws SQLException{  
         Connection c=null;  
         PreparedStatement ps=null;  
         int recordCounter=0;  
         try {  
                  c=this.getConnection();  
                 ps=c.prepareStatement(" delete from TEST_TABEL_DEMO where id=? ");  
                 ps.setString(1, id);
                 recordCounter=ps.executeUpdate();  
         } catch (Exception e) { e.printStackTrace(); }   
         finally{  
         if (ps!=null){  
                 ps.close();  
        }if(c!=null){  
                 c.close();  
         }   
      }  
        return recordCounter;  
     }  

}
