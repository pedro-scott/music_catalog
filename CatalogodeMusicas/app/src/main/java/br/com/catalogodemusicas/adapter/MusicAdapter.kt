package br.com.catalogodemusicas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.catalogodemusicas.databinding.MusicItemBinding
import br.com.catalogodemusicas.model.Music

class MusicAdapter(
    private val musicList: List<Music>
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(musicList[position])

        holder.binding2.let { binding ->
            binding.card.setOnClickListener {
                if (binding.layoutInfo.isVisible) {
                    binding.layoutInfo.visibility = View.GONE
                    binding.layoutInfo.isVisible = false
                } else {
                    binding.layoutInfo.visibility = View.VISIBLE
                    binding.layoutInfo.isVisible = true
                }
            }
        }
    }

    override fun getItemCount() = musicList.size

    class ViewHolder(
        private val binding: MusicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val binding2 = binding

        fun bind(music: Music) {
            binding.musicImage.setImageResource(music.imageId)
            binding.musicName.text = music.name
            binding.musicArtist.text = music.artist
            binding.musicDuring.text = music.during
            binding.musicAlbum.text = music.album
        }
    }
}