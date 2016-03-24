package org.swinglife.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.swinglife.configure.WxConfigure;
import org.swinglife.form.UnifiedOrder;
import org.swinglife.service.UnifiedOrderService;
import org.xml.sax.SAXException;

public class Signature {
	
	public static void main(String args[]) throws Exception{
		UnifiedOrder order = new UnifiedOrder();
		System.out.println(order.getSign());
		
		System.out.println(System.currentTimeMillis()/1000);
		
		UnifiedOrderService unifiedOrderService = new UnifiedOrderService(WxConfigure.unifiedOrder_API);
		System.out.println(unifiedOrderService.request(order));
		
	}
	
	/**
     * ǩ���㷨
     * @param o Ҫ����ǩ�������ݶ���
     * @return ǩ��
     * @throws IllegalAccessException
     */
    public static String getSign(Object o) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<String>();
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
                list.add(f.getName() + "=" + f.get(o) + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WxConfigure.APIKEY;
        System.out.println("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        System.out.println("Sign Result:" + result);
        return result;
    }

    public static String getSign(Map<String,Object> map){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WxConfigure.APIKEY;
        //Util.log("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }

    /**
     * ��API���ص�XML�����������¼���һ��ǩ��
     * @param responseString API���ص�XML����
     * @return ���ʳ�¯��ǩ��
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static String getSignFromResponseString(String responseString) throws IOException, SAXException, ParserConfigurationException {
        Map<String,Object> map = XMLParser.getMapFromXML(responseString);
        //����������ݶ��������Sign���ݣ����ܰ��������Ҳ�ӽ�ȥ����ǩ������Ȼ����ǩ���㷨����ǩ��
        map.put("sign","");
        //��API���ص����ݸ�����ǩ���㷨���м����µ�ǩ����������API���ص�ǩ�����бȽ�
        return Signature.getSign(map);
    }

    /**
     * ����API���ص����������ǩ���Ƿ�Ϸ������������ڴ���Ĺ����б��������۸�
     * @param responseString API���ص�XML�����ַ���
     * @return APIǩ���Ƿ�Ϸ�
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkIsSignValidFromResponseString(String responseString) throws ParserConfigurationException, IOException, SAXException {

        Map<String,Object> map = XMLParser.getMapFromXML(responseString);
        System.out.println(map.toString());

        String signFromAPIResponse = map.get("sign").toString();
        if(signFromAPIResponse=="" || signFromAPIResponse == null){
        	System.out.println("API���ص�����ǩ�����ݲ����ڣ��п��ܱ��������۸�!!!");
            return false;
        }
        System.out.println("�������ذ������ǩ����:" + signFromAPIResponse);
        //����������ݶ��������Sign���ݣ����ܰ��������Ҳ�ӽ�ȥ����ǩ������Ȼ����ǩ���㷨����ǩ��
        map.put("sign","");
        //��API���ص����ݸ�����ǩ���㷨���м����µ�ǩ����������API���ص�ǩ�����бȽ�
        String signForAPIResponse = Signature.getSign(map);

        if(!signForAPIResponse.equals(signFromAPIResponse)){
            //ǩ���鲻������ʾ���API���ص������п����Ѿ����۸���
        	System.out.println("API���ص�����ǩ����֤��ͨ�����п��ܱ��������۸�!!!");
            return false;
        }
        System.out.println("��ϲ��API���ص�����ǩ����֤ͨ��!!!");
        return true;
    }
}
