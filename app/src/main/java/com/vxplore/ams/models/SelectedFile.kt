package com.vxplore.ams.models

import android.net.Uri

data class SelectedFile(
    val uri: Uri,
    val fileName: String?,
    val isPDF: Boolean
)