import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyLabel extends Label implements Runnable {

	int value;
	boolean stop = false;

	public MyLabel() {
		super("number");
		value = 0;
	}

	@Override
	public void run() {

		while (true) {
			value = (int) (Math.random() * 10);
			setText(Integer.toString(value));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (stop) {
				break;
			}
		}
	}

}

public class p3 extends Frame {

	MyLabel x[] = new MyLabel[6];

	public p3(String title) {
		super(title);
		Panel disp = new Panel();
		disp.setLayout(new FlowLayout());
		for (int i = 0; i < 6; i++) {
			x[i] = new MyLabel();
			disp.add(x[i]);
			new Thread(x[i]).start();
		}
		add("Center", disp);
		Button control = new Button("Í£Ö¹");
		add("South", control);
		pack();
		setVisible(true);
		control.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 6; i++) {
					x[i].stop = true;
				}
			}
		});
	}

	public static void main(String[] args) {
		new p3("Ñ¡ºÅ³ÌÐò");
	}
}
