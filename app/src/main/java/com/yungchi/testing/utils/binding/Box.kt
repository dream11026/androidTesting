package com.cathay.main.util.binding

/**
 * Created by i9400514 on 2020/09/22.
 */

typealias Listener<T> = (T?) -> Unit

class Box<T> {
    var listener: Listener<T>?

    private var _value: T?

    var value: T?
        set(value) {
            this._value = value
            listener?.invoke(_value)
        }
        get(): T? = _value

    constructor(value: T?, listener: Listener<T>? = null) {
        this._value = value
        this.listener = listener
    }

    fun binding(trigger: Boolean = true, listener: Listener<T>? = null) {
        this.listener = listener
        if (trigger) {
            listener?.invoke(_value)
        }
    }

    fun removeBinding() {
        this.listener = null
    }
}