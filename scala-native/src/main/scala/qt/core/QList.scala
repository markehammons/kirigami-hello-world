package qt.core

import scalanative.unsafe.*

opaque type QList[A] = Ptr[Byte]

@extern
@link("Qt5Core")
private object _QList:
  def q_list_is_empty(list: Ptr[Byte]): CChar = extern

object QList:
  extension [A](q: QList[A])
    def isEmpty: Boolean = 
      if _QList.q_list_is_empty(q) == 0 then false else true