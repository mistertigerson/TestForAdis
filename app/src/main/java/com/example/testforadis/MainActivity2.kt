package com.example.testforadis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {


    private var galleryAdapter: GalleryAdapter = GalleryAdapter()
    private var list: ArrayList<Model> = ArrayList()
    private var model: Model = Model()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initRecycler()
    }

    private fun initRecycler() {
        model.image = R.drawable.ic_launcher_background
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        with(recycler) {
            galleryAdapter = GalleryAdapter()
            adapter = galleryAdapter
            galleryAdapter.setList(list)
            layoutManager = GridLayoutManager(context, 3)
        }

    }
}