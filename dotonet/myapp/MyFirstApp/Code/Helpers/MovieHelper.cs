using System;
using System.Collections.Generic;

namespace MyFirstApp.Code.Helpers
{
    public static class MovieHelper 
    {
        public static string DisplayMovies(List<MyFirstApp.Models.Movie> model){
            string html = "";
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            sb.Append("<ul><li>");
            // build contents
            foreach(var movie in model) {
                sb.Append("<ul>");
                sb.Append("<li>" + @movie.ID + "</li>");
                sb.Append("<li>" + @movie.Title + "</li>");
                sb.Append("<li>" + @movie.ReleaseDate + "</li>");
                sb.Append("<li>" + @movie.Genre + "</li>");
                sb.Append("<li>" + @movie.Price + "</li>");
                sb.Append("</ul>");
            }
            sb.Append("</li></ul>");
            html = sb.ToString();
            return html;
        }
    }
}
