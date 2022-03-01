package com.example.testforadis

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Gallery
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener{
            getFromGallery()
        }
    }

    private fun getFromGallery() {
        Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        ).apply {
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            type = "image/*"
            registerForActivity.launch(this)

        }
    }

    private val registerForActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                if (it != null) {
                    val count: Int = it.data?.clipData!!.itemCount
                    for (i in 0 until count) {
                        (Gallery(it.data?.clipData?.getItemAt(i)?.uri.toString()))
                        Log.e(TAG, ": ${Gallery}" )
                    }
                }
            }
        }



    companion object{
        val RESULT_LOAD_IMG = "text"
    }


}