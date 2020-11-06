package com.github.art241111.tcpClient

import androidx.lifecycle.LiveData
import com.github.art241111.tcpClient.connection.Connection
import com.github.art241111.tcpClient.connection.Status
import com.github.art241111.tcpClient.reader.RemoteReader
import com.github.art241111.tcpClient.reader.RemoteReaderImp
import com.github.art241111.tcpClient.writer.RemoteWriter
import com.github.art241111.tcpClient.writer.RemoteWriterImp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.github.art241111.tcpClient.handlers.HandlerImp
import com.github.art241111.tcpClient.writer.Sender
import kotlinx.coroutines.delay
import java.net.Socket

/**
 * TCP client.
 * @author Artem Gerasimov.
 */
class Client(){
    private val connection = Connection()
    private val remoteReader = RemoteReader()
    private val remoteWriter = RemoteWriter()
    fun getSender(): Sender = remoteWriter
    fun getSafeSender(): Sender = remoteWriter

    private val handlers: MutableList<HandlerImp> = mutableListOf()

    private val connectStatus: LiveData<Status> = connection.getConnectStatus()
    /**
     * @return connect status
     */
    fun getConnectStatus(): LiveData<Status> = connectStatus

    @Suppress("unused")
    fun addHandlers(handlers: List<HandlerImp>) {
        this.handlers.addAll(handlers)
    }

    @Suppress("unused")
    fun addHandler(handler: HandlerImp) {
        this.handlers.add(handler)
    }

    @Suppress("unused")
    fun removeHandlers(handlers: List<HandlerImp>) {
        this.handlers.removeAll(handlers)
    }

    /**
     * Connect to TCP sever.
     * @param address - server ip port,
     * @param port - server port.
     */
    fun connect(address: String,
                port: Int,
                senderDelay: Long = 0L){
        GlobalScope.launch {
            // Connect to tcp server
            connection.connect(address, port)

            // When the device connects to the server, it creates Reader and Writer
            if(connection.value != null && connection.value!!.isConnected){
                startReadingAndWriting(socket = connection.value!!, senderDelay)

                // Add handlers to Reader
                remoteReader.addHandlers(handlers)
            }
        }
    }

    /**
     * Disconnect from TCP sever.
     */
    fun disconnect(){
        GlobalScope.launch {
            remoteReader.destroyReader()
            remoteWriter.destroyWriter()

            delay(50L)
            connection.disconnect()
        }
    }

    /**
     * Send text to the server.
     */
    fun send(text: String) {
        remoteWriter.send(text)
    }

    private fun startReadingAndWriting(socket: Socket, delay: Long) {
        remoteReader.createReader(socket)
        remoteWriter.createWriter(socket, delay)
    }
}