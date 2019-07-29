package org.java.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.util.UUID;

@Controller
public class ForwardController {


    /**
     * 退款，返回退款结果
     * @param map
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("refundOrder")
    @ResponseBody
    public boolean refundOrder(@RequestParam Map<String,Object> map){

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016100100641462","MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCfTmASss7qw3iQDG3l5mja0zAV1YsYjPBcVYc4LN1a2IDoxy993yJLFA8dsfD3OX30/9m2d+h0d7ksSu+dRJRkOWMjl7cywzHDX/4pInTwg9gnPGx/8JRnAjN8DOCxwzS+MV2i1ixTmX4+tt7+erhu4GR5eXvQVgMGz7hcgMrLBCEB9f9KSPN0Hfo91O8Nlqiv+wvKCyWKTo8WdCDUpt6Uy7Le3haXWZ6UQk6dyeS+hAHu3hJH3o9uXyVYGZvOuPmhzz7GU8JTpN3Xzq68H8UU7cQtFkv09IdU/8SgbTkDgA0ykPlIvQDCQyV6NTMWdbwTCjk9OalsxPMfeOMJ6JHJAgMBAAECggEAd/xfDhZRFK8vUkeaSos1NIPV9swE3PPiYZklpGDeQ/tHdIv5sDNsr+Gm1PXeCUbrIKnHf9Bma7p05PB38xrhLW+vxPITUI+GHqJhWvgR3clf94ViLyazj7YvsuI8JodhZVLnNKtdbYXxeSjhYghqe1BVPM0MPUlbNDklob57f1YlrmUdVth+gyZezjGRddFC69/aCMo0j1R8rJ1bME1c1RoQ6F8n62YEi1sCpeoO3uLunrYoY3LPYf3RmzmLPgFy7ErXu4uV3h8abybg4cK6RMS1ZPFZQmig06SDnsuNJxX1l7ZUDG9pWA0AEB3gJI1BeB831n4PLRwbVkMX8UFg0QKBgQDh0ja+NSagiL3VWqLAOYhw6yzvtptUs4Rn2lSwTkG3Cslzvb/cSSvuzV+De/ZpH05a21myCL5ZVaBva92cImJghf12J6vn1/X2et5ebXl5ifpI0trScBBYnEPNYiXi2ZLtY+huXjx5kS5h8GGm+V+Nh6sbnJe+SDlMKVxHqLgiBQKBgQC0mI1w/l3+0g/bAtyMgZG2UDVVKxm8vUnZjzT1XOrnGjLCTxLJChE+0AVxaO0lTpMGGI8vA+hoZkC86zo6T8ZvdtRcco4Z9vi86s142v4L+3pa/Jhpar4hKcxvoXxzFZhwa1jAwYsqkp4h2wCZZLpVKilZineEaCcD6cV3TABn9QKBgF+0Vq0QG5nHuiR08CrldzTcBsRlMLmaB1B4UJIT6Hfp42zhCzIR9MOVWJiB7fGpaezJr97rI7j6uC7gmSA11lmwD7aGo61zcnOOqTV90hC3cFJywniTM+pJ99ZQdVwJ9+ISCIzV9W1UIUMyvEAmyd9Skyr1l732IApuMQTRtY/9AoGAbeZwHJUPCmU29OaW5IJs8+93pS6naO4gJN87MR2sbZrJzOll2yXfPMRGq69YsV1Rp2IGsGvGYNHpD45uTtIBRg+gR+oGg9KBqCWTiLpr40rUOM6CyZQFxBS1rjEtlLNNowwQZKzjTbMPvDaT9MURh4Yyx6S1+sOPCpiWbHS5wokCgYBPVypNBsQlg81z7Bj9mtGPX7FnCZT/7IEpSXnZPxSXUPVExwXhL8S1lWJcYkp/BxsQBctw1NQejEH5V5cJCPuHOK8C27wVH0JlUEDW6nGcH8mcr3rEAHvH/vWrtprX8NY/4vZvhWKU2cUcYnUp/ixg6EQzpp4gANJIJze7x9pqGQ==","json","GBK","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqOpYq5Sr6DrNo8oKHoPECcYOnl6FZ+pQ83u1hhZxMFh65J/5lnkvKjXiCVa0KmjChD2OQpwdnjAQk4xJnJ9cMozih3C/Wfws5U/XR52+Lh4XuWL6AzpP9zS65fsNjEMABkuaFlynmc67JLHFEkXyNyE3CwYYruqlGRARH8/wyrwfk7zx7UOpOyXSZMwnuc7kwB6GXJ4NVSun2FRxDGvo544LHKK+8SCAYf/CtYJ5r0tICI0FbOQQ7auoz5ivp6IRDF8y4dbnT9OgeNYhPmt/LusxPWf2OBBXP93P2wYZzkmmfpPZe3AjP8A4UD9geP5o5j8fuIMeTrgsUWSwCkcznwIDAQAB","RSA2");
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        //商家订单号
        String out_trade_no = map.get("order_id").toString();
        //支付宝交易号
//        String trade_no = "2019071722001427761002192484";
        //退款金额
        double refund_amount = Double.parseDouble(map.get("refund_amount").toString());

        //随机数，部分退款时必须要写得参数
        String out_request_no = RandomStringUtils.randomAlphanumeric(13);

        request.setBizContent("{" +
                "\"out_trade_no\":\"" + out_trade_no + "\"," +
                "\"refund_amount\":\"" + refund_amount + "\"," +
                "\"refund_reason\":\"正常退款\"," +
                "\"out_request_no\":\""+out_request_no+"\"" +
                " }");
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response.isSuccess();
    }


    /**
     * 转账到目标用户
     * @param appOrderNO 订单号
     * @param payee_account 目标支付宝账户
     * @param amount 转账金额
     * @param remark 转账备注
     * @return
     */
    @RequestMapping("transAccount")
    @ResponseBody
    public boolean transAccount(String appOrderNO,String payee_account,Double amount,String remark){
        String payer_show_name = "苏车保车险";               //付款方姓名（可选）
        String payee_real_name = "沙箱环境";               //收款方真是姓名（可选）
        String payee_type = "ALIPAY_LOGONID";//收款方账户类型，当前为支付宝登录号，支持邮箱和手机号格式。

        /*初始化客户端参数*/
        String appId = "2016100100641462";
        String CHARSET = "UTF-8";
        String ALIPAY_URL = "https://openapi.alipaydev.com/gateway.do";//支付宝网关，当前为沙箱环境
        //商户私钥
        String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCfTmASss7qw3iQDG3l5mja0zAV1YsYjPBcVYc4LN1a2IDoxy993yJLFA8dsfD3OX30/9m2d+h0d7ksSu+dRJRkOWMjl7cywzHDX/4pInTwg9gnPGx/8JRnAjN8DOCxwzS+MV2i1ixTmX4+tt7+erhu4GR5eXvQVgMGz7hcgMrLBCEB9f9KSPN0Hfo91O8Nlqiv+wvKCyWKTo8WdCDUpt6Uy7Le3haXWZ6UQk6dyeS+hAHu3hJH3o9uXyVYGZvOuPmhzz7GU8JTpN3Xzq68H8UU7cQtFkv09IdU/8SgbTkDgA0ykPlIvQDCQyV6NTMWdbwTCjk9OalsxPMfeOMJ6JHJAgMBAAECggEAd/xfDhZRFK8vUkeaSos1NIPV9swE3PPiYZklpGDeQ/tHdIv5sDNsr+Gm1PXeCUbrIKnHf9Bma7p05PB38xrhLW+vxPITUI+GHqJhWvgR3clf94ViLyazj7YvsuI8JodhZVLnNKtdbYXxeSjhYghqe1BVPM0MPUlbNDklob57f1YlrmUdVth+gyZezjGRddFC69/aCMo0j1R8rJ1bME1c1RoQ6F8n62YEi1sCpeoO3uLunrYoY3LPYf3RmzmLPgFy7ErXu4uV3h8abybg4cK6RMS1ZPFZQmig06SDnsuNJxX1l7ZUDG9pWA0AEB3gJI1BeB831n4PLRwbVkMX8UFg0QKBgQDh0ja+NSagiL3VWqLAOYhw6yzvtptUs4Rn2lSwTkG3Cslzvb/cSSvuzV+De/ZpH05a21myCL5ZVaBva92cImJghf12J6vn1/X2et5ebXl5ifpI0trScBBYnEPNYiXi2ZLtY+huXjx5kS5h8GGm+V+Nh6sbnJe+SDlMKVxHqLgiBQKBgQC0mI1w/l3+0g/bAtyMgZG2UDVVKxm8vUnZjzT1XOrnGjLCTxLJChE+0AVxaO0lTpMGGI8vA+hoZkC86zo6T8ZvdtRcco4Z9vi86s142v4L+3pa/Jhpar4hKcxvoXxzFZhwa1jAwYsqkp4h2wCZZLpVKilZineEaCcD6cV3TABn9QKBgF+0Vq0QG5nHuiR08CrldzTcBsRlMLmaB1B4UJIT6Hfp42zhCzIR9MOVWJiB7fGpaezJr97rI7j6uC7gmSA11lmwD7aGo61zcnOOqTV90hC3cFJywniTM+pJ99ZQdVwJ9+ISCIzV9W1UIUMyvEAmyd9Skyr1l732IApuMQTRtY/9AoGAbeZwHJUPCmU29OaW5IJs8+93pS6naO4gJN87MR2sbZrJzOll2yXfPMRGq69YsV1Rp2IGsGvGYNHpD45uTtIBRg+gR+oGg9KBqCWTiLpr40rUOM6CyZQFxBS1rjEtlLNNowwQZKzjTbMPvDaT9MURh4Yyx6S1+sOPCpiWbHS5wokCgYBPVypNBsQlg81z7Bj9mtGPX7FnCZT/7IEpSXnZPxSXUPVExwXhL8S1lWJcYkp/BxsQBctw1NQejEH5V5cJCPuHOK8C27wVH0JlUEDW6nGcH8mcr3rEAHvH/vWrtprX8NY/4vZvhWKU2cUcYnUp/ixg6EQzpp4gANJIJze7x9pqGQ==";
        //支付宝公钥
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqOpYq5Sr6DrNo8oKHoPECcYOnl6FZ+pQ83u1hhZxMFh65J/5lnkvKjXiCVa0KmjChD2OQpwdnjAQk4xJnJ9cMozih3C/Wfws5U/XR52+Lh4XuWL6AzpP9zS65fsNjEMABkuaFlynmc67JLHFEkXyNyE3CwYYruqlGRARH8/wyrwfk7zx7UOpOyXSZMwnuc7kwB6GXJ4NVSun2FRxDGvo544LHKK+8SCAYf/CtYJ5r0tICI0FbOQQ7auoz5ivp6IRDF8y4dbnT9OgeNYhPmt/LusxPWf2OBBXP93P2wYZzkmmfpPZe3AjP8A4UD9geP5o5j8fuIMeTrgsUWSwCkcznwIDAQAB";

        //初始化客户端
        DefaultAlipayClient alipayClien = new DefaultAlipayClient(ALIPAY_URL, appId, APP_PRIVATE_KEY, "JSON", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化提现请求
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();
        model.setOutBizNo(appOrderNO);
        model.setAmount(amount.doubleValue() + "");
        model.setPayeeType(payee_type);
        model.setPayeeAccount(payee_account);
        model.setPayeeRealName(payee_real_name);
        model.setPayerShowName(payer_show_name);
        model.setRemark(remark);
        //绑定参数model
        request.setBizModel(model);
        try {
            //执行请求
            AlipayFundTransToaccountTransferResponse response = alipayClien.execute(request);
            return response.getCode().equals("10000");
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
    }
}
