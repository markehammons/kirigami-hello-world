scalaVersion := "3.3.1"

enablePlugins(ScalaNativePlugin)
enablePlugins(BuildInfoPlugin)
enablePlugins(UniversalPlugin)

maintainer := "markehammons@gmail.com"

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
    .withCompileOptions(Seq("-I/usr/include/qt5", "-I/usr/include/qt5/QtCore", "-I/usr/include/KF5", "-I/usr/include/KF5/KI18n", "-DQT_NO_VERSION_TAGGING"))
    .withLinkingOptions(Seq("-lQt5Core", "-lQt5Widgets", "-lQt5Qml", "-lKF5I18n", 
    //for qml file?
    "-lQt5Gui", "-lQt5QuickControls2", "-lQt5Quick", "-lQt5Test",
    "-lKF5Kirigami2", "-lKF5CoreAddons"))
}

lazy val qrcLocation = settingKey[File]("Location of QRC files")
lazy val qrcBuild = taskKey[List[File]]("build qrc files for inclusion into project")

mappings in Universal += (nativeLink in Compile).value -> s"${name.value}"