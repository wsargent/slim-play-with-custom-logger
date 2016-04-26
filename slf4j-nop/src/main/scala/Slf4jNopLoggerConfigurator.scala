
import java.io.File
import java.net.URL

import play.api.{Environment, LoggerConfigurator, Mode}

class Slf4jNopLoggerConfigurator extends LoggerConfigurator {

  override def init(rootPath: File, mode: Mode.Mode): Unit = {
    val properties = Map("application.home" -> rootPath.getAbsolutePath)
    val resourceUrl = None
    configure(properties, resourceUrl)
  }

  override def shutdown(): Unit = {
    System.out.println("configurator shutdown")
  }

  override def configure(env: Environment): Unit = {
    val properties = Map("application.home" -> env.rootPath.getAbsolutePath)
    val resourceUrl = None
    configure(properties, resourceUrl)
  }

  override def configure(properties: Map[String, String], config: Option[URL]): Unit = {
    System.out.println(s"configurator startup with properties ${properties}, config = ${config}")
  }
}