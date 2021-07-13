package br.com.catalogodemusicas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.catalogodemusicas.adapter.ViewPagerAdapterActivity
import br.com.catalogodemusicas.databinding.ActivityMainBinding
import br.com.catalogodemusicas.fragment.AlbumPagerFragment
import br.com.catalogodemusicas.fragment.ImagePagerFragment
import br.com.catalogodemusicas.fragment.MusicFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        val fragmentList = listOf(
            MusicFragment(),
            ImagePagerFragment(),
            AlbumPagerFragment()
        )
        val viewPagerAdapter = ViewPagerAdapterActivity(
            fragmentActivity = this,
            fragmentList = fragmentList
        )

        binding.pagerMain.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabMain, binding.pagerMain) { tab, position ->
            when (position) {
                0 -> tab.text = "Músicas"
                1 -> tab.text = "Imagens"
                2 -> tab.text = "Álbuns"
            }
        }.attach()
    }
}