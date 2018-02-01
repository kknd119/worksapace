package java1101.swing7;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Enroll_person extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    private JTextField textField_name;
    private JTextField textField_pid1;
    private JTextField textField_phone1;
    private JTextField textField_phone2;
    private JComboBox comboBox_phone;
    private JTextField textField_email;
    private JComboBox comboBox_email;
    private JButton btnNewButton;
    private JButton button;
    private JLabel lblNewLabel;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    
    ////////////////////////////////////////////////
    //생성자
    
    
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Enroll_person frame = new Enroll_person();
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
    public Enroll_person() {
        setTitle("회원가입");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLabel());
        contentPane.add(getTextField_name());
        contentPane.add(getTextField_pid1());
        contentPane.add(getTextField_phone1());
        contentPane.add(getTextField_phone2());
        contentPane.add(getComboBox_phone());
        contentPane.add(getTextField_email());
        contentPane.add(getComboBox_email());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getLabel_4_1());
        contentPane.add(getLabel_5());
        contentPane.add(getLabel_6());
        contentPane.add(getLabel_7());
        contentPane.add(getTextField_pid2());
    }
    
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("회원 정보 입력");
        	label.setBounds(156, 10, 106, 15);
        }
        return label;
    }
    private JTextField getTextField_name() {
        if (textField_name == null) {
        	textField_name = new JTextField();
        	textField_name.setBounds(86, 50, 116, 21);
        	textField_name.setColumns(10);
        }
        return textField_name;
    }
    private JTextField getTextField_pid1() {
        if (textField_pid1 == null) {
        	textField_pid1 = new JTextField();
        	textField_pid1.setColumns(10);
        	textField_pid1.setBounds(86, 91, 116, 21);
        }
        return textField_pid1;
    }
    private JTextField getTextField_phone1() {
        if (textField_phone1 == null) {
        	textField_phone1 = new JTextField();
        	textField_phone1.setColumns(10);
        	textField_phone1.setBounds(179, 133, 68, 21);
        }
        return textField_phone1;
    }
    private JTextField getTextField_phone2() {
        if (textField_phone2 == null) {
        	textField_phone2 = new JTextField();
        	textField_phone2.setColumns(10);
        	textField_phone2.setBounds(274, 133, 68, 21);
        }
        return textField_phone2;
    }
    private JComboBox getComboBox_phone() {
        if (comboBox_phone == null) {
        	comboBox_phone = new JComboBox();
        	comboBox_phone.setModel(new DefaultComboBoxModel(new String[] {"010", "02", "031", ""}));
        	comboBox_phone.setBounds(86, 133, 74, 21);
        }
        return comboBox_phone;
    }
    private JTextField getTextField_email() {
        if (textField_email == null) {
        	textField_email = new JTextField();
        	textField_email.setBounds(86, 180, 132, 21);
        	textField_email.setColumns(10);
        }
        return textField_email;
    }
    private JComboBox getComboBox_email() {
        if (comboBox_email == null) {
        	comboBox_email = new JComboBox();
        	comboBox_email.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "daum.net", "gmail.com"}));
        	comboBox_email.setBounds(251, 180, 91, 21);
        }
        return comboBox_email;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("가입");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        // 값 main에 돌려주기///////////////////////////////////
        	        
        	                 
        	        String name = textField_name.getText();
        	        String pid = textField_pid1.getText()+"-"+textField_pid2.getText();
        	        String phone = comboBox_phone.getSelectedItem()+"-"+textField_phone1.getText()+"-"+textField_phone2.getText();
        	        String email = textField_email.getText()+"@"+comboBox_email.getSelectedItem();
        	                 
        	        try {
                        parent.refresh_Person(name,pid,phone,email);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
        	        JOptionPane.showMessageDialog(null, "가입되셨습니다.");
        	        dispose();
        	        ////////////////////////////////////////////////////
        	    }
        	});
        	btnNewButton.setBounds(124, 211, 97, 41);
        }
        return btnNewButton;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("취소");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	button.setBounds(226, 211, 97, 41);
        }
        return button;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("이름");
        	lblNewLabel.setBounds(12, 53, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("주민번호");
        	label_1.setBounds(12, 94, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("전화번호");
        	label_2.setBounds(12, 136, 57, 15);
        }
        return label_2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("메일계정");
        	label_3.setBounds(12, 183, 57, 15);
        }
        return label_3;
    }
    private JLabel getLabel_4_1() {
        if (label_4 == null) {
        	label_4 = new JLabel("-");
        	label_4.setBounds(208, 94, 11, 15);
        }
        return label_4;
    }
    private JLabel getLabel_5() {
        if (label_5 == null) {
        	label_5 = new JLabel("-");
        	label_5.setBounds(166, 136, 11, 15);
        }
        return label_5;
    }
    private JLabel getLabel_6() {
        if (label_6 == null) {
        	label_6 = new JLabel("-");
        	label_6.setBounds(251, 136, 11, 15);
        }
        return label_6;
    }
    private JLabel getLabel_7() {
        if (label_7 == null) {
        	label_7 = new JLabel("@");
        	label_7.setBounds(226, 183, 21, 15);
        }
        return label_7;
    }
    //////////////////////////////////////////
    //부모 메인창 가르키는 필드
    private Main parent = null;
    private JPasswordField textField_pid2;
    public Main getparent() {
        return parent;
    }
    public void setParent(Main parent) {
        this.parent=parent;
    }
    
    // 회원가입창 
    public Enroll_person(Main parent) {
        commonConstructorEP();
        this.parent = parent;
        
    }

    private void commonConstructorEP() {
       

        setTitle("회원가입");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLabel());
        contentPane.add(getTextField_name());
        contentPane.add(getTextField_pid1());
        contentPane.add(getTextField_pid2());
        contentPane.add(getTextField_phone1());
        contentPane.add(getTextField_phone2());
        contentPane.add(getComboBox_phone());
        contentPane.add(getTextField_email());
        contentPane.add(getComboBox_email());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getLabel_4_1());
        contentPane.add(getLabel_5());
        contentPane.add(getLabel_6());
        contentPane.add(getLabel_7());
    }
    private JPasswordField getTextField_pid2() {
        if (textField_pid2 == null) {
        	textField_pid2 = new JPasswordField();
        	textField_pid2.setBounds(226, 91, 116, 21);
        }
        return textField_pid2;
    }
}
