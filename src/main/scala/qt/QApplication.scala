package qt

import scalanative.unsafe.*
import scalanative.libc.stdlib.{malloc,free}
import scala.util.Using.Manager
import scala.util.Using.Releasable
opaque type QApplication = Ptr[Byte]
object QApplication:
  given Releasable[QApplication] with 
    def release(resource: QApplication): Unit = 
      println("closing qapp")
      free(resource)

  given Releasable[Zone] with 
    def release(resource: Zone): Unit = resource.close()
  extension (q: QApplication) 
    def close() = free(q)
    def exec() = QApplicationBinding.qapplication_exec(q)
  def apply(args: Array[String])(using m: Manager): QApplication = 
    given Zone = m(Zone.open())
      
    val argv = alloc[CString](1)
    argv(0) = toCString("kirigami-hello-world")
    //for i <- 0 until args.length do argv(i) = toCString(args(i))
    m(QApplicationBinding.qapplication_init(1, argv))

@link("Qt5Core")
@link("Qt5Widgets")
@extern
private[qt] object QApplicationBinding:
  def qapplication_init(argc: CInt, argv: Ptr[CString]): QApplication = extern
  def qapplication_exec(application: QApplication): CInt = extern
