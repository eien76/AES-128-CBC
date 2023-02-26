import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Dec {
	
	public static String decrypt(String cipherText, String key,String iv)
	        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
	        InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		
			byte[] keyByte = HexStringToByteArray(key);	    
			SecretKeySpec secretKey = new SecretKeySpec(keyByte,"AES");
	        IvParameterSpec ivparameterspec = new IvParameterSpec(HexStringToByteArray(iv));
	        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
	        byte[] plainText = cipher.doFinal(HexStringToByteArray(cipherText));
	        return new String(plainText);
	        
	    }
	public static byte[] HexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
}
