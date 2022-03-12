package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import java.net.URL
import javax.net.ssl.HttpsURLConnection

private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        sslTest()
    }

    private fun sslTest() {
        Thread(Runnable {
            Log.d(TAG, "sslTest: ")
            val url = URL("https://192.168.1.39:4442")
            val httpsURLConnection = url.openConnection() as HttpsURLConnection
            httpsURLConnection.connect()
            Log.d(TAG, "sslTest: "+ httpsURLConnection.responseCode)

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