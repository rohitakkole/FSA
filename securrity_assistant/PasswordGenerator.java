import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class PasswordGenerator
{
    private JFrame frame;
    private JButton generateButton;
    private JTextField passwordField;
    private JSpinner passwordLengthSpinner;
    private JLabel passwordLabel;
    private JLabel spinnerLabel;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JPanel mainPanel;
    private String password;
    private int rndNumber;
    private JCheckBox specialSignCheckBox;
    private String[] charPool;
    
    public PasswordGenerator() {
        this.password = "";
        this.charPool = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "°", "^", "!", "§", "$", "%", "&", "/", "(", ")", "=", "?", "`", "´", "{", "}", "[", "]", "*", "-", "+", ",", "<", ">", "|", "_", ";", "#", "µ", "~", ".", ":", "'" };
    }
    
    public String getPassword(final int spinnerValue) {
        this.password = "";
        for (int i = 0; i < spinnerValue; ++i) {
            if (!this.specialSignCheckBox.isSelected()) {
                this.rndNumber = (int)(Math.random() * 72.0);
                this.password = this.password.concat(this.charPool[this.rndNumber]);
            }
            else {
                this.rndNumber = (int)(Math.random() * 105.0);
                this.password = this.password.concat(this.charPool[this.rndNumber]);
            }
        }
        return this.password;
    }
    
    public static void main(final String[] args) {
        new PasswordGenerator().setupGui();
    }
    
    public void setupGui() {
        this.frame = new JFrame("Password Generator");
        this.panelOne = new JPanel();
        this.spinnerLabel = new JLabel("length");
        (this.passwordLengthSpinner = new JSpinner()).setModel(new SpinnerNumberModel(6, 6, 256, 1));
        (this.generateButton = new JButton("Generate")).addActionListener(new GenerateButtonListener());
        this.panelOne.add(this.generateButton);
        this.panelOne.add(this.spinnerLabel);
        this.panelOne.add(this.passwordLengthSpinner);
        this.panelTwo = new JPanel();
        this.passwordLabel = new JLabel("Password");
        this.passwordField = new JTextField(22);
        this.specialSignCheckBox = new JCheckBox("Add Special Signs to enforce password (/,=?`´}[]*-+<>|_;#µ~.:')");
        this.passwordField.setEditable(false);
        this.panelTwo.add(this.passwordLabel);
        this.panelTwo.add(this.passwordField);
        this.panelTwo.add(this.specialSignCheckBox);
        (this.mainPanel = new JPanel()).add(this.panelOne);
        this.mainPanel.add(this.panelTwo);
        this.frame.getContentPane().add(this.mainPanel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.pack();
    }
    
    public class GenerateButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(final ActionEvent ev) {
            final int spinnerValue = Integer.parseInt(PasswordGenerator.this.passwordLengthSpinner.getValue().toString());
            PasswordGenerator.this.passwordField.setText(PasswordGenerator.this.getPassword(spinnerValue));
        }
    }
}
