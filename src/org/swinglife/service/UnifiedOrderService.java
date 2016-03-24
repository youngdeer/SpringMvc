package org.swinglife.service;

import org.swinglife.configure.WxConfigure;
import org.swinglife.form.UnifiedOrder;

public class UnifiedOrderService extends BaseService{

	public UnifiedOrderService(String api) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		super(WxConfigure.unifiedOrder_API);
		// TODO Auto-generated constructor stub
	}

	/**
     * 请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(UnifiedOrder unifiedOrder) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(unifiedOrder);

        return responseString;
    }
}
