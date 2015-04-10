import model.{ItemType, User}

object Test {



  def main(args: Array[String]) {

    data.DAOUser.createUsers()

    //data.DAOUser.deleteUser(1)


    //I want the user identified by 1

    //val user = data.DAOUser.getUser("ale")
    val user = data.DAOUser.getUser("ale").get
    println("USER: " + user)

    //User1 wants to create a story

    user.makesStory(ItemType.Story, Some(20), Some("url"), Some("title1"))

    val users: List[User] = data.DAOUser.allUsers()
    users.foreach (user =>   println("User id: " + user.id + " Users' stories: " + user.submissions + " Number of submissions : " + user.submissions.size))
  }
}
