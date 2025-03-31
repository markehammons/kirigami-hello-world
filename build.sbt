lazy val qrcLocation = settingKey[File]("Location of QRC files")
lazy val qrcBuild =
  taskKey[List[File]]("build qrc files for inclusion into project")

lazy val root = project.in(file(".")).aggregate(`scala-native`, jvm)

import scala.scalanative.build._
lazy val `scala-native` = project
  .settings(
    scalaVersion := "3.3.5",
    nativeConfig ~= { c =>
      c.withLTO(LTO.none) // thin
        .withMode(Mode.debug) // releaseFast
        .withGC(GC.immix) // commix
        .withCompileOptions(
          Seq(
            "-I/usr/include/qt5",
            "-I/usr/include/qt5/QtCore",
            "-I/usr/include/KF5",
            "-I/usr/include/KF5/KI18n",
            "-DQT_NO_VERSION_TAGGING"
          )
        )
        .withLinkingOptions(
          Seq(
            "-lQt5Core",
            "-lQt5Widgets",
            "-lQt5Qml",
            "-lKF5I18n",
            // for qml file?
            "-lQt5Gui",
            "-lQt5QuickControls2",
            "-lQt5Quick",
            "-lQt5Test",
            "-lKF5Kirigami2",
            "-lKF5CoreAddons"
          )
        )
    },
    logLevel := Level.Info,
    mappings in Universal += (nativeLink in Compile).value -> s"${name.value}"
  )
  .enablePlugins(
    ScalaNativePlugin,
    BuildInfoPlugin,
    UniversalPlugin
  )

import traveler.sbt._

lazy val jvm = project.settings(
  scalaVersion := "3.3.5",
  name := "kirigami-hello-world",
  Compile / compileCPP / includeFiles := Seq(file("/usr/include/qt5")),
  Compile / compileCPP / linkerLibs := Seq("Qt5Widgets")
).enablePlugins(TravelerPlugin)