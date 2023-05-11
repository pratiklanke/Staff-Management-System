
package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname , tffname , tfaddress , tfphone,tfaadhar,tfmail,tfdesi,tfsalary;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add, back;
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        add(heading);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
         tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
         dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
       
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
         tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
         tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
         tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelmail = new JLabel("Email");
        labelmail.setBounds(50,300,150,30);
        labelmail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelmail);
         tfmail = new JTextField();
        tfmail.setBounds(200,300,150,30);
        add(tfmail);
        
        JLabel labeledu = new JLabel("Highest Education");
        labeledu.setBounds(400,300,150,30);
        labeledu.setFont(new Font("serif",Font.PLAIN,20));
        add(labeledu);
        String courses[] = {"Select","BBA","MBA","BA","MA","BSc","MSc","BE","ME","BTech","MTech","BCA","MCA","BCS","MCS","PHD"};
         cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);
        
        JLabel labeldesi = new JLabel("Designation");
        labeldesi.setBounds(50,350,150,30);
        labeldesi.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesi);
         tfdesi = new JTextField();
        tfdesi.setBounds(200,350,150,30);
        add(tfdesi);
        
        JLabel labelaadhar = new JLabel("Aaadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
         tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        lblempid = new JLabel(""+ number);
        lblempid.setBounds(200,400,150,30);
        add(lblempid);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfmail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesi.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempid.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
