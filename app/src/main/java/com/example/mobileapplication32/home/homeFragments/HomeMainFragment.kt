package com.example.mobileapplication32.home.homeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapplication32.adapters.RvPostsAdapter
import com.example.mobileapplication32.adapters.RvStoryAdapter
import com.example.mobileapplication32.databinding.FragmentHomeMainBinding
import com.example.mobileapplication32.models.Post
import com.example.mobileapplication32.models.Story

class HomeMainFragment : Fragment() {

    private lateinit var binding : FragmentHomeMainBinding
    private lateinit var storyAdapter: RvStoryAdapter
    private lateinit var postAdapter: RvPostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRCViewStory()
        initRcViewPost()
    }

    private fun initRCViewStory() = with(binding) {
        rcViewStories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        storyAdapter = RvStoryAdapter()
        rcViewStories.adapter = storyAdapter

        val list = listOf(
            Story("","username56789024"),
            Story("","wirbskj789024"),
            Story("","0872395"),
            Story("","s_kfghjhewfg"),
            Story("","lsdhgfj"),
            Story("","username56789024"),
            Story("","wirbskj789024"),
            Story("","0872395"),
            Story("","s_kfghjhewfg"),
            Story("","lsdhgfj"),
        )

        storyAdapter.submitList(list)
    }

    private fun initRcViewPost() = with(binding){
        rcViewPosts.layoutManager = LinearLayoutManager(activity)
        postAdapter = RvPostsAdapter()
        rcViewPosts.adapter = postAdapter
        val list = listOf(
            Post("","wirbskj789024", "London, England",""),
            Post("","2352352srgt", "London, England",""),
            Post("","qweregs", "London, England",""),
            Post("","ksdgsgw", "London, England",""),
            Post("","wirbskj789024", "London, England",""),
            Post("","wirbskj789024", "London, England",""),
            Post("","wirbskj789024", "London, England",""),
            Post("","wirbskj789024", "London, England",""),

            )
        postAdapter.submitList(list)
    }

    companion object {
        fun newInstance() =
            HomeMainFragment()
    }
}