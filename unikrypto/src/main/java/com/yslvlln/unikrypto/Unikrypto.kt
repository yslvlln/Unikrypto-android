package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.interfaces.Box
import com.goterl.lazycode.lazysodium.interfaces.SecretBox
import com.goterl.lazycode.lazysodium.utils.Key
import com.goterl.lazycode.lazysodium.utils.KeyPair

class Unikrypto {
    private var ls: LazySodiumAndroid? = null
    fun initSodium() : LazySodiumAndroid {
        return ls ?: LazySodiumAndroid(SodiumAndroid())
    }
    fun krypted(secretKey: Key, message: String): String? {
        val nonce = ls?.randomBytesBuf(SecretBox.NONCEBYTES)
        try {
            val ciphertext = ls?.cryptoSecretBoxEasy(message, nonce, secretKey)
            return ciphertext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }
    fun deckypted(secretKey: Key, ciphertext: String): String? {
        val nonce = ls?.randomBytesBuf(SecretBox.NONCEBYTES)
        try {
            val plaintext = ls?.cryptoSecretBoxOpenEasy(ciphertext, nonce, secretKey)
            return plaintext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }
    fun generateNonce(): ByteArray? {
        try {
            return ls?.randomBytesBuf(SecretBox.NONCEBYTES)
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }
}