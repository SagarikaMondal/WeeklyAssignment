import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ABCSchool {

	public static void main(String[] args) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
		 Statement st=con.createStatement();
		 Scanner sc=new Scanner(System.in); 
		 boolean loop=true;
	do
	{
		
		System.out.println(" Select any option");
		System.out.println("  1.For insertion");
		System.out.println("  2.For deletion");
		System.out.println("  3.For modification");
		System.out.println("  4.For display");
		System.out.println("  5.Exit");
		System.out.println();
		int sw=sc.nextInt();
		switch(sw) {
		case 1:
			 System.out.println("Enter no of student");
			 int n=sc.nextInt();
			
			 for(int i=0;i<n;i++)
			 {
				 System.out.println("Enter roll no of the student");
				 int r=sc.nextInt();
				 if(r>9999)
				 {
					 i--;
					 System.out.println("Invalid roll no");
					 continue;
				 }
				 sc.nextLine();
				 System.out.println("Enter name of the student");
				 String nm=sc.nextLine();
				 if(nm.length()>20 || !(nm.equals(nm.toUpperCase())))
				 {
					 i--;
					 System.out.println("Length of name more than 20 or lower case is not allowed.");
					 continue;
				 }
				 System.out.println("Enter standard of the student");
				 String stn=sc.nextLine();
				 String ar[]= {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
				 boolean res=false;
				 for(int j=0;j<ar.length;j++)
				 {
					 if(ar[j].equals(stn))
					 {
						 res=true;
						 break;
					 } 
				 }
				 if(res==false)
				 {
					 System.out.println("Invalid standard");
					 i--;
					 continue;
				 }
				 System.out.println("Enter date of birth");
				 String std=sc.nextLine();
				 Date dt=Date.valueOf(std);
				 System.out.println("Enter fees");
				 float fs=sc.nextFloat();
				 String sq="insert into student"+"(Rollno,StudentName,Standard,Date_Of_Birth,Fees)"+"values(?,?,?,?,?)";
				  PreparedStatement pst = con.prepareStatement(sq);
				  pst.setInt(1, r);
				  pst.setString(2, nm);
				  pst.setString(3, stn);
				  pst.setDate(4,dt);
				  pst.setFloat(5, fs);
				  pst.executeUpdate();
				  System.out.println();
				  break;
				} 
			 
		case 2:
			 System.out.println("Enter roll no of the student whose record you want to delete");
			 int r=sc.nextInt();
			 String sq = "DELETE FROM student WHERE Rollno="+r;
			 PreparedStatement pst = con.prepareStatement(sq);
			 pst.executeUpdate(sq);
			 System.out.println("record deleted successfully");
			 break;
			 
			 
		case 3:
			 System.out.println("Enter roll no of the student whose fees you need to modify");
			 int roll=sc.nextInt();
			 System.out.println("Enter fees");
			 float f=sc.nextFloat();
			 String s="update  student set Fees="+f+"where Rollno="+roll;
			 PreparedStatement ps = con.prepareStatement(s);
			 ps.executeUpdate(s);
			 System.out.println("record modified successfully");
			 System.out.println();
			break;
			
		case 4:
			System.out.println("enter roll no to display a record of that student");
			String inp=sc.nextLine();
			if(inp.equals(""))
			{
				 ResultSet rs=st.executeQuery("select * from student");
				 while(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getDouble(5));
				 }
			}
			else
			{
				int rl=Integer.valueOf(inp);
				 String v="select * from student where Rollno="+rl;
				 PreparedStatement pr= con.prepareStatement(v);
				ResultSet rs=pr.executeQuery();
				if(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getDouble(5));
				else
					System.out.println("No data found");
				
			}
			System.out.println();
			break;
		case 5:
			loop=false;
		}
	}
	while(loop==true);
	System.out.println("Execution Terminated");

	}

}
