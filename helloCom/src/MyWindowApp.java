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
        super("My First Window"); //Заголовок окна
        setBounds(200, 200, 300, 200); //Если не выставить размер и положение - то окно будет мелкое и незаметное
        //Подготавливаем компоненты объекта
        countLabel = new JLabel("Controls");
        Forward = new JButton("Forward");
        Back = new JButton("Back");
        Left = new JButton("Left");
        Right = new JButton("Right");
        Light = new JButton("Light");
     
        //Подготавливаем временные компоненты
        JPanel buttonsPanel = new JPanel(new FlowLayout()); 
        JPanel buttonsPanelForward = new JPanel(new FlowLayout()); 
        //Расставляем компоненты по местам
        add(countLabel, BorderLayout.NORTH); //Размещение компонентов
     
        buttonsPanelForward.add(Forward);
        buttonsPanel.add(Back);
        buttonsPanel.add(Left);
        buttonsPanel.add(Right);
        buttonsPanel.add(Light);
     
        add(buttonsPanelForward, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.AFTER_LAST_LINE);
      }
    
     
      public static void main(String[] args) { //эта функция может быть и в другом классе
        MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //С этого момента приложение запущено!
      }

}
