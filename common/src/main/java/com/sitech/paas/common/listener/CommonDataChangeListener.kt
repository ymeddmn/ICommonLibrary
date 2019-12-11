package com.sitech.paas.common.listener

interface CommonDataChangeListener<Data> {
    fun onChange(data: Data)
}