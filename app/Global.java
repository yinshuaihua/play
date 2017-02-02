import play.GlobalSettings;
import play.mvc.Result;
import play.mvc.Results;

public class Global extends GlobalSettings {

    public Result onError(Throwable t) {
        return Results.notFound(views.html.error404.render());
    }

}
