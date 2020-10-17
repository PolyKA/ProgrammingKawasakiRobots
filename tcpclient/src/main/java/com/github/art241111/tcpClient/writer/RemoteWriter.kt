package com.github.art241111.tcpClient.writer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.PrintStream
import java.io.PrintWriter
import java.net.Socket

/**
 * This class creates a Writer that allows
 * you to send text strings to the server.
 * @author Artem Gerasimov.
 */
class RemoteWriter: RemoteWriterImp {
    // A variable that displays whether our Writer is working.
    private var isWriting = false

    // Writer, which allows you to send data to the server
    private lateinit var writer: PrintStream

    /**
     * Sending a text command to the server.
     * @param text - the text that will be sent to the server
     */
    override fun send(text: String) {
        if(isWriting){
            GlobalScope.launch {
                writer.print(text)
                writer.flush()
            }
        }
    }

    /**
     * Creating a writer that will send data to the server.
     * @param socket - - the connection that you want to listen to.
     */
    override fun createWriter(socket: Socket) {
        writer = PrintStream(socket.getOutputStream())
        isWriting = true
    }

    /**
     * Sending the final command and closing Writer.
     */
    override fun destroyWriter(stopCommand: String) {
        if(::writer.isInitialized && isWriting){
            if(stopCommand != ""){
                send(stopCommand)
                Thread.sleep(50L)
            }
            writer.close()
        }

        isWriting = false
    }
}
