package com.yagmurerdogan.dogsimages.utils.extensions

import com.google.android.material.bottomnavigation.BottomNavigationView


fun BottomNavigationView.openCheckable() {
    this.menu.setGroupCheckable(0, true, true)
}

fun BottomNavigationView.closeCheckable() {
    this.menu.setGroupCheckable(0, false, true)
}