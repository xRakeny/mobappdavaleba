package com.example.mobileapplication32.profile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mobileapplication32.R
import com.example.mobileapplication32.adapters.RvStoryAdapter
import com.example.mobileapplication32.adapters.VpAdapter
import com.example.mobileapplication32.databinding.FragmentHomeBinding
import com.example.mobileapplication32.databinding.FragmentProfileBinding
import com.example.mobileapplication32.models.Story
import com.example.mobileapplication32.models.User
import com.example.mobileapplication32.onBoarding.SignInFragment
import com.example.mobileapplication32.profile.postsFragments.PostsFragment
import com.example.mobileapplication32.profile.postsFragments.TaggedFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var rvAdapter: RvStoryAdapter
    private lateinit var vpAdapter: VpAdapter

    private val fList = listOf(
        PostsFragment.newInstance(),
        TaggedFragment.newInstance()
    )

    private val tList = listOf(
        "POSTS", "TAGGED"
    )

    private val db = FirebaseDatabase.getInstance().getReference("USER")
    private val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initVP()
        rvInit()
    }

    private fun init() = with(binding){
        btnSignOut.setOnClickListener{
            auth.signOut()
            parentFragmentManager.beginTransaction().replace(R.id.placeHolder, SignInFragment.newInstance()).commit()
        }

        db.child(auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(User::class.java) ?: return
                tvMainUserUserName.text = userInfo.userID
                Glide.with(requireContext()).load(userInfo.profileAvatar).into(ivMainUserAvatar)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
            }

        })



    }

    private fun rvInit() = with(binding) {
        rvAdapter = RvStoryAdapter()
        rvHighlights.adapter = rvAdapter
        rvHighlights.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        val list = listOf(Story("","highlight1"),
            Story("","highlight2"), Story("","highlight3"),
            Story("","highlight4"), Story("","highlight5"),
            Story("","highlight6")
        )

        rvAdapter.submitList(list)

    }

    private fun initVP() = with(binding){
        vpAdapter = VpAdapter(activity as FragmentActivity, fList)
        //        vpAdapter = VpAdapter(requireActivity(),fList) ესეც მისაღებია
        vp.adapter = vpAdapter
        TabLayoutMediator(tabLayout, vp) { tab, position ->
//            tab.text = "tab ${position + 1}"
            tab.text = tList[position]
        }.attach()
    }



    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}