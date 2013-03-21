import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyWindowApp  extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -9210644035014991364L;
    private JLabel countLabel;
    private JButton Forward;
    private JButton Back;
    private JButton Left;
    private JButton Right;
    private JButton Light;
    
    public MyWindowApp(){
        super("My First Window"); //��������� ����
        setBounds(200, 200, 300, 200); //���� �� ��������� ������ � ��������� - �� ���� ����� ������ � ����������
        //�������������� ���������� �������
        countLabel = new JLabel("Controls");
        Forward = new JButton("Forward");
        Back = new JButton("Back");
        Left = new JButton("Left");
        Right = new JButton("Right");
        Light = new JButton("Light");
     
        //�������������� ��������� ����������
        JPanel buttonsPanel = new JPanel(new FlowLayout()); 
        JPanel buttonsPanelForward = new JPanel(new FlowLayout()); 
        //����������� ���������� �� ������
        add(countLabel, BorderLayout.NORTH); //���������� �����������
     
        buttonsPanelForward.add(Forward);
        buttonsPanel.add(Back);
        buttonsPanel.add(Left);
        buttonsPanel.add(Right);
        buttonsPanel.add(Light);
     
        add(buttonsPanelForward, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.AFTER_LAST_LINE);
      }
    
     
      public static void main(String[] args) { //��� ������� ����� ���� � � ������ ������
        MyWindowApp app = new MyWindowApp(); //������� ��������� ������ ����������
        app.setVisible(true); //� ����� ������� ���������� ��������!
      }

}
