 package random;

import javax.swing.JFrame;
  

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JLabel;
    import javax.swing.JPanel;

      class TimeFrame extends JPanel{
    JLabel time = new JLabel("Time goes here", JLabel.CENTER);
   projectTimer t = new projectTimer();
    JButton pause = new JButton ("Pause");
     JButton start = new JButton ("Start");
    public TimeFrame(){

         start.addActionListener(new starts());
         pause.addActionListener(new starts());
         add(time);
         add(start);
         add(pause);
    }
    public void update(String sec,int s, String min,String mil,int m){
        if (s<=10){
            sec="0"+sec;
        }
        System.out.println(min+":"+sec+","+mil);
        time.setText(min+":"+sec+","+mil);

    }
    public class starts implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == start){
                t.shouldCount=true;
            }else{
                t.shouldCount=false;
            }
            t.count();
        }
    }
     
}

class projectTimer {
boolean shouldCount=false;
int int_sec=0;
int int_min=0;
int int_mil=0;
public void count(){
    TimeFrame t = new TimeFrame();
    if(shouldCount){
        long now = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis()-now>=100){
                now=System.currentTimeMillis();
                String sec = Integer.toString(int_sec);
                String min = Integer.toString(int_min);
                String mil = Integer.toString(int_mil);
                t.update(sec,int_sec,min,mil,int_mil);
                int_mil++;
                if(int_mil>9){
                    int_mil=0;
                    int_sec++;
                    if(int_sec>=60){
                        int_sec=1;
                        int_min++;
                    }
                }
            }
        }
    }
}
public static void main(String[] args) {
    TimeFrame t = new TimeFrame();
    JFrame f = new JFrame("Timer");
    f.setSize(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    f.getContentPane().add(t);
    f.setVisible(true);
}


}
