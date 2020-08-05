import java.awt.*;
import java.awt.event.*;
class calc implements ActionListener
{
  Frame f=new Frame();
  Label l1=new Label("First Number:  ");
  Label l2=new Label("Second  Number:   ");
  Label l3=new Label("Result:  ");

    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    Button b1=new Button("sum");
     Button b2=new Button("Dif");
     Button b3=new Button("Pro");
     Button b4=new Button("Div"); 
     Button b5=new Button("Can");
     calc()
     {
         l1.setBounds(50,100,100,20);
         l2.setBounds(50,150,100,20);
         l3.setBounds(50,200,100,20);

         t1.setBounds(200,100,100,20);
         t2.setBounds(200,140,100,20);
         t3.setBounds(200,180,100,20);

         b1.setBounds(50,250,50,20); 
         b2.setBounds(100,250,50,20); 
         b3.setBounds(150,250,50,20);
         b4.setBounds(200,250,50,20); 
         b5.setBounds(250,250,50,20);  
         f.add(l1);
         f.add(l2);
         f.add(l3);
          
         f.add(t1);
         f.add(t2);
         f.add(t3);

         f.add(b1);
         f.add(b2);
         f.add(b3);
         f.add(b4);
         f.add(b5);
          
        

         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);

         f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
         f.setLayout(null);
         f.setSize(400,350);
         f.setLocation(500,200);
         f.setVisible(true);
     }
     public void actionPerformed(ActionEvent e)
     {
         int n1=Integer.parseInt(t1.getText());
         int n2=Integer.parseInt(t2.getText());
     
     if(e.getSource()==b1)
     {
      int res=n1+n2;
      t3.setText(String.valueOf(res));
     }
    if(e.getSource()==b2)
     {
      int res=n1-n2;
      t3.setText(String.valueOf(res));
     }
     if(e.getSource()==b3)
     {
      int res=n1*n2;
      t3.setText(String.valueOf(res));
     }
     if(e.getSource()==b4)
     {
      int res=n1/n2;
      t3.setText(String.valueOf(res));
     } 
     if(e.getSource()==b5)
     {
      System.exit(0);
     }
    } 
public static void main(String []args)
{
    new calc();
}
}
