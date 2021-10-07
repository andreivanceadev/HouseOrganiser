package com.andreivanceadev.kitchen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.andreivanceadev.storage.StorageForTest

@Composable
@Preview
fun Test() {
    Text(text = "Oh Look, it's working, OMG")
    StorageForTest()
}
