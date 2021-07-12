package br.com.catalogodemusicas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.catalogodemusicas.databinding.FragmentAlbumBinding

class AlbumFragment(
    private val image: Int,
    private val albumName: String,
    private val releaseYear: Int
) : Fragment() {

    private var binding: FragmentAlbumBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { binding ->
            binding.album.setImageResource(image)
            binding.albumName.text = albumName
            binding.releaseYear.text = releaseYear.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}