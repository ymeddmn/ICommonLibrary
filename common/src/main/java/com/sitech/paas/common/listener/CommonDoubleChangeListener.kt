package com.sitech.paas.common.listener

interface CommonDoubleChangeListener<M, N> {
    fun onChange(m: M, n: N)
}