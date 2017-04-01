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
	 * 棋盘 面板
	 */
	private Panel panel;

	/**
	 * 构造方法
	 */
	public AppFrame() {
		initUi();
		setVisible(true);
	}
	/**
	 * 初始化用户接口
	 */
	private void initUi() {
		setTitle("五子棋");
		setSize(506, 529);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		panel = new Panel();
		add(panel);
	}

}
