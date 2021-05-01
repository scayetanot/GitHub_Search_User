package com.example.githubsearchuser.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Adapter
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearchuser.MainApplication
import com.example.githubsearchuser.R
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.databinding.ActivityMainBinding
import com.example.githubsearchuser.utils.viewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val appComponents by lazy { MainApplication.appComponents }

    private lateinit var gitHubUsersListAdapter: GitHubUsersListAdapter


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponents.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObservers()
    }

    private fun getViewModel(): MainActivityViewModel {
        return viewModelProvider(viewModelFactory)
    }

    private fun initViews() {
        binding.searchHint.visibility = View.VISIBLE
        binding.searchGitUser.addTextChangedListener(inputTxtWatcher)
    }

    private val inputTxtWatcher = object: TextWatcher {
        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int,
                                       count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            if(count > 3) {
                startSearch()
                binding.searchHint.visibility = View.GONE
            }
            else {
                binding.searchHint.visibility = View.VISIBLE
            }
        }
    }

    private fun startSearch() {
        getViewModel().getGitHubUsers(binding.searchGitUser.toString())
    }

    private fun initObservers() {
        getViewModel().resultList.observe(viewLifecycleOwner, Observer { usersList ->
            usersList?.let {
                initRecycler(usersList)
            }
        })
    }

    private fun initRecycler(list: List<GitHubUserListResult>) {
        if (!list.isNullOrEmpty()) {
            gitHubUsersListAdapter = GitHubUsersListAdapter(list, getViewModel())
            binding.simpleList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = gitHubUsersListAdapter
            }
        }
    }
}