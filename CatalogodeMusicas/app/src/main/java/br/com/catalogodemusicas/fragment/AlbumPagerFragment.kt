package br.com.catalogodemusicas.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.catalogodemusicas.transformer.DepthPageTransformer
import br.com.catalogodemusicas.R
import br.com.catalogodemusicas.adapter.ViewPagerAdapterFragment
import br.com.catalogodemusicas.databinding.FragmentAlbumPagerBinding

class AlbumPagerFragment : Fragment() {

    private var binding: FragmentAlbumPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumPagerBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumList = listOf(
            AlbumFragment(
                R.drawable.linkin_park_album_2000,
                "Hybrid Theory",
                2000
            ),
            AlbumFragment(
                R.drawable.rolling_stones_album_1971,
                "Hot Rocks",
                1971
            ),
            AlbumFragment(
                R.drawable.led_zepellin_album_1971,
                "Led Zepellin IV",
                1971
            ),
            AlbumFragment(
                R.drawable.acdc_album_1980,
                "Back in Black",
                1980
            ),
            AlbumFragment(
                R.drawable.metallica_album_1991,
                "Metallica",
                1991
            )
        )

        val viewPagerAdapter = ViewPagerAdapterFragment(
            this,
            albumList
        )
        binding?.pagerAlbuns?.apply {
            adapter = viewPagerAdapter
            setPageTransformer(DepthPageTransformer())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}