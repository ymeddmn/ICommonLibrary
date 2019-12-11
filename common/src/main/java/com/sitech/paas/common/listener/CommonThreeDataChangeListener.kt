package com.sitech.paas.common.listener

interface CommonThreeDataChangeListener<M, N, Q> {
    fun onChange(m: M, n: N, q: Q)
}