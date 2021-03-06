package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

object SecretKey {
    var mKey: Key? = null

    fun setKey(key: String) {
        mKey = Key.fromHexString(key)
    }

    fun getKey(): Key {
        if (mKey != null) {
            return mKey!!
        } else {
            throw Exception("Secret key is null")
        }
    }
}