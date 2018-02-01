package java1101.swing7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Enroll_Book extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField_title;
    private JTextField textField_publisher;
    private JTextField textField_author;
    private JTextField textField_sal;
    private JButton btnNewButton;
    private JButton button;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JComboBox comboBox_genre;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Enroll_Book frame = new Enroll_Book();
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
    public Enroll_Book() {
        setTitle("책등록");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField_title());
        contentPane.add(getTextField_publisher());
        contentPane.add(getTextField_author());
        contentPane.add(getTextField_sal());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getComboBox_genre());
    }
    
    private JTextField getTextField_title() {
        if (textField_title == null) {
        	textField_title = new JTextField();
        	textField_title.setBounds(68, 35, 211, 21);
        	textField_title.setColumns(10);
        }
        return textField_title;
    }
    private JTextField getTextField_publisher() {
        if (textField_publisher == null) {
        	textField_publisher = new JTextField();
        	textField_publisher.setColumns(10);
        	textField_publisher.setBounds(68, 66, 211, 21);
        }
        return textField_publisher;
    }
    private JTextField getTextField_author() {
        if (textField_author == null) {
        	textField_author = new JTextField();
        	textField_author.setColumns(10);
        	textField_author.setBounds(68, 97, 211, 21);
        }
        return textField_author;
    }
    private JTextField getTextField_sal() {
        if (textField_sal == null) {
        	textField_sal = new JTextField();
        	textField_sal.setColumns(10);
        	textField_sal.setBounds(68, 128, 108, 21);
        }
        return textField_sal;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("등록");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	     // 값 main에 돌려주기///////////////////////////////////
                    
                             
                    String title    = textField_title.getText();
                    String publisher= textField_publisher.getText();
                    String genre    = comboBox_genre.getSelectedItem()+"";
                    String author   = textField_author.getText();
                    Integer sal     = Integer.parseInt(textField_sal.getText());
                    String rent_if  = "대여가능";        
                    
                    
                    try {
                        parent.refresh_Book(title,publisher,genre,author ,sal,rent_if);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "등록완료");
                    dispose();
                    ////////////////////////////////////////////////////
        	        
        	        
        	        
        	    }
        	});
        	btnNewButton.setBounds(94, 206, 97, 46);
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
        	button.setBounds(203, 206, 97, 46);
        }
        return button;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 제목");
        	lblNewLabel.setBounds(13, 35, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("출판사");
        	label.setBounds(12, 66, 57, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("저자");
        	label_1.setBounds(13, 97, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("가격");
        	label_2.setBounds(13, 128, 57, 15);
        }
        return label_2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("장르");
        	label_3.setBounds(13, 159, 57, 15);
        }
        return label_3;
    }
    private JComboBox getComboBox_genre() {
        if (comboBox_genre == null) {
        	comboBox_genre = new JComboBox();
        	comboBox_genre.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        	comboBox_genre.setBounds(68, 156, 108, 21);
        }
        return comboBox_genre;
    }
    /////////////////////////////////////////////
    //부모 메인창을 가르키는 필드
    private Main parent = null;
    public Main getparent() {
        return parent;
    }
    public void setParent(Main parent) {
        this.parent=parent;
    }
    
}
