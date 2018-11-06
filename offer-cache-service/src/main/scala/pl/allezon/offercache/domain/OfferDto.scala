package pl.allezon.offercache.domain

import scala.beans.BeanProperty

class OfferDto {
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var description: String = _

  def canEqual(other: Any): Boolean = other.isInstanceOf[OfferDto]

  override def equals(other: Any): Boolean = other match {
    case that: OfferDto =>
      (that canEqual this) &&
        id == that.id &&
        name == that.name &&
        description == that.description
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id, name, description)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }


  override def toString = s"OfferDto($id, $name, $description)"
}
