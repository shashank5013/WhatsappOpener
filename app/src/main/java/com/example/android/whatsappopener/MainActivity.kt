package com.example.android.whatsappopener

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.whatsappopener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding=ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(intent.action==Intent.ACTION_PROCESS_TEXT){
            val number=if(intent.action== Intent.ACTION_PROCESS_TEXT){
                intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT).toString()
            }
            else {"0"}

            openWhatsapp(number)
            finish()
        }
        finish()
    }

    /**
     * function for opening whatsapp
     */
    fun openWhatsapp(number:String){
        val uri= Uri.parse("smsto:$number")
        val intent=Intent(Intent.ACTION_SENDTO).apply {
            data=uri
            setPackage("com.whatsapp")
        }
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Whatsapp not installed",Toast.LENGTH_SHORT).show()
        }
    }
}