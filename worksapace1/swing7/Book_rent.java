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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.cglib.core.Local;

import java31.swing.FrmA;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Book_rent extends JFrame {
    
    private JPanel      contentPane;
    private JTextField  textField_title;
    private JTextField  textField_publisher;
    private JTextField  textField_author;
    private JTextField  textField_search;
    private JLabel      label;
    private JLabel      label_1;
    private JLabel      label_2;
    private JLabel      label_3;
    private JButton     btnNewButton;
    private JButton     button;
    private JButton     btnNewButton_1;
    private JScrollPane scrollPane;
    private JTable      table_rent;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Book_rent frame = new Book_rent();
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
    public Book_rent() {
        setTitle("책 대여");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField_title());
        contentPane.add(getTextField_publisher());
        contentPane.add(getTextField_author());
        contentPane.add(getTextField_search());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getScrollPane());
    }// private->public
    
    private JTextField getTextField_title() {
        if (textField_title == null) {
            textField_title = new JTextField();
            textField_title.setEditable(false);
            textField_title.setBounds(84, 44, 176, 21);
            textField_title.setColumns(10);
        }
        return textField_title;
    }
    
    private JTextField getTextField_publisher() {
        if (textField_publisher == null) {
            textField_publisher = new JTextField();
            textField_publisher.setEditable(false);
            textField_publisher.setColumns(10);
            textField_publisher.setBounds(84, 87, 176, 21);
        }
        return textField_publisher;
    }
    
    private JTextField getTextField_author() {
        if (textField_author == null) {
            textField_author = new JTextField();
            textField_author.setEditable(false);
            textField_author.setColumns(10);
            textField_author.setBounds(84, 131, 176, 21);
        }
        return textField_author;
    }
    
    private JTextField getTextField_search() {
        if (textField_search == null) {
            textField_search = new JTextField();
            textField_search.setColumns(10);
            textField_search.setBounds(101, 175, 95, 21);
        }
        return textField_search;
    }
    
    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("책 제목");
            label.setBounds(12, 47, 57, 15);
        }
        return label;
    }
    
    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("출판사");
            label_1.setBounds(12, 90, 57, 15);
        }
        return label_1;
    }
    
    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("저자");
            label_2.setBounds(12, 134, 57, 15);
        }
        return label_2;
    }
    
    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("회원 번호 검색");
            label_3.setBounds(12, 178, 89, 15);
        }
        return label_3;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("대여");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //// 대여// 사람 정보랑 책정보랑 합쳐서 rent_total에 들어감.
                    
                    // 책정보 받음
                    Integer b_no = Integer.parseInt(""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 0));
                    String title = ""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 1);
                    String publisher = ""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 2);       
                    String genre = ""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 3);
                    String author =""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 4);
                    Integer sal   =Integer.parseInt(""+parent.bookif.getValueAt(parent.bookif.getSelectedRow(), 5));
                    String rent_if = "대여불가";
                    
                    
                    //대여정보
                    LocalDate cdate =LocalDate.now();
                    String rent_date = cdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    
                    
                   // 사람정보 받음
                    Integer p_no   = Integer.parseInt("" + table_rent.getValueAt(table_rent.getSelectedRow(), 0));
                    String name = "" + table_rent.getValueAt(table_rent.getSelectedRow(), 1);
                    String phone = "" + table_rent.getValueAt(table_rent.getSelectedRow(), 2);
                    String pid = "" + table_rent.getValueAt(table_rent.getSelectedRow(), 3);
                    String email = "" + table_rent.getValueAt(table_rent.getSelectedRow(), 4);
                    
                    // 합쳐서 -> rent 갱신,//책목록 -> 대여불가 변경
                    
                    ///////////////////////////////
                    //rent_total
                    try {
                        parent.refresh_rent(/*rent_no,*/ name, pid, phone, email, title,
                                publisher, genre, author, b_no, rent_date);
                        
                        parent.refresh_Book1(b_no, title, publisher, genre, author,
                                sal, rent_if);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    //책정보 변경 대여가능->대여불가
                    
                    
                    //parent.refresh_rent1(name, title, rent_date);
                    JOptionPane.showMessageDialog(null, "대여완료");
                    dispose();
                }
            });
            btnNewButton.setBounds(325, 42, 97, 42);
        }
        return btnNewButton;
    }
    
    private JButton getButton() {
        if (button == null) {
            button = new JButton("취소");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //창닫음
                    dispose();
                    
                }
            });
            button.setBounds(325, 114, 97, 42);
        }
        return button;
    }
    
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("검색");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 대여창에서 회원검색
                    String search = textField_search.getText();
                    
                    if(search.equals("")) {
                        JOptionPane.showMessageDialog(null, "잘못된 회원번호 입니다.");
                        
                    }else {
                        Object[] tempObject = new Object[5];
                        DefaultTableModel model = (DefaultTableModel) table_rent.getModel();
                        model.setRowCount(0);
                        
                        ModelPerson mperson = null;
                        
                        java.sql.ResultSet rs;
                        try {
                            rs = parent.svrp.selectAll();
                            for (int i = 0; i < parent.svrp
                                    .getCount(mperson); i++) {
                                rs.next();// result set에서 다음 row로
                                Integer p_no = rs.getInt("p_no");
                                
                                if (p_no == (Integer.parseInt(search))) {
                                    
                                           p_no = rs.getInt("p_no");
                                    String name = rs.getString("name");
                                    String pid = rs.getString("pid");
                                    String phone = rs.getString("phone");
                                    String email = rs.getString("email");
                                    
                                    tempObject[0] = p_no;
                                    tempObject[1] = name;
                                    tempObject[2] = pid;
                                    tempObject[3] = phone;
                                    tempObject[4] = email;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                            }
                            
                            table_rent.setModel(model);
                            
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                    }
                   
                    
                    
                    
                }
            });
            btnNewButton_1.setBounds(197, 174, 63, 23);
        }
        return btnNewButton_1;
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(12, 228, 410, 151);
            scrollPane.setViewportView(getTable_rent());
        }
        return scrollPane;
    }
    
    private JTable getTable_rent() {
        if (table_rent == null) {
            table_rent = new JTable();
            table_rent.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "NO", "\uC774\uB984",
                            "\uC8FC\uBBFC\uBC88\uD638",
                            "\uC804\uD654\uBC88\uD638",
                            "\uC774\uBA54\uC77C\uC8FC\uC18C" }) {
                Class[] columnTypes = new Class[] { Integer.class, String.class,
                        String.class, String.class, String.class };
                
                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return table_rent;
    }
    
    //// 메인의 bookif 테이블 정보를 대여창 테이블에서 받는다.
    public void refresh(String title, String publisher, String author) {
        textField_title.setText(title);
        textField_publisher.setText(publisher);
        textField_author.setText(author);
    }
    
    //////////////////////// main 정보 가져오기 위한 ////////
    private Main parent = null;
    
    public Main getparent() {
        return parent;
    }
    
    public void setParent(Main parent) {
        this.parent = parent;
        
    }
    
    // 대여창
    public Book_rent(Main parent) {
        commonConstructorBR();
        this.parent = parent;
        
    }
    
    private void commonConstructorBR() {
        
        setTitle("책 대여");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField_title());
        contentPane.add(getTextField_publisher());
        contentPane.add(getTextField_author());
        contentPane.add(getTextField_search());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getScrollPane());
    }
}
