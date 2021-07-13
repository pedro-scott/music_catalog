package br.com.catalogodemusicas.model

data class Music (
    val imageId: Int,
    val name: String,
    val artist: String,
    val during: String,
    val album: String
)