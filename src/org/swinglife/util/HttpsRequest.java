package org.swinglife.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.swinglife.configure.WxConfigure;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:36
 */
public class HttpsRequest implements IServiceRequest{

    public interface ResultListener {


        public void onConnectionPoolTimeoutError();

    }


    //��ʾ�������Ƿ��Ѿ����˳�ʼ������
    private boolean hasInit = false;

    //���ӳ�ʱʱ�䣬Ĭ��10��
    private int socketTimeout = 10000;

    //���䳬ʱʱ�䣬Ĭ��30��
    private int connectTimeout = 30000;

    //������������
    private RequestConfig requestConfig;

    //HTTP������
    private CloseableHttpClient httpClient;

    public HttpsRequest() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        init();
    }

    private void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(WxConfigure.getCertLocalPath()));//���ر��ص�֤�����https���ܴ���
        try {
            keyStore.load(instream, WxConfigure.getCertPassword().toCharArray());//����֤������
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, WxConfigure.getCertPassword().toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();

        //����Ĭ�ϳ�ʱ���Ƴ�ʼ��requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * ͨ��Https��API post xml����
     *
     * @param url    API��ַ
     * @param xmlObj Ҫ�ύ��XML���ݶ���
     * @return API�ذ���ʵ������
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */

    public String sendPost(String url, Object xmlObj) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        //���XStream�Գ���˫�»��ߵ�bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

        //��Ҫ�ύ��API�����ݶ���ת����XML��ʽ����Post��API
        String postDataXML = xStreamForRequestPostData.toXML(xmlObj);

        System.out.println("API��POST��ȥ�������ǣ�");
        System.out.println(postDataXML);

        //��ָ��ʹ��UTF-8���룬����API������XML�����Ĳ��ܱ��ɹ�ʶ��
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        //����������������
        httpPost.setConfig(requestConfig);

        System.out.println("executing request" + httpPost.getRequestLine());

        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
        	System.out.println("http get throw ConnectionPoolTimeoutException(wait time out)");

        } catch (ConnectTimeoutException e) {
        	System.out.println("http get throw ConnectTimeoutException");

        } catch (SocketTimeoutException e) {
        	System.out.println("http get throw SocketTimeoutException");

        } catch (Exception e) {
        	System.out.println("http get throw Exception");

        } finally {
            httpPost.abort();
        }

        return result;
    }

    /**
     * �������ӳ�ʱʱ��
     *
     * @param socketTimeout ����ʱ����Ĭ��10��
     */
    public void setSocketTimeout(int socketTimeout) {
        socketTimeout = socketTimeout;
        resetRequestConfig();
    }

    /**
     * ���ô��䳬ʱʱ��
     *
     * @param connectTimeout ����ʱ����Ĭ��30��
     */
    public void setConnectTimeout(int connectTimeout) {
        connectTimeout = connectTimeout;
        resetRequestConfig();
    }

    private void resetRequestConfig(){
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }

    /**
     * �����̻��Լ������߼������ӵ�����������
     *
     * @param requestConfig ����HttpsRequest������������
     */
    public void setRequestConfig(RequestConfig requestConfig) {
        requestConfig = requestConfig;
    }
}

