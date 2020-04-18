import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class PopUpMessages extends JFrame {
    public JButton okButton;

    public PopUpMessages(String title){
        super(title);
        if( title.equals("Login Failed"))
            loginFailedMessage(title);
    }

    // When authentication operation doesn't match the pre-stored username and password.
    public void loginFailedMessage(String title){
        setIconImage(Toolkit.getDefaultToolkit().
                getImage(PopUpMessages.class.getResource("/images/error-icon.png")));
        setSize(560, 160);
        setTitle(title);
        getContentPane().setBackground(new Color(199, 204, 210));
        getContentPane().setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Login Failed. Check your username and password.");
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        label.setForeground(Color.RED);
        label.setBounds(16, -35, 650, 150);
        getContentPane().add(label);

        okButton = new JButton();
        okButton.setIcon(new ImageIcon(
                PopUpMessages.class.getResource("/images/ok-button-icon.png")));
        okButton.setBackground(new Color(199, 204, 210));
        okButton.setBounds(220, 65, 81, 41);
        okButton.setFocusPainted(false);
        okButton.setBorderPainted(false);
        getContentPane().add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        okButton.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    setVisible(false);
            }
        });
    }

    // This method has been made only for class functionality testing.
    public static void main(String[] args) {
        PopUpMessages ob = new PopUpMessages("Login Failed");
        ob.setVisible(true);
    }
}