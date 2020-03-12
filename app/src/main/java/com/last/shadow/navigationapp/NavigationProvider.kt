package com.last.shadow.navigationapp

interface NavigationProvider<in A> {

    fun navigateTo(originView: A, destinationView: A)
}
