package com.super2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ��Ϸ����
 * 
 * @author ����į��ʱ��
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
	private static final String TITLE = "����2048";
	private static final Color TEXT_COLOR = new Color(119, 110, 101);
	private static final Font BIG_FONT = new Font(Font.DIALOG, Font.BOLD, 52);
	private static final Font SMALL_FONT = new Font(Font.DIALOG, Font.PLAIN, 15);

	private JPanel headPanel = new JPanel();
	private DisplayValueBoard scoreBoard = new DisplayValueBoard("�÷�", "0");
	private DisplayValueBoard stepBoard = new DisplayValueBoard("����", "0");
	private JButton startButton = new JButton("��ʼ��Ϸ");

	private GameController gameController = new GameController(scoreBoard, stepBoard);
	private JPanel gamePanel = new GameContainer(gameController);

	/**
	 * ������Ϸ�ķ���
	 */
	public void run() {
		// ���ñ���
		this.setTitle(TITLE);
		// ����ͼ��
		try {
			this.setIconImage(ResourcesLoader.loadImage("images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "ò�Ƴ������أ�", "�����ˣ�", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		headPanel.setLayout(new GridBagLayout());
		// ��д����
		JLabel title = new JLabel(TITLE);
		title.setFont(BIG_FONT);
		title.setForeground(TEXT_COLOR);
		headPanel.add(title, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		// ��д�Ʒְ�
		headPanel.add(scoreBoard, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ��д�Ʋ���
		headPanel.add(stepBoard, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ��д��ͬ˵��
		JLabel differenceText = new JLabel("���������2048��ͬ����������256����");
		differenceText.setFont(SMALL_FONT);
		differenceText.setForeground(TEXT_COLOR);
		headPanel.add(differenceText, new GridBagConstraints(0, 1, 4, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ��д��Ϸ˵��
		JLabel instructionText = new JLabel("ʹ���������϶����ϲ�����ֱ��2048");
		instructionText.setFont(SMALL_FONT);
		instructionText.setForeground(TEXT_COLOR);
		headPanel.add(instructionText, new GridBagConstraints(0, 2, 4, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ��д����
		JLabel authorText = new JLabel("by��@����į��ʱ��");
		authorText.setFont(SMALL_FONT);
		authorText.setForeground(TEXT_COLOR);
		headPanel.add(authorText, new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ��д��ʼ��ť
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.this.gameController.newGame();
				GUI.this.gamePanel.repaint();
			}
		});
		headPanel.add(startButton, new GridBagConstraints(1, 3, 2, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		// ���ͷ�����
		this.getContentPane().add(headPanel, BorderLayout.NORTH);
		// �����Ϸ�������
		this.getContentPane().add(gamePanel, BorderLayout.CENTER);
		// ��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = this.getPreferredSize();
		this.setSize(dimension.width + 50, dimension.height + 50);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// ��ʾ����
		this.setVisible(true);
		// �µ���Ϸ
		gameController.newGame();
	}
}
