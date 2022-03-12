package com.example.myapplication.model.networking

import android.util.Log
import java.net.ServerSocket
import java.net.Socket

private const val TAG = "ServerApis"

class ServerApis {

    private lateinit var socket: Socket
    private lateinit var thread: Thread

    fun createServer() {
        val server = ServerSocket(2000)
        socket = server.accept()

        Log.d(TAG, "createServer: " + socket.isConnected)

    }


    fun readData() {

    }

}