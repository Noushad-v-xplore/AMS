package com.vxplore.ams.models

data class Assigntasklist(
    val Task: String,
    val Date: String,
    val Comments: Comment
)

data class Comment(
    val Comment: String,
    val Emoji: String,
)