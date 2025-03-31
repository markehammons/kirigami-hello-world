package qt.core

import scalanative.unsafe.*
import util.Using.{Manager, Releasable}
import qt.QString
import java.net.URI

opaque type QUrl = Ptr[Byte]

@extern
@link("Qt5Core")
private object _QUrl:
  def q_url_init(url: QString): QUrl = extern
  def q_url_destroy(url: QUrl): Unit = extern

object QUrl:
  given Releasable[QUrl] with
    def release(resource: QUrl): Unit =
      println("destroying qurl")
      _QUrl.q_url_destroy(resource)

  def apply(uri: URI)(using m: Manager): QUrl =
    println("allocating qurl")
    println(uri.toASCIIString())
    val url = m(_QUrl.q_url_init(QString(uri.toASCIIString())))
    println("done")
    url
