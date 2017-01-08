package com.super2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * ����������
 * 
 * @author ����į��ʱ��
 *
 */
public class BlockGenerator {
	private static final Font FONT = new Font(Font.DIALOG, Font.BOLD, 20);

	private static final Color NULL_BLOCK_COLOR = new Color(205, 193, 180);
	private static final Color $2_BLOCK_COLOR = new Color(238, 228, 218);
	private static final Color $4_BLOCK_COLOR = new Color(237, 224, 200);
	private static final Color $8_BLOCK_COLOR = new Color(242, 177, 121);
	private static final Color $16_BLOCK_COLOR = new Color(245, 149, 99);
	private static final Color $32_BLOCK_COLOR = new Color(246, 124, 95);
	private static final Color $64_BLOCK_COLOR = new Color(246, 94, 59);
	private static final Color $128_BLOCK_COLOR = new Color(237, 207, 114);
	private static final Color $256_BLOCK_COLOR = new Color(237, 204, 97);
	private static final Color $512_BLOCK_COLOR = new Color(237, 200, 80);
	private static final Color $1024_BLOCK_COLOR = new Color(237, 197, 63);
	private static final Color $2048_BLOCK_COLOR = new Color(237, 194, 46);

	private static final Color $2_TEXT_COLOR = new Color(119, 110, 101);
	private static final Color $4_TEXT_COLOR = new Color(119, 110, 101);
	private static final Color $8TO2048_TEXT_COLOR = new Color(249, 246, 242);

	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;

	/**
	 * ����ȼ�ö����
	 * 
	 * @author ����į��ʱ��
	 *
	 */
	public enum Level {
		// ��Ϊ���ֲ��ܿ�ͷ���Ҿ���$����
		NULL, $2, $4, $8, $16, $32, $64, $128, $256, $512, $1024, $2048;
		/**
		 * ���صȼ�ö������Ӧ������
		 * 
		 * @param level
		 *            �ȼ�ö����
		 * @return ��Ӧ������
		 */
		public static int getValue(BlockGenerator.Level level) {
			switch (level) {
			case NULL:
				return 0;
			case $2:
				return 2;
			case $4:
				return 4;
			case $8:
				return 8;
			case $16:
				return 16;
			case $32:
				return 32;
			case $64:
				return 64;
			case $128:
				return 128;
			case $256:
				return 256;
			case $512:
				return 512;
			case $1024:
				return 1024;
			case $2048:
				return 2048;
			default:
				return 0;
			}
		}

		/**
		 * �������ֶ�Ӧ�ĵȼ�ö����
		 * 
		 * @param value
		 *            ��Ӧ������
		 * @return �ȼ�ö����
		 */
		public static BlockGenerator.Level toEnum(int value) {
			switch (value) {
			case 0:
				return NULL;
			case 2:
				return $2;
			case 4:
				return $4;
			case 8:
				return $8;
			case 16:
				return $16;
			case 32:
				return $32;
			case 64:
				return $64;
			case 128:
				return $128;
			case 256:
				return $256;
			case 512:
				return $512;
			case 1024:
				return $1024;
			case 2048:
				return $2048;
			default:
				return NULL;
			}
		}
	}

	/**
	 * ���ݵȼ�ö�������ɷ���ͼ��
	 * 
	 * @param level
	 *            �ȼ�ö����
	 * @return ����ͼ��
	 */
	public static Image generateBlockImage(BlockGenerator.Level level) {
		Color backgroundColor = generateBlockColor(level);
		Color textColor = generateTextColor(level);
		String text = generateText(level);
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(backgroundColor);
		graphics2d.fillRoundRect(0, 0, WIDTH, WIDTH, 5, 5);
		if (level != BlockGenerator.Level.NULL) {
			FontMetrics fontMetrics = graphics2d.getFontMetrics(FONT);
			int x = (WIDTH - fontMetrics.stringWidth(text)) / 2;
			int y = (HEIGHT - (fontMetrics.getAscent() + fontMetrics.getDescent())) / 2 + fontMetrics.getAscent();
			graphics2d.setFont(FONT);
			graphics2d.setColor(textColor);
			graphics2d.drawString(text, x, y);
		}
		graphics2d.dispose();
		return image;
	}

	/**
	 * ���ݵȼ�ö�������ɷ��鱳����ɫ
	 * 
	 * @param level
	 *            �ȼ�ö����
	 * @return ���鱳����ɫ
	 */
	private static Color generateBlockColor(BlockGenerator.Level level) {
		switch (level) {
		case NULL:
			return NULL_BLOCK_COLOR;
		case $2:
			return $2_BLOCK_COLOR;
		case $4:
			return $4_BLOCK_COLOR;
		case $8:
			return $8_BLOCK_COLOR;
		case $16:
			return $16_BLOCK_COLOR;
		case $32:
			return $32_BLOCK_COLOR;
		case $64:
			return $64_BLOCK_COLOR;
		case $128:
			return $128_BLOCK_COLOR;
		case $256:
			return $256_BLOCK_COLOR;
		case $512:
			return $512_BLOCK_COLOR;
		case $1024:
			return $1024_BLOCK_COLOR;
		case $2048:
			return $2048_BLOCK_COLOR;
		default:
			return null;
		}
	}

	/**
	 * ���ݵȼ�ö�������ɷ���������ɫ
	 * 
	 * @param level
	 *            �ȼ�ö����
	 * @return ����������ɫ
	 */
	private static Color generateTextColor(BlockGenerator.Level level) {
		switch (level) {
		case NULL:
			return null;
		case $2:
			return $2_TEXT_COLOR;
		case $4:
			return $4_TEXT_COLOR;
		case $8:
			return $8TO2048_TEXT_COLOR;
		case $16:
			return $8TO2048_TEXT_COLOR;
		case $32:
			return $8TO2048_TEXT_COLOR;
		case $64:
			return $8TO2048_TEXT_COLOR;
		case $128:
			return $8TO2048_TEXT_COLOR;
		case $256:
			return $8TO2048_TEXT_COLOR;
		case $512:
			return $8TO2048_TEXT_COLOR;
		case $1024:
			return $8TO2048_TEXT_COLOR;
		case $2048:
			return $8TO2048_TEXT_COLOR;
		default:
			return null;
		}
	}

	/**
	 * ���ݵȼ�ö�������ɷ�������
	 * 
	 * @param level
	 *            �ȼ�ö����
	 * @return ��������
	 */
	private static String generateText(BlockGenerator.Level level) {
		return String.valueOf(BlockGenerator.Level.getValue(level));
	}
}
