package br.com.catalogodemusicas.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.catalogodemusicas.R
import br.com.catalogodemusicas.adapter.MusicAdapter
import br.com.catalogodemusicas.databinding.FragmentMusicBinding
import br.com.catalogodemusicas.model.Music

class MusicFragment : Fragment() {

    private var binding: FragmentMusicBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val musicList = listOf(
            Music(
                imageId = R.drawable.in_the_end_linkin_park,
                name = "In the End",
                artist = "Linkin Park",
                during = "03:36",
                album = "Hybrid Theory"
            ),
            Music(
                imageId = R.drawable.wild_horses_rolling_stones,
                name = "Wild Horses",
                artist = "Rolling Stones",
                during = "05:42",
                album = "Hot Rocks"
            ),
            Music(
                imageId = R.drawable.starway_to_heaven_led_zepellin,
                name = "Starway to Heaven",
                artist = "Led Zepellin",
                during = "08:02",
                album = "Led Zepellin IV"
            ),
            Music(
                imageId = R.drawable.back_in_black_acdc,
                name = "Back in Black",
                artist = "AC/DC",
                during = "04:15",
                album = "Back in Black"
            ),
            Music(
                imageId = R.drawable.nothing_else_matters_metallica,
                name = "Nothing Else Matters",
                artist = "Metallica",
                during = "06:28",
                album = "Metallica"
            )
        )
        val musicAdapter = MusicAdapter(musicList) {
            if (it.layoutInfo.isVisible) {
                it.layoutInfo.apply {
                    visibility = View.GONE
                    isVisible = false
                }
            } else {
                it.layoutInfo.apply {
                    visibility = View.VISIBLE
                    isVisible = true
                }
            }
        }

        binding?.let {
            with(it) {
                vgMusicRecycler.layoutManager = LinearLayoutManager(context)
                vgMusicRecycler.adapter = musicAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}