//import required classes and packages  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.*; 
class otp
{
	 
	public  String OTP()
	{
		ArrayList<Integer> list =new ArrayList<>();
		for(int i=0;i<=9;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		int Otp=0;
		Otp=(list.get(0)*1000)+(list.get(1)*100)+(list.get(2)*10)+(list.get(3)*1);
		System.out.println(Otp);
		return Integer.toString(Otp);
	}
	
}
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
      String b;
    //calling constructor  
    CreateLoginForm(String a)  
    {     
		b=a;
        // String b=a; 
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
        System.out.println(passValue);
        //check whether the credentials are authentic or not  
        if (userValue.equals("rohit") && passValue.equals(b)) {  //if authentic, navigate user to a new page  
              
            //create instance of the NewPage  
            NewPage page = new NewPage();  
              
            //make page visible to the user  
            page.setVisible(true);  
              
            //create a welcome label and set it to the new page  
            JLabel wel_label = new JLabel("Welcome: "+userValue);  
            page.getContentPane().add(wel_label); 
             
           JButton b=new JButton("let us Start");
           b.setBounds(50,100,100, 20);
            wel_label.add(b);
            wel_label.setSize(400,500);//400 width and 500 height  
			wel_label.setLayout(null);//using no layout managers  
			wel_label.setVisible(true);
			  
        }  
        else{  
            //show error message  
           NewPage paga = new NewPage();  
            paga.setVisible(true);
            JLabel wel_label = new JLabel("Please enter valid username and password");
            paga.getContentPane().add(wel_label);
            System.out.println("Please enter valid username and password"); 
        }  
    }  
}  
class NewPage extends JFrame  
{  
    //constructor  
    NewPage()  
    {  
        setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);  
        setTitle("Welcome");  
        setSize(400, 200);  
    }  
}  
//create the main class  
class projectLoginFormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
			otp p=new otp();
			String a=p.OTP();
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm(a);  
            form.setSize(500,300);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user  
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}  
