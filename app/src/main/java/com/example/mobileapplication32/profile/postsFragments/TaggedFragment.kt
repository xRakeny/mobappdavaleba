package com.example.mobileapplication32.profile.postsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileapplication32.R

class TaggedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tagged, container, false)
    }

    companion object {
          @JvmStatic
        fun newInstance() = TaggedFragment()
    }
}