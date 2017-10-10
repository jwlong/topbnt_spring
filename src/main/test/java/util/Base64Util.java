package util;

import java.io.UnsupportedEncodingException;

/**
 * base64 util
 */
public class Base64Util {

    /**
     *
     * @param s
     * @return
     */
    public static String encode(byte[] s) {
        if (s == null)
            return null;
        return (new sun.misc.BASE64Encoder()).encode(s);
    }

    /**
     * @param s
     * @return
     */
    public static String encodeForUrl(byte[] s){
        if (s == null)
            return null;
        String standerBase64 = encode(s);
        String encodeForUrl = standerBase64;
        encodeForUrl = encodeForUrl.replace("=", "");
        encodeForUrl = encodeForUrl.replace("+", "*");
        encodeForUrl = encodeForUrl.replace("/", "-");
        //remove \n
        encodeForUrl = encodeForUrl.replace("\n", "");
        encodeForUrl = encodeForUrl.replace("\r", "");

        //change * to  -x-
        encodeForUrl = encodeSpecialLetter1(encodeForUrl);

        return encodeForUrl;

    }

    /**
     * @param str
     * @return
     */
    private static String encodeSpecialLetter1(String str){
        str = str.replace("-x", "-xx");
        str = str.replace("*", "-x-");
        return str;
    }

    /**
     * @param str
     * @return
     */
    private static String decodeSpecialLetter1(String str){
        str = str.replace("-x-", "*");
        str = str.replace("-xx", "-x");
        return str;
    }
    /**
     * @param s
     * @return
     */
    public static String encode(String s) {

        if (s == null)
            return null;
        return encode(s.getBytes());
    }

    /**
     * @param s
     * @return
     */
    public static byte[] decode(String s) {
        if (s == null)
            return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return b;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     *
     * @param s
     * @return
     */
    public static byte[] decodeForUrl(String s) {
        if (s == null)
            return null;
        s = decodeSpecialLetter1(s);
        s = s.replace("*", "+");
        s = s.replace("-", "/");
        s += "=";
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s );
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        String headUrl = "http://192.168.99.85:8080/pds//inSession/changeProduct/NewChangeProductAction.do?param=";
        String s = "eyJzdGF0dXNTZWxlY3Rpb25SZXN1bHRGcm9tUHJvZHVjdENvZGUiOiIiLCJmb3JtVHlwZSI6IldvdmVuQXBwRm9ybUZvcm0iLCJwcm9kdWN0Q29kZSI6IlBSSERJV0gwMDgiLCJwYXR0ZXJuQ29kZSI6IkhISkNXREIiLCJhcnR3b3JrRmlsZVBhdGgiOiJEOi8vb3B0L2RhdGEvcGRzL2FydHdvcmsvUFJIRElXSDAwOC8wMDIvREgvUFJIRElXSDAwODAwMi5wZGYiLCJhZGRpbmdNZXRob2QiOiJhZGRCeVByb2R1Y3RDb2RlIiwiaXNTdGF0dXNTZWxlY3Rpb24iOnRydWUsInBhcmFtR2VuZXJhbFJlbWFya3MiOiJBY2NvcmRpbmcgdG8gRVBTTyM6IEVQUFJEWTEzMjY0Njc0PGJyPlJldmlzZSBQVE4kd28xIHRvOjxicj5zdHlsZTE8YnI-x-UmV2aXNlIEdyb3VwV08yIHRvOjxicj5zdHlsZTI8YnI-x-UmV2aXNlIEdyb3VwV08zIHRvOjxicj5zdHlsZTM8YnI-x-In0";
       // String s =  "remarks=ฉันชอบคุณ中文测试한국어 시험あなたのことが好きです";
        String s1 = encodeForUrl(s.getBytes());
        System.out.println(s1);
        String test = new String(decodeForUrl(s));
        System.out.println(test);
    }

}