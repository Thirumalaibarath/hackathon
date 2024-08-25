package com.example.client

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.client.ui.theme.ClientTheme
import io.socket.client.Socket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
//    private val service = GameServices.create()
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocketHandler.setSocket()

            val mSocket = SocketHandler.getSocket()

            mSocket.connect()

            Trail(socket = mSocket)



//            val scope = CoroutineScope(Dispatchers.IO)
//
//            scope.launch {
//                val currentGame = service.getLiveData()
//            }


        }
    }
}

@Composable
fun Trail(socket: Socket)
{
    Box(
        modifier = Modifier.fillMaxSize()
            .clickable {
                       socket.emit("counter")
            },
        contentAlignment = Alignment.Center
    )
    {

    }
}

