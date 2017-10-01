package com.financing.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081500253280";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDbhxWViVk6PJtU1gV2DfIygbIyBOwpWMrAVyWI6GjNjctRegP8GPFDUvT41up0RjR8zWXl5dOT8x6SkRep8Pk/jCsujFl657zX1TzqkcbFtU7A3ZLhLDY0mJ+/mLJa8u70W/ZHaXrN7sqpF00b9vEuJ8tbWlqZm9SeyIHsh5zDjlMjR3U0bfHYGAO92ALImJWNyubvdYZ5zHLAQXvXBsK/YnQCSPuQ3RSz7Kscs9uEQQ51Dxie54PHYSG7PJpVKiajV/liJvqCyRl1ivo8xr5mdIbJvo5NMi+Uvkev+3LOJEEArmVTIa0VLCpta9ysdqmaKgiC/H1ka6LNk3h6+2HAgMBAAECggEAPkhi82MVi3F82OQjHQ7+uI9Mkb+G3TIzAYE+sAOoqKCbmz/CjjMcBJidc4cNvDbTrUK1BeaXlEvqmZUyOy0DfzQaOvBtUmBLTgfCSUpLMgIrADFO0NDLwaRJeubwR4Vm4dWJTHlpVENv1fBYHu5XVi0reaqcxwhN/udNJBp7pYfJ9cgNo8vAtbwfr5DunHWLBdejJ82hWi4alvZ+8MKWdo7BtRB52uCvnMxxKcWWn5RoQsSYbSSI6tkNEQlyoeVmdw5/mIdUm8lhjuUV9mhd3WE5647Vu7Gp+4+6xKFWh5LdYRjAjeBCQbTOkjtkZzGGvlhi5cbW7HbAWqn3phuXWQKBgQDeb+pMj6txC8M0WV4kjSzFcdflkPuGwlNsuAst66l9sAINyS+epPfcYZEalcrmYmcjgbZy7QeIbIfnRWF0AXkBV39x/bvA8JF39GpSpvvOGUNIgM5oahMsJCWqVBlfLEZrAIZlsvH53fuTkY65xpKd0KIU2auk6nh8ni4+kPMmbQKBgQCXQt1MI+C+Ql7RYtnlg+jXMwEKat1nML26ZiFsw4wLVMHU1lrrIf0XnvrWc9xKbyOFDGKBqDBaH0zFvHmzNxWfbWo+mFbVEDnOAYKf/5VKNSxdRB5ySKtxrfh30EeW2RirAUihiy++XoU6N1oVzn7bG7L/FQZoAN8kR8y7qIz7QwKBgQCFJxtrT0mCd1cX/DNF0Biv7PEfZAWdarBD0Xwntf2U1oq0M+3Emt4g12rkLizyco9pCtnrvAYZXVaRU8/9gHAuJHGPDCObYKbD1tTau0ja2/aR7UEh8fWeI9lEN+mkNj3FCeBp+o+tUnupn6V/geX8gIq1zoNYSl9rwcjO/TgAlQKBgEQfrSM5lWKa6bFL3+7qdddV9UYH0ydCYHCuxqcBevUvewysbc4wRJh61WX4UGKFo22sokDayswMBLuZowX/7REcahk+6vySjjYln/sHVOlTAWQP5dZ6vBw6ygjMGTHrHJ0HuvpmgV4vm7kYbM4dbiyoUPlpMrVsjxL7800hID2ZAoGBAISxMx2RJ7JsGKDcN7ps+nML94H0pkUF01Lba8TpEcIzhit6Lr5GjDxMj89HD888tfYoiMMFDPh649qTmLnAbKThqYgsGtugsxs6PYU3XEslSCMd3dX2yEgrcUPIOvvDzaLHcaewpkGocf/wimEdw6j4hBm14dNuAoAoDjOTO6fM";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。

    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw7hq4M764Nb2IkFIDuNhJKx9HsJNNsSqT09h1NkI3Mavp9nt8cNGfApeVwL+u2XeKx282RjdRr4ERPind6kOuDW9ZrB+xfq8cChaqp8vow2BjP4g3A/5tjO7rIeSlZnTQ7jyWfujLQUrdU03oOFt07Rw0Q7ezM2zMDF46jJFAE4y3/iwsdkY0d52+yXbCAfULD7yhbVrhAHeNTuogYIuNFNa28k9QAreLKWFRoDIq2jIrI/R8QiwIP/rtyMGHJCUpvL6V81FgPEEUTjd8gw8ALavzQaZbcEtqf7e4qxFx5DEmOHGAkYOWlFuUVPz9dRKv/4R5ZPaRBZJTTewZhxloQIDAQAB";

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	/*public static String app_id ="2016081500253280"; 
		
	public static String merchant_private_key  ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDbhxWViVk6PJtU1gV2DfIygbIyBOwpWMrAVyWI6GjNjctRegP8GPFDUvT41up0RjR8zWXl5dOT8x6SkRep8Pk/jCsujFl657zX1TzqkcbFtU7A3ZLhLDY0mJ+/mLJa8u70W/ZHaXrN7sqpF00b9vEuJ8tbWlqZm9SeyIHsh5zDjlMjR3U0bfHYGAO92ALImJWNyubvdYZ5zHLAQXvXBsK/YnQCSPuQ3RSz7Kscs9uEQQ51Dxie54PHYSG7PJpVKiajV/liJvqCyRl1ivo8xr5mdIbJvo5NMi+Uvkev+3LOJEEArmVTIa0VLCpta9ysdqmaKgiC/H1ka6LNk3h6+2HAgMBAAECggEAPkhi82MVi3F82OQjHQ7+uI9Mkb+G3TIzAYE+sAOoqKCbmz/CjjMcBJidc4cNvDbTrUK1BeaXlEvqmZUyOy0DfzQaOvBtUmBLTgfCSUpLMgIrADFO0NDLwaRJeubwR4Vm4dWJTHlpVENv1fBYHu5XVi0reaqcxwhN/udNJBp7pYfJ9cgNo8vAtbwfr5DunHWLBdejJ82hWi4alvZ+8MKWdo7BtRB52uCvnMxxKcWWn5RoQsSYbSSI6tkNEQlyoeVmdw5/mIdUm8lhjuUV9mhd3WE5647Vu7Gp+4+6xKFWh5LdYRjAjeBCQbTOkjtkZzGGvlhi5cbW7HbAWqn3phuXWQKBgQDeb+pMj6txC8M0WV4kjSzFcdflkPuGwlNsuAst66l9sAINyS+epPfcYZEalcrmYmcjgbZy7QeIbIfnRWF0AXkBV39x/bvA8JF39GpSpvvOGUNIgM5oahMsJCWqVBlfLEZrAIZlsvH53fuTkY65xpKd0KIU2auk6nh8ni4+kPMmbQKBgQCXQt1MI+C+Ql7RYtnlg+jXMwEKat1nML26ZiFsw4wLVMHU1lrrIf0XnvrWc9xKbyOFDGKBqDBaH0zFvHmzNxWfbWo+mFbVEDnOAYKf/5VKNSxdRB5ySKtxrfh30EeW2RirAUihiy++XoU6N1oVzn7bG7L/FQZoAN8kR8y7qIz7QwKBgQCFJxtrT0mCd1cX/DNF0Biv7PEfZAWdarBD0Xwntf2U1oq0M+3Emt4g12rkLizyco9pCtnrvAYZXVaRU8/9gHAuJHGPDCObYKbD1tTau0ja2/aR7UEh8fWeI9lEN+mkNj3FCeBp+o+tUnupn6V/geX8gIq1zoNYSl9rwcjO/TgAlQKBgEQfrSM5lWKa6bFL3+7qdddV9UYH0ydCYHCuxqcBevUvewysbc4wRJh61WX4UGKFo22sokDayswMBLuZowX/7REcahk+6vySjjYln/sHVOlTAWQP5dZ6vBw6ygjMGTHrHJ0HuvpmgV4vm7kYbM4dbiyoUPlpMrVsjxL7800hID2ZAoGBAISxMx2RJ7JsGKDcN7ps+nML94H0pkUF01Lba8TpEcIzhit6Lr5GjDxMj89HD888tfYoiMMFDPh649qTmLnAbKThqYgsGtugsxs6PYU3XEslSCMd3dX2yEgrcUPIOvvDzaLHcaewpkGocf/wimEdw6j4hBm14dNuAoAoDjOTO6fM";
	// 商户私钥，您的PKCS8格式RSA2私钥
	 
 // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
  public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg24cVlYlZOjybVNYFdg3yMoGyMgTsKVjKwFcliOhozY3LUXoD/BjxQ1L0+NbqdEY0fM1l5eXTk/MekpEXqfD5P4wrLoxZeue819U86pHGxbVOwN2S4Sw2NJifv5iyWvLu9Fv2R2l6ze7KqRdNG/bxLifLW1pamZvUnsiB7Iecw45TI0d1NG3x2BgDvdgCyJiVjcrm73WGecxywEF71wbCv2J0Akj7kN0Us+yrHLPbhEEOdQ8YnueDx2EhuzyaVSomo1f5Yib6gskZdYr6PMa+ZnSGyb6OTTIvlL5Hr/tyziRBAK5lUyGtFSwqbWvcrHapmioIgvx9ZGuizZN4evthwIDAQAB";
  */
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 	public static String notify_url ="http://localhost:8080/FinancingProject/MemberController/ok";

 	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 	public static String return_url ="http://localhost:8080/FinancingProject/MemberController/ok";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "G:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

