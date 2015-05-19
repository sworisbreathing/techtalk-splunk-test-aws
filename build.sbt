import au.com.ecetera.sbt.S3WebsitePlugin.S3WS._

// Give your techtalk a name!
// Can be:
// name := "foobar" or
// name := "2015/05/foobar"
name := ""

enablePlugins(S3WebsitePlugin)

bucket in s3wsUpload := "techtalks.ecetera.com.au"
bucket in s3wsDeleteAll := "techtalks.ecetera.com.au"

s3wsAssetDir := baseDirectory.value / "assets"

progressBar in s3wsUpload := true
credentials += Credentials(Path.userHome / ".s3TechtalksCreds")
s3wsIncremental := true

s3wsPrefix in s3wsUpload := "techsync/" + name.value + "/"
s3wsPrefix in s3wsDeleteAll := "techsync/" + name.value + "/"

lazy val root = (project in file(".")).enablePlugins(SbtWeb)
pipelineStages := Seq(concat)