package com.owtelse

import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}

import sbt._

object PrefixPlugin extends Plugin {

  object PrefixKeys {
    lazy val date = SettingKey[Date]("current build date")
    lazy val tsyncprefix1 = SettingKey[String]("first part of the prefix, eg Year")
    lazy val tsyncprefix2 = SettingKey[String]("second part of the prefix, eg Month")
    lazy val tsyncprefix = SettingKey[String]("primary package of this project")
  }

  def prefixSettings = Seq(
      PrefixKeys.date in ThisBuild := PrefixPlugin.now
    , PrefixKeys.tsyncprefix1 in ThisBuild := getYear(PrefixKeys.date.value)
    , PrefixKeys.tsyncprefix2 in ThisBuild := getMonth(PrefixKeys.date.value)
    , PrefixKeys.tsyncprefix in ThisBuild := PrefixKeys.tsyncprefix1.value + "/" + PrefixKeys.tsyncprefix2.value
  )

  lazy val now = new Date

  def getYear(d: Date) = {
    val formatter = new SimpleDateFormat("yyyy")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter.format(d)
  }

  def getMonth(d: Date) = {
    val formatter = new SimpleDateFormat("MM")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter.format(d)
  }

}
