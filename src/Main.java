import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class Main {
    JFrame frame = new JFrame("Радиокнопки");
    JPanel panel = new JPanel();
    ButtonGroup bg = new ButtonGroup();
    JRadioButton rb1 = new JRadioButton ("Лето");
    JRadioButton rb2 = new JRadioButton ("Осень");
    JRadioButton rb3 = new JRadioButton ("Зима");
    JRadioButton rb4 = new JRadioButton ("Весна");
    JButton button = new JButton("Ответ");
    JLabel label = new JLabel();
    int width = 170, height = 300;

    public Main () {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2 - width/2, dim.height/2 - height/2, width,height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        panel.add(Box.createVerticalStrut(10));
        addComponent(rb1);
        addComponent(rb2);
        addComponent(rb3);
        addComponent(rb4);
        addComponent(button);
        addComponent(label);
        button.addActionListener(actionEvent -> {
            //label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setText(getNameSelectedRadio());
        });
        frame.setVisible(true);
    }

    void addComponent (JComponent c) {
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createHorizontalStrut(40));
        panel.add(c);
        panel.add(Box.createVerticalStrut(10));
    }

    String getNameSelectedRadio () {
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "<html> <font color='red'><b> Выберите время года</b></font></html>";
    }

    public static void main(String[] args) {
        new Main();
    }
}
