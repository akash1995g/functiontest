package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.Repo
import okhttp3.*
import retrofit2.Call
import retrofit2.Response
import java.net.URL
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.net.ssl.*

private const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Thread(Runnable {
            sslTest()
            sslWithRetrofit()
        }).start()

    }

    private fun sslWithRetrofit() {
        val okHttpClient = OkHttpClient.Builder()
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificateFile = application.resources.openRawResource(R.raw.localhost_android)
        try {
            val certificate = certificateFactory.generateCertificate(certificateFile)

            val keyStore = KeyStore.getDefaultType()
            val key = KeyStore.getInstance(keyStore)
            key.load(null,null)
            key.setCertificateEntry("ca",certificate)

            val trustManagerFactory = TrustManagerFactory.getDefaultAlgorithm()
            val trustManager = TrustManagerFactory.getInstance(trustManagerFactory)
            trustManager.init(key)

            val ssl = SSLContext.getInstance("TLS")
            ssl.init(null,trustManager.trustManagers,null)

            okHttpClient.sslSocketFactory(ssl.socketFactory,
                trustManager.trustManagers[0] as X509TrustManager
            )
        }catch (e:Exception){
            if(certificateFile != null){
                certificateFile.close()
            }
        }

        val repo = Repo().callIndexPage(okHttpClient.build())
        val calls = repo.indexPage()

       calls.enqueue(object:retrofit2.Callback<ResponseBody> {
           override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               Log.d(TAG, "retrofit Response: "+ response.code())
           }

           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               Log.d(TAG, "onFailure: "+ t.message)
           }

       })


    }

    private fun sslTest() {
        Thread(Runnable {
            Log.d(TAG, "sslTest: ")
            val url = URL("https://192.168.1.39:4442")
            val httpsURLConnection = url.openConnection() as HttpsURLConnection
            httpsURLConnection.connect()
            Log.d(TAG, "sslTest: " + httpsURLConnection.responseCode)

        }).start()
    }

    /**

    Cmd to generate Certificate

    openssl req -x509 -out localhost_android.crt -keyout localhost_android.key -newkey rsa:2048
    -days 1024 -nodes -sha256 -subj "/C=US/O=Dev-Certificate/CN=Android" -extensions EXT -config config.txt


     */

    /**
     * config file data

    [dn]
    CN=Android
    [req]
    distinguished_name=dn
    [EXT]
    subjectAltName=DNS:localhost,IP:10.0.2.2,IP:192.168.1.39
    keyUsage=digitalSignature
    extendedKeyUsage=serverAuth



     */


}