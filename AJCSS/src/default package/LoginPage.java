import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {

    private JTextField usernameTextField;
    private JPasswordField passwordField;
    public JButton loginButton;
    public JButton backButton;

    public LoginPage(String title) {
        super(title);
        setSize(890, 500);
        setTitle(title);
        // To set the general application icon.
        setIconImage(Toolkit.getDefaultToolkit().
                getImage(LoginPage.class.getResource("/images/user-icon.png")));
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 204, 210));
        panel.setBounds(0, 0, 480, 605);
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBorder(new MatteBorder
                (0,0,0,1, new Color(23,255,122)));

        JLabel label02 = new JLabel("");
        label02.setBounds(101, 90, 289, 291);
        label02.setIcon(new ImageIcon(LoginPage.class.getResource("/images/user-icon.png")));
        panel.add(label02);

        JLabel labe0l = new JLabel();
        labe0l.setHorizontalAlignment(SwingConstants.CENTER);
        labe0l.setVerticalAlignment(SwingConstants.TOP);
        labe0l.setIcon(new ImageIcon(LoginPage.class.getResource("/images/lock-icon.png")));
        labe0l.setBounds(600, 30, 148, 128);
        getContentPane().add(labe0l);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 23));
        usernameTextField.setBackground(Color.WHITE);
        usernameTextField.setBounds( 541, 175, 268, 48);
        getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);
        usernameTextField.setText("username");
        usernameTextField.setForeground(Color.LIGHT_GRAY);
        usernameTextField.setBorder(new MatteBorder(0,0,1,0, Color.LIGHT_GRAY));
        usernameTextField.addMouseListener(new MouseAdapter() {
            // All of the following methods
            // control the style of the components regarding the Mouse Click, Enter and Exit.
            @Override
            public void mouseClicked(MouseEvent e) {
                if (usernameTextField.getText().equals("username")){
                    usernameTextField.setText("");
                    usernameTextField.setBorder(new MatteBorder
                            (0,0,1,0, new Color(23,255,122)));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(usernameTextField.getText().equals("username")){
                    usernameTextField.setText("");
                    usernameTextField.setBorder(new MatteBorder
                            (0,0,1,0, new Color(23,255,122)));
                }
            }

            @Override
            public void mouseExited(MouseEvent e){
                if(usernameTextField.getText().isEmpty()){
                    usernameTextField.setText("username");
                    usernameTextField.setBorder(
                            new MatteBorder(0,0,1,0, Color.LIGHT_GRAY));
                }
                else{
                    if(!usernameTextField.getText().isEmpty()
                            && !usernameTextField.getText().equals("username"))
                        usernameTextField.setBorder(new MatteBorder
                                (0,0,1,0, new Color(23,255,122)));
                }

                if(usernameTextField.getText().equals("username"))
                    usernameTextField.setForeground(Color.LIGHT_GRAY);
            }
        });

        usernameTextField.addFocusListener(new FocusAdapter() {
            // All of the following methods control the style of the components regarding the Gained/Lost focus.
            @Override
            public void focusGained(FocusEvent e) {
                if(!usernameTextField.getText().equals("username"))
                    usernameTextField.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!usernameTextField.getText().equals("username"))
                    usernameTextField.setForeground(Color.BLACK);
            }
        });

        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    // To let the application be more easier to use.
                    // Once the user pressed Enter key, The system will authenticates his/her identity.
                    // If the entered data is correct then the login button automatically will be pressed.
                    if( passwordField.getText().equals("password") || passwordField.getText().isEmpty() ) {
                        if (usernameTextField.getText().equals("username") || usernameTextField.getText().isEmpty() ){
                            emptyUsernameCase();
                            emptyPasswordCase();
                        }
                        else
                            emptyPasswordCase();
                    }
                    else
                        if(usernameTextField.getText().equals("username"))
                            emptyUsernameCase();
                        else
                            usernameTextField.getRootPane().setDefaultButton(loginButton);
                }
            }
        });

        passwordField = new JPasswordField();
        passwordField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 23));
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setBounds(541, 250, 268, 48);
        getContentPane().add(passwordField);
        passwordField.setText("password");
        passwordField.setBorder(new MatteBorder(0,0,1,0, Color.LIGHT_GRAY));

        passwordField.addMouseListener(new MouseAdapter() {
            // All of the following methods
            // control the style of the components regarding the Mouse Click, Enter and Exit.
            @Override
            public void mouseClicked(MouseEvent e) {
                if(passwordField.getText().equals("password"))
                    passwordField.setText("");
                passwordField.setBorder(new MatteBorder
                        (0,0,1,0, new Color(23,255,122)));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(passwordField.getText().equals("password")){
                    passwordField.setText("");
                    passwordField.setBorder(new MatteBorder
                            (0,0,1,0, new Color(23,255,122)));
                }
            }

            @Override
            public void mouseExited(MouseEvent e){
                if(passwordField.getText().isEmpty()){
                    passwordField.setText("password");
                    passwordField.setBorder(new MatteBorder
                            (0,0,1,0, Color.LIGHT_GRAY));
                }
                else{
                    if(!passwordField.getText().isEmpty() &&
                            !passwordField.getText().equals("password"))
                        passwordField.setBorder(new MatteBorder
                                (0,0,1,0, new Color(23,255,122)));
                }
                if(passwordField.getText().equals("password"))
                    passwordField.setForeground(Color.LIGHT_GRAY);
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            // All of the following methods control the style of the components regarding the Gained/Lost focus.
            @Override
            public void focusGained(FocusEvent e) {
                if(!passwordField.getText().equals("password"))
                    passwordField.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().equals("password"))
                    passwordField.setForeground(Color.LIGHT_GRAY);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // To let the application be more easier to use.
                    // Once the user pressed Enter key, The system will authenticates his/her identity.
                    //  If the entered data is correct then the login button automatically will be pressed.
                    if (usernameTextField.getText().equals("username") || usernameTextField.getText().isEmpty() ) {
                        if (passwordField.getText().equals("password") || passwordField.getText().isEmpty()) {
                            emptyUsernameCase();
                            emptyPasswordCase();
                        } else
                            emptyUsernameCase();
                    } else
                        if(passwordField.getText().equals("password"))
                            emptyPasswordCase();
                        else
                            passwordField.getRootPane().setDefaultButton(loginButton);
                }
            }
        });

        loginButton = new JButton();
        loginButton.setIcon(new ImageIcon(
                LoginPage.class.getResource("/images/login-button-icon.png")));
        loginButton.setBackground(Color.WHITE);
        loginButton.setBounds(600, 325, 161, 41);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        getContentPane().add(loginButton);

        loginButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // Checking the values of username/password for authenticating user identity.
                String username = usernameTextField.getText();
                @SuppressWarnings("deprecation")
                String password = passwordField.getText();
                if ( (username.isEmpty() || username.equals("username")) || (password.isEmpty() || password.equals("password"))){
                    if ( username.isEmpty() || username.equals("username") )
                        emptyUsernameCase();
                    if ( password.isEmpty() || password.equals("password") )
                        emptyPasswordCase();
                }
                else {
                    if( username.equals("admin") && password.equals("admin") ){
                        AJCSS ajcss = new AJCSS();
                        ajcss.jTabbedPane1.removeTabAt(WIDTH);
                        ajcss.jTabbedPane1.removeTabAt(WIDTH+1);
                        ajcss.setVisible(true);
                        setVisible(false);
                    }
                    else{
                        PopUpMessages popUpMessages = new PopUpMessages("Login Failed");
                        popUpMessages.setVisible(true);
                    }
                }

            }
        });

        backButton = new JButton();
        backButton.setBounds(15, 10, 65, 64);
        backButton.setIcon(new ImageIcon(
                LoginPage.class.getResource("/images/back-arrow-icon.png")));
        backButton.setBackground(new Color(199, 204, 210));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        getContentPane().add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Once user interacts with the back icon,
                // it will direct him/her into the user type page (First page of the application).
                UserTypePage userTypePage = new UserTypePage("AJCSS");
                userTypePage.setVisible(true);
                setVisible(false);
            }
        });
    }

    // In case of username text field is empty or has its default value with no changes.
    // this method will prevent the login operation action to be happen.
    public void emptyUsernameCase(){
        usernameTextField.setBorder(new MatteBorder(0,0,1,0, Color.RED));
    }

    // In case of password text field is empty or has its default value with no changes.
    // this method will prevent the login operation action to be happen.
    public void emptyPasswordCase() {
        passwordField.setBorder(new MatteBorder(0,0,1,0, Color.RED));
    }

    // This method has been made only for class functionality testing.
    public static void main(String[] args){
        LoginPage ob = new LoginPage("Login");
        ob.setVisible(true);
    }
}