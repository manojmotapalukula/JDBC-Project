import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB2 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JButton insertButton;

    public DB2() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        connectDb();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void connectDb(){
        //register driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // establish connection

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Manoj@85");
                System.out.println("Database connected Successfully");
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DB2 dialog = new DB2();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
