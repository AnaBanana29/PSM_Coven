using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using System.Web.Http.Cors;

namespace wsCoven
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Cors
            config.EnableCors(new EnableCorsAttribute("*", "*", "*"));

            //Web API routes
            config.MapHttpAttributeRoutes();

            //Set web services format
            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{action}/{id}",
                defaults: new { id = RouteParameter.Optional }
            );
        }
    }
}
