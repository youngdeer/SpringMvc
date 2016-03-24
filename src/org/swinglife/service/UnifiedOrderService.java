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
     * ����֧������
     * @param scanPayReqData ������ݶ������������APIҪ���ύ�ĸ��������ֶ�
     * @return API���ص�����
     * @throws Exception
     */
    public String request(UnifiedOrder unifiedOrder) throws Exception {

        //--------------------------------------------------------------------
        //����HTTPS��Post����API��ַ
        //--------------------------------------------------------------------
        String responseString = sendPost(unifiedOrder);

        return responseString;
    }
}
