package com.example.githubstars.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubstars.databinding.ActivityMainBinding
import com.example.githubstars.presentation.adapter.ResultAdapter
import com.example.githubstars.presentation.viewmodel.ResultViewModel
import com.example.githubstars.presentation.viewmodel.ResultViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var resultAdapter: ResultAdapter
    @Inject
    lateinit var resultViewModelFactory: ResultViewModelFactory
    lateinit var viewModel: ResultViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            resultAdapter.setOnItemClickListener {
                Toast.makeText(this@MainActivity, ""+it.name, Toast.LENGTH_SHORT).show()
            }
            adapter = resultAdapter

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this@MainActivity, resultViewModelFactory).get(ResultViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {

                resultAdapter.submitData(it)
            }
        }
    }
}