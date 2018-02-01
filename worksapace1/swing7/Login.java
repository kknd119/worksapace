package java1101.swing7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    
    private JPanel             contentPane;
    private JTextField         textField_ID;
    private JLabel             lblId;
    private JLabel             lblPw;
    private JButton            btnNewButton;
    private JPasswordField     textField_pw;
    /////////////////////////////////////////
    private static ModelIDPW   MIDPW = null;
    private static ServiceIDPW svr   = null;
    
    private Main               main  = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 175);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField_ID());
        contentPane.add(getLblId());
        contentPane.add(getLblPw());
        contentPane.add(getBtnNewButton());
        contentPane.add(getTextField_pw());
    }
    
    private JTextField getTextField_ID() {
        if (textField_ID == null) {
            textField_ID = new JTextField();
            textField_ID.setBounds(75, 39, 202, 21);
            textField_ID.setColumns(10);
        }
        return textField_ID;
    }
    
    private JLabel getLblId() {
        if (lblId == null) {
            lblId = new JLabel("ID");
            lblId.setBounds(26, 37, 25, 15);
        }
        return lblId;
    }
    
    private JLabel getLblPw() {
        if (lblPw == null) {
            lblPw = new JLabel("PW");
            lblPw.setBounds(26, 73, 25, 15);
        }
        return lblPw;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("Login");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /// 로그인하여 Main 들어가기
                    
                    String id = textField_ID.getText();
                    String pw = textField_pw.getText();
                    String ido = "";
                    String pwo = "";
                    MIDPW = new ModelIDPW();
                    svr = new ServiceIDPW();
                    try {
                        for (int i = 0; i < svr.getCount(MIDPW); i++) {
                            
                            ResultSet rs = svr.selectAll();
                            rs.next();
                            ido = rs.getString("id");
                            pwo = rs.getString("pw");
                            
                            if (id.equals(ido) && pw.equals(pwo)) {
                                
                                main = new Main();
                                main.setVisible(true);
                                
                                JOptionPane.showMessageDialog(null,
                                        "로그인하였습니다.");
                                dispose();
                                
                            } else if (!id.equals(ido) && pw.equals(pwo)) {
                                
                                JOptionPane.showMessageDialog(null,
                                        "잘못된 아이디입니다.");
                                
                            } else if (id.equals(ido) && !pw.equals(pwo)) {
                                JOptionPane.showMessageDialog(null,
                                        "잘못된 비밀번호입니다.");
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "다시입력하세요.");
                            }
                            
                        }
                        
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                }
            });
            btnNewButton.setBounds(309, 38, 97, 47);
        }
        return btnNewButton;
    }
    
    private JPasswordField getTextField_pw() {
        if (textField_pw == null) {
            textField_pw = new JPasswordField();
            textField_pw.setBounds(75, 70, 202, 21);
        }
        return textField_pw;
    }
}
