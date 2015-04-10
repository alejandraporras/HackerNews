package model

case class ItemType(value: String)

object ItemType{
  val Job = ItemType("Job")
  val Story = ItemType("Story")
  val Comment = ItemType("Comment")

}

case class Story(
                  id : Int,
                  `type`: ItemType = ItemType.Story,
                  by : Option[String] = None,
                  score: Option[Int] = None,
                  url: Option[String] = None,
                  title: Option[String] = None
                  ){

}

case class Comment(
                    id: Int,
                    var `type`: ItemType = ItemType.Comment,
                    by : Option[String] = None,
                    text: Option[String] = None
                    )

case class User(id: String = "",
                //created: DateTime,
                about: Option[String] = None,
                var stories: List[Story] = List(),
                var comments: List[Comment] = List()
                 ) {
  def submissions = stories ++ comments

  def makesStory(`type`: ItemType, score: Option[Int],  url: Option[String] , title: Option[String] ): Unit ={
    val rnd = new scala.util.Random(5)
    val identifier = rnd.nextInt(99999)
    println("User " + id + " is making a story")
    val story = data.DAOStory.createStory(identifier, ItemType.Story, Some(this.id), score, url, title)
    stories= stories.::(story)
    println("STORIES: " + stories)
  }
}



