package com.super2048;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Դ������
 * 
 * @author ����į��ʱ��
 *
 */
public class ResourcesLoader {
	private static final ClassLoader LOADER = ResourcesLoader.class.getClassLoader();

	/**
	 * �����ļ�
	 * 
	 * @param path
	 *            ·��
	 * @return URL
	 * @throws FileNotFoundException
	 *             ����ļ�������
	 */
	public static URL load(String path) throws FileNotFoundException {
		URL url = LOADER.getResource(path);
		if (url != null) {
			return url;
		} else {
			throw new FileNotFoundException(path + "�ļ�������");
		}
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ·��
	 * @return ͼƬ
	 * @throws IOException
	 *             ����ļ������ڻ���IO�쳣
	 */
	public static Image loadImage(String path) throws IOException {
		URL url = load(path);
		return ImageIO.read(url);
	}
}
