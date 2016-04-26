# Simplest Possible Play

This is a copy of lloydmeta's [slim-play](https://beachape.com/blog/2015/07/25/slim-play-app/), with the following changes:

## Maven Layout

This project uses a standard Maven repository layout with `disablePlugins(PlayLayout)`.

## SLF4J Simple Binding

This project uses slf4j-nop instead of Logback.  Note that this **requires** that you have a published project before you start up the Play project.

To do this, run the following:

```
sbt
project slf4jNop
publishLocal
```

then the project will be in `libraryDependencies` and will be picked up by Play.

## URI Router

The URI router is in /src/main/scala/MyComponents.scala and includes a Play WS call out to https://playframework.com to show the use of components.

## ScalaTest bindings

There are some Scalatest utility classes and a call out to a running Play server, using Play WS and providing additional patience.  This is not required, but is useful as example.