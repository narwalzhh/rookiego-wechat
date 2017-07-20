package com.rookiego.wechat.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * <b>类名称:</b>WeChatSHA1<br/>
 * <b>类描述:</b>计算微信公众平台的消息签名接口<br/>
 * <b>创建人:</b>rookie<br/>
 * <b>修改人:</b>rookie<br/>
 * <b>修改时间:</b>2017年06月30日 03时26分09秒<br/>
 * <b>修改备注:</b><br/>
 *
 * @version 1.0.0<br/>
 */
public class WeChatSHA1 {

    /**
     * @param token     票据
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return java.lang.String 安全签名
     * @Title getSHA1
     * @Description 用SHA1算法生成安全签名
     * @author rookie
     */
    public static String getSHA1(String token, String timestamp, String nonce) throws Exception {
        try {
            String[] array = new String[]{token, timestamp, nonce};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 3; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
