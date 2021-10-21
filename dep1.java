//
/*
 create a table in mysql  named as ddep;
+------------+----------+------+-----+---------+-------+
| Field      | Type     | Null | Key | Default | Extra |
+------------+----------+------+-----+---------+-------+
| departid   | char(8)  | YES  |     | NULL    |       |
| department | char(40) | YES  |     | NULL    |       |
| hod        | char(40) | YES  |     | NULL    |       |
| location   | char(40) | YES  |     | NULL    |       |
/*/

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.border.*;
 import javax.swing.event.*;
 import java.sql.*;

      class dep1 extends JFrame implements ActionListener,ItemListener
      {
       JComboBox jcb=new JComboBox();
       JLabel l1,l2,l3,l4,l5;
       JButton b1,b2,b3,b4,b5,b6;
       JTextField t1,t2,t3,t4,t5;
       static Connection c;
       static Statement st;
       static ResultSet rs,rs1,rs2,rs3,rs4;
       static PreparedStatement ps,ps1;
       String s;
       static int c1=1;
       static int x = 1;

      int d = 1;
      String arr[] = new String[5];
      static int ii = 0;


      dep1()
         {

          Container c=getContentPane();
          JPanel p=new JPanel();
          p.setLayout(null);

          l1=new JLabel("DEPNO:");
          l2=new JLabel("DEPNAME:");
          l3=new JLabel("HOD:");
          l4=new JLabel("LOCATION:");


          b1=new JButton("ADD");
          b2=new JButton("MODIFY");
          b3=new JButton("DELETE");
          b4=new JButton("SAVE");                    
          b5=new JButton(">>>");                    
          b6=new JButton("<<<");                    
                                  

          t1=new JTextField(20);
          t2=new JTextField(20);
          t3=new JTextField(20);
          t4=new JTextField(20);


          l1.setBounds(50,20,50,60);
          p.add(l1);
          t1.setBounds(160,40,60,20);
          p.add(t1);

          l2.setBounds(50,50,60,60);
          p.add(l2);
          t2.setBounds(160,70,60,20);
          p.add(t2);

          l3.setBounds(50,80,60,60);
          p.add(l3);
          t3.setBounds(160,100,60,20);
          p.add(t3);

          l4.setBounds(50,110,50,60);
          p.add(l4);
          t4.setBounds(160,130,60,20);
          p.add(t4);


         b1.setBounds(50,240,50,30);
         p.add(b1);

         b2.setBounds(120,240,50,30);
         p.add(b2);
            
         b3.setBounds(190,240,60,30);
         p.add(b3);

         b4.setBounds(260,240,50,30);
         p.add(b4);

         b5.setBounds(200,290,70,30);
         p.add(b5);

         b6.setBounds(250,290,70,30);
         p.add(b6);

         l1.setForeground(Color.black);
         l1.setFont(new Font("sans",Font.BOLD,13)); 

         l2.setForeground(Color.black);
         l2.setFont(new Font("sans",Font.BOLD,13)); 

         l3.setForeground(Color.black);
         l3.setFont(new Font("sans",Font.BOLD,13)); 

         l4.setForeground(Color.black);
         l4.setFont(new Font("sans",Font.BOLD,13)); 

         b1.setForeground(Color.red);
         b1.setFont(new Font("sans",Font.BOLD,13)); 
         b2.setForeground(Color.black);
         b2.setFont(new Font("sans",Font.BOLD,13)); 
         b3.setForeground(Color.blue);
         b3.setFont(new Font("sans",Font.BOLD,13)); 

         b4.setForeground(Color.gray);
         b4.setFont(new Font("sans",Font.BOLD,13)); 

         LineBorder i=new LineBorder(Color.gray,5);
         b1.setBorder(i);

         LineBorder i1=new LineBorder(Color.gray,5);
         b2.setBorder(i1);

         LineBorder i2=new LineBorder(Color.gray,5);
         b3.setBorder(i2);

         LineBorder i3=new LineBorder(Color.gray,5);
         b4.setBorder(i3);

         LineBorder i4=new LineBorder(Color.gray,5);
         b5.setBorder(i4);

         LineBorder i5=new LineBorder(Color.gray,5);
         b6.setBorder(i5);

         LineBorder i6=new LineBorder(Color.black,5);
         p.setBorder(i6);

       //   t1.setBounds(160,40,60,20);
         jcb.setBounds(160,40,80,30);
         jcb.addItemListener(this);
         c.add(jcb);
         jcb.setVisible(false);
         c.add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

       setSize(400,400);
       setVisible(true);

     }


   public void itemStateChanged(ItemEvent ie)
   {
    if(ie.getStateChange()==ItemEvent.SELECTED)
      {
       jcb.setVisible(false);
        t1.setText((String)ie.getItem()); 

       }
   }

   public void actionPerformed(ActionEvent ev)
   {
        if(ev.getSource()==b1) //b1 start
            {
            try{
                  jcb.setVisible(false);

                   rs1=st.executeQuery("select max(ddep_id) from ddep1");

                   if(rs1.next())
                    {
                     System.out.println("b1 while");
                     s=rs1.getString(1);
                     System.out.println(s);

                    System.out.println(s);
                    int s1= Integer.parseInt(s.substring(3));
                    s1=s1+1;
                    String s3=s.substring(0,3)+Integer.toString(s1);
                    t1.setText(s3);
                    t1.setEditable(false);
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    }
                 else
                    {
                    t1.setText("D001");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");

                    }

                }catch(SQLException se1){ System.out.println(se1);}
           }   //b1 end

    if(ev.getSource()==b2) //b2 start
     {  
        jcb.setVisible(true);

         try{
             if(c1==1)
                {
                 rs3=st.executeQuery("select * from ddep1");
                 c1++;
                }
            while(rs3.next())
            {
             jcb.addItem(rs3.getString(1));
            }
         }catch(SQLException sq){}

        t2.setText("");
        t3.setText("");
        t4.setText("");

     }    //b2 end
   
    if(ev.getSource()==b3) //b3 start
     {

     try{
      t1.setEditable(false);

         String dele=t1.getText();
         System.out.println("***"+dele);
         ps1=c.prepareStatement("delete from ddep1 where ddep_id='"+dele+"'");
        // ps1.setString(1,dele);

         int r=ps1.executeUpdate();
         System.out.println(+r+" : is deleted");
         JOptionPane.showMessageDialog(this,Integer.toString(r)+" :is deleted","message",JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException d){System.out.println(d);}

     }    //b3 end


 if(ev.getSource()==b4) // SAVE b4 start
     {
       if(t2.getText().equals(null)||t2.getText().equals(""))
       {
         System.out.println("null inside if");
         t2.requestFocus();
         JOptionPane.showMessageDialog(this,"one colom has no information","message",JOptionPane.INFORMATION_MESSAGE);
        
       }
else{
   try{
          t1.setEditable(false);

          String s1=t1.getText();
          String s2=t2.getText();
          String s3=t3.getText();
          String s4=t4.getText();

       rs4=st.executeQuery("select * from ddep1");
       while(rs4.next())
       {
        System.out.println("while inside");
        if(s1.equals(rs4.getString(1)))
         {
         System.out.println("INSIDE if");
         JOptionPane.showMessageDialog(this,"no dummy record is inserted","message",JOptionPane.INFORMATION_MESSAGE);
        }
       
    else  {
          ps=c.prepareStatement("insert into ddep1 values(?,?,?,?)");
          ps.setString(1,s1);
          ps.setString(2,s2);
          ps.setString(3,s3);
          ps.setString(4,s4);
          int i=ps.executeUpdate();
          System.out.println(+i+" : is inserted");
          JOptionPane.showMessageDialog(this,Integer.toString(i)+" :is inserted","message",JOptionPane.INFORMATION_MESSAGE);
         
         }    //second else

       }  //end while

     }catch(SQLException p){System.out.println(p);}
    
    }    //first else
  }    //b4 end

    if(ev.getSource()==b5)     //b5 start
     {
     try{
           if (x == 1)
           {
            t1.setEditable(false);

            rs=st.executeQuery("select * from ddep1");
            rs.next();
            x++;
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));

            arr[ii]=t1.getText();
            ii++;
           }

      else if(rs.next())
         {
        t1.setEditable(false);

          t1.setText(rs.getString(1));
          t2.setText(rs.getString(2));
          t3.setText(rs.getString(3));
          t4.setText(rs.getString(4));
           
          arr[ii]=t1.getText();
          ii++;
          System.out.println(">>>>");
         }
        
     else {
         System.out.println(" no more record"); 
         JOptionPane.showMessageDialog(this,"no more record","message",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(SQLException evv) {System.out.println("FIRST"+evv); }

     } //end b5


    if(ev.getSource()==b6)  // b6 statt
       {
       try{    
              ii--;
              rs2 = st.executeQuery("select * from ddep1 where ddep_id ='"+arr[ii]+"'");
              if(rs2.next())
              {
               t1.setText(""+rs2.getString(1));
               t2.setText(""+rs2.getString(2));
               t3.setText(""+rs2.getString(3)); 
               t4.setText(""+rs2.getString(4)); 
               t1.setEditable(false);
              
              }
              else {
                System.out.println(" no previous record");
                JOptionPane.showMessageDialog(this,"no previous record","message",JOptionPane.INFORMATION_MESSAGE);
               }
              }catch(SQLException evv){System.out.println("FIRST"+evv);  }

         }  //end b6

      }  //end for Actionperformed


  public static void main(String arg[])
  {
     
     try{

       // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//c=DriverManager.getConnection("jdbc:odbc:raj","ovb9331","ovb9325");

         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        System.out.println("Connected");
        st=con.createStatement();
      }catch(SQLException evv)
        {
        System.out.println("FIRST"+evv);
        } 

   dep1 r=new dep1();
  }
}




