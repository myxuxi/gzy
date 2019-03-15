
import java.awt.Container;
import javax.swing.JFrame;

public class BoxFrame2 extends JFrame {
	public BoxFrame2() {
		// 默认的窗体名称
		setTitle("2.5D推箱子游戏");
		// 获得我们自定义面板[PushBox面板]的实例
		//PushBox_manmove panel = new PushBox_manmove();
		PushBox panel = new PushBox();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		setSize(750, 700);
	}
	public static void main(String[] args) {
		BoxFrame2 e1 = new BoxFrame2();
		// 设定允许窗体关闭操作
		e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 显示窗体
		e1.setVisible(true);
	}
}

