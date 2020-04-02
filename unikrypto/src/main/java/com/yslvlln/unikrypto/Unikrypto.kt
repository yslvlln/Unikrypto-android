package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.interfaces.Box
import com.goterl.lazycode.lazysodium.interfaces.SecretBox
import com.goterl.lazycode.lazysodium.utils.Key
import com.goterl.lazycode.lazysodium.utils.KeyPair

class Unikrypto {
    companion object {
        private var ls: LazySodiumAndroid? = null
        fun initSodium() : LazySodiumAndroid {
            return ls ?: LazySodiumAndroid(SodiumAndroid())
        }
        fun krypted(publicKey: Key, secretKey: Key,  message: String, nonce: ByteArray): String? {
            val keyPair = KeyPair(publicKey, secretKey)
            try {
                val ciphertext = ls?.cryptoBoxEasy(message, nonce, keyPair)
                return ciphertext
            } catch (e: SodiumException) {
                e.printStackTrace()
                return null
            }
        }
        fun deckypted(publicKey: Key, secretKey: Key, ciphertext: String, nonce: ByteArray): String? {
            val keyPair = KeyPair(publicKey, secretKey)
            try {
                val plaintext = ls?.cryptoBoxOpenEasy(ciphertext, nonce, keyPair)
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
}