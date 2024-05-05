package com.ellycrab.imagesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.ellycrab.imagesearch.databinding.ActivityMainBinding
import com.ellycrab.imagesearch.presentation.adapter.ViewPagerAdapter
import com.ellycrab.imagesearch.presentation.search.fragments.SaveFragment
import com.ellycrab.imagesearch.presentation.search.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var searchFragment: SearchFragment
    private lateinit var saveFragment: SaveFragment

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchFragment = supportFragmentManager.findFragmentById(R.id.searchFragment) as? SearchFragment
            ?: SearchFragment.newInstance()
        saveFragment = supportFragmentManager.findFragmentById(R.id.saveFragment) as? SaveFragment
            ?: SaveFragment.newInstance()

        val navView: BottomNavigationView = binding.navView
        val viewPager: ViewPager2 = binding.viewPager


        //FragmentStateAdapter 의 생성자가 Lifecycle을 필요로한다.
        //처음에는 FragmentManager만 전달했지만, 이렇게 하면 프래그먼트의 생명주기가 제대로 관리되지 않을 수 있다.
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        // 초기에 searchFragment만 보이도록 설정
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, searchFragment, "searchFragment")
            .add(R.id.fragmentContainerView, saveFragment, "saveFragment")
            .hide(saveFragment)
            .commit()

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.searchFragment -> {
                    viewPager.currentItem = 0
                    supportFragmentManager.beginTransaction()
                        .show(searchFragment)
                        .hide(saveFragment)
                        .commit()
                    true
                }
                R.id.saveFragment -> {
                    viewPager.currentItem = 1
                    supportFragmentManager.beginTransaction()
                        .show(saveFragment)
                        .hide(searchFragment)
                        .commit()
                    true
                }
                else -> false
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> navView.selectedItemId = R.id.searchFragment
                    1 -> navView.selectedItemId = R.id.saveFragment
                }
            }
        })
    }
}
