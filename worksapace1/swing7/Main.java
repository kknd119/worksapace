package java1101.swing7;

import static org.hamcrest.CoreMatchers.containsString;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.CardLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.springframework.ui.Model;

import java23.jdbc.ModelBook1;
import java23.jdbc.ServiceBook1;

import java.awt.Component;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class Main extends JFrame {
    
    private JPanel                 contentPane;
    private JButton                btnNewButton;
    private JButton                button;
    private JButton                button_1;
    private JButton                button_2;
    private JScrollPane            scrollPane;
    private static JTable          rentif;
    private JTabbedPane            tabbedPane;
    private JPanel                 책정보;
    private JPanel                 회원관리;
    private JPanel                 대여목록;
    private JTree                  tree;
    private JTextField             textField_title;
    private JTextField             textField_publisher;
    private JTextField             textField_author;
    private JTextField             textField_sal;
    private JTextField             textField_genre;
    private JTextField             textField_searchb;
    private JTextField             textField_bookid;
    private JLabel                 lblNewLabel;
    private JLabel                 label;
    private JLabel                 label_1;
    private JLabel                 label_2;
    private JLabel                 label_3;
    private JLabel                 label_4;
    private JComboBox              comboBox_bs;
    private JButton                btnNewButton_1;
    private JLabel                 label_5;
    private JButton                btnNewButton_2;
    private JButton                button_3;
    private JButton                button_4;
    private JButton                button_5;
    private JScrollPane            scrollPane_1;
    protected static JTable        bookif;
    private JButton                btnNewButton_3;
    private JScrollPane            scrollPane_2;
    private static JTable          rentif_total;
    private JTextField             textField_name;
    private JTextField             textField_no;
    private JTextField             textField_pid1;
    private JTextField             textField_phone1;
    private JTextField             textField_email1;
    private JTextField             textField_phone2;
    private JTextField             textField_email2;
    private JLabel                 lblNewLabel_1;
    private JLabel                 label_6;
    private JLabel                 label_7;
    private JLabel                 label_8;
    private JTextField             textField_searchp;
    private JButton                btnNewButton_4;
    private JComboBox              comboBox_ps;
    private JButton                btnNewButton_5;
    private JTextField             textField_phone3;
    private JLabel                 label_9;
    private JLabel                 label_10;
    private JLabel                 label_11;
    private JScrollPane            scrollPane_3;
    private JButton                button_6;
    private JButton                button_7;
    private static JTable          personsif;
    private JPasswordField         textField_pid2;
    private JLabel                 label_12;
    private JLabel                 label_13;
    /**
     * Launch the application.
     * 
     */
    ////////////////////////////////////////
    // 자신 Main을 가르키느 필드
    private static Main            frame   = null;
    /////////////////////////////////////
    // 데이타베이스 연동
    private static ModelBook       Mbook   = null;
    private static ModelPerson     MPerson = null;
    private static ModelRent       MRent   = null;
    private static ServiceBook     svr     = null;
    protected static ServicePerson svrp    = null;
    private static ServiceRent     svrr    = null;
    
    //////////////////////////////// 메서드//////////////////////////////////////
    // refreshTable 메서드// 자식호출 메서드 /static 해줘야 nullpoint exception 안뜸.
    public static void refreshTable_book_if(JTable bookif) throws SQLException {
        // 책정보를 책정보테이블에 뿌려줌
        Object[] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel) bookif.getModel();
        model.setRowCount(0);
        
        svr = new ServiceBook();
        java.sql.ResultSet rs = svr.selectAll();
        
        for (int i = 0; i < svr.getCount(Mbook); i++) {
            
            rs.next();// result set에서 다음 row로
            int b_no = rs.getInt("b_no");
            String title = rs.getString("title");
            String publisher = rs.getString("publisher");
            String genre = rs.getString("genre");
            String author = rs.getString("author");
            Integer sal = rs.getInt("sal");
            String rent_if = rs.getString("rent_if");
            
            tempObject[0] = b_no;
            tempObject[1] = title;
            tempObject[2] = publisher;
            tempObject[3] = genre;
            tempObject[4] = author;
            tempObject[5] = sal;
            tempObject[6] = rent_if;
            
            model.addRow(tempObject);
            
        }
        
        if (model.getRowCount() > 0) {
            bookif.setModel(model);
        }
        
    }
    
    public static void refreshTable_personsif(JTable personsif)
            throws SQLException {
        
        // 회원정보를 회원정보 테이블에 뿌려줌
        
        Object[] tempObject = new Object[5];
        DefaultTableModel model = (DefaultTableModel) personsif.getModel();
        model.setRowCount(0);
        
        svrp = new ServicePerson();
        java.sql.ResultSet rs = svrp.selectAll();
        
        for (int i = 0; i < svrp.getCount(MPerson); i++) {
            
            rs.next();// result set에서 다음 row로
            int p_no = rs.getInt("p_no");
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
        
        if (model.getRowCount() > 0) {
            personsif.setModel(model);
        }
        
    }
     
    public static void refreshTable_rentif(JTable rentif) throws SQLException {
        // 대여정보를 대여정보테이블(작은거)에 뿌려줌
        
        Object[] tempObject = new Object[3];
        DefaultTableModel model = (DefaultTableModel) rentif.getModel();
        model.setRowCount(0);
        
        svrr = new ServiceRent();
        java.sql.ResultSet rs = svrr.selectAll();
        
        for (int i = 0; i < svrr.getCount(MRent); i++) {
            
            rs.next();// result set에서 다음 row로
            
            String name = rs.getString("name");
            String title = rs.getString("title");
            String rent_date = rs.getString("rent_date");
            
            tempObject[0] = name;
            tempObject[1] = title;
            tempObject[2] = rent_date;
            
            model.addRow(tempObject);
            
        }
        
        if (model.getRowCount() > 0) {
            rentif.setModel(model);
        }
        
    }
    
    public static void refreshTable_rentif_total(JTable rentif_total)
            throws SQLException {
        // 대여정보를 대여정보테이블(큰거)에 뿌려줌
        
        Object[] tempObject = new Object[11];
        DefaultTableModel model = (DefaultTableModel) rentif_total.getModel();
        model.setRowCount(0);
        
        svrr = new ServiceRent();
        java.sql.ResultSet rs = svrr.selectAll();
        
        for (int i = 0; i < svrr.getCount(MRent); i++) {
            
            rs.next();// result set에서 다음 row로
            Integer rent_no = rs.getInt("rent_no");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String pid = rs.getString("pid");
            String email = rs.getString("email");
            String title = rs.getString("title");
            String publisher = rs.getString("publisher");
            String genre = rs.getString("genre");
            String author = rs.getString("author");
            String b_no = rs.getString("b_no");
            String rent_date = rs.getString("rent_date");
            
            tempObject[0] = rent_no;
            tempObject[1] = name;
            tempObject[2] = phone;
            tempObject[3] = pid;
            tempObject[4] = email;
            tempObject[5] = title;
            tempObject[6] = publisher;
            tempObject[7] = genre;
            tempObject[8] = author;
            tempObject[9] = b_no;
            tempObject[10] = rent_date;
            
            model.addRow(tempObject);
            
        }
        
        if (model.getRowCount() > 0) {
            rentif_total.setModel(model);
        }
        
    }
    
    // 책,사람,대여 정보 등록 및 업데이트/////////////////////////////////////////////////////
    
    public static void refresh_rent(/* Integer rent_no, */ String name,
            String phone, String pid, String email, String title,
            String publisher, String genre, String author, Integer b_no,
            String rent_date) throws SQLException {
        // 대여창에서 대여한 정보를 rent total에 넘기는 것.
        ModelRent rent = new ModelRent();
        // rent.setRent_no(rent_no);
        rent.setTitle(title);
        rent.setPublisher(publisher);
        rent.setGenre(genre);
        rent.setAuthor(author);
        rent.setB_no(b_no);
        rent.setRent_date(rent_date);
        rent.setName(name);
        rent.setPid(pid);
        rent.setPhone(phone);
        rent.setEmail(email);
        
        svrr.insertRent(rent);
        
    }
    
    public static void refresh_Book1(Integer b_no, String title,
            String publisher, String genre, String author, Integer sal,
            String rent_if) // 책 대여후 업데이트
    
    {
        
        ModelBook wherebook = new ModelBook();
        wherebook.setB_no(Integer
                .parseInt("" + bookif.getValueAt(bookif.getSelectedRow(), 0)));
        ModelBook setbook = new ModelBook();
        setbook.setB_no(b_no);
        setbook.setTitle(title);
        setbook.setPublisher(publisher);
        setbook.setGenre(genre);
        setbook.setAuthor(author);
        setbook.setSal(sal);
        setbook.setRent_if(rent_if);
        
        try {
            svr.updateBook(wherebook, setbook);
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        
    }
    
    public static void refresh_Person(String name, String pid, String phone,
            String email) throws SQLException {
        // 회원정보 등록하는 메서드
        
        ModelPerson person = new ModelPerson();
        
        person.setName(name);
        person.setPid(pid);
        person.setPhone(phone);
        person.setEmail(email);
        
        svrp.insertperson(person);
        
    }
  
    
    public static void refresh_Book(/* Integer b_no, */String title,
            String publisher, String genre, String author, Integer sal,
            String rent_if) throws SQLException {
        // 책정보 등록하는 메서드
        
        ModelBook book = new ModelBook();
        
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setGenre(genre);
        book.setAuthor(author);
        book.setSal(sal);
        book.setRent_if(rent_if);
        svr.insertBook(book);
        
    }
    
    //////////////////////////////////////////////////////////////////////////
    // 메인메서드 ////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                    
                    refreshTable_book_if(bookif);
                    refreshTable_personsif(personsif);
                    refreshTable_rentif(rentif);
                    refreshTable_rentif_total(rentif_total);
                    //
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    
    /**
     * Create the frame.
     */
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1101, 789);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getButton_1());
        contentPane.add(getButton_2());
        contentPane.add(getScrollPane());
        contentPane.add(getTabbedPane());
        contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[] { getBtnNewButton(), getButton(), getButton_1(),
                        getButton_2(), getScrollPane(), getRentif() }));
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("회원 등록");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 회원 등록 창
                    Enroll_person ep = new Enroll_person();
                    ep.setVisible(true);
                    ep.setParent(frame);// 회원등록창에 main정보 전달
                    
                }
            });
            btnNewButton.setBounds(12, 10, 105, 51);
        }
        return btnNewButton;
    }
    
    private JButton getButton() {
        if (button == null) {
            button = new JButton("책 등록");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 책 등록 창열기
                    Enroll_Book eb = new Enroll_Book();
                    eb.setVisible(true);
                }
            });
            button.setBounds(129, 10, 105, 51);
        }
        return button;
    }
    
    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("새로고침");
            button_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    /// 새로고침 데이터 새로 불러오기.
                    try {
                        refreshTable_book_if(bookif);
                        refreshTable_personsif(personsif);
                        refreshTable_rentif(rentif);
                        refreshTable_rentif_total(rentif_total);
                        
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    /////////////////////////////////////
                }
            });
            button_1.setBounds(246, 10, 105, 51);
        }
        return button_1;
    }
    
    private JButton getButton_2() {
        if (button_2 == null) {
            button_2 = new JButton("프로그램종료");
            button_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // main창 닫음
                    dispose();
                }
            });
            button_2.setBounds(363, 10, 117, 51);
        }
        return button_2;
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setToolTipText("");
            scrollPane.setBounds(12, 99, 236, 642);
            scrollPane.setViewportView(getRentif());
        }
        return scrollPane;
    }
    
    private JTable getRentif() {
        if (rentif == null) {
            rentif = new JTable();
            rentif.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "\uC774\uB984", "\uCC45 \uC81C\uBAA9",
                            "\uB300\uC5EC\uB0A0\uC9DC" }) {
                Class[] columnTypes = new Class[] { String.class, String.class,
                        String.class };
                
                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return rentif;
    }
    
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setBounds(246, 99, 814, 642);
            tabbedPane.addTab("책정보", null, get책정보(), null);
            tabbedPane.addTab("회원관리", null, get회원관리(), null);
            tabbedPane.addTab("대여목록", null, get대여목록(), null);
        }
        return tabbedPane;
    }
    
    private JPanel get책정보() {
        if (책정보 == null) {
            책정보 = new JPanel();
            책정보.setBackground(SystemColor.activeCaption);
            책정보.setForeground(Color.BLACK);
            책정보.setLayout(null);
            책정보.add(getTree());
            책정보.add(getTextField_title());
            책정보.add(getTextField_publisher());
            책정보.add(getTextField_author());
            책정보.add(getTextField_sal());
            책정보.add(getTextField_genre());
            책정보.add(getTextField_searchb());
            책정보.add(getTextField_bookid());
            책정보.add(getLblNewLabel());
            책정보.add(getLabel());
            책정보.add(getLabel_1());
            책정보.add(getLabel_2());
            책정보.add(getLabel_3());
            책정보.add(getLabel_4());
            책정보.add(getComboBox_bs());
            책정보.add(getBtnNewButton_1());
            책정보.add(getLabel_5());
            책정보.add(getBtnNewButton_2());
            책정보.add(getButton_3());
            책정보.add(getButton_4());
            책정보.add(getButton_5());
            책정보.add(getScrollPane_1());
        }
        return 책정보;
    }
    
    private JPanel get회원관리() {
        if (회원관리 == null) {
            회원관리 = new JPanel();
            회원관리.setBackground(SystemColor.activeCaption);
            회원관리.setLayout(null);
            회원관리.add(getTextField_name());
            회원관리.add(getTextField_no());
            회원관리.add(getTextField_pid1());
            회원관리.add(getTextField_phone1());
            회원관리.add(getTextField_email1());
            회원관리.add(getTextField_phone2());
            회원관리.add(getTextField_email2());
            회원관리.add(getLblNewLabel_1());
            회원관리.add(getLabel_6());
            회원관리.add(getLabel_7());
            회원관리.add(getLabel_8());
            회원관리.add(getTextField_searchp());
            회원관리.add(getBtnNewButton_4());
            회원관리.add(getComboBox_ps());
            회원관리.add(getBtnNewButton_5());
            회원관리.add(getTextField_phone3());
            회원관리.add(getLabel_9());
            회원관리.add(getLabel_10());
            회원관리.add(getLabel_11());
            회원관리.add(getScrollPane_3());
            회원관리.add(getButton_6());
            회원관리.add(getButton_7());
            회원관리.add(getLabel_13());
            회원관리.add(getLabel_12_1());
            회원관리.add(getTextField_pid2());
            회원관리.add(getLabel_12());
            회원관리.add(getLabel_13_1());
        }
        return 회원관리;
    }
    
    private JPanel get대여목록() {
        if (대여목록 == null) {
            대여목록 = new JPanel();
            대여목록.setLayout(null);
            대여목록.add(getBtnNewButton_3());
            대여목록.add(getScrollPane_2());
        }
        return 대여목록;
    }
    
    private JTree getTree() {
        if (tree == null) {
            tree = new JTree();
            tree.setModel(
                    new DefaultTreeModel(new DefaultMutableTreeNode("장르\t") {
                        {
                            // getContentPane().add(new DefaultMutableTreeNode("소설"));
                            // getContentPane().add(new DefaultMutableTreeNode("교육"));
                            // getContentPane().add(new DefaultMutableTreeNode("문학"));
                            // getContentPane().add(new DefaultMutableTreeNode("해외"));
                            // getContentPane().add(new DefaultMutableTreeNode("기타"));
                        }
                    }));
            tree.setBounds(12, 24, 185, 273);
        }
        return tree;
    }
    
    private JTextField getTextField_title() {
        if (textField_title == null) {
            textField_title = new JTextField();
            textField_title.setBounds(285, 34, 162, 21);
            textField_title.setColumns(10);
        }
        return textField_title;
    }
    
    private JTextField getTextField_publisher() {
        if (textField_publisher == null) {
            textField_publisher = new JTextField();
            textField_publisher.setColumns(10);
            textField_publisher.setBounds(285, 65, 162, 21);
        }
        return textField_publisher;
    }
    
    private JTextField getTextField_author() {
        if (textField_author == null) {
            textField_author = new JTextField();
            textField_author.setColumns(10);
            textField_author.setBounds(285, 96, 162, 21);
        }
        return textField_author;
    }
    
    private JTextField getTextField_sal() {
        if (textField_sal == null) {
            textField_sal = new JTextField();
            textField_sal.setColumns(10);
            textField_sal.setBounds(285, 127, 82, 21);
        }
        return textField_sal;
    }
    
    private JTextField getTextField_genre() {
        if (textField_genre == null) {
            textField_genre = new JTextField();
            textField_genre.setColumns(10);
            textField_genre.setBounds(285, 158, 82, 21);
        }
        return textField_genre;
    }
    
    private JTextField getTextField_searchb() {
        if (textField_searchb == null) {
            textField_searchb = new JTextField();
            textField_searchb.setColumns(10);
            textField_searchb.setBounds(347, 189, 75, 21);
        }
        return textField_searchb;
    }
    
    private JTextField getTextField_bookid() {
        if (textField_bookid == null) {
            textField_bookid = new JTextField();
            textField_bookid.setEditable(false);
            textField_bookid.setColumns(10);
            textField_bookid.setBounds(498, 34, 48, 21);
        }
        return textField_bookid;
    }
    
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("책제목");
            lblNewLabel.setBounds(209, 37, 57, 15);
        }
        return lblNewLabel;
    }
    
    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("출판사");
            label.setBounds(209, 68, 57, 15);
        }
        return label;
    }
    
    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("저자");
            label_1.setBounds(209, 99, 57, 15);
        }
        return label_1;
    }
    
    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("가격");
            label_2.setBounds(209, 130, 57, 15);
        }
        return label_2;
    }
    
    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("장르");
            label_3.setBounds(209, 161, 57, 15);
        }
        return label_3;
    }
    
    private JLabel getLabel_4() {
        if (label_4 == null) {
            label_4 = new JLabel("검색");
            label_4.setBounds(209, 192, 57, 15);
        }
        return label_4;
    }
    
    private JComboBox getComboBox_bs() {
        if (comboBox_bs == null) {
            comboBox_bs = new JComboBox();
            comboBox_bs.setModel(new DefaultComboBoxModel(new String[] { "No",
                    "제목", "출판사", "장르", "저자", "가격", "대여정보" }));
            comboBox_bs.setBounds(285, 189, 57, 21);
        }
        return comboBox_bs;
    }
    
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("검색");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //// 책정보검색/////
                    
                    String search1 = (String) comboBox_bs.getSelectedItem();
                    
                    String search2 = textField_searchb.getText();
                    
                    if (search1 == "No") {
                        
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i < svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                Integer b_no = rs.getInt("b_no");
                                
                                if (/* search2!="" || */b_no == (Integer
                                        .parseInt(search2))) {
                                    
                                    b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    String genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (NumberFormatException | SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else if (search1 == "제목") {
                        
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                String title = rs.getString("title");
                                
                                if (/* search2!="" || */title.equals(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    String genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else if (search1 == "출판사") {
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                String publisher = rs.getString("publisher");
                                
                                if (/* search2!="" || */publisher
                                        .equals(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    publisher = rs.getString("publisher");
                                    String genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                    } else if (search1 == "장르") {
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                String genre = rs.getString("genre");
                                
                                if (/* search2!="" || */genre.equals(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    
                    else if (search1 == "저자") {
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                String author = rs.getString("author");
                                
                                if (/* search2!="" || */author
                                        .equals(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    String genre = rs.getString("genre");
                                    author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    
                    else if (search1 == "가격") {
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                Integer sal = rs.getInt("sal");
                                
                                if (/* search2!="" || */sal==Integer.parseInt(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    String genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    sal = rs.getInt("sal");
                                    String rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else if (search1 == "대여정보") {
                        Object[] tempObject = new Object[7];
                        DefaultTableModel model = (DefaultTableModel) bookif
                                .getModel();
                        model.setRowCount(0);
                        
                        svr = new ServiceBook();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svr.selectAll();
                            for (int i = 0; i <= svr.getCount(Mbook); i++) {
                                rs.next();// result set에서 다음 row로
                                String rent_if = rs.getString("rent_if");
                                
                                if (/* search2!="" || */rent_if
                                        .equals(search2)) {
                                    
                                    Integer b_no = rs.getInt("b_no");
                                    String title = rs.getString("title");
                                    String publisher = rs
                                            .getString("publisher");
                                    String genre = rs.getString("genre");
                                    String author = rs.getString("author");
                                    Integer sal = rs.getInt("sal");
                                    rent_if = rs.getString("rent_if");
                                    
                                    tempObject[0] = b_no;
                                    tempObject[1] = title;
                                    tempObject[2] = publisher;
                                    tempObject[3] = genre;
                                    tempObject[4] = author;
                                    tempObject[5] = sal;
                                    tempObject[6] = rent_if;
                                    
                                    model.addRow(tempObject);
                                    
                                }
                                
                                bookif.setModel(model);
                                
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    
                    ///////////////////////////////////////////////////////////////////////////
                    
                }
                
            });
            btnNewButton_1.setBounds(428, 188, 82, 23);
        }
        return btnNewButton_1;
    }
    
    private JLabel getLabel_5() {
        if (label_5 == null) {
            label_5 = new JLabel("책 번호");
            label_5.setBounds(453, 37, 57, 15);
        }
        return label_5;
    }
    
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
            btnNewButton_2 = new JButton("대여하기");
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if ("대여가능".equals(""
                            + bookif.getValueAt(bookif.getSelectedRow(), 6))) {
                        
                        // 책 대여창 띄우기
                        Book_rent br = new Book_rent();
                        br.setVisible(true);
                        // 책 대여창의 책정보 띄우기
                        String title = ""
                                + bookif.getValueAt(bookif.getSelectedRow(), 1);
                        String publisher = ""
                                + bookif.getValueAt(bookif.getSelectedRow(), 2);
                        String author = ""
                                + bookif.getValueAt(bookif.getSelectedRow(), 3);
                        
                        br.refresh(title, publisher, author);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "대여중입니다.");
                        
                    }
                    
                }
            });
            btnNewButton_2.setBounds(202, 248, 90, 49);
        }
        return btnNewButton_2;
    }
    
    private JButton getButton_3() {
        if (button_3 == null) {
            button_3 = new JButton("수정");
            button_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 책목록 내용 수정하기
                    
                    Integer b_no = Integer.parseInt(textField_bookid.getText());
                    String title = textField_title.getText();
                    String publisher = textField_publisher.getText();
                    String genre = textField_genre.getText();
                    String author = textField_author.getText();
                    Integer sal = Integer.parseInt(textField_sal.getText());
                    String rent_if = "대여가능";
                    //대여중인 책을 수정할 수 없도록.
                    String rent_info="";
                    
                    Mbook =new ModelBook();
                    Mbook.setTitle(title);
                    svr =new ServiceBook();
                    ResultSet rs=null;
                    
                    
                    try {
                        rs = svr.selectEqual(Mbook);
                        rs.next();
                        rent_info=rs.getString("rent_if");
                        
                            
                        
                    } catch (SQLException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    
                    
                    if(rent_info.equals("대여불가")) {
                        JOptionPane.showMessageDialog(null, "대여중인 책은 수정할 수 없습니다.");
                    }
                    else {
                        
                        ModelBook wherebook = new ModelBook();
                        wherebook.setB_no(Integer.parseInt(""
                                + bookif.getValueAt(bookif.getSelectedRow(), 0)));
                        ModelBook setbook = new ModelBook();
                        setbook.setB_no(b_no);
                        setbook.setTitle(title);
                        setbook.setPublisher(publisher);
                        setbook.setGenre(genre);
                        setbook.setAuthor(author);
                        setbook.setSal(sal);
                        setbook.setRent_if(rent_if);
                        
                        try {
                            svr.updateBook(wherebook, setbook);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        
                        
                        ////// 알림창 띄우기
                        JOptionPane.showMessageDialog(null, "수정완료완료");
                        
                        /// 새로고침 데이터 새로 불러오기.
                        try {
                            refreshTable_book_if(bookif);
                            refreshTable_personsif(personsif);
                            refreshTable_rentif(rentif);
                            refreshTable_rentif_total(rentif_total);
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                        /////////////////////////////////////
                        
                    }
                    
                    
                    
                }
            });
            button_3.setBounds(294, 248, 90, 49);
        }
        return button_3;
    }
    
    private JButton getButton_4() {
        if (button_4 == null) {
            button_4 = new JButton("삭제");
            button_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 대여중인 책은 삭제 불가.
                    if ("대여불가".equals(
                            bookif.getValueAt(bookif.getSelectedRow(), 6))) {
                        
                        JOptionPane.showMessageDialog(null,
                                "대여중인 책은 삭제할 수 없습니다.");
                    } else {
                        
                        // 책 목록 삭제 하기.
                        
                        ModelBook book = new ModelBook();
                        book.setTitle("" + bookif
                                .getValueAt(bookif.getSelectedRow(), 1));
                        try {
                            svr.deletBook(book);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        
                        // 새로고침 데이터 새로 불러오기.
                        try {
                            refreshTable_book_if(bookif);
                            refreshTable_personsif(personsif);
                            refreshTable_rentif(rentif);
                            refreshTable_rentif_total(rentif_total);
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                    }
                    /////////////////////////////////////
                    
                }
            });
            button_4.setBounds(386, 248, 90, 49);
        }
        return button_4;
    }
    
    private JButton getButton_5() {
        if (button_5 == null) {
            button_5 = new JButton("취소");
            button_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 취소버튼 누르면 검색이전 전체 테이블 목록
                    try {
                        refreshTable_book_if(bookif);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                }
            });
            button_5.setBounds(480, 248, 97, 49);
        }
        return button_5;
    }
    
    private JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(12, 307, 785, 296);
            scrollPane_1.setViewportView(getBookif());
        }
        return scrollPane_1;
    }
    
    protected JTable getBookif() {
        if (bookif == null) {
            bookif = new JTable();
            bookif.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // 테이블의 책정보를 텍스트 필드에 불러옴
                    Object no = bookif.getValueAt(bookif.getSelectedRow(), 0);
                    Object title = bookif.getValueAt(bookif.getSelectedRow(),
                            1);
                    Object publisher = bookif
                            .getValueAt(bookif.getSelectedRow(), 2);
                    Object genre = bookif.getValueAt(bookif.getSelectedRow(),
                            3);
                    Object author = bookif.getValueAt(bookif.getSelectedRow(),
                            4);
                    Object sal = bookif.getValueAt(bookif.getSelectedRow(), 5);
                    
                    textField_bookid.setText("" + no);
                    textField_title.setText((String) title);
                    textField_publisher.setText((String) publisher);
                    textField_genre.setText((String) genre);
                    textField_author.setText((String) author);
                    textField_sal.setText("" + sal);
                    
                }
            });
            bookif.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "No", "\uC81C\uBAA9", "\uCD9C\uD310\uC0AC",
                            "\uC7A5\uB974", "\uC800\uC790", "\uAC00\uACA9",
                            "\uB300\uC5EC\uC815\uBCF4" }) {
                Class[] columnTypes = new Class[] { Integer.class, String.class,
                        String.class, String.class, String.class, Integer.class,
                        String.class };
                
                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return bookif;
    }
    
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
            btnNewButton_3 = new JButton("반납완료");
            btnNewButton_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    // 반납목록을 삭제 한다.
                    
                    ModelRent rent = new ModelRent();
                    rent.setRent_no(Integer.parseInt("" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 0)));
                    
                    try {
                        svrr.deletRent(rent);
                    } catch (SQLException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    
                    // 반납완료 알림창
                    JOptionPane.showMessageDialog(null, "반납완료");
                    
                    // 반납 완료후 대여불가-> 대여가능
                    Integer b_no = Integer.parseInt("" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 9));
                    String title = "" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 5);
                    String publisher = "" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 6);
                    String genre = "" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 7);
                    String author = "" + rentif_total
                            .getValueAt(rentif_total.getSelectedRow(), 8);
                    
                    Mbook = new ModelBook();
                    Mbook.setTitle(title);// sal은 rentif_total에 없으므로
                    Integer sal = null;
                    try {
                        java.sql.ResultSet rs = svr.selectEqual(Mbook);
                        rs.next();
                        sal = rs.getInt("sal");
                    } catch (SQLException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    String rent_if = "대여가능";
                    
                    ModelBook wherebook = new ModelBook();
                    wherebook.setB_no(b_no);
                    ModelBook setbook = new ModelBook();
                    setbook.setB_no(b_no);
                    setbook.setTitle(title);
                    setbook.setPublisher(publisher);
                    setbook.setGenre(genre);
                    setbook.setAuthor(author);
                    setbook.setSal(sal);
                    setbook.setRent_if(rent_if);
                    try {
                        svr.updateBook(wherebook, setbook);
                    } catch (SQLException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    /// 새로고침 데이터 새로 불러오기.
                    try {
                        refreshTable_book_if(bookif);
                        refreshTable_personsif(personsif);
                        refreshTable_rentif(rentif);
                        refreshTable_rentif_total(rentif_total);
                        
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                    /////////////////////////////////////
                }
            });
            btnNewButton_3.setBounds(440, 22, 115, 52);
        }
        return btnNewButton_3;
    }
    
    private JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
            scrollPane_2 = new JScrollPane();
            scrollPane_2.setBounds(12, 96, 785, 507);
            scrollPane_2.setViewportView(getRentif_total());
        }
        return scrollPane_2;
    }
    
    private JTable getRentif_total() {
        if (rentif_total == null) {
            rentif_total = new JTable();
            rentif_total.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "NO", "\uC774\uB984",
                            "\uC804\uD654\uBC88\uD638",
                            "\uC8FC\uBBFC\uBC88\uD638",
                            "\uBA54\uC77C\uC8FC\uC18C", "\uCC45 \uC81C\uBAA9",
                            "\uCD9C\uD310\uC0AC", "\uC7A5\uB974",
                            "\uC800\uC790", "\uCC45\uBC88\uD638",
                            "\uB300\uC5EC\uB0A0\uC9DC" }) {
                Class[] columnTypes = new Class[] { Integer.class, String.class,
                        String.class, String.class, String.class, String.class,
                        Object.class, String.class, String.class, Integer.class,
                        String.class };
                
                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return rentif_total;
    }
    
    private JTextField getTextField_name() {
        if (textField_name == null) {
            textField_name = new JTextField();
            textField_name.setBounds(85, 49, 91, 21);
            textField_name.setColumns(10);
        }
        return textField_name;
    }
    
    private JTextField getTextField_no() {
        if (textField_no == null) {
            textField_no = new JTextField();
            textField_no.setEditable(false);
            textField_no.setColumns(10);
            textField_no.setBounds(188, 49, 60, 21);
        }
        return textField_no;
    }
    
    private JTextField getTextField_pid1() {
        if (textField_pid1 == null) {
            textField_pid1 = new JTextField();
            textField_pid1.setColumns(10);
            textField_pid1.setBounds(85, 80, 91, 21);
        }
        return textField_pid1;
    }
    
    private JTextField getTextField_phone1() {
        if (textField_phone1 == null) {
            textField_phone1 = new JTextField();
            textField_phone1.setColumns(10);
            textField_phone1.setBounds(85, 111, 91, 21);
        }
        return textField_phone1;
    }
    
    private JTextField getTextField_email1() {
        if (textField_email1 == null) {
            textField_email1 = new JTextField();
            textField_email1.setColumns(10);
            textField_email1.setBounds(85, 142, 91, 21);
        }
        return textField_email1;
    }
    
    private JTextField getTextField_phone2() {
        if (textField_phone2 == null) {
            textField_phone2 = new JTextField();
            textField_phone2.setColumns(10);
            textField_phone2.setBounds(188, 111, 116, 21);
        }
        return textField_phone2;
    }
    
    private JTextField getTextField_email2() {
        if (textField_email2 == null) {
            textField_email2 = new JTextField();
            textField_email2.setColumns(10);
            textField_email2.setBounds(188, 142, 116, 21);
        }
        return textField_email2;
    }
    
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
            lblNewLabel_1 = new JLabel("이름");
            lblNewLabel_1.setBounds(16, 52, 57, 15);
        }
        return lblNewLabel_1;
    }
    
    private JLabel getLabel_6() {
        if (label_6 == null) {
            label_6 = new JLabel("주민번호");
            label_6.setBounds(16, 83, 57, 15);
        }
        return label_6;
    }
    
    private JLabel getLabel_7() {
        if (label_7 == null) {
            label_7 = new JLabel("전화번호");
            label_7.setBounds(16, 114, 57, 15);
        }
        return label_7;
    }
    
    private JLabel getLabel_8() {
        if (label_8 == null) {
            label_8 = new JLabel("메일주소");
            label_8.setBounds(16, 145, 57, 15);
        }
        return label_8;
    }
    
    private JTextField getTextField_searchp() {
        if (textField_searchp == null) {
            textField_searchp = new JTextField();
            textField_searchp.setColumns(10);
            textField_searchp.setBounds(188, 175, 180, 21);
        }
        return textField_searchp;
    }
    
    private JButton getBtnNewButton_4() {
        if (btnNewButton_4 == null) {
            btnNewButton_4 = new JButton("회원삭제");
            btnNewButton_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /// 회원정보 삭제
                    ModelPerson person = new ModelPerson();
                    person.setName("" + personsif
                            .getValueAt(personsif.getSelectedRow(), 1));
                    try {
                        svrp.deletperson(person);
                    } catch (SQLException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    
                    // 새로고침 데이터 새로 불러오기.
                    try {
                        refreshTable_book_if(bookif);
                        refreshTable_personsif(personsif);
                        refreshTable_rentif(rentif);
                        refreshTable_rentif_total(rentif_total);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                }
            });
            btnNewButton_4.setBounds(16, 215, 91, 48);
        }
        return btnNewButton_4;
    }
    
    private JComboBox getComboBox_ps() {
        if (comboBox_ps == null) {
            comboBox_ps = new JComboBox();
            comboBox_ps.setModel(new DefaultComboBoxModel(
                    new String[] { "회원번호", "이름", "" }));
            comboBox_ps.setBounds(85, 175, 91, 21);
        }
        return comboBox_ps;
    }
    
    private JButton getBtnNewButton_5() {
        if (btnNewButton_5 == null) {
            btnNewButton_5 = new JButton("검색");// 사람검색
            btnNewButton_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 회원 검색////////
                    
                    String search1 = (String) comboBox_ps.getSelectedItem();
                    
                    String search2 = textField_searchp.getText();
                    
                    if (search1 == "회원번호") {
                        
                        Object[] tempObject = new Object[5];
                        DefaultTableModel model = (DefaultTableModel) personsif
                                .getModel();
                        model.setRowCount(0);
                        
                        svrp = new ServicePerson();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svrp.selectAll();
                            for (int i = 0; i <= svrp.getCount(MPerson); i++) {
                                rs.next();// result set에서 다음 row로
                                Integer p_no = rs.getInt("p_no");
                                
                                if (/* search2!="" || */p_no == (Integer
                                        .parseInt(search2))) {
                                    
                                    p_no = rs.getInt("p_no");
                                    String name = rs.getString("Name");
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
                                
                                personsif.setModel(model);
                                
                            }
                        } catch (NumberFormatException | SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                    } else if (search1 == "이름") {
                        
                        Object[] tempObject = new Object[5];
                        DefaultTableModel model = (DefaultTableModel) personsif
                                .getModel();
                        model.setRowCount(0);
                        
                        svrp = new ServicePerson();
                        java.sql.ResultSet rs;
                        
                        try {
                            rs = svrp.selectAll();
                            for (int i = 0; i <= svrp.getCount(MPerson); i++) {
                                rs.next();// result set에서 다음 row로
                                String name = rs.getString("Name");
                                
                                if (/* search2!="" || */name.equals(search2)) {
                                    
                                    Integer p_no = rs.getInt("p_no");
                                    name = rs.getString("Name");
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
                                
                                personsif.setModel(model);
                                
                            }
                        } catch (NumberFormatException | SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                    }
                    
                    ////////////////////////////////////////////////////////
                    
                }
            });
            btnNewButton_5.setBounds(394, 174, 60, 23);
        }
        return btnNewButton_5;
    }
    
    private JTextField getTextField_phone3() {
        if (textField_phone3 == null) {
            textField_phone3 = new JTextField();
            textField_phone3.setColumns(10);
            textField_phone3.setBounds(316, 111, 116, 21);
        }
        return textField_phone3;
    }
    
    private JLabel getLabel_9() {
        if (label_9 == null) {
            label_9 = new JLabel("-");
            label_9.setBounds(176, 83, 13, 15);
        }
        return label_9;
    }
    
    private JLabel getLabel_10() {
        if (label_10 == null) {
            label_10 = new JLabel("-");
            label_10.setBounds(176, 114, 13, 15);
        }
        return label_10;
    }
    
    private JLabel getLabel_11() {
        if (label_11 == null) {
            label_11 = new JLabel("@");
            label_11.setBounds(176, 145, 13, 15);
        }
        return label_11;
    }
    
    private JScrollPane getScrollPane_3() {
        if (scrollPane_3 == null) {
            scrollPane_3 = new JScrollPane();
            scrollPane_3.setBounds(16, 273, 781, 330);
            scrollPane_3.setViewportView(getPersonsif());
        }
        return scrollPane_3;
    }
    
    private JButton getButton_6() {
        if (button_6 == null) {
            button_6 = new JButton("회원수정");
            button_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 회원 정보 수정하기
                    
                    Integer p_no = Integer.parseInt(textField_no.getText());
                    String name = textField_name.getText();
                    String pid = textField_pid1.getText()
                            + textField_pid2.getText();
                    String phone = textField_phone1.getText()
                            + textField_phone2.getText()
                            + textField_phone3.getText();
                    String email = textField_email1.getText()
                            + textField_email2.getText();
                    
                    ModelPerson whereperson = new ModelPerson();
                    whereperson.setP_no(Integer.parseInt("" + personsif
                            .getValueAt(personsif.getSelectedRow(), 0)));
                    ModelPerson setperson = new ModelPerson();
                    setperson.setP_no(p_no);
                    ;
                    setperson.setPid(pid);
                    setperson.setPhone(phone);
                    setperson.setEmail(email);
                    
                    try {
                        svrp.updateperson(whereperson, setperson);
                    } catch (SQLException e2) {
                        
                        e2.printStackTrace();
                    }
                    
                    ////// 알림창 띄우기
                    JOptionPane.showMessageDialog(null, "수정완료완료");
                    
                    /// 새로고침 데이터 새로 불러오기.
                    try {
                        refreshTable_book_if(bookif);
                        refreshTable_personsif(personsif);
                        refreshTable_rentif(rentif);
                        refreshTable_rentif_total(rentif_total);
                    } catch (SQLException e1) {
                        
                        e1.printStackTrace();
                    }
                    /////////////////////////////////////////////////////////////////
                    
                }
            });
            button_6.setBounds(132, 215, 91, 48);
        }
        return button_6;
    }
    
    private JButton getButton_7() {
        if (button_7 == null) {
            button_7 = new JButton("취소");
            button_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 검색 테이블 초기화
                    try {
                        refreshTable_personsif(personsif);
                    } catch (SQLException e1) {
                        
                        e1.printStackTrace();
                    }
                    
                }
            });
            button_7.setBounds(250, 215, 91, 48);
        }
        return button_7;
    }
    
    private JTable getPersonsif() {
        if (personsif == null) {
            personsif = new JTable();
            personsif.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ///////////// 사람정보 텍스트 필드에 불러옴
                    Integer no = (Integer) personsif
                            .getValueAt(personsif.getSelectedRow(), 0);
                    String name = (String) personsif
                            .getValueAt(personsif.getSelectedRow(), 1);
                    String pid = (String) personsif
                            .getValueAt(personsif.getSelectedRow(), 2);
                    String phone = (String) personsif
                            .getValueAt(personsif.getSelectedRow(), 3);
                    String email = (String) personsif
                            .getValueAt(personsif.getSelectedRow(), 4);
                    // 주민번호 전화번호 이메일 분리
                    
                    String[] pids = pid.split("-");
                    String[] phones = phone.split("-");
                    String[] emails = email.split("@");
                    
                    textField_no.setText("" + no);
                    textField_name.setText(name);
                    textField_pid1.setText(pids[0]);
                    textField_pid2.setText(pids[1]);
                    textField_phone1.setText(phones[0]);
                    textField_phone2.setText(phones[1]);
                    textField_phone3.setText(phones[2]);
                    textField_email1.setText(emails[0]);
                    textField_email2.setText(emails[1]);
                    
                }
            });
            personsif.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984",
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
        return personsif;
    }
    
    private JLabel getLabel_13() {
        if (label_13 == null) {
            label_13 = new JLabel("검색");
            label_13.setBounds(16, 178, 57, 15);
        }
        return label_13;
    }
    
    private JLabel getLabel_12_1() {
        if (label_12 == null) {
            label_12 = new JLabel("-");
            label_12.setBounds(307, 114, 13, 15);
        }
        return label_12;
    }
    
    private JPasswordField getTextField_pid2() {
        if (textField_pid2 == null) {
            textField_pid2 = new JPasswordField();
            textField_pid2.setBounds(188, 80, 116, 21);
        }
        return textField_pid2;
    }
    
    private JLabel getLabel_12() {
        if (label_12 == null) {
            label_12 = new JLabel("-");
            label_12.setBounds(176, 52, 13, 15);
        }
        return label_12;
    }
    
    private JLabel getLabel_13_1() {
        if (label_13 == null) {
            label_13 = new JLabel("검색");
            label_13.setBounds(16, 178, 57, 15);
        }
        return label_13;
    }
}
