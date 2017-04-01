package test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 面板
 * 
 * @author LY
 *
 */
public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Piece> piecesList = new ArrayList<>();
	private Piece piece;
	/**
	 * 读取图片
	 */
	private BufferedImage image;

	/*
	 * 构造方法
	 */
	public Panel() {
		try {
			image = ImageIO.read(new File("res/wu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 注册一个监听器
		addMouseListener(new PanelListener());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 画背景
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);// getWidth()和getHeight()是设置最大范围为自己的panel大小，这样比较合适
		// 画棋子
		for (Piece piece : piecesList) {
			// g.fillOval(piece.getX(), piece.getY(), 30, 30);
			piece.draw(g);
			// 设置抗锯齿
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
	}

	/**
	 * 面板中鼠标事件的监听（适配器模式）
	 * 
	 * @author LY
	 *
	 */
	class PanelListener extends MouseAdapter {
		boolean isWhite = true;

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			System.out.printf("(%d,%d)\n", e.getX(), e.getY());
			piece = new Piece(e.getX(), e.getY(), isWhite);
			System.out.println(piece);
			piecesList.add(piece);
			isWhite = !isWhite;
			// 重绘
			repaint();
		}
	}

}
