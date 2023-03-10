package com.techpalle;

import java.sql.*;

	public class Employee 
	{
		public static Connection con=null;
		public static Statement s=null;
		public static PreparedStatement ps=null;
		
		public static String url="jdbc:mysql://localhost:3306/dept";
		public static String username="root";
		public static String password="admin";
		
		public static ResultSet rs = null;
		
		public void creating() 
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url,username,password);
				
				s=con.createStatement();
				
				s.executeUpdate("create table employee (eid int primary key auto_increment , "
								+ "ename varchar(40)not null,esal int)");
					
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try
				{
					if (s != null)
					{
						s.close();
					}
					if (con != null)
					{
						con.close();
					}			
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}	
			}
		}
		public void inserting(String name,int sal)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("insert into employee (ename, esal)values(?,?)");
				
				ps.setString(1, name);
				ps.setInt(2, sal);
				
				ps.executeUpdate();
				
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}		
			finally 
			{
				try
				{
					if (ps != null)
					{
						ps.close();
					}
					if (con != null)
					{
						con.close();
					}		
				}
				catch (SQLException e) 
				{
					e.printStackTrace();	
				}
			}
		}
		public void updating(int id,String name,int sal)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("update employee set ename=?,esal=? where eid=?");
				
				ps.setString(1, name);
				ps.setInt(2, sal);
				ps.setInt(3, id);
				
				ps.executeUpdate();
				
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try
				{
					if (ps != null)
					{
						ps.close();
					}
					if (con != null)
					{
						con.close();
					}
					
				}
				catch (SQLException e) 
				{	
					e.printStackTrace();	
				}
			}
		}
		public void deleting(int id)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("delete from employee where eid=?");
				
				ps.setInt(1, id);
				
				ps.executeUpdate();
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if (ps != null)
					{
						ps.close();
					}
					if (con != null)
					{
						con.close();
					}		
				}
				catch (SQLException e) 
				{
					e.printStackTrace();	
				}
			}
		}
		 public void read()
		  {
			  try 
			  {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				String qry="select * from employee";
				s=con.createStatement();
				
				rs=s.executeQuery(qry);
				
				while(rs.next()==true)
				{
					System.out.println("eid:"+rs.getInt("eid"));
					System.out.println("ename:"+rs.getString("ename"));
					System.out.println("esl:"+rs.getInt("esal"));
				}
			  } 
			  catch (ClassNotFoundException e) 
			  {
				e.printStackTrace();
			  } 
			  catch (SQLException e) 
			  {
				e.printStackTrace();
			  }
			  finally
			  {
				  try
				  {
					  if(rs != null)
					  {
						  rs.close();
					  }
					  if(s != null)
					  {
						  s.close();
					  }
					  if(con != null)
					  {
						  con.close();
					  }
				  }
				  catch(SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
		   }
	}