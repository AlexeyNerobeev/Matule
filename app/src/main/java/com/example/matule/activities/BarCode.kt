package com.example.matule.activities

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

fun generateBarcode(text: String): Bitmap? {
    return try {
        val bitMatrix: BitMatrix = MultiFormatWriter().encode(
            text,
            BarcodeFormat.CODE_128,
            264,
            53
        )
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) -0x1000000 else -0x1)
            }
        }
        bitmap
    } catch (e: Exception) {
        null
    }
}

@Composable
fun BarcodeScreen() {
    val barcodeText = "https://developer.android.com/?hl=ru"
    val barcodeBitmap: Bitmap? = generateBarcode(barcodeText)

    Box{
        barcodeBitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Barcode",
                modifier = Modifier.size(264.dp, 53.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBarcodeScreen() {
    BarcodeScreen()
}