
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.Dialog;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.Label;
import javax.swing.JFileChooser;
import java.io.File;

public class note1 {
    public static void main(String[] args) {
        Frame frm = new Frame("NOTE BOOK");
        frm.setBounds(0, 0, 600, 500);

        final JFileChooser fc = new JFileChooser();
        

        TextArea ta = new TextArea();
        frm.add(ta);

        Menu menu1 = new Menu("File");
        MenuItem item1 = new MenuItem("Save");
        MenuItem item2 = new MenuItem("Open");
        menu1.add(item1);
        menu1.add(item2);

        Menu menu2 = new Menu("Edit");

        MenuItem itemy = new MenuItem("Clear");

        Dialog Dcheck = new Dialog(frm, "conform save as");
        Dcheck.setBounds(0, 0, 400, 300);

        Label Dlbl = new Label();
        Dlbl.setBounds(40, 40, 180, 100);

        Button Dbt1 = new Button("ok");
        Dbt1.setBounds(50, 240, 30, 30);

        Button Dbt2 = new Button("cancle");
        Dbt2.setBounds(110, 240, 50, 30);

        Dcheck.add(Dlbl);
        Dcheck.add(Dbt1);
        Dcheck.add(Dbt2);

        menu2.add(itemy);
        itemy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ta.getText();
                ta.setText("");
            }
        });

        MenuBar menubar = new MenuBar();
        menubar.add(menu1);
        menubar.add(menu2);
        frm.setMenuBar(menubar);

        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int returnval = fc.showSaveDialog(frm);
                if (returnval == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        FileReader fr = new FileReader(file.getAbsolutePath());
                        BufferedReader br = new BufferedReader(fr);

                        Dcheck.setVisible(true);
                        Dlbl.setText("DO you want to replace press ok");

                        Dbt1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String data = ta.getText();
                                    FileWriter fw = new FileWriter(file);
                                    fw.write(data);
                                    fw.close();
                                    Dcheck.setVisible(false);
                                } catch (IOException ee) {
                                }
                            }
                        });

                        Dbt2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Dcheck.setVisible(false);
                            }
                        });

                        br.close();
                        fr.close();
                    } catch (IOException ex) {
                        try {
                            String data = ta.getText();
                            FileWriter fw = new FileWriter(file);
                            fw.write(data);
                            fw.close();
                        } catch (IOException ee) {
                        }
                    }
                }
            }
        });
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int returnVal = fc.showOpenDialog(frm);

                // fc.showSaveDialog(parent)

                try {
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();

                        FileReader fr = new FileReader(file.getAbsolutePath());
                        BufferedReader br = new BufferedReader(fr);
                        String st;
                        String data = "";
                        while ((st = br.readLine()) != null) {
                            data = data + st;
                        }
                        ta.setText(data);
                        fr.close();
                    }
                } catch (IOException ex) {
                    System.out.println("ioexception");
                }
            }
        });

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        Dcheck.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {

                Dcheck.setVisible(false);
            }
        });

        Dcheck.setLayout(null);
        frm.setVisible(true);
    }
} 