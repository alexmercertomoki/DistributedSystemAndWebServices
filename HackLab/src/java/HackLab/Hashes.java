
package HackLab;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;


public class Hashes {

    /** 
     * Text to be encoded
     */
    private String text;
    
    /**
     * Encoding method
     */
    private String method;
    
    /** 
     * Hexadecimal hash
     */
    private String hexHash;
    
    /** 
     * base64 hash
     */
    private String base64Hash;
    
    /**
     * The hash byte for the hash operation
     */
    private byte[] hashByte;

    /**
     * Store any error that occured while performing the hash operation
     */
    private String error;
    /**
     * Constructor 
     * @param text
     * @param method 
     */
    public Hashes(String text, String method) {
        this.text = text;
        this.method = method;
        this.doByteEncode();
    }

    /**
     * Method that performs the hash operation
     */
    private void doByteEncode() {
        // Perform the hash encoding
        try {
            MessageDigest md = MessageDigest.getInstance(this.method);
            md.update(text.getBytes());
            this.hashByte = md.digest();
        } catch (NoSuchAlgorithmException e) {
            // If the encoding method is not recognized, return an error
            this.error = "Encode method not recognized";
        }
    }

    /**
     * Returns the hexademical String based on the hashByte that was generated
     * @return 
     */
    public String getHexString() {
        try {
            String hexString = this.byteToHexString(hashByte);
            return hexString.toUpperCase();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Returns the base64 encoding string
     * @return 
     */
    public String getBase64String() {
        BASE64Encoder encoder = new BASE64Encoder();
        hexHash = encoder.encode(hashByte);
        return hexHash;
    }

    // From the web site "Real's How To" to convert byte to hexadecimal string 
    private String byteToHexString(byte[] b) throws Exception {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

}
