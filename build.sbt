/**
 * You should give the project a real name
 * by default a prefix is prepended to the name such that
 *
 * name := "foobar"
 *
 * would produce an a path(key) in S3 of "techsync/<year>/<month>/foobar"
 *   where <year> is the current year and <month> is the current month.
 *
 * you can modify the prefix by using PrefixKeys.tsyncprefix setting,
 * eg to create an s3 path of "techsync/wibble/foobar" you woul do this:-
 *
 *
 *
 * PrefixKeys.tsyncprefix := "wibble"
 *
 * name := "foobar"
 *
 *
 *
 * NB you can always check what you prefix is by doing:
 *
 * sbt s3wsPrefix
 *
 */
name := "You_should_Name_me"
