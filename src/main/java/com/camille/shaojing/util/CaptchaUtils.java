package com.camille.shaojing.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CaptchaUtils {
	
	private static final Random rn=new Random();
	
	private static final char[] codeSequence = { 
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	/**
	 * 生成图形验证码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/captcha.jpg",method = RequestMethod.GET)
	public void generateVerifyCodeImg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应方式为图片类型
		response.setContentType("image/jpeg");
		//设置为无缓存
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "No-cache");
	    response.setDateHeader("Expires", 0L);
	    response.reset();
		OutputStream os = response.getOutputStream();
	    int width = 80;
	    int height = 30;
	    BufferedImage image = new BufferedImage(width, height, 1);
	    Graphics g = image.getGraphics();
	    g.setColor(getRandColor(200, 250));
	    g.fillRect(0, 0, width, height);
	    g.setFont(new Font("Arial", 0, 25));
	    g.setColor(getRandColor(160, 200));
	    //生成160条干扰线
	    for (int i = 0; i < 160; ++i) {
	    	int x=rn.nextInt(width + 100);
		    int y=rn.nextInt(height + 100);
		    int xl=rn.nextInt(10);
		    int yl=rn.nextInt(12);
		    g.drawOval(x, y, x + xl, y + yl);
	    }
	    String content = "";
	    for (int i = 0; i < 4; ++i){
	      String rand = String.valueOf(codeSequence[rn.nextInt(codeSequence.length)]);
	      content = content + rand;
	      g.setColor(new Color(20 + rn.nextInt(110), 20 + rn
	        .nextInt(110), 20 + rn.nextInt(110)));
	      g.drawString(rand, 14 * i + 5, 25);
	    }
	    HttpSession session = request.getSession();
		session.setAttribute("checkCode", content);
	    g.dispose();
	    ImageIO.write(image, "JPEG", os);
		os.close();
		
	}
	/**
	 * 获取验证码的颜色
	 * @param fc
	 * @param bc
	 * @return
	 */
	 private Color getRandColor(int fc, int bc) {
		  if (fc > 255)
		    fc = 255;
		  if (bc > 255)
		    bc = 255;
		  int r = fc + rn.nextInt(bc - fc);
		  int g = fc + rn.nextInt(bc - fc);
		  int b = fc + rn.nextInt(bc - fc);
		  return new Color(r, g, b);    
	 }
	 /**
	 * 图形校验
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/verifyCodeCheck",method = RequestMethod.POST)
	public void verifyCodeCheck(@RequestBody Map<String, Object> map,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		Object checkCode = map.get("checkCode");
		String sessionCheckCode = (String) request.getSession().getAttribute("checkCode");
		if(checkCode!=null&&!"".equals(checkCode)&&checkCode.toString().equalsIgnoreCase(sessionCheckCode)) {
			
		}else {
			result.put("success", false);
			result.put("message",  "校验码错误");
		}
	}
}
