import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnAdd = new Button("Add");
    private Button btnExit = new Button("Exit");
    private Button btnSub = new Button("Sub");
    private Button btnStop = new Button("Stop");
    private Label lab = new Label("@_@");
    private Timer t1;
    private boolean flag=true;
    private int labx = 50, laby = 50,colorR=255,colorG=255,colorB=255;
    public MainFrame() {
        init();
    }

    public void init() {
        this.setLayout(null);
        setBounds(100, 100, 500, 400);
        this.add(lab);
        lab.setBounds(50, 50, 100, 30);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.add(btnAdd);
        btnAdd.setBounds(100, 200, 50, 30);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                flag=true;
            }
        });

        this.add(btnSub);
        btnSub.setBounds(175, 200, 50, 30);
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                flag=false;
            }
        });

        this.add(btnExit);
        btnExit.setBounds(250, 200, 50, 30);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(btnStop);
        btnStop.setBounds(325, 200, 50, 30);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
            }
        });

        t1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag){
                    labx+=5;
                    lab.setLocation(labx, laby);
                    colorB-=0.1; colorG-=0.1;  colorB-=0.1;
                    lab.setForeground(new Color(colorR,colorG,colorB));
                    if(labx>MainFrame.this.getWidth()){
                        flag=false;
                    }
                }
                else if(!flag){
                    labx-=5;
                    colorB+=0.1; colorG+=0.1;  colorB+=0.1;
                    lab.setForeground(new Color(colorR,colorG,colorB));
                    lab.setLocation(labx, laby);
                    if(labx<0){
                        flag=true;
                    }
                }

            }
        });
    }
}
