package org.dbserver.sicredi.provaSicredi.auxi;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class ScreenShot {

	public static String captureToBase64() {
	    Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenCapture = null;
	    String base64Encoded = "";

	    try {
	        screenCapture = new Robot().createScreenCapture(screenSize);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(screenCapture, "png", baos);
	        baos.flush();
	        byte[] encodeBase64 = Base64.encodeBase64(baos.toByteArray());
	        base64Encoded = new String(encodeBase64);
	        baos.close();
	    } catch (AWTException | IOException e) {
	        e.getMessage();
	    }

	    //return "data:image/jpeg;base64," + base64Encoded;
	    return base64Encoded;
	}

}
