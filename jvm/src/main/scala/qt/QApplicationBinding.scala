package qt

import java.nio.file.Path
import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.util.Collections
import java.net.URI
import java.lang.foreign.Linker
import java.lang.foreign.SymbolLookup
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.MemoryLayout
import java.lang.foreign.ValueLayout
import java.lang.foreign.MemorySegment
import java.nio.file.Files
import java.nio.file.Paths

opaque type QApplication = MemorySegment
object QApplication:
  def apply(args: Array[String]): QApplication =
    val arr = Arena.global().allocate(ValueLayout.ADDRESS, args.length)
    val strings = args.map(Arena.global().allocateFrom(_)).zipWithIndex.map((v, i) => 
      arr.setAtIndex(ValueLayout.ADDRESS, i, MemorySegment.ofAddress(v.address()))
    )
    QApplicationBinding.qapplication_init(args.length, arr)
    

object QApplicationBinding:
  //grab helper lib data
  val uri = getClass()
    .getClassLoader()
    .getResource("traveler-helpers/kirigami-hello-world-helper.so")
    .toURI() // .toString() match

  println(uri)

  val newFs = FileSystems.newFileSystem(uri, Collections.emptyMap())
  val path = newFs.getPath("traveler-helpers", "kirigami-hello-world-helper.so")
  println(path)

  val fileData = Files.readAllBytes(path)

  val tempDir = Files.createTempDirectory("temp")

  val soFile = tempDir.resolve("traveler-helpers", "kirigami-hello-world-helper.so")

  Files.createDirectories(soFile.getParent())
  Files.write(soFile, fileData)

  println(Files.readAllBytes(soFile).length)


  //instantiate linker
  val linker = Linker.nativeLinker()
  val lookup = SymbolLookup.libraryLookup(soFile, Arena.global())

  //init shape
  private val qapplication_initShape = FunctionDescriptor.of(
    ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS 
  )

  //method address
  private val qapplication_initAddress = lookup.find("qapplication_init").get()

  //method executor
  private val qapplication_initMethod = linker.downcallHandle(qapplication_initAddress, qapplication_initShape)

  def qapplication_init(argc: Int, argv: MemorySegment): MemorySegment = qapplication_initMethod.invokeExact(argc, argv)