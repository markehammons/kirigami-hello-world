package qt

import scalanative.unsafe.*
import scalanative.libc.stdlib.free
opaque type QApplication = Ptr[Byte]
object QApplication:
  extension (q: QApplication) 
    def close() = free(q)
    def exec() = QApplicationBinding.qapplication_exec(q)
  def apply(args: Array[String]): QApplication = 
    Zone{ implicit z =>
      
      val argv = alloc[CString](args.length)
      for i <- 0 until args.length do argv(i) = toCString(args(i))
        args.map(toCString)
      QApplicationBinding.qapplication_init(args.length, argv)
    }

@link("Qt5Core")
@link("Qt5Widgets")
@extern
private[qt] object QApplicationBinding:
  def qapplication_init(argc: CInt, argv: Ptr[CString]): QApplication = extern
  def qapplication_exec(application: QApplication): CInt = extern
