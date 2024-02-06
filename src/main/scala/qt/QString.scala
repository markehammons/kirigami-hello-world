package qt

import scala.scalanative.unsafe.Ptr
import scala.scalanative.unsafe.extern
import scala.scalanative.unsafe.link
import scalanative.unsafe.CString
import scalanative.unsafe.sizeof
import scala.scalanative.unsafe.Zone
import scala.scalanative.unsafe.CSize
import scala.scalanative.unsafe.UWord
import scala.scalanative.unsigned.ULong
import scala.scalanative.runtime.RawPtr
import scala.util.Using.Manager
import qt._QString.q_string_init
import scalanative.unsafe.*
import scala.util.Using.Releasable

opaque type QString = Ptr[Byte]

@extern
@link("Qt5Core")
object _QString:
  def q_string_init(string: CString): QString = extern
  def q_string_destroy(string: QString): Unit = extern

object QString:
  given Releasable[QString] with
    def release(resource: QString): Unit = _QString.q_string_destroy(resource)

  def apply(string: String)(using m: Manager) =
    Zone { implicit z =>
      m.apply(q_string_init(toCString(string)))
    }
