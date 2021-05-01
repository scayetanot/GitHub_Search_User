package com.example.githubsearchuser.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearchuser.R
import com.example.githubsearchuser.BR
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.databinding.GitUserItemBinding

class GitHubUsersListAdapter (
        var listOfUsers: List<GitHubUserListResult>,
        var viewModel: MainActivityViewModel
): RecyclerView.Adapter<GitHubUsersListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return listOfUsers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                parent.context,
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.git_user_item,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder()
    }

    inner class ViewHolder(private val context: Context, private val viewDataBinding: GitUserItemBinding) :
            RecyclerView.ViewHolder(viewDataBinding.root) {

            fun bindViewHolder() {

                viewDataBinding.setVariable(BR.viewModel, )
                viewDataBinding.executePendingBindings()
            }
    }
}