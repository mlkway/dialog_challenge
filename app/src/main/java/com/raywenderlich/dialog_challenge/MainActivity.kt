package com.raywenderlich.dialog_challenge

import android.app.Dialog
import android.hardware.display.DisplayManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.viewbinding.ViewBinding
import com.raywenderlich.dialog_challenge.databinding.ActivityMainBinding
import com.raywenderlich.dialog_challenge.databinding.ItemDialogBinding
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private  lateinit var dialogBinding: ItemDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            dialogBinding = ItemDialogBinding.inflate(layoutInflater)
            showDialog("this is enough ?")
        }

    }


    private fun showDialog(question: String){
        val dialog = Dialog(this)
        dialog.setUp(android.R.color.transparent,dialogBinding)
        dialogBinding.question.text = question
        dialogBinding.apply {
            okButton.setOnClickListener {
                dialog.cancel()
            }
            noButton.setOnClickListener {

                dialogBinding.question.text = " I am joke for you ?"
            }
        }

    }





    fun Dialog.setUp(color:Int,bind: ViewBinding){

        window!!.setBackgroundDrawableResource(color)
        window!!.requestFeature(Window.FEATURE_NO_TITLE)
        window!!.setContentView(bind.root)
        val params = window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        this.show()


    }




}