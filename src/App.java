import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class App {

    private JFrame frame;
    private JTable table;
    private JTextField txname;
    private JTextField txemail;
    private JTextField txaddress;
    private ButtonGroup radiogender;
    private JRadioButton r1;
    private JRadioButton r2;
    private JComboBox course;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getSelectedOption() {
        Enumeration<AbstractButton> radioButtons = radiogender.getElements();
        while (radioButtons.hasMoreElements()) {
            AbstractButton currentRadioButton = radioButtons.nextElement();
            if (currentRadioButton.isSelected()) {
                return currentRadioButton.getText();
            }
        }
        return null;
    }

    /**
     * Create the application.
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * 
     * @return
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 802, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(37, 36, 700, 232);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Name", "Email", "Gender", "Address", "Course"
                }) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        scrollPane.setViewportView(table);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbName.setBounds(37, 323, 124, 27);
        frame.getContentPane().add(lbName);

        JLabel lbemail = new JLabel("Email");
        lbemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbemail.setBounds(37, 378, 124, 27);
        frame.getContentPane().add(lbemail);

        JLabel lbgender = new JLabel("Gender");
        lbgender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbgender.setBounds(37, 431, 124, 27);
        frame.getContentPane().add(lbgender);
        // Object[]row = new Object[4];
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbaddress.setBounds(37, 485, 124, 27);
        frame.getContentPane().add(lbaddress);

        JLabel lbcourse = new JLabel("Course");
        lbcourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbcourse.setBounds(37, 539, 124, 27);
        frame.getContentPane().add(lbcourse);

        JButton btADD = new JButton("ADD");
        btADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // row[0] = txage.getText() ;
                // row[1] = txfirst.getText() ;
                // row[2] = txlast.getText() ;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[] { txname.getText(), txemail.getText(), getSelectedOption(),
                        txaddress.getText(), course.getItemAt(course.getSelectedIndex()) });

            }
        });
        btADD.setBounds(30, 603, 181, 37);
        frame.getContentPane().add(btADD);

        JButton btDELETE = new JButton("DELETE");
        btDELETE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int i = table.getSelectedRow();
                if (i >= 0) {
                    model.removeRow(i);
                } else {
                    JOptionPane.showConfirmDialog(btDELETE, "DELETE ERROR");
                }

            }
        });
        btDELETE.setBounds(300, 603, 181, 37);
        frame.getContentPane().add(btDELETE);

        JButton btUPDATE = new JButton("UPDATE");
        btUPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int i = table.getSelectedRow();
                if (i >= 0) {
                    model.removeRow(i);
                    model.insertRow(i, new Object[] { txname.getText(), txemail.getText(), getSelectedOption(),
                            txaddress.getText(), course.getItemAt(course.getSelectedIndex()) });
                } else {
                    JOptionPane.showConfirmDialog(btUPDATE, "UPDATE ERROR");
                }
            }
        });
        btUPDATE.setBounds(570, 603, 181, 37);
        frame.getContentPane().add(btUPDATE);

        txname = new JTextField();
        txname.setBounds(122, 323, 327, 27);
        frame.getContentPane().add(txname);
        txname.setColumns(10);

        txemail = new JTextField();
        txemail.setColumns(10);
        txemail.setBounds(122, 377, 327, 27);
        frame.getContentPane().add(txemail);

        radiogender = new ButtonGroup();
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBounds(122, 431, 80, 27);
        r2.setBounds(222, 431, 100, 27);
        radiogender.add(r1);
        radiogender.add(r2);
        frame.getContentPane().add(r1);
        frame.getContentPane().add(r2);

        String subject_course[] = { "EE351", "EE352", "EE353", "EE354", "EE355" };
        course = new JComboBox(subject_course);
        course.setBounds(122, 539, 80, 27);
        frame.getContentPane().add(course);

        txaddress = new JTextField();
        txaddress.setColumns(10);
        txaddress.setBounds(122, 485, 327, 27);
        frame.getContentPane().add(txaddress);

    }
}
