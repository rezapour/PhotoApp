package me.rezapour.photoapp.ui.activites.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import me.rezapour.photoapp.R
import me.rezapour.photoapp.ui.activites.adapters.ViewPagerAdapter

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentList = arrayListOf<Fragment>(
            PhotosListFragment(),
            PhotoPreviewFragment()
        )

        val viewPagerAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        view.viewpager_main.adapter = viewPagerAdapter
        TabLayoutMediator(TabLayout_List, view.viewpager_main) { tab, position ->
            when (position) {
                0 -> tab.text = "Recently"
                1 -> tab.text = "Popular"
                2 -> tab.text = "Last seen"
            }
        }.attach()
    }

}