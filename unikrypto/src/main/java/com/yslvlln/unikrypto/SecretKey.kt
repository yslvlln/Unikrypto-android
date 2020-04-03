package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.utils.Key

object SecretKey {
    var mKey: Key? = null

    fun setKey(key: String) {
        mKey = Key.fromPlainString(key)
    }
}