//resolver for sbt-s3-resolver
resolvers += "Era7 maven releases" at "http://releases.era7.com.s3.amazonaws.com"

resolvers += Resolver.url("ecetera-repo-oss", new URL("https://s3-ap-southeast-2.amazonaws.com/ecetera-repo-oss/"))(Resolver.ivyStylePatterns)

addSbtPlugin("ohnosequences" % "sbt-s3-resolver" % "0.12.0")

addSbtPlugin("net.ground5hark.sbt" % "sbt-concat" % "0.1.8")

addSbtPlugin("au.com.ecetera.sbt" % "sbt-web-s3" % "0.2.1-20150609054819-72af433")
