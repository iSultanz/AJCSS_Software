import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class UserTypePage extends JFrame {
    public JButton managerIcon;
    public JButton memberIcon;

    public UserTypePage(String title) {
        super(title);
        setSize(445, 450);
        setTitle("AJCSS");
        setIconImage(Toolkit.getDefaultToolkit().
                getImage(UserTypePage.class.getResource("/images/AJCSSIcon.png")));
        getContentPane().setBackground(new Color(199, 204, 210));
        getContentPane().setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel selectUserLabel = new JLabel("Select user type", SwingConstants.CENTER);
        selectUserLabel.setBounds(-225, 0, 890,55);
        selectUserLabel.setFont(new Font("Freestyle Script", Font.PLAIN, 48));
        selectUserLabel.setForeground(Color.DARK_GRAY);
        selectUserLabel.setBorder(new MatteBorder(1,0,1,0,Color.DARK_GRAY));
        getContentPane().add(selectUserLabel);

        managerIcon = new JButton("");
        managerIcon.setBounds(25, 136, 149, 215);
        managerIcon.setIcon(new ImageIcon(
                UserTypePage.class.getResource("/images/HR-Manager-icon.png")));
        managerIcon.setBackground(new Color(199, 204, 210));
        managerIcon.setBorderPainted(false);
        managerIcon.setFocusPainted(false);
        getContentPane().add(managerIcon);

        managerIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRManagerUserAction();
            }
        });

        JButton HRManagerButton = new JButton("HR Manager");
        HRManagerButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        HRManagerButton.setForeground(Color.BLACK);
        HRManagerButton.setBackground(new Color(199, 204, 210));
        HRManagerButton.setBounds(25, 349, 147, 40);
        HRManagerButton.setBorder(new MatteBorder(0,1,1,1,Color.BLACK));
        HRManagerButton.setFocusPainted(false);
        getContentPane().add(HRManagerButton);

        HRManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRManagerUserAction();
            }
        });

        memberIcon = new JButton();
        memberIcon.setBounds(250, 135, 149, 215);
        memberIcon.setIcon(new ImageIcon(
                UserTypePage.class.getResource("/images/HR-Member-icon.png")));
        memberIcon.setBackground(new Color(199, 204, 210));
        memberIcon.setBorderPainted(false);
        memberIcon.setFocusPainted(false);
        getContentPane().add(memberIcon);

        memberIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRMemberUserAction();
            }
        });

        JButton HRMemberButton = new JButton("HR Member");
        HRMemberButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        HRMemberButton.setForeground(Color.BLACK);
        HRMemberButton.setBackground(new Color(199, 204, 210));
        HRMemberButton.setBounds(251, 349, 147, 40);
        HRMemberButton.setBorder(new MatteBorder(0,1,1,1,Color.BLACK));
        HRMemberButton.setFocusPainted(false);
        getContentPane().add(HRMemberButton);

        HRMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRMemberUserAction();
            }
        });
    }

    // Once the user interacts with any component of the HR Manager icon/button.
    // the following method action will be performed.
    public void HRManagerUserAction(){
        LoginPage loginPage = new LoginPage("Login");
        loginPage.setVisible(true);
        setVisible(false);
    }

    // Once the user interacts with any component of the HR Member icon/button.
    // the following method action will be performed.
    public void HRMemberUserAction(){
        AJCSS ajcss;
        ajcss= new AJCSS();
        ajcss.jTabbedPane1.removeTabAt(WIDTH+1);
        ajcss.jTabbedPane1.removeTabAt(WIDTH-1);
        ajcss.setVisible(true);
        setVisible(false);
    }

    // This method has been made only for class functionality testing.
    public static void main(String[] args) {
        UserTypePage userTypePage = new UserTypePage("AJCSS");
        userTypePage.setVisible(true);
    }
}