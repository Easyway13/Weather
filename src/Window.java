
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Window extends JFrame {

    private String city;
    private static String text;
    private JList cityList;
    private JScrollPane jsp;
    private JTextArea textArea;
    private String[] cities = {"Київ","Дніпро", "Львів", "Одеса", "Харків"};

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }


    public static void setText(String text) {
        Window.text = text;
    }

    Window(){
        JFrame frame = new JFrame("Weather forecast");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();


        cityList = new JList(cities);
        cityList.setSelectedIndex(0);
        jsp = new JScrollPane(cityList);

        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        frame.add(jsp, c);


        textArea = new JTextArea(20, 10);
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 80;
        c.gridheight = 10;
        c.anchor = GridBagConstraints.PAGE_START;
        frame.add(textArea,c);

        frame.setVisible(true);

        cityList.addMouseListener(new MouseEventListener());


    }

    class MouseEventListener implements MouseListener{

        @Override
        public void mousePressed(MouseEvent e) {

            int selected_value = cityList.getSelectedIndex();
            String txt = cities[selected_value];
            GetSetDataFromSite.setMousePressed(true);
            GetSetDataFromSite.setCity(txt.toLowerCase());
            System.out.println(txt);

            GetSetDataFromSite connect = new GetSetDataFromSite();

            while(text == null){
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }


            textArea.setText(text);
            text = null;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }





}

