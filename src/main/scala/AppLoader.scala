import play.api.ApplicationLoader.Context
import play.api._

class AppLoader extends ApplicationLoader {
  def load(context: Context) = new MyComponents(context).application
}