package qt.core

import scalanative.unsafe.*
import scala.util.Using.Releasable
import scala.util.Using.Manager

opaque type QByteArray = Ptr[Byte]

@extern
@link("Qt5Core")
private object _QByteArray:
  def q_byte_array_init(data: CString): QByteArray = extern
  def q_byte_array_destroy(array: QByteArray): Unit = extern

object QByteArray:
  given Releasable[Zone] with 
    def release(resource: Zone): Unit = resource.close()
  given Releasable[QByteArray] with
    def release(resource: QByteArray): Unit =
      println("destroying byte array")
      _QByteArray.q_byte_array_destroy(resource)

  def apply(data: String)(using m: Manager) = 
    println("creating qbytearray")
    given Zone = m(Zone.open())
    m(_QByteArray.q_byte_array_init(toCString(data)))