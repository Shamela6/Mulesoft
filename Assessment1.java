package mulesoft.assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author SY
 */
public class MulesoftAssessment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        Class.forName("java.sql.Driver");
        Connection obj=DriverManager.getConnection("jdbc:mysql://localhost/mulesoft","root","asdfghjkl@46");
        Statement obj1 =obj.createStatement();
        String q= "insert into movies values('Alive','Yoo Ah In','Park Shin Hye','II Cho',2020);";
        obj1.executeUpdate(q);
        String p= "insert into movies values('Train to Busan','Gong Yoo','Kim Soo Ahn','Yeon Sang Ho',2016);";
        obj1.executeUpdate(p);
        String r= "insert into movies values('Money heist','Alvaro Morte','Ursula Corbero','Alex Pina',2017);";
        obj1.executeUpdate(r);
        
        System.out.println("OUTPUT of select query:\n");
        String q1="select * from movies;";
            ResultSet r1=obj1.executeQuery(q1);
            while(r1.next()){
                String a1=r1.getString("name");
                String b1=r1.getString("actor");
                String c1=r1.getString("actress");
                String d=r1.getString("director");
                String yr=r1.getString("year_of_release");
                System.out.print(a1+"\t");
                System.out.print(b1+"\t");
                System.out.print(c1+"\t");
                System.out.print(d+"\t");
                System.out.print(yr+"\t");
                System.out.println();
            }
            
            String q11="select name,director from movies where actor='Gong Yoo';";
            ResultSet r11=obj1.executeQuery(q11);
            while(r11.next()){
                String n=r11.getString("name");
                String d=r11.getString("director");
                System.out.println();
                System.out.println("OUTPUT of select query where actor name is Gong Yoo\n");
                System.out.print(n+"\t"+d);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Incorrect!");
        }
    }
    
}
