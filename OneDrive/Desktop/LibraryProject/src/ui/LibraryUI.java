package ui;

import dao.LibraryDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LibraryUI extends JFrame implements ActionListener {

    JButton add, view, issue, exit;
    LibraryDao dao = new LibraryDao();

    public LibraryUI() {
        setTitle("Library System");
        setSize(400, 300);
        setLayout(new GridLayout(5,1));

        add = new JButton("Add Book");
        view = new JButton("View Books");
        issue = new JButton("Issue Book");
        exit = new JButton("Exit");

        add(add); add(view); add(issue); add(exit);

        add.addActionListener(this);
        view.addActionListener(this);
        issue.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            String t = JOptionPane.showInputDialog("Title");
            String a = JOptionPane.showInputDialog("Author");
            int q = Integer.parseInt(JOptionPane.showInputDialog("Quantity"));
            dao.addBook(t,a,q);
        }

        if(e.getSource()==view){
            System.out.println("VIEW BUTTON CLICKED");
    String data = dao.getBooks();

    JTextArea area = new JTextArea(data);
    area.setEditable(false);

    JOptionPane.showMessageDialog(this, new JScrollPane(area));
}

        if(e.getSource()==issue){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Book ID"));
            String name = JOptionPane.showInputDialog("User Name");
            dao.issueBook(id,name);
        }

        if(e.getSource()==exit){
            System.exit(0);
        }
    }
}
