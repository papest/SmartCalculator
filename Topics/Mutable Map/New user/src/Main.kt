fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    return userMap.toMutableMap().apply {
        if (contains(login)) println("User with this login is already registered!") else this[login] = password
    }
}