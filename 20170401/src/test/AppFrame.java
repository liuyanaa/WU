package test;

import javax.swing.JFrame;

/**
 * 五子棋
 * 
 * @author LY
 *
 */
public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public AppFrame() {
		setTitle("五子棋");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

}
