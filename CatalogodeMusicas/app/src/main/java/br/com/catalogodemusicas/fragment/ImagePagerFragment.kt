package br.com.catalogodemusicas.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.catalogodemusicas.R
import br.com.catalogodemusicas.adapter.ViewPagerAdapterFragment
import br.com.catalogodemusicas.databinding.FragmentImagePagerBinding
import br.com.catalogodemusicas.transformer.DepthPageTransformer

class ImagePagerFragment : Fragment() {

    private var binding: FragmentImagePagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImagePagerBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagesList = listOf(
            ImageFragment(R.drawable.linkin_park),
            ImageFragment(R.drawable.rolling_stones),
            ImageFragment(R.drawable.led_zepellin),
            ImageFragment(R.drawable.acdc),
            ImageFragment(R.drawable.metallica)
        )

        val viewPagerAdapterFragment = ViewPagerAdapterFragment(
            this,
            imagesList
        )

        binding?.pagerImages?.apply {
            adapter = viewPagerAdapterFragment
            setPageTransformer(DepthPageTransformer())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}