package com.example.mobileapplication32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileapplication32.databinding.FragmentMainBinding
import com.example.mobileapplication32.home.HomeFragment
import com.example.mobileapplication32.home.homeFragments.HomeMainFragment
import com.example.mobileapplication32.profile.ProfileFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container, false)
        return binding.root
    }

    private fun loadFragment(f: Fragment){
        parentFragmentManager.beginTransaction().replace(R.id.container,f).commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        loadFragment(HomeMainFragment.newInstance())
        bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeMainFragment.newInstance())
                    true
                }
                R.id.search -> {
                    Toast.makeText(requireContext(), "soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.add -> {
                    Toast.makeText(requireContext(), "soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.notifications -> {
                    Toast.makeText(requireContext(), "soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment.newInstance())
                    true
                }
                else -> {
                    loadFragment(HomeMainFragment.newInstance())
                    true
                }
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}