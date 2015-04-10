package data

import model.{ItemType, Story, User}


object DAOUser {

   // var users:List[User] = List()

   var users: Map[String, User] = Map()

    def createUsers(): Unit = {
      val user1 = User("ale", Some("Hola"), List(),List())
      val user2 = User("jandra", Some("About me"), List())
      users += (user1.id->user1)
      users += (user2.id-> user2)
    }

    def allUsers()={
      users.values.toList
    }

  def getUser(id: String): Option[User] = {
    users.get(id)


  }

  def deleteUser(id: String)={
    users= users.-(id)
  }

}

object DAOStory{

  var stories: Map[Int, Story] = Map()

  def createStory(id : Int, `type`: ItemType, by : Option[String], score: Option[Int],  url: Option[String] , title: Option[String] )={
   val aux =  Story(id,`type`, by, score, url, title)
    stories += (id -> aux)
    aux
  }
  def createStories()={
    val story1 = Story(1, ItemType.Story, None, None, Some("url1"), Some("title1"))
    val story2 = Story(2, ItemType.Story, None, None, Some("url2"), Some("title2"))
    val story3 = Story(3, ItemType.Story, None, None, Some("url3"), Some("title3"))
    val story4 = Story(4, ItemType.Story, None, None, Some("url4"), Some("title4"))

    stories += (story1.id -> story1)
    stories += (story2.id -> story2)
    stories += (story3.id -> story3)
    stories += (story4.id -> story4)

  }

}
