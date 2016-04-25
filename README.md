# Simplest Possible Play

This is a copy of lloydmeta's [slim-play](https://beachape.com/blog/2015/07/25/slim-play-app/), with the following changes:

* Took out Logback with `disablePlugins(PlayLogback)`, using slf4j-simple instead (the "simplest possible" slf4j option)
* Standard Maven repository layout with `disablePlugins(PlayLayout)`.

URI router is in /src/main/scala/MyComponents.

Added Scalatest utility classes so there is have an HTTP client library handy, but they are not necessary.