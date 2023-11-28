package com.inandout.real_rider.util

import android.graphics.*
import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.util.Log
import java.io.ByteArrayOutputStream

// H.264 디코더 클래스
class H264Decoder(private val width: Int, private val height: Int) {
    private val mediaCodec: MediaCodec

    init {
        // 비디오 포맷 설정
        val format = MediaFormat.createVideoFormat("video/avc", width, height)
        format.setInteger(MediaFormat.KEY_BIT_RATE, width * height)
        format.setInteger(MediaFormat.KEY_FRAME_RATE, 30)
        format.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Flexible)

        // 디코더 생성
        mediaCodec = MediaCodec.createDecoderByType("video/avc")
        mediaCodec.configure(format, null, null, 0)
        mediaCodec.start()
    }

    // ByteArray를 받아 Bitmap으로 디코딩하는 함수
    fun decodeFrame(byteArray: ByteArray): Bitmap? {
        try {
            val inputBufferIndex = mediaCodec.dequeueInputBuffer(-1)
            if (inputBufferIndex >= 0) {
                val inputBuffer = mediaCodec.getInputBuffer(inputBufferIndex)
                inputBuffer?.clear()
                inputBuffer?.put(byteArray)
                mediaCodec.queueInputBuffer(inputBufferIndex, 0, byteArray.size, 0, 0)
            }

            val bufferInfo = MediaCodec.BufferInfo()
            val outputBufferIndex = mediaCodec.dequeueOutputBuffer(bufferInfo, 0)
            if (outputBufferIndex >= 0) {
                val outputBuffer = mediaCodec.getOutputBuffer(outputBufferIndex)
                val outputBytes = ByteArray(bufferInfo.size)
                outputBuffer?.get(outputBytes)

                // YUV 데이터를 Bitmap으로 변환
                val yuvImage = YuvImage(outputBytes, ImageFormat.NV21, width, height, null)
                val byteArrayOutputStream = ByteArrayOutputStream()
                yuvImage.compressToJpeg(Rect(0, 0, width, height), 100, byteArrayOutputStream)
                val jpegByteArray = byteArrayOutputStream.toByteArray()

                // Bitmap으로 변환
                return BitmapFactory.decodeByteArray(jpegByteArray, 0, jpegByteArray.size)
            }
        } catch (e: Exception) {
            Log.e("H264Decoder", "Error decoding frame: ${e.message}")
        }

        return null
    }

    // 디코더 해제
    fun release() {
        mediaCodec.stop()
        mediaCodec.release()
    }
}