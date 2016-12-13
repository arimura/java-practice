package com.hormiga6.javapractice.ssl;

import org.junit.Ignore;
import org.junit.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SSLTest {
    @Test
    public void testSSLContext() throws NoSuchAlgorithmException {
        //another instance
        //Each SSLContext instance keep state of connection
        SSLContext ssl1 = SSLContext.getInstance("SSL");
        SSLContext ssl2 = SSLContext.getInstance("SSL");
        assertThat(ssl1 == ssl2, is(false));
    }

    @Test
    @Ignore
    public void testLoadKeyStore() throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        BufferedInputStream caInput = new BufferedInputStream(new FileInputStream("your/path/to/self-signed.cert"));
        Certificate ca;
        try {
            ca = cf.generateCertificate(caInput);
        } finally {
            caInput.close();
        }

        // Create a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        // Create a TrustManager that trusts the CAs in our KeyStore
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // Create an SSLContext that uses our TrustManager
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);

        URL url = new URL("https://hogehogefugfuga.com/");
        HttpsURLConnection urlConnection =
                (HttpsURLConnection) url.openConnection();
        if (context != null) {
            urlConnection.setSSLSocketFactory(context.getSocketFactory());
        }
        urlConnection.getResponseCode();
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
        String str = null;
        while ((str = bufReader.readLine()) != null) {
            System.out.println(str);
        }
    }

    @Test
    public void testAllTrustManager() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
    }
}
