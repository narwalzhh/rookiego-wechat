package com.rookiego.wechat.ctrl;

import com.rookiego.wechat.utils.WeChatSHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>类名称:</b>ReceiveWeChatController<br/>
 * <b>类注释:</b>微信服务器验证|接收微信服务器转发的消息<br/>
 * <b>类描述:</b><br/>
 * <b>创建人:</b>rookie<br/>
 * <b>修改人:</b>rookie<br/>
 * <b>修改时间:</b>2017年07月20日 23时23分45秒<br/>
 * <b>修改备注:</b><br/>
 *
 * @version 1.0.0<br/>
 */
@Controller
public class ReceiveWeChatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveWeChatController.class);

    private static final String TOKEN = "token";

    /**
     * @param httpServletRequest
     * @return java.lang.String
     * @Title validateWeChatMessage
     * @Description 微信服务器验证
     * @author rookie
     */
    @ResponseBody
    @RequestMapping(value = "receiveWeChat", method = RequestMethod.GET)
    public String validateWeChatMessage(HttpServletRequest httpServletRequest) throws Exception {
        String signature = httpServletRequest.getParameter("signature");
        String timestamp = httpServletRequest.getParameter("timestamp");
        String nonce = httpServletRequest.getParameter("nonce");
        String echostr = httpServletRequest.getParameter("echostr");

        String securitySignature = WeChatSHA1.getSHA1(TOKEN, timestamp, nonce);

        LOGGER.info(String.format("%s--%s--%s", "ReceiveWeChatController.validateWeChatMessage", securitySignature, signature));

        if (signature.equals(securitySignature)) {
            return echostr;
        }

        return null;
    }

    /**
     * @param httpServletRequest
     * @return java.lang.String
     * @Title receiveWeChatMessage
     * @Description 接收微信服务器转发的消息
     * @author rookie
     */
    @ResponseBody
    @RequestMapping(value = "receiveWeChat", method = RequestMethod.POST)
    public String receiveWeChatMessage(HttpServletRequest httpServletRequest) {

        return "";
    }

}
