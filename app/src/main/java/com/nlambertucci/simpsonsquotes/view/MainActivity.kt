package com.nlambertucci.simpsonsquotes.view

import android.content.res.Configuration
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nlambertucci.simpsonsquotes.R
import com.nlambertucci.simpsonsquotes.model.Quotes
import com.nlambertucci.simpsonsquotes.utils.SplashScreen
import com.nlambertucci.simpsonsquotes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SplashScreen {

    lateinit var viewModel: MainViewModel
    lateinit var quotesAdapter: QuotesAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.title = "The Simpsons"
        this.supportActionBar?.subtitle = "Quotes!"

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getQuotes()
    }

    private fun getQuotes(){
        recyclerView = findViewById(R.id.quoteRecyclerView)
        recyclerView.setHasFixedSize(true)

        if(this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        recyclerView.itemAnimator = DefaultItemAnimator()

        viewModel.getQuotes()?.observe(this, Observer {
           quotesAdapter = QuotesAdapter(it)
            recyclerView.adapter = quotesAdapter
            hideLoading()
        })
    }

    override fun hideLoading() {
       splashImage.visibility = View.GONE
    }

}
