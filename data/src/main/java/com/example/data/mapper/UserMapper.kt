package com.example.data.mapper

import com.example.domain.model.User
import com.google.firebase.auth.FirebaseUser

fun FirebaseUser.toDomain(): User {
    return User(
        userID = this.uid,
        username = this.displayName.orEmpty(),
        emailAddress = this.email.orEmpty()
    )
}