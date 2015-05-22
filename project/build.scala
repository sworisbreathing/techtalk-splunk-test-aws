import au.com.ecetera.sbt.S3WebsitePlugin
import au.com.ecetera.sbt.S3WebsitePlugin.S3WS._
import com.owtelse.PrefixPlugin
import com.owtelse.PrefixPlugin.PrefixKeys._
import com.typesafe.sbt.web.SbtWeb
import sbt.Keys._
import sbt._

object build extends Build {

  type Sett = sbt.Def.Setting[_]

  lazy val standardSettings = PrefixPlugin.prefixSettings ++ Seq[Sett](
      name := "CHANGE_MY_NAME"
    , bucket in s3wsUpload := "techtalks.ecetera.com.au"
    , bucket in s3wsDeleteAll := "techtalks.ecetera.com.au"
    , s3wsAssetDir := baseDirectory.value / "assets"
    , progressBar in s3wsUpload := true
    , credentials += Credentials(Path.userHome / ".s3TechtalksCreds")
    , s3wsIncremental := true
    , s3wsPrefix := "techsync/" + tsyncprefix.value + "/" + name.value + "/"
    , s3wsPrefix in s3wsUpload := s3wsPrefix.value
    , s3wsPrefix in s3wsDeleteAll := s3wsPrefix.value
  )

  lazy val root: Project = Project(
      id = "tech-talk"
    , base = file(".")
    , settings = standardSettings
  ).enablePlugins(S3WebsitePlugin, SbtWeb)


}