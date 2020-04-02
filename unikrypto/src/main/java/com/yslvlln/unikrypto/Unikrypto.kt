package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

class Unikrypto {
    companion object {
        private var ls: LazySodiumAndroid
        init {
            ls = LazySodiumAndroid(SodiumAndroid())
        }
        fun createKey(key: String): Key {
            if (key.isNullOrEmpty()) {
                throw Exception("Input parameter empty")
            } else {
                return Key.fromPlainString(key)
            }
        }
        fun krypted(secretKey: String,  message: String): String? {
            if (ls != null) {
                val key = Key.fromPlainString(secretKey)
                try {
                    val ciphertext = ls.cryptoSecretBoxEasy(message, ByteArray(24), key)
                    return ciphertext
                } catch (e: SodiumException) {
                    e.printStackTrace()
                    return null
                }
            } else
                throw Exception("Error initialization")

        }
        fun deckypted(secretKey: String, ciphertext: String): String? {
            if (ls != null) {
                val key = Key.fromPlainString(secretKey)
                try {
                    val plaintext = ls.cryptoSecretBoxOpenEasy(ciphertext, ByteArray(24), key)
                    return plaintext
                } catch (e: SodiumException) {
                    e.printStackTrace()
                    return null
                }
            } else
                throw Exception("Error initialization")
        }
    }
}