package com.qunawan.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qunawan.globle.Constants;

/**
 * ����������֤��ͼƬ
 */
@WebServlet("/code.jhtml")
public class CodeAction extends HttpServlet {

	private static final long serialVersionUID = 1736370958785036518L;

	// ��֤������
	private Font[] codeFont = { new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30), new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30) };

	// ��֤��������ɫ
	private Color[] color = { Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE };

	private String codeNumbers = "";

	private final String IMAGE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private final Integer IMAGE_WIDTH = 120;
	private final Integer IMAGE_HEIGHT = 40;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ��������ͷΪgif��ͼƬ����
		response.setContentType("image/gif");

		/* �����û��棬ҳ�治ʹ�û��� */
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// ����һ��ͼ��,��֤����ʾ��ͼƬ��С
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

		// ��ȡͼ�λ��ƶ���
		Graphics g = image.getGraphics();

		// ����ͼƬ������ɫ
		g.setColor(createRandomColor(200, 250));

		// ���Ʊ���ͼƬ
		g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

		// ѭ������4λ�����
		for (int i = 0; i < 4; i++)
			drawString(g, i);

		// ��Ӹ�����
		drawNoise(g, 12);

		// �����ɵ���֤���ַ�����������
		saveCodeInSession(request);

		// �����ַ���
		codeNumbers = "";
		// ����ImageIO���write������ͼ����б���
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "GIF", sos);
		sos.close();
	}

	/**
	 * �����漴��
	 * 
	 * @param graphics
	 *            ��ͼ����
	 * @param i
	 *            ��������
	 */
	private void drawString(Graphics graphics, int i) {
		Random random = new Random();
		// �����漴�и����
		/* 0-61.9999 */
		Integer j = random.nextInt((IMAGE_CHAR.length()));
		// �и������
		String number = IMAGE_CHAR.substring(j, j + 1);
		graphics.setFont(codeFont[i]);
		graphics.setColor(color[i]);
		// ������֤�뵽ͼƬX��Y��ÿ������xÿ�β���13�ı�����y���䣬��С6*6��
		graphics.drawString(number, 20 + i * 20, 30);

		codeNumbers += number;
	}


	/**
	 * �����漴����ɫ
	 * 
	 * @param fc
	 *            ����ɫɫ���߽�
	 * @param bc
	 *            ����ɫɫ���߽�
	 * @return ����ɫ
	 */
	private Color createRandomColor(int fc, int bc) {// ������Χ��������ɫ
		// �������
		Random random = new Random();
		// �����ʼ��ֵ���ô���255
		if (fc > 255)
			fc = 255;
		// �����ʼ��ֵ���ô���255
		if (bc > 255)
			bc = 255;
		// �������������ɫ��
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}


	/**
	 * ���Ƹ�����
	 * 
	 * @param graphics
	 *            ��ͼ����
	 * @param lineNumber
	 *            ��������
	 */
	private void drawNoise(Graphics graphics, int lineNumber) {
		// ��������ɫ
		graphics.setColor(createRandomColor(160, 200));
		for (int i = 0; i < lineNumber; i++) {
			// �ߵ���ʾX��(ֻ��80,20�ķ�Χ����������ڴ��㿪ʼ������Ҫ��һ)
			int pointX1 = 1 + (int) (Math.random() * 120);
			// �ߵ���ʾY��(ֻ��80,20�ķ�Χ����������ڴ��㿪ʼ������Ҫ��һ)
			int pointY1 = 1 + (int) (Math.random() * 40);
			// �ߵ���ֹX��(ֻ��80,20�ķ�Χ����������ڴ��㿪ʼ������Ҫ��һ)
			int pointX2 = 1 + (int) (Math.random() * 120);
			// �ߵ���ֹY��(ֻ��80,20�ķ�Χ����������ڴ��㿪ʼ������Ҫ��һ)
			int pointY2 = 1 + (int) (Math.random() * 40);
			graphics.drawLine(pointX1, pointY1, pointX2, pointY2);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void saveCodeInSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		// ��֮ǰ����֤���Ƴ������µ���֤�����ݱ����session��
		session.setAttribute(Constants.CHECK_NUMBER_NAME, codeNumbers);
	}
}
